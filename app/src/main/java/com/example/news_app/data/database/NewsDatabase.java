package com.example.news_app.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.news_app.data.Network.NetworkResponse;

/**
 * Created by Kundan on 22-08-2018.
 */
@Database(entities = {NetworkResponse.class}, version = 1, exportSchema = false)
public abstract class NewsDatabase extends RoomDatabase {

    public abstract NewsDAO newsDAO();

}
