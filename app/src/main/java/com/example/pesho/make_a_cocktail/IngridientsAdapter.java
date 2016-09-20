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
    String tag;

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
        Log.e("bar", Integer.toString(products.size()));
        final Product p = products.get(position);
        holder.image.setImageResource(p.getImage());
        holder.name.setText(p.getName());

        //edit button
        if(tag == null ){
            holder.button.setImageResource(R.mipmap.shopping_cart);
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    UsersManager.getShoppingList(loggedUser).addProduct(p);
                }
            });
        }
        else if (tag.equals("Bar Shelf")){
            //remove product from bar shelf and set button to X
            holder.button.setImageResource(R.drawable.cancel);
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    UsersManager.getBarShelf(loggedUser).getProducts().remove(p);
                }
            });
        }
        else if(tag.equals("Shop")) {
            holder.button.setImageResource(R.mipmap.shopping_cart);
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    UsersManager.getShoppingList(loggedUser).addProduct(p);
                }
            });
        }else if(tag.equals("Shopping list")){
            holder.button.setImageResource(R.mipmap.shopping_cart);
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    UsersManager.getShoppingList(loggedUser).removeProduct(p);
                    UsersManager.getBarShelf(loggedUser).addProduct(p);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void setNewList(ArrayList<Product> products) {
        this.products = products;
    }


    public void setTag(String tag) {
        this.tag = tag;
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
