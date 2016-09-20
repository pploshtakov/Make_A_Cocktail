package com.example.pesho.make_a_cocktail;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pesho.make_a_cocktail.model.products.Product;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Simeon Angelov on 19.9.2016 г..
 */
public class IngridientsAdapter extends RecyclerView.Adapter<IngridientsAdapter.MyViewHolder>{

    private HashMap<String,Product> products;
    Activity activity;

    public IngridientsAdapter(HashMap<String,Product> products,Activity activity) {
        Log.e("Collection", products.values().toString());
        this.products = products;
        this.activity = activity;
    }

    @Override
    public IngridientsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = activity.getLayoutInflater().inflate(R.layout.adapter_product,parent,false);
        return new MyViewHolder(row);
    }

    @Override
    public void onBindViewHolder(IngridientsAdapter.MyViewHolder holder, int position) {
        Product p = products.get(position);
        holder.image.setImageResource(p.getImage());
        holder.name.setText(p.getName());

        //TODO: setOnClickListener for cart button to add in shopping list
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name;

        public MyViewHolder(View row) {
            super(row);
            image = (ImageView) row.findViewById(R.id.ingridientImageView);
            name = (TextView) row.findViewById(R.id.ingridientNameTV);
        }
    }

    //set adapter and layout manager

}
