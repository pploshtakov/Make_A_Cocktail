package com.example.pesho.make_a_cocktail;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pesho.make_a_cocktail.model.drinks.Drink;
import com.example.pesho.make_a_cocktail.model.drinks.DrinksManager;


/**
 * A simple {@link Fragment} subclass.
 */
public class CocktailsFragment extends Fragment {
    Activity activity;
    MyDrinkAdapter adapter;
    RecyclerView rv;
    String loggedUser;

    public CocktailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cocktails, container, false);
        Intent intent = getActivity().getIntent();
        loggedUser = ((Communicator)activity).getLoggedUserName();
        rv = (RecyclerView) view.findViewById(R.id.cocktail_recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new MyDrinkAdapter(DrinksManager.getList(), rv, loggedUser);
        rv.setAdapter(adapter);
        return view;
        //return inflater.inflate(R.layout.fragment_cocktails, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = (Activity) context;
    }

    interface Communicator {
        String getLoggedUserName();
    }

    @Override
    public void onResume() {
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new MyDrinkAdapter(DrinksManager.getList(), rv, loggedUser);
        rv.setAdapter(adapter);
        super.onResume();
    }
}
