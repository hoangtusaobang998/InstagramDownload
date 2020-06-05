package com.tt.dev.instagramdownload.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.azoft.carousellayoutmanager.CarouselLayoutManager;
import com.azoft.carousellayoutmanager.CarouselZoomPostLayoutListener;
import com.azoft.carousellayoutmanager.CenterScrollListener;
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.tt.dev.instagramdownload.R;
import com.tt.dev.instagramdownload.adapter.AdapterIMG;
import com.tt.dev.instagramdownload.init.Init;
import com.tt.dev.instagramdownload.model.FileInstagram;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;

import static android.widget.LinearLayout.HORIZONTAL;

public class IMGActivity extends AppCompatActivity {

    private AdapterIMG adapterIMG;
    private List<FileInstagram> list;
    public static final String KEY_LIST = "key_list";
    public static final String KEY_POSITION = "key_position";
    private LinearLayoutManager layoutManager;
    private int index = -1;
    private boolean isFeleteFile = false;
    ProgressDialog progressDialog;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    private int count_delete = 0;
    private TextView position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img);
        mAdView = findViewById(R.id.admob);
        position = findViewById(R.id.position);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        ButterKnife.bind(this);
        list = (List<FileInstagram>) getIntent().getExtras().get(KEY_LIST);
        index = (int) getIntent().getExtras().get(KEY_POSITION);
        if (list == null && index == -1) {
            Toasty.error(this, "Err", Toasty.LENGTH_SHORT).show();
            finish();
        }
        list.remove(0);
        index--;

        Log.e("LIST_SIZE", list.size() + "");
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        adapterIMG = new AdapterIMG(list, this);
        recycler.setLayoutManager(layoutManager);
        recycler.addOnScrollListener(new CenterScrollListener());
        //layoutManager.setPostLayoutListener(new CarouselZoomPostLayoutListener());
        recycler.setHasFixedSize(true);
        recycler.setAdapter(adapterIMG);
        GravitySnapHelper snapHelper = new GravitySnapHelper(Gravity.START);
        snapHelper.attachToRecyclerView(recycler);
        recycler.scrollToPosition(index);
        recycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    index = getCurrentItem();
                    position.setText((index + 1) + "/" + list.size());
                    Log.e("Size", index + "");
                }
            }
        });
        position.setText((index + 1) + "/" + list.size());
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getString(R.string.set_wallpaper_));
        ads();
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
                if (isFeleteFile) {
                    setResult(RESULT_OK);
                }
                finish();
            }
        });
    }

    void showAds() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            if (isFeleteFile) {
                setResult(RESULT_OK);
            }
            finish();
        }
    }

    @OnClick(R.id.view)
    public void close() {
        showAds();
    }

    @OnClick(R.id.view_a)
    public void delete() {

        isFeleteFile = true;
        try {
            index = getCurrentItem();
            File file = new File(list.get(index).getPath());
            file.delete();
            list.remove(index);
            adapterIMG.delete(index);
            if (list.isEmpty()) {
                showAds();
            }
        } catch (Exception e) {

        }

    }

    @OnClick(R.id.view_b)
    public void share() {
        Init.sendMessenger(new File(list.get(index).getPath()), IMGActivity.this);
    }

    @BindView(R.id.img)
    ImageView img;

    @OnClick(R.id.setWallpaper)
    public void setWallpaper() {
        Picasso.get().load(new File(list.get(index).getPath())).fit().centerCrop().into(img, new Callback() {
            @Override
            public void onSuccess() {
                Bitmap bitmap = ((BitmapDrawable) img.getDrawable()).getBitmap();
                if (bitmap != null) {
                    new SetWallpaperManager().execute(bitmap);
                }

            }

            @Override
            public void onError(Exception e) {

            }
        });

    }

    @BindView(R.id.recyclerview)
    RecyclerView recycler;

    private int getCurrentItem() {
        return ((LinearLayoutManager) recycler.getLayoutManager())
                .findLastVisibleItemPosition();
    }

    private class SetWallpaperManager extends AsyncTask<Bitmap, Integer, Void> {

        @Override
        protected Void doInBackground(Bitmap... bitmaps) {
            WallpaperManager myWallpaperManager
                    = WallpaperManager.getInstance(getApplicationContext());
            try {
                myWallpaperManager.setBitmap(bitmaps[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.show();
        }


        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (progressDialog.isShowing()) {
                progressDialog.cancel();
            }
            showAds();
            startHome(IMGActivity.this);

        }
    }

    public static void startHome(Context context) {
        try {
            Intent i = new Intent(Intent.ACTION_MAIN);
            i.addCategory(Intent.CATEGORY_HOME);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        } catch (Exception e) {

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFeleteFile) {
            setResult(RESULT_OK);
        }
    }

    @Override
    public void onBackPressed() {
        showAds();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}
