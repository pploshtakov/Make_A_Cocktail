package com.example.pesho.make_a_cocktail;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pesho.make_a_cocktail.model.drinks.Drink;
import com.example.pesho.make_a_cocktail.model.products.Product;

import java.util.ArrayList;

public class IngredientsFragment extends Fragment {

    private RecyclerView ingredientsRV;
    private  Activity activity;
    private IngredientsAdapter adapter;
    private ArrayList<Product> products;
    String loggedUser;
    private ArrayList<Product> currentProducts;

    public IngredientsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ingredients, container, false);
        ingredientsRV = (RecyclerView) view.findViewById(R.id.ingridientsRecyclerView);
        ingredientsRV.setLayoutManager(new LinearLayoutManager(getActivity()));
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
        currentProducts = products;
        adapter = new IngredientsAdapter(products,activity,loggedUser);
        ingredientsRV.setAdapter(adapter);
        // Inflate the layout for this fragment
        return view;
    }

    public void search(String newText) {
        ArrayList<Product> products = new ArrayList<>();
        newText = newText.toLowerCase();
        for (Product p: currentProducts) {
            String name = p.getName().toLowerCase();
            if (name.contains(newText)) {
                products.add(p);
            }
        }
        adapter = (IngredientsAdapter) ingredientsRV.getAdapter();
        adapter.setNewList(products);
        adapter.notifyDataSetChanged();
    }

    interface Communicator {
        String getLoggedUserName();
    }

    public void refreshList(ArrayList<Product> products,String tag) {
        adapter = (IngredientsAdapter)ingredientsRV.getAdapter();
        adapter.setNewList(products);
        currentProducts = products;
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
