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
    Call<NetworkResponse.RootObject> getTopHeadlinesArticlesList(@Path("type") String articleType
                                                    , @Query("country") String country
                                                    , @Query("apiKey") String apiKey
                                                    , @Query("page") int pageNo
                                                    , @Query("pageSize") int pageSize);

    @GET("{type")
    Call<NetworkResponse.RootObject> getArticles(@Path("type") String articleType
                                                            , @Query("apiKey") String apiKey
                                                            , @Query("page") int pageNo
                                                            , @Query("pageSize") int pageSize);
}
