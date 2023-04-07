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
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class RestaurantAdapter extends ArrayAdapter<Restaurant> {


    public RestaurantAdapter(Context context, List<Restaurant> restaurantList) {
        super(context, R.layout.list_item, restaurantList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Restaurant restaurant = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.restaurant_image);
        TextView nameTextView = convertView.findViewById(R.id.restaurant_name);
        RatingBar ratingBar = convertView.findViewById(R.id.restaurant_rating);
        CardView cardView = convertView.findViewById(R.id.card_view);


        imageView.setImageResource(restaurant.getImageResourceId());
        nameTextView.setText(restaurant.getName());
        ratingBar.setRating(restaurant.getRating());
        int color;
        switch (restaurant.getType()) {
            case "Italian":
                color = ContextCompat.getColor(getContext(), R.color.btn_italian);
                break;
            case "Fast Food":
                color = ContextCompat.getColor(getContext(), R.color.btn_fastfood);
                break;
            case "Chinese":
                color = ContextCompat.getColor(getContext(), R.color.btn_chinese);
                break;
            case "Mexican":
                color = ContextCompat.getColor(getContext(), R.color.btn_mexican);
                break;
            default:
                color = ContextCompat.getColor(getContext(), R.color.default_btn_color);
                break;
        }
        cardView.setCardBackgroundColor(color);


        return convertView;
    }

}
