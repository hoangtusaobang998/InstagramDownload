package com.tt.dev.instagramdownload;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import com.androidnetworking.AndroidNetworking;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Objects;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());
        setupNotificationChannel();
        MobileAds.initialize(this, initializationStatus -> {
        });
    }

    private void setupNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(this.getPackageName(), "Download",
                    NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            Objects.requireNonNull(manager).createNotificationChannel(channel);
        }

    }
}
