package com.example.news_app.data;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Kundan on 22-08-2018.
 */
public class NetworkResponse {

    public class Source
    {
        private String id;

        public String getId() { return this.id; }

        public void setId(String id) { this.id = id; }

        private String name;

        public String getName() { return this.name; }

        public void setName(String name) { this.name = name; }
    }

    public class Article
    {
        private Source source;

        public Source getSource() { return this.source; }

        public void setSource(Source source) { this.source = source; }

        private String author;

        public String getAuthor() { return this.author; }

        public void setAuthor(String author) { this.author = author; }

        private String title;

        public String getTitle() { return this.title; }

        public void setTitle(String title) { this.title = title; }

        private String description;

        public String getDescription() { return this.description; }

        public void setDescription(String description) { this.description = description; }

        private String url;

        public String getUrl() { return this.url; }

        public void setUrl(String url) { this.url = url; }

        private String urlToImage;

        public String getUrlToImage() { return this.urlToImage; }

        public void setUrlToImage(String urlToImage) { this.urlToImage = urlToImage; }

        private Date publishedAt;

        public Date getPublishedAt() { return this.publishedAt; }

        public void setPublishedAt(Date publishedAt) { this.publishedAt = publishedAt; }
    }

    public class RootObject
    {
        private String status;

        public String getStatus() { return this.status; }

        public void setStatus(String status) { this.status = status; }

        private int totalResults;

        public int getTotalResults() { return this.totalResults; }

        public void setTotalResults(int totalResults) { this.totalResults = totalResults; }

        private ArrayList<Article> articles;

        public ArrayList<Article> getArticles() { return this.articles; }

        public void setArticles(ArrayList<Article> articles) { this.articles = articles; }
    }
}
