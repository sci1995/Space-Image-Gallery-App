package com.example.finalassignment.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.finalassignment.AdaptorNasa;
import com.example.finalassignment.R;
import com.example.finalassignment.model.NasaCollection;
import com.example.finalassignment.model.NasaItem;
import com.example.finalassignment.model.NasaItemData;
import com.example.finalassignment.model.NasaItemLink;
import com.example.finalassignment.model.NasaResponse;
import com.example.finalassignment.retrofitnetwork.NASAAPI;
import com.example.finalassignment.retrofitnetwork.RetrofitClientInst;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class SecondActivityRecyclerView extends AppCompatActivity {

    private AdaptorNasa adapter;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_recycler_view);


        Intent intent = getIntent();
        String strmessage = intent.getStringExtra("message");


        NASAAPI service = RetrofitClientInst.getRetrofitInstance().create(NASAAPI.class);

        Log.i("AB", "Before making call");
        Call<NasaResponse> call = service.getAllSearchResults(strmessage);
        call.enqueue(new Callback<NasaResponse>() {

            @Override
            @EverythingIsNonNull
            public void onResponse(Call<NasaResponse> call, Response<NasaResponse> response) {
                Log.i("AB", "Success making call");
                if (response.isSuccessful()) {
                    generateDataList(response.body().getCollection());
                } else {
                    Toast.makeText(SecondActivityRecyclerView.this,
                            "Error: " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            @EverythingIsNonNull
            public void onFailure(Call<NasaResponse> call, Throwable t) {
                Log.i("AB", "Failure making call");
                Toast.makeText(SecondActivityRecyclerView.this,
                        "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateDataList(NasaCollection collection) {
        if (collection != null && collection.getItems() != null) {

            recyclerView = findViewById(R.id.ImageRecyclerView);
            adapter = new AdaptorNasa(collection.getItems(),this);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SecondActivityRecyclerView.this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }

//            for (NasaItem item : collection.getItems()) {
//                // Iterate through NasaItemData objects
//                if (item.getData() != null) {
//                    for (NasaItemData data : item.getData()) {
//                        Log.d("NASA_API", "Title: " + data.getTitle());
//                        Log.d("NASA_API", "Description: " + data.getDescription());
//                        // Add more fields as needed
//                        // Example: Log.d("NASA_API", "Field: " + data.getField());
//                        Log.d("NASA_API", "---------------------");
//                    }
//                }
//
//                // Iterate through NasaItemLink objects
//                if (item.getLinks() != null) {
//                    for (NasaItemLink link : item.getLinks()) {
//                        Log.d("NASA_image", "link: " + link.getHref());
//                    }
//                }
//            }
//        }

    }
}