package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

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
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        restaurantList.add(new Restaurant("Pizza Hut", "Italian", 4.5f, R.drawable.pizzahut, R.drawable.pizzahut2,
                "Pizza Hut is an American restaurant chain and international franchise, known for its pizza and side dishes.","555-1234.", "www.pizzahut.ro"));
        restaurantList.add(new Restaurant("Burger King", "Fast Food", 3.8f, R.drawable.burgerking,R.drawable.burgerking2,
                "Burger King is an American multinational chain of hamburger fast food restaurants.","555-5678.", "www.burgerking.ro"));
        restaurantList.add(new Restaurant("Taco Bell", "Mexican", 4.0f, R.drawable.tacobell,R.drawable.tacobell2,
                "Taco Bell is an American chain of fast food restaurants specializing in Mexican-inspired food.","555-4321.", "www.taco-bell.ro"));
        restaurantList.add(new Restaurant("McDonald's", "Fast Food", 3.5f, R.drawable.mcdonalds,R.drawable.mc2,
                "McDonald's is an American fast food company, founded in 1940 as a restaurant operated by Richard and Maurice McDonald.","555-8765.", "www.mcdonalds.ro"));
        restaurantList.add(new Restaurant("KFC", "Fast Food", 4.2f, R.drawable.kfc, R.drawable.kfc2,
                "KFC is an American fast food restaurant chain that specializes in fried chicken.","555-2468.", "www.kfc.ro"));
        restaurantList.add(new Restaurant("Mesopotamia", "Fast Food", 4.5f, R.drawable.mesopotamia, R.drawable.mesopotamia2,
                "Mesopotamia is a Mediterranean fast food restaurant that serves shawarma, falafel, hummus and more.","555-9876.", "www.mesopotamia.ro"));
        restaurantList.add(new Restaurant("Chopstix", "Chinese", 5.0f, R.drawable.chopstix, R.drawable.chopsticks2,
                "Chopstix is a Chinese restaurant that serves authentic Chinese cuisine. ","555-5432.", "chopstix.ro"));



        // Initialize custom adapter
        RestaurantAdapter adapter = new RestaurantAdapter(MainActivity.this, restaurantList);
        binding.listviewRestaurants.setAdapter(adapter);
        binding.listviewRestaurants.setClickable(true);
        binding.listviewRestaurants.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Restaurant selectedRestaurant = (Restaurant) adapterView.getItemAtPosition(i);
                Intent detailIntent = new Intent(MainActivity.this, RestaurantActivity.class);
                // Pass data to the new activity as extras
                detailIntent.putExtra("name", selectedRestaurant.getName());
                detailIntent.putExtra("image", selectedRestaurant.getDetailsPicture());
                detailIntent.putExtra("description", selectedRestaurant.getDescription());
                detailIntent.putExtra("webpage", selectedRestaurant.getWebpage());
                detailIntent.putExtra("rating",selectedRestaurant.getRating());
                detailIntent.putExtra("phone",selectedRestaurant.getPhoneNumber());

                // Start the new activity
                startActivity(detailIntent);
            }
        });

        RadioGroup filterRadioGroup = findViewById(R.id.filter_radio_group);
        filterRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String selectedType = ((RadioButton) findViewById(checkedId)).getText().toString();

                List<Restaurant> filteredList = new ArrayList<>();
                if (selectedType.equals("All")) {
                    filteredList.addAll(restaurantList);
                } else {
                    for (Restaurant restaurant : restaurantList) {
                        if (restaurant.getType().equals(selectedType)) {
                            filteredList.add(restaurant);
                        }
                    }
                }

                RestaurantAdapter adapter = new RestaurantAdapter(MainActivity.this, filteredList);
                binding.headerText.setText(selectedType+" restaurants");
                binding.listviewRestaurants.setAdapter(adapter);
            }

        });

    }
}

