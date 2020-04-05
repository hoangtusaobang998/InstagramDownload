package com.tt.dev.instagramdownload.retrofit;


import com.tt.dev.instagramdownload.view.ListIMG;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface DataClient {

    //Code GET ALL DATA
    @GET("p/{id}/?__a=1")
    Call<ListIMG> getDataALL(@Path("id") String id);
}
