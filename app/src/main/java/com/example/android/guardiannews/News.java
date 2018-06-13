package com.example.android.guardiannews;

import java.net.URL;
import java.util.Date;

/**
 * Created by dzsub on 2018.06.04..
 */

public class News {

    private String mSection;

    private String mArticle;

    private String mAuthor;

    private String mDate;

    private String mUrl;

    public News(String section, String article, String author, String date, String url) {
        mSection = section;
        mArticle = article;
        mAuthor = author;
        mDate = date;
        mUrl = url;
    }

    public String getmSection() {
        return mSection;
    }

    public String getmArticle() {
        return mArticle;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public String getmDate() {
        return mDate;
    }

    public String getmUrl() {
        return mUrl;
    }
}
