package com.tt.dev.instagramdownload.listen;

import com.tt.dev.instagramdownload.model.FileInstagram;

import java.io.FileInputStream;
import java.util.List;

public interface GetListFile {

    void listFile(FileInstagram fileInstagrams);

    void listNull();

    void hasPemission();
}
