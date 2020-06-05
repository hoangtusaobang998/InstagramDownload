package com.tt.dev.instagramdownload.room;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class RoomViewModel extends AndroidViewModel {

    public RoomViewModel(@NonNull Application application) {
        super(application);
        roomDatabaseRepository = new RoomDatabaseRepository(application);
        listLiveData = roomDatabaseRepository.getAllRoomDatabase();
    }

    private RoomDatabaseRepository roomDatabaseRepository;
    private LiveData<List<ModelBaseUtis>> listLiveData;


    public boolean insert(ModelBaseUtis modelBaseUtis) {
        try {
            roomDatabaseRepository.insert(modelBaseUtis);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void update(ModelBaseUtis modelBaseUtis) {
        roomDatabaseRepository.update(modelBaseUtis);
    }

    public void delete(ModelBaseUtis modelBaseUtis) {
        roomDatabaseRepository.delete(modelBaseUtis);
    }

    public LiveData<List<ModelBaseUtis>> getListLiveData() {
        return listLiveData;
    }
}
