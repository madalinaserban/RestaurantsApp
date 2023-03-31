package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<Restaurant> restaurantList = new ArrayList<>();
    int resource = R.layout.list_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize restaurant data
        restaurantList.add(new Restaurant("Pizza Hut", "Italian, Pizza", 4.5f, R.drawable.default_img));
        restaurantList.add(new Restaurant("Burger King", "Fast Food, Burgers", 3.8f, R.drawable.default_img));
        restaurantList.add(new Restaurant("Taco Bell", "Mexican, Tacos", 4.0f, R.drawable.default_img));
        restaurantList.add(new Restaurant("McDonald's", "Fast Food, Burgers", 3.5f, R.drawable.default_img));
        restaurantList.add(new Restaurant("KFC", "Fast Food, Fried Chicken", 4.2f, R.drawable.default_img));

        // Initialize ListView
        listView = findViewById(R.id.restaurant_list);

        // Initialize custom adapter
        RestaurantAdapter adapter = new RestaurantAdapter(this, resource,restaurantList);

        // Set the adapter for the ListView
        listView.setAdapter(adapter);

        // Set click listener for list items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Handle list item click event
                Restaurant restaurant = restaurantList.get(position);
                Toast.makeText(MainActivity.this, "Clicked on " + restaurant.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
