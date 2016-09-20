package com.example.pesho.make_a_cocktail;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pesho.make_a_cocktail.R;
import com.example.pesho.make_a_cocktail.model.drinks.Drink;
import com.example.pesho.make_a_cocktail.model.products.Product;
import com.example.pesho.make_a_cocktail.model.products.ProductManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IngredientsFragment extends Fragment {

    private RecyclerView ingridientsRV;
    private  Activity activity;
    private  IngridientsAdapter adapter;
    private ArrayList<Product> products;
    String loggedUser;

    public IngredientsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ingredients, container, false);
        ingridientsRV = (RecyclerView) view.findViewById(R.id.ingridientsRecyclerView);
        ingridientsRV.setLayoutManager(new LinearLayoutManager(getActivity()));
        loggedUser = ((Communicator)activity).getLoggedUserName();

       // products = ProductManager.getProducts();
        products = new ArrayList<>();
        Product tequila = new Product("Tequila", R.drawable.tequila ,true);
        Product whiskey = new Product("Whiskey",R.drawable.whiskey ,true);
        Product rum = new Product("Rum",R.drawable.rum ,true);
        Product grenadine = new Product("Grenadine",R.drawable.grenadine ,true);

        products.add(tequila);
        products.add(whiskey);
        products.add(rum);
        products.add(grenadine);
        adapter = new IngridientsAdapter(products,activity,loggedUser);
        ingridientsRV.setAdapter(adapter);
        // Inflate the layout for this fragment
        return view;
    }

    interface Communicator {
        String getLoggedUserName();
    }

    public void refreshList(ArrayList<Product> products,String tag) {
        adapter = (IngridientsAdapter) ingridientsRV.getAdapter();
        adapter.setNewList(products);
        adapter.setTag(tag);
        this.products = products;
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = (Activity) context;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
