package com.example.hima.historicalplace;

public class Places {
    private String name;
    private  String description;
    private  String country;
    private int image;
    private  int rate;

    public Places(String name, String description, String country, int image, int rate) {
        this.name = name;
        this.description = description;
        this.country = country;
        this.image = image;
        this.rate = rate;
    }

    public Places(String name, String description, String country, int image) {
        this.name = name;
        this.description = description;
        this.country = country;
        this.image = image;
    }

    public Places() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
