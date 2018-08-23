package com.example.news_app.data.Network;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Kundan on 22-08-2018.
 */
public class NetworkResponse {

    public class Source {
        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("name")
        @Expose
        private String name;

        public String getId() {
            return this.id;
        }

        public void setId(String id) {
            this.id = id;
        }


        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    @Entity(tableName = "articles")
    public class Article {
        @Embedded
        @SerializedName("source")
        @Expose
        private Source source;
        @SerializedName("author")
        @Expose
        private String author;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("publishedAt")
        @Expose
        private String publishedAt;
        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("urlToImage")
        @Expose
        private String urlToImage;

        public Source getSource() {
            return this.source;
        }

        public void setSource(Source source) {
            this.source = source;
        }


        public String getAuthor() {
            return this.author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }


        public String getTitle() {
            return this.title;
        }

        public void setTitle(String title) {
            this.title = title;
        }


        public String getDescription() {
            return this.description;
        }

        public void setDescription(String description) {
            this.description = description;
        }


        public String getUrl() {
            return this.url;
        }

        public void setUrl(String url) {
            this.url = url;
        }


        public String getUrlToImage() {
            return this.urlToImage;
        }

        public void setUrlToImage(String urlToImage) {
            this.urlToImage = urlToImage;
        }


        public String getPublishedAt() {
            return this.publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }
    }

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
