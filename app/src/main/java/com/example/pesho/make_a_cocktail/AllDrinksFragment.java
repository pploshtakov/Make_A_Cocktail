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

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllDrinksFragment extends Fragment {
    Activity activity;
    MyDrinkAdapter adapter;
    RecyclerView rv;
    String loggedUser;
    ArrayList<Drink> currentDrinks = new ArrayList<>();

    public AllDrinksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_drinks, container, false);
        Intent intent = getActivity().getIntent();
        loggedUser = ((Communicator)activity).getLoggedUserName();
        rv = (RecyclerView) view.findViewById(R.id.cocktail_recycler_view);
       // rv.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        currentDrinks = DrinksManager.getList();
        adapter = new MyDrinkAdapter(currentDrinks, rv, loggedUser);
        rv.setAdapter(adapter);

        return view;
        //return inflater.inflate(R.layout.fragment_cocktails, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = (Activity) context;
    }
    //TODO !!!
    public void refreshList(ArrayList<Drink> drinks) {
        adapter = (MyDrinkAdapter) rv.getAdapter();
        adapter.setNewList(drinks);
        currentDrinks = drinks;
        adapter.notifyDataSetChanged();
    }
    //search drinks in current list
    public void search (String newText) {
        ArrayList<Drink> drink = new ArrayList<>();
        newText = newText.toLowerCase();
        for (Drink d: currentDrinks) {
            String name = d.getName().toLowerCase();
            if (name.contains(newText)) {
                drink.add(d);
            }
        }
        adapter = (MyDrinkAdapter) rv.getAdapter();
        adapter.setNewList(drink);
        adapter.notifyDataSetChanged();
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
