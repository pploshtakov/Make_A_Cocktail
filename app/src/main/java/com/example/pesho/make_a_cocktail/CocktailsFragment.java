package com.example.pesho.make_a_cocktail;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pesho.make_a_cocktail.model.drinks.Drink;
import com.example.pesho.make_a_cocktail.model.drinks.DrinksManager;


/**
 * A simple {@link Fragment} subclass.
 */
public class CocktailsFragment extends Fragment {


    public CocktailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cocktails, container, false);
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.cocktail_recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        MyDrinkAdapter adapter = new MyDrinkAdapter(DrinksManager.getList());
        rv.setAdapter(adapter);
        return view;
        //return inflater.inflate(R.layout.fragment_cocktails, container, false);
    }

}
