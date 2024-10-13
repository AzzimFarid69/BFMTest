package com.example.bfm_test.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Podcast {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("subtitle")
    @Expose
    private String subtitle;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("data")
    @Expose
    private PodcastData podcastData;

    /**
     * No args constructor for use in serialization
     *
     */
    public Podcast() {
    }

    public Podcast(String title, String subtitle, String type, String source, PodcastData podcastData) {
        super();
        this.title = title;
        this.subtitle = subtitle;
        this.type = type;
        this.source = source;
        this.podcastData = podcastData;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public PodcastData getData() {
        return podcastData;
    }

    public void setData(PodcastData podcastData) {
        this.podcastData = podcastData;
    }
}
