package com.example.pesho.make_a_cocktail;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pesho.make_a_cocktail.model.drinks.Drink;
import com.example.pesho.make_a_cocktail.model.drinks.DrinksManager;
import com.example.pesho.make_a_cocktail.model.users.UsersManager;

import java.util.ArrayList;

/**
 * Created by Pesho on 9/13/2016.
 */
public class MyDrinkAdapter extends RecyclerView.Adapter<MyDrinkAdapter.MyViewHolder> {
    private ArrayList<Drink> drinks;
    private final View.OnClickListener mOnClickListener = new MyOnClickListener();
    private RecyclerView mRecyclerView;
    private String loggedUser;

    public MyDrinkAdapter(ArrayList<Drink> drinks, RecyclerView mRecyclerView, String loggedUser) {
        this.mRecyclerView = mRecyclerView;
        this.loggedUser = loggedUser;
        if (drinks != null) {
            this.drinks = drinks;
        }
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.drink_info_layout, parent, false);
        myView.setOnClickListener(mOnClickListener);
        MyViewHolder viewHolder = new MyViewHolder(myView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Drink drink = drinks.get(position);
        holder.drinkImageView.setImageResource(drink.getImage());
        holder.drinkTitleTextView.setText(drink.getName());
        holder.drinkCategoryTV.setText(drink.getStrCategory());
        if (drink.isFavorite()) {
            holder.drinkFavoriteImageButton.setImageResource(R.drawable.star2_pic);
        } else {
            holder.drinkFavoriteImageButton.setImageResource(R.drawable.star1_pic);
        }
        holder.drinkFavoriteImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drink drink = drinks.get(position);
                if (!drink.isFavorite()) {
                    holder.drinkFavoriteImageButton.setImageResource(R.drawable.star2_pic);
                    drink.setFavorite(true);
                    UsersManager.addFavoriteDrink(loggedUser,drink);
                } else {
                    holder.drinkFavoriteImageButton.setImageResource(R.drawable.star1_pic);
                    drink.setFavorite(false);
                    UsersManager.removeFavoriteDrink(loggedUser,drink);
                }
                DrinksManager.overwriteSharedPrefsDrinks(loggedUser);
            }
        });

    }

    @Override
    public int getItemCount() {
        return drinks.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView drinkImageView;
        TextView drinkTitleTextView;
        ImageButton drinkFavoriteImageButton;
        TextView drinkCategoryTV;

        public MyViewHolder(View itemView) {
            super(itemView);
            drinkImageView = (ImageView) itemView.findViewById(R.id.drink_info_pic);
            drinkTitleTextView = (TextView) itemView.findViewById(R.id.drink_info_title);
            drinkFavoriteImageButton = (ImageButton) itemView.findViewById(R.id.drink_info_favorite_button);
            drinkCategoryTV = (TextView) itemView.findViewById(R.id.drink_info_category);
        }
    }


    public class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int itemPosition = mRecyclerView.getChildLayoutPosition(v);
            Drink item = drinks.get(itemPosition);
            Intent intent = new Intent(v.getContext(), DrinkInfoActivity.class);
            Integer in = item.getImage();
            intent.putExtra("idDrink", item.getIdDrink());
            v.getContext().startActivity(intent);
        }
    }

    public void setNewList(ArrayList<Drink> drinks) {
        this.drinks = drinks;
    }
}
