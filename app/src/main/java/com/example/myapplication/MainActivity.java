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
                "Pizza Hut is an American restaurant chain and international franchise, known for its pizza and side dishes. It was founded in 1958 by two brothers, Dan and Frank Carney, in Wichita, Kansas. Today, Pizza Hut is one of the world's largest pizza chains, with more than 18,000 restaurants in over 100 countries. The company's signature dish is the pan pizza, which is known for its crispy crust and generous toppings. In addition to pizza, Pizza Hut also offers a variety of other dishes, including pasta, wings, and desserts. With its warm and inviting atmosphere, friendly service, and delicious food, Pizza Hut is the perfect place to enjoy a casual meal with family and friends.","555-1234.", "www.pizzahut.ro"));
        restaurantList.add(new Restaurant("Burger King", "Fast Food", 3.8f, R.drawable.burgerking,R.drawable.burgerking2,
                "Burger King is an American multinational chain of hamburger fast food restaurants. It was founded in 1953 in Jacksonville, Florida, by James McLamore and David Edgerton. Today, Burger King is one of the largest fast food chains in the world, with more than 17,000 restaurants in over 100 countries. The company is known for its flame-grilled burgers, which are made with 100% beef and served on a sesame seed bun. In addition to burgers, Burger King also offers a variety of other fast food items, including chicken sandwiches, fries, and milkshakes. With its quick and convenient service, affordable prices, and delicious food, Burger King is a popular choice for people on-the-go.","555-5678.", "www.burgerking.ro"));
        restaurantList.add(new Restaurant("Taco Bell", "Mexican", 4.0f, R.drawable.tacobell,R.drawable.tacobell2,
                "Taco Bell is an American chain of fast food restaurants specializing in Mexican-inspired food. It was founded in 1962 by Glen Bell in Downey, California. Today, Taco Bell is one of the largest fast food chains in the world, with more than 7,000 restaurants in over 30 countries. The company's signature dish is the taco, which is made with a crispy or soft shell and filled with seasoned beef, lettuce, cheese, and other toppings. In addition to tacos, Taco Bell also offers a variety of other Mexican-inspired dishes, including burritos, nachos, and quesadillas. With its bold and spicy flavors, convenient service, and affordable prices, Taco Bell is a popular choice for people who love Mexican food.","555-4321.", "www.taco-bell.ro"));
        restaurantList.add(new Restaurant("McDonald's", "Fast Food", 3.5f, R.drawable.mcdonalds,R.drawable.mc2,
                "McDonald's is an American fast food company, founded in 1940 as a restaurant operated by Richard and Maurice McDonald. Today, McDonald's is one of the largest fast food chains in the world, with more than 38,000 restaurants in over 100 countries. The company is known for its hamburgers, which are made with 100% beef and served on a sesame seed bun. In addition to hamburgers, McDonald's also offers a variety of other fast food items, including chicken sandwiches, fries, and breakfast items. With its iconic golden arches, friendly service, and affordable prices, McDonald's is a popular choice for people of all ages.","555-8765.", "www.mcdonalds.ro"));
        restaurantList.add(new Restaurant("KFC", "Fast Food", 4.2f, R.drawable.kfc, R.drawable.kfc2,
                "KFC is an American fast food restaurant chain that specializes in fried chicken. It was founded in 1930 by Harland Sanders in Corbin, Kentucky. Today, KFC is one of the largest fast food chains in the world, with more than 23,000 restaurants in over 140 countries. The company's signature dish is the Original Recipe fried chicken, which is made with a secret blend of 11 herbs and spices. In addition to fried chicken, KFC also offers a variety of other fast food items, including chicken sandwiches, fries, and coleslaw. With its finger-licking good chicken, friendly service, and convenient locations, KFC is a popular choice for people who love fried chicken.","555-2468.", "www.kfc.ro"));
        restaurantList.add(new Restaurant("Mesopotamia", "Fast Food", 4.5f, R.drawable.mesopotamia, R.drawable.mesopotamia2,
                "Mesopotamia is a Mediterranean fast food restaurant that serves a range of delicious and healthy dishes. Located in the heart of the city, Mesopotamia has become a popular destination for food lovers. The restaurant specializes in shawarma, falafel, hummus, and more. The food is made using the freshest ingredients and the recipes are authentic and traditional. Mesopotamia is committed to offering customers a unique dining experience that is both healthy and delicious. The restaurant has a cozy and welcoming atmosphere, perfect for a quick lunch or a relaxed dinner with friends and family. With its friendly staff and excellent service, Mesopotamia is a must-visit for anyone looking for great Mediterranean cuisine.","555-9876.", "www.mesopotamia.ro"));
        restaurantList.add(new Restaurant("Chopstix", "Chinese", 5.0f, R.drawable.chopstix, R.drawable.chopsticks2,
                "Chopstix is a Chinese restaurant that serves authentic Chinese cuisine. Located in a beautiful and spacious setting, Chopstix is the perfect place to enjoy a delicious meal with friends and family. The restaurant has a wide range of dishes on its menu, from traditional favorites such as Kung Pao Chicken and Beef with Broccoli, to more exotic options like Peking Duck and Ma Po Tofu. The food is made using fresh ingredients and traditional cooking techniques to ensure that every dish is full of flavor and authentic. Chopstix also offers a selection of vegetarian and gluten-free options for those with special dietary needs. With its elegant decor, attentive service, and excellent food, Chopstix is one of the best Chinese restaurants in the city and is a must-visit for anyone looking for a memorable dining experience. ","555-5432.", "chopstix.ro"));



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

