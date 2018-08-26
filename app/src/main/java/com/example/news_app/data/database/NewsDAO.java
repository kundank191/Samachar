package com.example.news_app.data.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Kundan on 22-08-2018.
 */
@Dao
public interface NewsDAO {

    @Query("SELECT * FROM articles")
    LiveData<Article> getNews();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(List<Article> article);

}
