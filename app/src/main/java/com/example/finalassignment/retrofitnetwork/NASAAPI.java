package com.example.finalassignment.retrofitnetwork;

import com.example.finalassignment.model.NasaResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NASAAPI {
    @GET("/search")
    Call<NasaResponse> getAllSearchResults(@Query("q") String query);
}
