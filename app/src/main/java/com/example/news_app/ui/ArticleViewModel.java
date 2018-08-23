package com.example.news_app.ui;

import android.arch.lifecycle.LiveData;

import com.example.news_app.data.Network.NetworkResponse;
import com.example.news_app.data.NewsRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Kundan on 20-08-2018.
 */
public class ArticleViewModel extends android.arch.lifecycle.ViewModel {

    private LiveData<List<NetworkResponse.Article>> article;
    private NewsRepository newsRepository;
    private String API_KEY;

    @Inject // Parameter provided by dagger 2
    public ArticleViewModel(NewsRepository newsRepository, String API_KEY){
        this.newsRepository = newsRepository;
        article = newsRepository.getArticles(API_KEY);
    }

    public LiveData<List<NetworkResponse.Article>> getArticles() {
        return article;
    }

    public void setArticle(LiveData<List<NetworkResponse.Article>> article) {
        this.article = article;
    }
}
