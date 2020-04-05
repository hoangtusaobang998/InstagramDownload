package com.tt.dev.instagramdownload.retrofit;

public class APIClient {
    public static  final String URL="https://www.instagram.com/";
    public static DataClient getData(){
        return RetrofitClient.getClient(URL).create(DataClient.class);
    }
}
