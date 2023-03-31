package com.example.myapplication;

public class Restaurant {

    private String name;
    private int imageResourceId;
    private String location;
    private float rating;

    public Restaurant(String name,String location, float rating,int imageResourceId) {
        this.name = name;
        this.location = location;
        this.rating = rating;
        this.imageResourceId=imageResourceId;
    }
    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public float getRating() {
        return rating;
    }
}
