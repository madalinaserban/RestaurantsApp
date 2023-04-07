package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.databinding.ActivityRestaurantBinding;
import com.example.myapplication.databinding.ActivityRestaurantDetailsBinding;

public class RestaurantDetailsActivity extends AppCompatActivity {
    ActivityRestaurantDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRestaurantDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Intent intent = getIntent();
        String description = intent.getStringExtra("description");
        binding.restaurantDescription.setText(description);

        binding.showLessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
