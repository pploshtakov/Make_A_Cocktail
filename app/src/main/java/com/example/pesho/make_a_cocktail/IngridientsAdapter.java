package com.example.pesho.make_a_cocktail;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pesho.make_a_cocktail.model.products.Product;
import com.example.pesho.make_a_cocktail.model.users.UsersManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Simeon Angelov on 19.9.2016 г..
 */
public class IngridientsAdapter extends RecyclerView.Adapter<IngridientsAdapter.MyViewHolder>{

    private ArrayList<Product> products;
    Activity activity;
    String loggedUser;

    public IngridientsAdapter(ArrayList<Product> products,Activity activity,String loggedUser) {
        this.products = products;
        this.activity = activity;
        this.loggedUser = loggedUser;
    }

    @Override
    public IngridientsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = activity.getLayoutInflater().inflate(R.layout.adapter_product,parent,false);
        return new MyViewHolder(row);
    }

    @Override
    public void onBindViewHolder(IngridientsAdapter.MyViewHolder holder, int position) {
        final Product p = products.get(position);
        holder.image.setImageResource(p.getImage());
        holder.name.setText(p.getName());

        if(/*shop fragment*/) {
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    UsersManager.getShoppingList(loggedUser).addProduct(p);
                }
            });
        }else if(/*shopping list fragment*/){
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    UsersManager.getBarShelf(loggedUser).addProduct(p);
                }
            });
        }else{
            //remove product from bar shelf and set button to X
            holder.button.setImageResource(R.drawable.cancel);
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    UsersManager.getBarShelf(loggedUser).getProducts().remove(p);
                }
            });

        }


        //TODO: setOnClickListener for cart button to add in shopping list
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name;
        ImageButton button;

        public MyViewHolder(View row) {
            super(row);
            image = (ImageView) row.findViewById(R.id.ingridientImageView);
            name = (TextView) row.findViewById(R.id.ingridientNameTV);
            button = (ImageButton) row.findViewById(R.id.shoppingCartButton);
        }
    }

    //set adapter and layout manager

}
