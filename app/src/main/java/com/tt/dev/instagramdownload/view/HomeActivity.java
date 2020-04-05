package com.tt.dev.instagramdownload.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.DownloadProgressListener;
import com.azoft.carousellayoutmanager.CarouselLayoutManager;
import com.azoft.carousellayoutmanager.CarouselZoomPostLayoutListener;
import com.azoft.carousellayoutmanager.CenterScrollListener;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.tt.dev.instagramdownload.BuildConfig;
import com.tt.dev.instagramdownload.R;
import com.tt.dev.instagramdownload.adapter.MyAdapter;
import com.tt.dev.instagramdownload.clip.Clip;
import com.tt.dev.instagramdownload.dialog.Dialog;
import com.tt.dev.instagramdownload.dialog.SweetAlertDialog;
import com.tt.dev.instagramdownload.init.FileUtil;
import com.tt.dev.instagramdownload.init.Init;
import com.tt.dev.instagramdownload.listen.GetListFile;
import com.tt.dev.instagramdownload.listen.GetVideoInstagram;
import com.tt.dev.instagramdownload.listen.ValidateUrl;
import com.tt.dev.instagramdownload.model.FileInstagram;
import com.tt.dev.instagramdownload.model.Url;
import com.tt.dev.instagramdownload.retrofit.APIClient;
import com.tt.dev.instagramdownload.task.InstagramDownloader;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.tt.dev.instagramdownload.init.Init.P;
import static com.tt.dev.instagramdownload.init.Init.P_CODE;
import static com.tt.dev.instagramdownload.init.Init.getDateFile;
import static com.tt.dev.instagramdownload.init.Init.getFileByType;
import static com.tt.dev.instagramdownload.init.Init.getIDUrl;
import static com.tt.dev.instagramdownload.init.Init.hasPermissions;
import static com.tt.dev.instagramdownload.init.Init.openGooglePlay;
import static com.tt.dev.instagramdownload.init.Init.validateIN;

public class HomeActivity extends AppCompatActivity implements ValidateUrl, GetListFile {

    private Context context = HomeActivity.this;
    private String url = null;
    private MyAdapter myAdapter;
    private LinearLayoutManager layoutManager;
    private List<FileInstagram> list;
    private SweetAlertDialog onLoading, onSucce;
    private InterstitialAd mInterstitialAd;
    private AdView mAdView;
    private PopupMenu popupMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ads();
        init();
    }

    void init() {
        mAdView = findViewById(R.id.admob);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        list = new ArrayList<>();
        layoutManager = new GridLayoutManager(this, 2);
        myAdapter = new MyAdapter(list, context, getwidth());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(myAdapter);
        myAdapter.setClickItem((fileInstagrams, position) -> {
            if (fileInstagrams.get(position).getPath().endsWith(".mp4")) {
                final File videoFile = new File(fileInstagrams.get(position).getPath());
                Uri fileUri = FileProvider.getUriForFile(context, BuildConfig.APPLICATION_ID + ".provider", videoFile);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(fileUri, "video/*");
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                startActivity(intent);
            } else {
                Intent intent = new Intent(HomeActivity.this, IMGActivity.class);
                intent.putExtra(IMGActivity.KEY_LIST, (Serializable) fileInstagrams);
                intent.putExtra(IMGActivity.KEY_POSITION, position);
                startActivityForResult(intent, 989);
            }
        });


    }

    int getwidth() {
        DisplayMetrics metrics = new DisplayMetrics();   //for all android versions
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.widthPixels;
    }

    void ads() {
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.inter_id));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClicked() {
            }

            @Override
            public void onAdClosed() {
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });
    }

    void showAds() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!hasPermissions(this)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(P, P_CODE);
            }
        } else {
            if (myAdapter.getFileInstagramList().isEmpty()) {
                getFileByType(context, HomeActivity.this);
            }

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Init.checkConnection(HomeActivity.this);
        Init.closeKeyboard(HomeActivity.this);
        String url = Clip.getClipboardText(this);

        if (url != null) {
            if (url.isEmpty()) {
                return;
            }
            edtUrl.setText(url);
            validateIN(url, HomeActivity.this);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 989 && resultCode == RESULT_OK) {
            if (!hasPermissions(this)) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(P, P_CODE);
                }
            } else {
                myAdapter.getFileInstagramList().clear();
                myAdapter.notifyDataSetChanged();
                getFileByType(context, HomeActivity.this);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == P_CODE) {
            if (!hasPermissions(this)) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(P, P_CODE);
                }
            } else {
                getFileByType(context, HomeActivity.this);
            }
        }
    }

    @BindView(R.id.loading)
    ProgressBar loading;

    @BindView(R.id.editText)
    EditText edtUrl;

    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    @OnClick(R.id.button)
    public void download() {
        url = edtUrl.getText().toString().trim();
        if (!TextUtils.isEmpty(url)) {
            Init.validateIN(url, HomeActivity.this);
        } else
            Toasty.error(context, getString(R.string.empty), Toast.LENGTH_SHORT).show();

    }

    @OnClick(R.id.button2)
    public void paste() {
        edtUrl.setText("");
        edtUrl.setText(Clip.getClipboardText(context));
        if (edtUrl.getText().toString().trim().equals("")) {
            Toasty.error(context, getString(R.string.nulllink), Toasty.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.imageView2)
    public void openInstagram() {
        try {
            Intent launchIntent = getPackageManager().getLaunchIntentForPackage(IN_PACK);
            startActivity(launchIntent);
        } catch (Exception e) {
            //openGooglePlay(HomeActivity.this, IN_PACK);
        }
    }

    private static final String TIKTOK_PACK = "com.tt.dev.tiktokdownload";
    private static final String LOVE_PACK = "com.teamdev.demngayyeu2020";
    private static final String IN_PACK = "com.instagram.android";

    @OnClick(R.id.imageView)
    public void openTiktok() {
        try {
            Intent launchIntent = getPackageManager().getLaunchIntentForPackage(TIKTOK_PACK);
            startActivity(launchIntent);
        } catch (Exception e) {
            openGooglePlay(HomeActivity.this, TIKTOK_PACK);
        }
    }

    @OnClick(R.id.imageView1)
    public void openDemNgayYeu() {
        try {
            Intent launchIntent = getPackageManager().getLaunchIntentForPackage(LOVE_PACK);
            startActivity(launchIntent);
        } catch (Exception e) {
            openGooglePlay(HomeActivity.this, LOVE_PACK);
        }
    }

    @OnClick(R.id.menu)
    public void menu(View view) {
        popupMenu = popDialog(view);
        popupMenu.show();
    }

    @Override
    public void onSussce(String url) {
        try {
            Clip.setClipboardText(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
        onLoading = Dialog.PROGRESS_TYPE(HomeActivity.this, getString(R.string.loading));
        onSucce = Dialog.SUCCESS_TYPE(HomeActivity.this, getString(R.string.sussce));
        showDialogLoading();
        Log.e("A", getIDUrl(url));
        APIClient.getData().getDataALL(getIDUrl(url)).enqueue(new Callback<ListIMG>() {
            @Override
            public void onResponse(Call<ListIMG> call, Response<ListIMG> response) {
                if (!response.isSuccessful()) {
                    Toasty.error(context, getString(R.string.retry), Toasty.LENGTH_SHORT).show();
                    cancelDialogLoading();
                    return;
                }
                try {
                    if (response.body().getGraphql().getShortcodeMedia().getEdgeSidecarToChildren().getEdges() == null) {
                        onRequesUrl(url);
                        return;
                    }
                } catch (Exception e) {
                    onRequesUrl(url);
                    return;
                }

                int size = response.body().getGraphql().getShortcodeMedia().getEdgeSidecarToChildren().getEdges().size();
                for (int i = 0; i < size; i++) {
                    String urlpath = response.body().getGraphql().getShortcodeMedia().getEdgeSidecarToChildren().getEdges().get(i).getNode().getDisplayUrl();
                    String filename = "instagram" + response.body().getGraphql().getShortcodeMedia().getEdgeSidecarToChildren().getEdges().get(i).getNode().getId() + ".jpg";
                    downloadStartList(urlpath, filename, i, size);
                }

            }

            @Override
            public void onFailure(Call<ListIMG> call, Throwable t) {
                onRequesUrl(url);
                Log.e("ERR", t.toString());
            }
        });
    }

    void onRequesUrl(String url) {
        new InstagramDownloader().setInstagram(new GetVideoInstagram() {
            @Override
            public void Links(Url url) {
                startDownload(url);
            }

            @Override
            public void Err() {

            }
        }, url);
    }

    @Override
    public void onFal(int type) {
        cancelDialogLoading();
        Toasty.error(context, getString(R.string.notlik), Toasty.LENGTH_SHORT).show();
    }

    @Override
    public void onNull() {
        cancelDialogLoading();
    }

    void cancelDialogLoading() {
        try {
            if (onLoading != null) {
                onLoading.cancel();
            }
        } catch (Exception e) {
        }
        ;
    }

    void showDialogLoading() {
        try {
            if (onLoading != null) {
                if (!onLoading.isShowing()) {
                    onLoading.show();
                }
            }
        } catch (Exception e) {
        }
        ;
    }

    void cancelDialogSussce() {
        try {
            if (onSucce != null) {
                onSucce.cancel();
            }
        } catch (Exception e) {
        }
        ;
    }

    void showDialogSussce() {
        try {
            if (onSucce != null) {
                onSucce.setSussceClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        showAds();
                    }
                });
                if (!onSucce.isShowing()) {
                    onSucce.show();
                }

            }
        } catch (Exception e) {
        }
        ;
    }

    @Override
    public void listFile(FileInstagram fileInstagrams) {
        loading.setVisibility(View.GONE);
        myAdapter.setFileInstagram(fileInstagrams);
    }

    @Override
    public void listNull() {
        myAdapter.setFileInstagram(new FileInstagram());
        loading.setVisibility(View.GONE);
    }

    @Override
    public void hasPemission() {
        hasPermissions(context);
    }

    void startDownload(Url url) {

        onSucce.setSussceClickListener(sweetAlertDialog -> {
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            }
        });

        String filename = "Instagram_" + new Date().getTime();
        if (url.getType().equals("1")) {
            filename = filename + ".mp4";
        } else {
            filename = filename + ".jpg";
        }
        downloadStart(url.getUrl_download(), filename);
    }

    public void downloadStart(String url, String titlename) {
        Log.e("titlename", titlename);
        AndroidNetworking.download(url, Init.getFilename(), titlename)
                .setTag(1).setPriority(Priority.HIGH)
                .build()
                .setDownloadProgressListener(new DownloadProgressListener() {
                    @Override
                    public void onProgress(long bytesDownloaded, long totalBytes) {
                        onLoading.setTitleText("Downloading " + FileUtil.getProgressDisplayLine(bytesDownloaded, totalBytes));
                        Log.e("AAAAAAAA", "Downloading " + FileUtil.formatFileSize(totalBytes));
                    }
                })
                .startDownload(new com.androidnetworking.interfaces.DownloadListener() {
                    @Override
                    public void onDownloadComplete() {
                        edtUrl.setText("");
                        cancelDialogLoading();
                        showDialogSussce();
                        File file1 = new File(Init.getFilename() + "/" + titlename);
                        FileInstagram fileInstagram = new FileInstagram();
                        fileInstagram.setPath(file1.getPath());
                        fileInstagram.setDate(getDateFile(file1));
                        fileInstagram.setSize(FileUtil.formatFileSize(file1.length()));
                        myAdapter.setFileInstagram(fileInstagram);
                        recyclerView.smoothScrollToPosition(1);
                        try {

                        } catch (Exception e) {
                            Toasty.error(context, "Err", Toasty.LENGTH_SHORT).show();
                            cancelDialogLoading();
                            Log.e("ERR_DELETE_ITEM", e.toString());
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        Toasty.error(context, "Err", Toasty.LENGTH_SHORT).show();
                        cancelDialogLoading();
                        Log.e("ERR_DELETE_ITEM", anError.toString());

                    }
                });
    }

    public void downloadStartList(String url, String titlename, int position, int size) {
        Log.e("titlename", titlename);
        if (!Init.isFile(titlename)) {
            cancelDialogLoading();
            Toasty.error(context, getString(R.string.filett), Toasty.LENGTH_SHORT).show();
            return;
        }
        AndroidNetworking.download(url, Init.getFilename(), titlename)
                .setTag(1).setPriority(Priority.HIGH)
                .build()
                .setDownloadProgressListener(new DownloadProgressListener() {
                    @Override
                    public void onProgress(long bytesDownloaded, long totalBytes) {
                        onLoading.setTitleText("Downloading" + "(" + position + "/" + size + ")" + FileUtil.getProgressDisplayLine(bytesDownloaded, totalBytes));
                        Log.e("AAAAAAAA", "Downloading " + FileUtil.formatFileSize(totalBytes));
                    }
                })
                .startDownload(new com.androidnetworking.interfaces.DownloadListener() {
                    @Override
                    public void onDownloadComplete() {

                        edtUrl.setText("");
                        cancelDialogLoading();
                        showDialogSussce();
                        File file1 = new File(Init.getFilename() + "/" + titlename);
                        FileInstagram fileInstagram = new FileInstagram();
                        fileInstagram.setPath(file1.getPath());
                        fileInstagram.setDate(getDateFile(file1));
                        fileInstagram.setSize(FileUtil.formatFileSize(file1.length()));
                        myAdapter.setFileInstagram(fileInstagram);
                        recyclerView.smoothScrollToPosition(1);
                        try {

                        } catch (Exception e) {
                            Toasty.error(context, "Err", Toasty.LENGTH_SHORT).show();
                            cancelDialogLoading();
                            Log.e("ERR_DELETE_ITEM", e.toString());
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        Toasty.error(context, "Err", Toasty.LENGTH_SHORT).show();
                        cancelDialogLoading();
                        Log.e("ERR_DELETE_ITEM", anError.toString());

                    }
                });
    }

    private PopupMenu popDialog(View view) {
        PopupMenu popupMenu = new PopupMenu(HomeActivity.this, view);
        popupMenu.inflate(R.menu.menu_items);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.share: {
                        try {
                            Intent share = new Intent(android.content.Intent.ACTION_SEND);
                            share.setType("text/plain");
                            share.putExtra(Intent.EXTRA_SUBJECT, "InstagramDownload");
                            share.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=" + context.getPackageName());
                            startActivity(Intent.createChooser(share, "Share link!"));
                        } catch (Exception e) {
                        }
                        break;
                    }
                    case R.id.comment: {
                        openGooglePlay(context, context.getPackageName());
                        break;
                    }
                    case R.id.exit: {
                        finish();
                        break;
                    }
                }
                return false;
            }
        });
        return popupMenu;
    }


}
