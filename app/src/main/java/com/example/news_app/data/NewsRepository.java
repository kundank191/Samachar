package com.example.news_app.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.news_app.Utils.NetworkUtils;
import com.example.news_app.data.Network.NetworkResponse;
import com.example.news_app.data.Network.NewsService;
import com.example.news_app.data.database.NewsDAO;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Kundan on 22-08-2018.
 */
@Singleton
public class NewsRepository {

    private NewsService newsService;
    private NewsDAO newsDAO;
    private Executor executor;

    @Inject
    public NewsRepository(NewsService newsService, NewsDAO newsDAO, Executor executor) {
        this.newsService = newsService;
        this.newsDAO = newsDAO;
        this.executor = executor;
    }

    public LiveData<List<NetworkResponse.Article>> getArticles(String Api_Key){

        final MutableLiveData<List<NetworkResponse.Article>> data = new MutableLiveData<>();
        newsService.getArticlesList(NetworkUtils.PATH_TOP_HEADLINES,Api_Key,NetworkUtils.COUNTRY_INDIA).enqueue(new Callback<NetworkResponse.RootObject>() {
            @Override
            public void onResponse(Call<NetworkResponse.RootObject> call, Response<NetworkResponse.RootObject> response) {
                data.setValue(response.body().getArticles());
            }

            @Override
            public void onFailure(Call<NetworkResponse.RootObject> call, Throwable t) {
                Log.i("Network Error",call.toString());
            }
        });
        return data;
    }
}
