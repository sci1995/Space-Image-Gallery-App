package com.example.finalassignment.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;


public class NasaCollection {

    @SerializedName("items")
    private List<NasaItem> items;

    public NasaCollection(List<NasaItem> items){
        this.items = items;
    }

    public List<NasaItem> getItems() {
        return items;
    }

    public void setItems(List<NasaItem> items) {
        this.items = items;
    }
}
