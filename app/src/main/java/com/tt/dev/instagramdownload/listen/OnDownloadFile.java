package com.tt.dev.instagramdownload.listen;

import java.io.File;

public interface OnDownloadFile {
    void onProgress(String txt);

    void onDownloadComplete(File file);

    void onError(String messge);
}
