package com.ASS2.restarauntlist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class fragment_restaurant_detail extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String ID_NAME = "ID_NAME";
    public static final String ID_CUISINE = "ID_CUISINE";
    public static final String ID_CITY = "ID_CITY";
    public static final String ID_RATING = "ID_RATING";
    public static final String ID_DESC = "ID_DESC";

    // TODO: Rename and change types of parameters
    private TextView tvName;
    private TextView tvCuisine;
    private TextView tvCity;
    private TextView tvRating;
    private TextView tvDesc;

    public fragment_restaurant_detail() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_restaurant_detail, container, false);
        tvName = rootView.findViewById(R.id.name);
        tvCuisine = rootView.findViewById(R.id.cuisine);
        tvCity = rootView.findViewById(R.id.city);
        tvRating = rootView.findViewById(R.id.rating);
        tvDesc = rootView.findViewById(R.id.desc);

        String name = getArguments().getString(fragment_restaurant_detail.ID_NAME);
        String cuisine = getArguments().getString(fragment_restaurant_detail.ID_CUISINE);
        String city = getArguments().getString(fragment_restaurant_detail.ID_CITY);
        String rating = getArguments().getString(fragment_restaurant_detail.ID_RATING);
        String desc = getArguments().getString(fragment_restaurant_detail.ID_DESC);

        tvName.setText(name);
        tvCuisine.setText(cuisine);
        tvCity.setText(city);
        tvRating.setText(rating);
        tvDesc.setText(desc);

        return rootView;
    }
}
