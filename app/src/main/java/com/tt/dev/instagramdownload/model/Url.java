package com.tt.dev.instagramdownload.model;

public class Url {
    String url_download;
    String type;

    public Url() {
    }

    public String getUrl_download() {
        return url_download;
    }

    public void setUrl_download(String url_download) {
        this.url_download = url_download;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Url(String url_download, String type) {
        this.url_download = url_download;
        this.type = type;
    }
}
