package com.example.finalassignment.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.finalassignment.R;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

public class ThirdRecyclerItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_recycler_item);

        Intent intent = getIntent();
        if (intent != null) {
            // Retrieve title, description, and image URL
            String title = intent.getStringExtra("title");
            String description = intent.getStringExtra("description");
            String imageUrl = intent.getStringExtra("imageUrl");

            // Find TextViews and ImageView in your layout
            TextView textViewTitle = findViewById(R.id.bigimgtitle);
            TextView textViewDescription = findViewById(R.id.bigimgdescription);
            ImageView imageView = findViewById(R.id.bigimage);

            // Set the received data to the UI components
            if (textViewTitle != null) {
                textViewTitle.setText(title);
            }

            if (textViewDescription != null) {
                textViewDescription.setText(description);
            }

            if (imageView != null) {
                // Load image using Picasso
                Picasso.Builder builder = new Picasso.Builder(this);
                builder.downloader(new OkHttp3Downloader(this));
                builder.build().load(imageUrl)
                        .placeholder((R.drawable.ic_launcher_background))
                        .error(R.drawable.ic_launcher_background)
                        .into(imageView);
            }
        }
    }
}