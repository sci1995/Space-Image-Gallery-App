package com.example.finalassignment.model;

import com.google.gson.annotations.SerializedName;

public class NasaItemLink {

    public NasaItemLink(String href) {
        this.href = href;
    }

    @SerializedName("href")
    private String href;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
