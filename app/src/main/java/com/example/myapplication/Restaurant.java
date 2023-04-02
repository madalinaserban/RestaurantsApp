package com.example.myapplication;

public class Restaurant {

    private String name;
    private int imageResourceId;
    private String type;
    private float rating;

    public Restaurant(String name,String type, float rating,int imageResourceId) {
        this.name = name;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public float getRating() {
        return rating;
    }
}
