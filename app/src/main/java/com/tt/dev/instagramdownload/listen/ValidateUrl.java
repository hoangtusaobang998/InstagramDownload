package com.tt.dev.instagramdownload.listen;

public interface ValidateUrl {

    void onSussce(String url);

    void onFal(int type);

    void onNull();
}
