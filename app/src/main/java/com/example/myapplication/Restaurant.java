package com.example.myapplication;

public class Restaurant {

    private String name;
    private int imageResourceId;
    private int detailsPicture;
    private String description;
    private String webpage;
    private String phoneNumber;
    private String type;
    private float rating;

    public Restaurant(String name, String type, float rating, int imageResourceId, int detailsPicture, String description, String phoneNumber, String webpage) {
        this.name = name;
        this.type = type;
        this.rating = rating;
        this.imageResourceId = imageResourceId;
        this.detailsPicture = detailsPicture;
        this.description = description;
        this.webpage = webpage;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public int getDetailsPicture() {
        return detailsPicture;
    }


    public String getDescription() {
        return description;
    }


    public String getWebpage() {
        return webpage;
    }


    public int getImageResourceId() {
        return imageResourceId;
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
