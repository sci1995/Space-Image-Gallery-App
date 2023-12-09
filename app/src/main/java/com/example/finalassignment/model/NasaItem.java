package com.example.finalassignment.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NasaItem {
    @SerializedName("data")
    private List<NasaItemData> data;

    @SerializedName("href")
    private String href;

    @SerializedName("links")
    private List<NasaItemLink> links;

    public NasaItem(List<NasaItemData> data, String href, List<NasaItemLink> links) {
        this.data = data;
        this.href = href;
        this.links = links;
    }

    public List<NasaItemData> getData() {
        return data;
    }

    public void setData(List<NasaItemData> data) {
        this.data = data;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<NasaItemLink> getLinks() {
        return links;
    }

    public void setLinks(List<NasaItemLink> links) {
        this.links = links;
    }
}
