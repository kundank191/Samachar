package com.example.news_app.Utils;

import android.content.Context;

import com.example.news_app.AppExecutors;
import com.example.news_app.data.Network.NewsService;
import com.example.news_app.data.NewsRepository;
import com.example.news_app.data.database.NewsDatabase;
import com.example.news_app.ui.ArticleViewModelFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Kundan on 23-08-2018.
 */
public class InjectorUtils {

    public static ArticleViewModelFactory provideArticleViewModelFactory(Context context, String API_KEY){
        return new ArticleViewModelFactory(provideNewsRepository(context),API_KEY);
    }

    public static NewsRepository provideNewsRepository(Context context){
        NewsService service = provideNewsService();
        NewsDatabase newsDatabase = NewsDatabase.getInstance(context);
        AppExecutors executors = AppExecutors.getInstance();

        return NewsRepository.getInstance(service,newsDatabase.newsDAO(),executors);
    }

    public static NewsService provideNewsService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NetworkUtils.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(NewsService.class);
    }
}
