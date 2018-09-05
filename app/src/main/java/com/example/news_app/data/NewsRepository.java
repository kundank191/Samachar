package com.example.news_app.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.news_app.AppExecutors;
import com.example.news_app.Utils.NetworkUtils;
import com.example.news_app.data.Network.NetworkResponse;
import com.example.news_app.data.Network.NewsService;
import com.example.news_app.data.database.Article;
import com.example.news_app.data.database.NewsDAO;

import java.util.List;

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
    private static final String LOG_TAG = NewsRepository.class.getSimpleName();
    private static int pageNo = 1;
    private static final int pageSize = 100;

    // For Singleton instantiation
    private static final Object LOCK = new Object();
    private static NewsRepository sInstance;

    private NewsService newsService;
    private NewsDAO newsDAO;
    private AppExecutors executor;

    @Inject
    public NewsRepository(NewsService newsService, NewsDAO newsDAO, AppExecutors executor) {
        this.newsService = newsService;
        this.newsDAO = newsDAO;
        this.executor = executor;
    }

    public synchronized static NewsRepository getInstance(
            NewsService newsService, NewsDAO newsDAO,
            AppExecutors executors) {
        Log.d(LOG_TAG, "Getting the repository");
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = new NewsRepository(newsService, newsDAO,
                        executors);
                Log.d(LOG_TAG, "Made new repository");
            }
        }
        return sInstance;
    }

    public LiveData<List<Article>> getTopHeadlines(String Api_Key){

        final MutableLiveData<List<Article>> data = new MutableLiveData<>();
        newsService.getTopHeadlinesArticlesList(NetworkUtils.PATH_TOP_HEADLINES,NetworkUtils.COUNTRY_INDIA,Api_Key,pageNo,pageSize).enqueue(new Callback<NetworkResponse.RootObject>() {
            @Override
            public void onResponse(@NonNull Call<NetworkResponse.RootObject> call, @NonNull Response<NetworkResponse.RootObject> response) {
                data.setValue(response.body().getArticles());
            }

            @Override
            public void onFailure(@NonNull Call<NetworkResponse.RootObject> call, @NonNull Throwable t) {
                Log.i("Network Error",call.toString());
            }
        });
        return data;
    }

    public LiveData<List<Article>> getAllArticles(String Api_key){
        final MutableLiveData<List<Article>> data = new MutableLiveData<>();
        newsService.getArticles(NetworkUtils.PATH_EVERYTHING,Api_key,pageNo,pageSize).enqueue(new Callback<NetworkResponse.RootObject>() {
            @Override
            public void onResponse(@NonNull Call<NetworkResponse.RootObject> call, @NonNull Response<NetworkResponse.RootObject> response) {
                data.setValue(response.body().getArticles());
            }

            @Override
            public void onFailure(@NonNull Call<NetworkResponse.RootObject> call, @NonNull Throwable t) {
                Log.i("Network Error",call.toString());
            }
        });
        return data;
    }
}
