package com.example.news_app.data.Network;

import com.example.news_app.data.database.Article;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Kundan on 22-08-2018.
 */
public class NetworkResponse {
    public class RootObject {
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("totalResults")
        @Expose
        private int totalResults;
        @SerializedName("articles")
        @Expose
        private ArrayList<Article> articles;

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String status) {
            this.status = status;
        }


        public int getTotalResults() {
            return this.totalResults;
        }

        public void setTotalResults(int totalResults) {
            this.totalResults = totalResults;
        }

        public ArrayList<Article> getArticles() {
            return this.articles;
        }

        public void setArticles(ArrayList<Article> articles) {
            this.articles = articles;
        }
    }
}
