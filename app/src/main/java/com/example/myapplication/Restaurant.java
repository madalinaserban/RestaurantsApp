package com.example.myapplication;

public class Restaurant {

    private String name;
    private int imageResourceId;
    private int detailsPicture;
    private String description;
    private String webpage;
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDetailsPicture() {
        return detailsPicture;
    }

    public void setDetailsPicture(int detailsPicture) {
        this.detailsPicture = detailsPicture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebpage() {
        return webpage;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    private String type;
    private float rating;


    public Restaurant(String name,String type, float rating,int imageResourceId,int detailsPicture, String description,String phoneNumber,String webpage) {
        this.name = name;
        this.type = type;
        this.rating = rating;
        this.imageResourceId=imageResourceId;
        this.detailsPicture=detailsPicture;
        this.description=description;
        this.webpage=webpage;
        this.phoneNumber=phoneNumber;
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
