package com.example.bas.Service.Model;
/**
 * Basic POJOs med variabler, contructor, getters, setters og toString metoden.
 */
public class News {
    private int newsId;
    private String newsHeadline;
    private String newsText;

    public News(int newsId, String newsHeadline, String newsText) {
        this.newsId = newsId;
        this.newsHeadline = newsHeadline;
        this.newsText = newsText;
    }

    public News() {
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getNewsHeadline() {
        return newsHeadline;
    }

    public void setNewsHeadline(String newsHeadline) {
        this.newsHeadline = newsHeadline;
    }

    public String getNewsText() {
        return newsText;
    }

    public void setNewsText(String newsText) {
        this.newsText = newsText;
    }

    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", newsHeadline='" + newsHeadline + '\'' +
                ", newsText='" + newsText + '\'' +
                '}';
    }
}
