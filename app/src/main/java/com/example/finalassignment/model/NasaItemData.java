package com.example.finalassignment.model;

import com.google.gson.annotations.SerializedName;

public class NasaItemData {

    @SerializedName("date_created")
    private String dateCreated;

    @SerializedName("description")
    private String description;

    public NasaItemData(String dateCreated, String description, String nasaId, String title) {
        this.dateCreated = dateCreated;
        this.description = description;
        this.nasaId = nasaId;
        this.title = title;
    }

    @SerializedName("nasa_id")
    private String nasaId;

    @SerializedName("title")
    private String title;

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNasaId() {
        return nasaId;
    }

    public void setNasaId(String nasaId) {
        this.nasaId = nasaId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
