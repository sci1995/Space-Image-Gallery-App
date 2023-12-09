package com.example.finalassignment.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.finalassignment.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Initialize the EditText after inflating the binding
        TextView editText = findViewById(R.id.editTextText);

        findViewById(R.id.button).setOnClickListener(view -> {
            String searchText = editText.getText().toString();
            if (!searchText.isEmpty()) {
                Intent intent = new Intent(getApplicationContext(), SecondActivityRecyclerView.class);
                intent.putExtra("message", searchText);
                startActivity(intent);
            }
        });


    }
}
