package com.ASS2.restarauntlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantListAdapter.ViewHolder>{

    ArrayList<Restaurant> restaurants;
    RecyclerViewClickListener listener;

    public RestaurantListAdapter(ArrayList<Restaurant> restaurants, RecyclerViewClickListener listener){
        this.restaurants = restaurants;
        this.listener = listener;
    }

    public interface RecyclerViewClickListener{
        void onClick(View view, int position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_list_item, parent, false);
        return new ViewHolder(v, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Restaurant myCity = restaurants.get(position);
        holder.name.setText(myCity.getName());
        holder.cuisine.setText(myCity.getCuisine());
        holder.city.setText(myCity.getCity());
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name, cuisine, city;
        RecyclerViewClickListener mListener;

        public ViewHolder(@NonNull View itemView, RecyclerViewClickListener listener) {
            super(itemView);
            mListener = listener;
            itemView.setOnClickListener(this);
            name = itemView.findViewById(R.id.name);
            cuisine = itemView.findViewById(R.id.cuisine);
            city = itemView.findViewById(R.id.city);
        }

        @Override
        public void onClick(View v) {
            mListener.onClick(v, getAdapterPosition());
        }
    }
}
