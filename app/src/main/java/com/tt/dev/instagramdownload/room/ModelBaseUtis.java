package com.tt.dev.instagramdownload.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "modelutils")
public class ModelBaseUtis {


    public ModelBaseUtis() {
    }

    @PrimaryKey(autoGenerate = true)
    private int id;

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public ModelBaseUtis(int id, String json) {
        this.id = id;
        this.json = json;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String json;

}
