package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class RestaurantAdapter extends ArrayAdapter<Restaurant> {
        private Context context;
        private int resource;
        private List<Restaurant> restaurantList;

        public RestaurantAdapter(Context context, int resource, List<Restaurant> restaurantList) {
            super(context, resource, restaurantList);
            this.context = context;
            this.resource = resource;
            this.restaurantList = restaurantList;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View view = convertView;

            if (view == null) {
                LayoutInflater inflater = LayoutInflater.from(context);
                view = inflater.inflate(resource, null);
            }

            ImageView imageView = view.findViewById(R.id.restaurant_image);
            TextView nameTextView = view.findViewById(R.id.restaurant_name);
          //  TextView ratingTextView = view.findViewById(R.id.restaurant_rating);
            RatingBar ratingBar = view.findViewById(R.id.restaurant_rating);

            Restaurant restaurant = restaurantList.get(position);

            imageView.setImageResource(restaurant.getImageResourceId());
            nameTextView.setText(restaurant.getName());
          //  ratingTextView.setText(String.valueOf(restaurant.getRating()));
            ratingBar.setRating(restaurant.getRating());

            return view;
        }

}
