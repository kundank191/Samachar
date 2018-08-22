package com.example.news_app.ui;

import android.arch.lifecycle.LiveData;

import com.example.news_app.data.NetworkResponse;

import java.util.List;

/**
 * Created by Kundan on 20-08-2018.
 */
public class ArticleViewModel extends android.arch.lifecycle.ViewModel {

    private LiveData<List<NetworkResponse.Article>> article;

    public LiveData<List<NetworkResponse.Article>> getArticle() {
        return article;
    }

    public void setArticle(LiveData<List<NetworkResponse.Article>> article) {
        this.article = article;
    }
}
