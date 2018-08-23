package com.example.news_app.Utils;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.example.news_app.data.Network.NetworkResponse;

/**
 * Created by Kundan on 22-08-2018.
 */
public class NetworkUtils {

    public static String PATH_TOP_HEADLINES = "top-headlines";
    public static String COUNTRY_INDIA = "in";
    public static String API_KEY = "apiKey";
    public static String BASE_URL = "https://newsapi.org/v2/";
    public static String BASE_URL_TOP_HEADLINES = "https://newsapi.org/v2/top-headlines";

    public static void requestNews(String Api_Key){
        AndroidNetworking.get(BASE_URL_TOP_HEADLINES)
                .setPriority(Priority.LOW)
                .addQueryParameter("country",COUNTRY_INDIA)
                .addQueryParameter(API_KEY,Api_Key)
                .build()
                .getAsObject(NetworkResponse.RootObject.class, new ParsedRequestListener() {
                    @Override
                    public void onResponse(Object response) {
                        NetworkResponse.RootObject rootObject = (NetworkResponse.RootObject) response;
                        Log.i("response,",rootObject.getArticles().get(0).getDescription());
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.i("response,",anError.getErrorBody());
                    }
                });
    }
}
