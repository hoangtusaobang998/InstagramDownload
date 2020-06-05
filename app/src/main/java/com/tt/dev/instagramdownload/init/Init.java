package com.tt.dev.instagramdownload.init;

import android.Manifest;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.webkit.MimeTypeMap;

import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import com.tt.dev.instagramdownload.BuildConfig;
import com.tt.dev.instagramdownload.listen.GetListFile;
import com.tt.dev.instagramdownload.listen.ValidateUrl;
import com.tt.dev.instagramdownload.model.FileInstagram;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

import es.dmoral.toasty.Toasty;

import static android.content.ClipDescription.MIMETYPE_TEXT_PLAIN;

public class Init {


    public static final String NULL_POINT = null;
    private static final String URL_IN = "https://www.instagram.com/";

    public static void closeKeyboard(Context context) {
        ((Activity) context).getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    public static void validateIN(String url, ValidateUrl validateUrl) {
        if (url.isEmpty()) {
            validateUrl.onNull();
            return;
        }
        if (url.startsWith(URL_IN)) {
            validateUrl.onSussce(url);
            return;
        } else {
            validateUrl.onFal(2);
            return;
        }
    }

    public static String getFilename() {
        String file_path = Environment.getExternalStorageDirectory().getAbsolutePath() +
                "/" + "InstagramDownload";
        File storageDir = new File(file_path);
        if (!storageDir.exists()) {
            storageDir.mkdirs();
        }
        return storageDir.getAbsolutePath();
    }

    public static boolean checkConnection(Context context) {
        final ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connMgr != null) {
            NetworkInfo activeNetworkInfo = connMgr.getActiveNetworkInfo();

            if (activeNetworkInfo != null) { // connected to the internet
                // connected to the mobile provider's data plan
                if (activeNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                    // connected to wifi
                    return true;
                } else return activeNetworkInfo.getType() == ConnectivityManager.TYPE_MOBILE;
            }
        }
        Toasty.error(context, "No Internet", Toasty.LENGTH_SHORT).show();
        return false;
    }

    public static final int P_CODE = 999;
    public static final String[] P = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};

    public static boolean hasPermissions(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && P != null) {
            for (String permission : P) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    public static final String getDateFile(File file) {
        Date lastModDate = new Date(file.lastModified());
        return new SimpleDateFormat("dd/MM/yyyy").format(lastModDate);
    }

    public static void getFileByType(Context context, GetListFile listFile) {

        if (!hasPermissions(context)) {
            listFile.hasPemission();
            return;
        }
        String path = getFilename();
        File file = new File(path);
        if (!file.exists()) {
            //null
            listFile.listNull();
            return;
        }
        File[] pictures = file.listFiles();
        if (pictures == null || pictures.length == 0) {
            //null
            listFile.listNull();
            return;
        }

        Arrays.sort(pictures, (f1, f2) -> Long.compare(f1.lastModified(), f2.lastModified()));

        Log.e("size", pictures.length + "");
        listFile.listFile(new FileInstagram());
        for (File file1 : pictures) {
            FileInstagram fileInstagram = new FileInstagram();
            fileInstagram.setPath(file1.getPath());
            fileInstagram.setDate(getDateFile(file1));
            fileInstagram.setSize(FileUtil.formatFileSize(file1.length()));
            listFile.listFile(fileInstagram);
        }

    }

    private static String url_test = "https://www.instagram.com/p/B8TfPMuBUpd/?igshid=v9fdhptex4g7";

    public static boolean isFile(String s) {
        String file_path = "";
        file_path = getFilename() + "/" + s;
        File dlCacheFile = new File(file_path);
        Log.e("d", dlCacheFile.getPath());
        if (!dlCacheFile.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public static final void openGooglePlay(Context context, String packagename) {
        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + packagename)));
        } catch (android.content.ActivityNotFoundException anfe) {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + packagename)));
        }
    }

    public static void sendMessenger(File myFile, Context context) {
        try {
            MimeTypeMap mime = MimeTypeMap.getSingleton();
            String ext = myFile.getName().substring(myFile.getName().lastIndexOf(".") + 1);
            String type = mime.getMimeTypeFromExtension(ext);
            Intent sharingIntent = new Intent("android.intent.action.SEND");
            sharingIntent.setType(type);
            if (getVersionSDK() > 23) {
                sharingIntent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(context, BuildConfig.APPLICATION_ID + ".provider", myFile));
            } else {
                sharingIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(myFile));
            }
            context.startActivity(Intent.createChooser(sharingIntent, "Share"));
        } catch (Exception e) {

        }
    }

    public static int getVersionSDK() {
        return Build.VERSION.SDK_INT;
    }

}
