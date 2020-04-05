package com.tt.dev.instagramdownload.task;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;

import com.tt.dev.instagramdownload.listen.GetVideoInstagram;
import com.tt.dev.instagramdownload.model.Url;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class InstagramDownloader {

    private Document page;
    private final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36";
    private GetVideoInstagram instagram;

    public void setInstagram(GetVideoInstagram instagram, String url) {
        this.instagram = instagram;
        loadUrl(url);
    }

    public void loadUrl(String url) {
        new GetImage().execute(url);
    }

    private class GetImage extends AsyncTask<String, Void, Url> {

        @Override
        protected Url doInBackground(String... strings) {
            String downloadUrl = "";
            Url url = new Url();
            try {
                page = Jsoup.connect(strings[0] + "/?__a=1").userAgent(USER_AGENT).get();
                String mediaType = page.select("meta[name=medium]").first()
                        .attr("content");

                switch (mediaType) {
                    case "video":
                        downloadUrl = page.select("meta[property=og:video]").first()
                                .attr("content");
                        url.setUrl_download(downloadUrl);
                        url.setType("1");
                        break;
                    case "image":
                        downloadUrl = page.select("meta[property=og:image]").first()
                                .attr("content");
                        url.setUrl_download(downloadUrl);
                        url.setType("2");
                        break;
                    default:
                        break;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return url;
        }

        @Override
        protected void onPostExecute(Url s) {
            super.onPostExecute(s);
            if (TextUtils.isEmpty(s.getType()) && TextUtils.isEmpty(s.getUrl_download())) {
                instagram.Err();
            } else {
                instagram.Links(s);
            }
        }
    }
}
