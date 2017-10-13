package com.example.android.newsapp;

/**
 * Created by karenulmer on 7/2/2017.
 */

public class News {

    // Section Title
    private final String mSection;

    // Article Title
    private final String mArticle;

    // Article URL
    private final String mUrl;

    public News(String section, String title, String url){
        mSection = section;
        mArticle = title;
        mUrl = url;
    }

    public String getSection() { return mSection; }
    public String getArticle() { return mArticle; }
    public String getUrl() { return mUrl; }



}
