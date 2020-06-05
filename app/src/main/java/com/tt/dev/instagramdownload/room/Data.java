package com.tt.dev.instagramdownload.room;

import java.util.List;

public class Data {

    private String username;
    private String status;
    private List<String> url;

    public Data() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getUrl() {
        return url;
    }

    public void setUrl(List<String> url) {
        this.url = url;
    }

    public Data(String username, String status, List<String> url) {
        this.username = username;
        this.status = status;
        this.url = url;
    }

}
