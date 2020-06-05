package com.tt.dev.instagramdownload.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface RoomDatabaseDao {
    @Insert
    void insert(ModelBaseUtis modelBaseUtis);

    @Update
    void update(ModelBaseUtis modelBaseUtis);

    @Delete
    void delete(ModelBaseUtis modelBaseUtis);

    @Query("SELECT * FROM modelutils")
    LiveData<List<ModelBaseUtis>> getAllRoomDatabase();

    @Query("SELECT * FROM modelutils ORDER BY id DESC LIMIT 1")
    LiveData<ModelBaseUtis> getRoomDatabaseLast();
}
