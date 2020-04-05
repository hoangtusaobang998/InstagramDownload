package com.tt.dev.instagramdownload.model;

import android.graphics.Bitmap;

import java.io.Serializable;

public class FileInstagram implements Serializable {

    private String date;
    private String path;
    private String size;

    public FileInstagram() {
    }

    public FileInstagram(String date, String path, String size) {
        this.date = date;
        this.path = path;
        this.size = size;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}