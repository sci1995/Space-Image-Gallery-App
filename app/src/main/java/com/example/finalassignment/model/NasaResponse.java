package com.example.finalassignment.model;

import com.google.gson.annotations.SerializedName;

public class NasaResponse {

    @SerializedName("collection")
    private NasaCollection collection;

    public NasaCollection getCollection() {
        return collection;
    }

    public void setCollection(NasaCollection collection) {
        this.collection = collection;
    }
}
