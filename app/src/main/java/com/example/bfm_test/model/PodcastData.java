package com.example.bfm_test.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PodcastData {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("mp3_duration")
    @Expose
    private String mp3Duration;
    @SerializedName("createdon")
    @Expose
    private String createdon;
    @SerializedName("pagetitle")
    @Expose
    private String pagetitle;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("fbimage")
    @Expose
    private String fbimage;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("alias")
    @Expose
    private String alias;
    @SerializedName("interviewtime")
    @Expose
    private String interviewtime;
    @SerializedName("content_type")
    @Expose
    private String contentType;
    @SerializedName("editedon")
    @Expose
    private String editedon;
    @SerializedName("mp3")
    @Expose
    private String mp3;
    @SerializedName("parent")
    @Expose
    private String parent;
    @SerializedName("belt_name")
    @Expose
    private String beltName;
    @SerializedName("hidedownload")
    @Expose
    private String hidedownload;
    @SerializedName("hidesponsor")
    @Expose
    private String hidesponsor;
    @SerializedName("selected_highlight")
    @Expose
    private String selectedHighlight;
    @SerializedName("show_name")
    @Expose
    private String showName;
    @SerializedName("delisted")
    @Expose
    private String delisted;
    @SerializedName("producers")
    @Expose
    private String producers;
    @SerializedName("presenters")
    @Expose
    private String presenters;
    @SerializedName("category")
    @Expose
    private List<String> category;
    @SerializedName("tags")
    @Expose
    private List<String> tags;
    @SerializedName("mp3file_size")
    @Expose
    private String mp3fileSize;
    @SerializedName("publishedon")
    @Expose
    private String publishedon;
    @SerializedName("guest_names")
    @Expose
    private List<String> guestNames;
    @SerializedName("salutations")
    @Expose
    private List<String> salutations;
    @SerializedName("guest_designations")
    @Expose
    private List<String> guestDesignations;
    @SerializedName("guest_organisations")
    @Expose
    private List<String> guestOrganisations;
    @SerializedName("guests")
    @Expose
    private List<String> guests;

    /**
     * No args constructor for use in serialization
     *
     */
    public PodcastData() {
    }

    public PodcastData(String id, String mp3Duration, String createdon, String pagetitle, String content, String image, String fbimage, String slug, String alias, String interviewtime, String contentType, String editedon, String mp3, String parent, String beltName, String hidedownload, String hidesponsor, String selectedHighlight, String showName, String delisted, String producers, String presenters, List<String> category, List<String> tags, String mp3fileSize, String publishedon, List<String> guestNames, List<String> salutations, List<String> guestDesignations, List<String> guestOrganisations, List<String> guests) {
        super();
        this.id = id;
        this.mp3Duration = mp3Duration;
        this.createdon = createdon;
        this.pagetitle = pagetitle;
        this.content = content;
        this.image = image;
        this.fbimage = fbimage;
        this.slug = slug;
        this.alias = alias;
        this.interviewtime = interviewtime;
        this.contentType = contentType;
        this.editedon = editedon;
        this.mp3 = mp3;
        this.parent = parent;
        this.beltName = beltName;
        this.hidedownload = hidedownload;
        this.hidesponsor = hidesponsor;
        this.selectedHighlight = selectedHighlight;
        this.showName = showName;
        this.delisted = delisted;
        this.producers = producers;
        this.presenters = presenters;
        this.category = category;
        this.tags = tags;
        this.mp3fileSize = mp3fileSize;
        this.publishedon = publishedon;
        this.guestNames = guestNames;
        this.salutations = salutations;
        this.guestDesignations = guestDesignations;
        this.guestOrganisations = guestOrganisations;
        this.guests = guests;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMp3Duration() {
        return mp3Duration;
    }

    public void setMp3Duration(String mp3Duration) {
        this.mp3Duration = mp3Duration;
    }

    public String getCreatedon() {
        return createdon;
    }

    public void setCreatedon(String createdon) {
        this.createdon = createdon;
    }

    public String getPagetitle() {
        return pagetitle;
    }

    public void setPagetitle(String pagetitle) {
        this.pagetitle = pagetitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFbimage() {
        return fbimage;
    }

    public void setFbimage(String fbimage) {
        this.fbimage = fbimage;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getInterviewtime() {
        return interviewtime;
    }

    public void setInterviewtime(String interviewtime) {
        this.interviewtime = interviewtime;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getEditedon() {
        return editedon;
    }

    public void setEditedon(String editedon) {
        this.editedon = editedon;
    }

    public String getMp3() {
        return mp3;
    }

    public void setMp3(String mp3) {
        this.mp3 = mp3;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getBeltName() {
        return beltName;
    }

    public void setBeltName(String beltName) {
        this.beltName = beltName;
    }

    public String getHidedownload() {
        return hidedownload;
    }

    public void setHidedownload(String hidedownload) {
        this.hidedownload = hidedownload;
    }

    public String getHidesponsor() {
        return hidesponsor;
    }

    public void setHidesponsor(String hidesponsor) {
        this.hidesponsor = hidesponsor;
    }

    public String getSelectedHighlight() {
        return selectedHighlight;
    }

    public void setSelectedHighlight(String selectedHighlight) {
        this.selectedHighlight = selectedHighlight;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getDelisted() {
        return delisted;
    }

    public void setDelisted(String delisted) {
        this.delisted = delisted;
    }

    public String getProducers() {
        return producers;
    }

    public void setProducers(String producers) {
        this.producers = producers;
    }

    public String getPresenters() {
        return presenters;
    }

    public void setPresenters(String presenters) {
        this.presenters = presenters;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getMp3fileSize() {
        return mp3fileSize;
    }

    public void setMp3fileSize(String mp3fileSize) {
        this.mp3fileSize = mp3fileSize;
    }

    public String getPublishedon() {
        return publishedon;
    }

    public void setPublishedon(String publishedon) {
        this.publishedon = publishedon;
    }

    public List<String> getGuestNames() {
        return guestNames;
    }

    public void setGuestNames(List<String> guestNames) {
        this.guestNames = guestNames;
    }

    public List<String> getSalutations() {
        return salutations;
    }

    public void setSalutations(List<String> salutations) {
        this.salutations = salutations;
    }

    public List<String> getGuestDesignations() {
        return guestDesignations;
    }

    public void setGuestDesignations(List<String> guestDesignations) {
        this.guestDesignations = guestDesignations;
    }

    public List<String> getGuestOrganisations() {
        return guestOrganisations;
    }

    public void setGuestOrganisations(List<String> guestOrganisations) {
        this.guestOrganisations = guestOrganisations;
    }

    public List<String> getGuests() {
        return guests;
    }

    public void setGuests(List<String> guests) {
        this.guests = guests;
    }


}
