package com.example.news_app.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.util.Log;

/**
 * Created by Kundan on 22-08-2018.
 */
@Database(entities = {Article.class}, version = 1, exportSchema = false)
public abstract class NewsDatabase extends RoomDatabase {

    private static final String LOG_TAG = NewsDatabase.class.getSimpleName();
    private static final String DATABASE_NAME = "news";

    // For Singleton instantiation
    private static final Object LOCK = new Object();
    private static NewsDatabase sInstance;

    public static NewsDatabase getInstance(Context context) {
        Log.d(LOG_TAG, "Getting the database");
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        NewsDatabase.class, NewsDatabase.DATABASE_NAME).build();
                Log.d(LOG_TAG, "Made new database");
            }
        }
        return sInstance;
    }


    public abstract NewsDAO newsDAO();

}
