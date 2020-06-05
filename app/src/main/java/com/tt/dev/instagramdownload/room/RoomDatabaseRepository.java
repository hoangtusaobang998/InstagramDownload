package com.tt.dev.instagramdownload.room;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class RoomDatabaseRepository {
    private RoomDatabaseDao roomDatabaseDao;
    private LiveData<List<ModelBaseUtis>> listLiveData;

    public RoomDatabaseRepository(Application application) {
        RoomDatabaseUtils roomDatabase = RoomDatabaseUtils.getInstance(application);
        roomDatabaseDao = roomDatabase.roomDatabaseDao();
        listLiveData = roomDatabaseDao.getAllRoomDatabase();
    }

    public void insert(ModelBaseUtis modelBaseUtis) {
        new InsertUserAsyncTask(roomDatabaseDao).execute(modelBaseUtis);
    }

    public void update(ModelBaseUtis modelBaseUtis) {
        new UpdateUserAsyncTask(roomDatabaseDao).execute(modelBaseUtis);
    }

    public void delete(ModelBaseUtis modelBaseUtis) {
        new DeleteUserAsyncTask(roomDatabaseDao).execute(modelBaseUtis);
    }

    public LiveData<List<ModelBaseUtis>> getAllRoomDatabase() {
        return listLiveData;
    }

    private static class InsertUserAsyncTask extends AsyncTask<ModelBaseUtis, Void, Void> {

        private RoomDatabaseDao roomDatabaseDao;

        public InsertUserAsyncTask(RoomDatabaseDao roomDatabaseDao) {
            this.roomDatabaseDao = roomDatabaseDao;
        }

        @Override
        protected Void doInBackground(ModelBaseUtis... modelBaseUtis) {
            roomDatabaseDao.insert(modelBaseUtis[0]);
            return null;
        }
    }

    private static class UpdateUserAsyncTask extends AsyncTask<ModelBaseUtis, Void, Void> {

        private RoomDatabaseDao roomDatabaseDao;

        public UpdateUserAsyncTask(RoomDatabaseDao roomDatabaseDao) {
            this.roomDatabaseDao = roomDatabaseDao;
        }

        @Override
        protected Void doInBackground(ModelBaseUtis... modelBaseUtis) {
            roomDatabaseDao.update(modelBaseUtis[0]);
            return null;
        }
    }


    private static class DeleteUserAsyncTask extends AsyncTask<ModelBaseUtis, Void, Void> {

        private RoomDatabaseDao roomDatabaseDao;

        public DeleteUserAsyncTask(RoomDatabaseDao roomDatabaseDao) {
            this.roomDatabaseDao = roomDatabaseDao;
        }

        @Override
        protected Void doInBackground(ModelBaseUtis... modelBaseUtis) {
            roomDatabaseDao.delete(modelBaseUtis[0]);
            return null;
        }
    }
}
