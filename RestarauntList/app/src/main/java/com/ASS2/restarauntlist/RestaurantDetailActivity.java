package com.ASS2.restarauntlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class RestaurantDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);
            //exactly the same fragment implementation as in the main activity
        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();

            arguments.putString(fragment_restaurant_detail.ID_NAME, getIntent().getStringExtra(fragment_restaurant_detail.ID_NAME));
            arguments.putString(fragment_restaurant_detail.ID_CUISINE, getIntent().getStringExtra(fragment_restaurant_detail.ID_CUISINE));
            arguments.putString(fragment_restaurant_detail.ID_CITY, getIntent().getStringExtra(fragment_restaurant_detail.ID_CITY));
            arguments.putString(fragment_restaurant_detail.ID_RATING, getIntent().getStringExtra(fragment_restaurant_detail.ID_RATING) );
            arguments.putString(fragment_restaurant_detail.ID_DESC, getIntent().getStringExtra(fragment_restaurant_detail.ID_DESC));

            //TODO: Create new fragment, add detail data and display it in its container
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            fragment_restaurant_detail fragment = new fragment_restaurant_detail();
            fragment.setArguments(arguments);

            transaction.replace(R.id.restaurant_detail_container, fragment);
            transaction.commit();

        }

    }
}
