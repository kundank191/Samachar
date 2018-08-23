package com.example.news_app.ui;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.example.news_app.data.NewsRepository;

/**
 * Created by Kundan on 24-08-2018.
 */
public class ArticleViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final NewsRepository newsRepository;
    private final String API_KEY;

    public ArticleViewModelFactory(NewsRepository newsRepository, String API_KEY){
        this.newsRepository = newsRepository;
        this.API_KEY = API_KEY;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        //noinspection unchecked
        return (T) new ArticleViewModel(newsRepository, API_KEY);
    }
}
