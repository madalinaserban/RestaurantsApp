package com.example.myapplication;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityRestaurantBinding;

public class RestaurantActivity extends AppCompatActivity {
    ActivityRestaurantBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRestaurantBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        // Get the data passed from the MainActivity's intent
        String name = getIntent().getStringExtra("name");
        int imageResId = getIntent().getIntExtra("image", 0);
        String description = getIntent().getStringExtra("description");
        String webpage = getIntent().getStringExtra("webpage");
        String phone = getIntent().getStringExtra("phone");
        Float rating = getIntent().getFloatExtra("rating", 0);

        // Display the data in the UI

        binding.restaurantImage.setImageResource(imageResId);

        binding.restaurantName.setText(name);
        binding.restaurantRating.setRating(rating);
        binding.restaurantPhone.setText("Phone: " + phone);
        binding.restaurantDescription.setText(description);




        binding.showMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RestaurantActivity.this, RestaurantDetailsActivity.class);
                intent.putExtra("description", description);
                startActivity(intent);
            }
        });

        TextView webpageTextView = findViewById(R.id.webpage_link);
        webpageTextView.setText(webpage);
    }

    public void openWebpage(View view) {
        TextView textView = (TextView) view;
        String webpageUrl = textView.getText().toString();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://" + webpageUrl + "/"));
        startActivity(intent);
    }


}