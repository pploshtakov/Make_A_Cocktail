package com.example.pesho.make_a_cocktail;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pesho.make_a_cocktail.model.drinks.Drink;

import java.util.ArrayList;

/**
 * Created by Pesho on 9/13/2016.
 */
public class MyDrinkAdapter extends RecyclerView.Adapter<MyDrinkAdapter.MyViewHolder> {
    private ArrayList<Drink> drinks;
    public MyDrinkAdapter(ArrayList<Drink> drinks) {
        if (drinks != null) {
            this.drinks = drinks;
        } else {
            drinks = new ArrayList<>();
        }
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.drink_info_layout, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(myView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Drink drink = drinks.get(position);
        holder.drinkImageView.setImageResource(drink.getImage());
        holder.drinkTitleTextView.setText(drink.getName());
        if (drink.isFavorite()) {
            holder.drinkFavoriteImageButton.setImageResource(R.drawable.favorite_pic);
        } else {
            holder.drinkFavoriteImageButton.setImageResource(R.drawable.heart_pic);
        }
    }

    @Override
    public int getItemCount() {
        return drinks.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView drinkImageView;
        TextView drinkTitleTextView;
        ImageButton drinkFavoriteImageButton;

        public MyViewHolder(View itemView) {
            super(itemView);
            drinkImageView = (ImageView) itemView.findViewById(R.id.drink_info_pic);
            drinkTitleTextView = (TextView) itemView.findViewById(R.id.drink_info_title);
            drinkFavoriteImageButton = (ImageButton) itemView.findViewById(R.id.drink_info_favorite_button);
        }
    }


}
