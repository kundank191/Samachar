package com.example.news_app.data.Network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Kundan on 22-08-2018.
 */
public interface NewsService {

    @GET("{type}")
    Call<NetworkResponse.RootObject> getArticlesList(@Path("type") String articleType
                                                    , @Query("api") String API
                                                    , @Query("country") String country);
}
