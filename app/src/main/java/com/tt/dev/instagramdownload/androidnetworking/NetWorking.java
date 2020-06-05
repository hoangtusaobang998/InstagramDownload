package com.tt.dev.instagramdownload.androidnetworking;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;

import java.util.ArrayList;
import java.util.List;

public class NetWorking {

    private static final String URL = "https://www.instagram.com/";

    private DataIMG dataIMG;

    public static NetWorking getInstance() {
        return new NetWorking();
    }

    public NetWorking() {
    }

    public NetWorking setDataIMG(DataIMG dataIMG) {
        this.dataIMG = dataIMG;
        return this;
    }

    private static String getIdUrl(String url) {
        String[] mang = url.split("/");
        if (mang.length < 4) {
            return null;
        }
        return mang[4];
    }

    public void requestAPI(String url) {
        if (this.dataIMG == null) {
            return;
        }

        AndroidNetworking.get(URL + "p/{id}/?__a=1")
                .addPathParameter("id", getIdUrl(url))
                .setTag("download")
                .setPriority(Priority.LOW)
                .build()
                .getAsObject(ListIMG.class, new ParsedRequestListener<ListIMG>() {

                    @Override
                    public void onResponse(ListIMG response) {
                        String getDisplayUrl = "";
                        String getUsername = "";
                        String getFullName = "";
                        String getProfilePicUrl = "";
                        List<Edge____> edge____list = null;
                        try {
                            getDisplayUrl = response.getGraphql().getShortcodeMedia().getDisplayUrl();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        try {
                            getUsername = response.getGraphql().getShortcodeMedia().getOwner().getUsername();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        try {
                            getFullName = response.getGraphql().getShortcodeMedia().getOwner().getFullName();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        try {
                            getProfilePicUrl = response.getGraphql().getShortcodeMedia().getOwner().getProfilePicUrl();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        try {
                            edge____list = response.getGraphql().getShortcodeMedia().getEdgeSidecarToChildren().getEdges();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        if (edge____list == null) {
                            Log.e("Url", getDisplayUrl);
                            dataIMG.onResponseTypeNoList(getDisplayUrl, getUsername, getFullName, getProfilePicUrl);
                            return;
                        }
                        if (edge____list.isEmpty()) {
                            Log.e("Url", getDisplayUrl);
                            dataIMG.onResponseTypeNoList(getDisplayUrl, getUsername, getFullName, getProfilePicUrl);
                            return;
                        }
                        List<String> listUrl = new ArrayList<>();
                        for (Edge____ edge____ : edge____list) {
                            List<DisplayResource_> strings = edge____.getNode().getDisplayResources();
                            listUrl.add(strings.get(strings.size() - 1).getSrc());
                            Log.e("Url", strings.get(strings.size() - 1).getSrc());
                        }
                        dataIMG.onResponseTypeList(getUsername, getFullName, getProfilePicUrl, listUrl);

                    }

                    @Override
                    public void onError(ANError anError) {
                        dataIMG.onError(anError.getMessage());
                    }
                });

    }

    public interface DataIMG {

        void onResponseTypeList(String getUsername, String getFullName, String imgusername, List<String> edge____list);

        void onResponseTypeNoList(String getDisplayUrl, String getUsername, String getFullName, String imgusername);

        void onError(String anError);
    }

}
