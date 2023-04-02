package com.example.myapplication;

import static android.widget.Toast.LENGTH_LONG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private List<Restaurant> restaurantList = new ArrayList<>();
    private int resource = R.layout.list_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize restaurant data
        restaurantList.add(new Restaurant("Pizza Hut", "Italian, Pizza", 4.5f, R.drawable.pizzahut));
        restaurantList.add(new Restaurant("Burger King", "Fast Food, Burgers", 3.8f, R.drawable.burgerking));
        restaurantList.add(new Restaurant("Taco Bell", "Mexican, Tacos", 4.0f, R.drawable.tacobell));
        restaurantList.add(new Restaurant("McDonald's", "Fast Food, Burgers", 3.5f, R.drawable.mcdonalds));
        restaurantList.add(new Restaurant("KFC", "Fast Food, Fried Chicken", 4.2f, R.drawable.kfc));
        restaurantList.add(new Restaurant("Mesopotamia", "Fast Food, Pizza", 4.5f, R.drawable.mesopotamia));
        restaurantList.add(new Restaurant("Chopstix", "Chinese, Noodles", 5.0f, R.drawable.chopstix));





        // Initialize custom adapter
        RestaurantAdapter adapter = new RestaurantAdapter(MainActivity.this,restaurantList);
        binding.listviewRestaurants.setAdapter(adapter);
        binding.listviewRestaurants.setClickable(true);
        binding.listviewRestaurants.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"Finally",LENGTH_LONG).show();
            }
        });
    }
}

