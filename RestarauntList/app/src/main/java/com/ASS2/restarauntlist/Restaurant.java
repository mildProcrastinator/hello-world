package com.ASS2.restarauntlist;

import java.util.ArrayList;

public class Restaurant {


    //OO programming basics, restaurant class to store all of the restaurant's details
    private String name;
    private String city;
    private String cuisine;
    private String desc;
    private String rating;

    public Restaurant(String name, String city, String cuisine, String desc, String rating) {
        this.name = name;
        this.city = city;
        this.cuisine = cuisine;
        this.desc = desc;
        this.rating = rating;
    }
    //method to call list of restaurants
    public static ArrayList<Restaurant> getResetaraunts() {
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("Thaitanic", "Casula", "Thai","Casual Dining - Thai.\n Offers home delivery, takeaway, BYO, and indoor seating", "1/3"));
        restaurants.add(new Restaurant("That's Fishy", "Casula", "Fish'n'Chips","Cooked to order fish, steaks and burgers with the option of grilled or fried served with salad or chips or both!", "3/3"));
        restaurants.add(new Restaurant("Gloria Jeans", "Hoxton Park", "Cafe","Coffee Chain, nothing remarkable", "0/3"));
        restaurants.add(new Restaurant("La Mono", "Hoxton Park", "Charcoal Chicken","At La Mono, we serve up delicious, fresh, authentic Lebanese cuisine including our famous charcoal chicken.", "2/3"));
        restaurants.add(new Restaurant("Chan's Canton Village", "Casula", "Chinese", "Chan's Canton Village is one of the finest establishments in the region. The exquisite cuisine and the authentic decor makes visiting this house\n of culture an absolute delight.", "3/3"));
        restaurants.add(new Restaurant("Enzos Cucina", "Casula", "Italian","Enzo’s Cucina Casula is one of our more intimate locations. Lia (Owner and Enzo’s mother-in-law) has over 30 years of hospitality experience. Lia \nbrings a simple but effective philosophy to Enzo’s Cucina – good staff, perfect food and great service.", "2/3"));
        restaurants.add(new Restaurant("ROCCO'S", "Casula", "Fine Dining","Quite expensive, although the atmosphere and quality of food is quite remarkable", "3/3"));
        restaurants.add(new Restaurant("Little Ceasar's", "Casula", "Pizza","Can't go wrong with this pizza chain", "1/3"));
        restaurants.add(new Restaurant("An Restaurant", "Bankstown", "Vietnamese, Pho","Serving Northern Vietnamese style cuisine, the Pho Bo is a speciality", "1/3"));
        restaurants.add(new Restaurant("Aswar Baghdad", "Farfield Heights", "Iraqi","Traditional Iraqi food at an affordable price", "2/3"));

        return restaurants;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
