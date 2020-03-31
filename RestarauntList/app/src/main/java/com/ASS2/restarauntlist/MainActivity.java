package com.ASS2.restarauntlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "RestaurantListActivity";
    private boolean mTwoPane;

    ArrayList<Restaurant> restaurants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        restaurants = Restaurant.getResetaraunts();

        //used to check if current screen is wider than 900dp
        if(findViewById(R.id.restaurant_detail_container) != null){
            mTwoPane = true;
        }

        RestaurantListAdapter.RecyclerViewClickListener listener = new RestaurantListAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                if (mTwoPane) {
                    //if in tablet, create fragment and add the related info(name,cuisine,city,rating, description) to a bundle
                    Bundle arguments = new Bundle();
                    arguments.putString(fragment_restaurant_detail.ID_NAME, restaurants.get(position).getName());
                    arguments.putString(fragment_restaurant_detail.ID_CUISINE, restaurants.get(position).getCuisine());
                    arguments.putString(fragment_restaurant_detail.ID_CITY, restaurants.get(position).getCity());
                    arguments.putString(fragment_restaurant_detail.ID_RATING, restaurants.get(position).getRating());
                    arguments.putString(fragment_restaurant_detail.ID_DESC, restaurants.get(position).getDesc());

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();

                    fragment_restaurant_detail fragment = new fragment_restaurant_detail();
                    fragment.setArguments(arguments);

                    transaction.replace(R.id.restaurant_detail_container, fragment);
                    transaction.commit();
                } else {
                    //otherwise launch a method to change activites
                    String name = restaurants.get(position).getName();
                    String cuisine = restaurants.get(position).getCuisine();
                    String city = restaurants.get(position).getCity();
                    String rating = restaurants.get(position).getRating();
                    String desc = restaurants.get(position).getDesc();
                    changeActivities(view, name, cuisine, city, rating, desc);
                }
            }
        };

        RecyclerView recyclerView = findViewById(R.id.restaurant_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new RestaurantListAdapter(restaurants, listener));

    }

    public void changeActivities(View view, String name, String cuisine, String city, String rating, String desc) {


        Intent explicitIntent = new Intent(this, RestaurantDetailActivity.class);
        explicitIntent.putExtra(fragment_restaurant_detail.ID_NAME, name);
        explicitIntent.putExtra(fragment_restaurant_detail.ID_CUISINE, cuisine);
        explicitIntent.putExtra(fragment_restaurant_detail.ID_CITY,city);
        explicitIntent.putExtra(fragment_restaurant_detail.ID_RATING,rating);
        explicitIntent.putExtra(fragment_restaurant_detail.ID_DESC, desc);
        startActivity(explicitIntent);

    }

}
