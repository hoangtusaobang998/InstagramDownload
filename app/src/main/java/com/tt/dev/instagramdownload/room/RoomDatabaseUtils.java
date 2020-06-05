package com.tt.dev.instagramdownload.room;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {ModelBaseUtis.class}, version = 1)
public abstract class RoomDatabaseUtils extends RoomDatabase {

    private static RoomDatabaseUtils instace;

    public abstract RoomDatabaseDao roomDatabaseDao();

    public static synchronized RoomDatabaseUtils getInstance(Context context) {
        if (instace == null) {
            instace = Room.databaseBuilder(context.getApplicationContext(), RoomDatabaseUtils.class, "modelbaseutis")
                    .fallbackToDestructiveMigration()
                    .addCallback(rooCallback)
                    .build();
        }
        return instace;
    }

    private static RoomDatabase.Callback rooCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

        }
    };

    private static class PopulateAsyncTask extends AsyncTask<Void, Void, Void> {

        private RoomDatabaseDao roomDatabaseDao;

        private PopulateAsyncTask(RoomDatabaseUtils db) {
            roomDatabaseDao = db.roomDatabaseDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            roomDatabaseDao.insert(new ModelBaseUtis());
            return null;
        }
    }
}
