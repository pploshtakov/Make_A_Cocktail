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

import com.example.pesho.make_a_cocktail.R;
import com.example.pesho.make_a_cocktail.model.products.Product;

import java.util.List;

public class IngredientsFragment extends Fragment {

    private RecyclerView ingridientsRV;
    private  Activity activity;
    private  IngridientsAdapter adapter;
    List<Product> products;

    public IngredientsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ingredients, container, false);
        ingridientsRV = (RecyclerView) view.findViewById(R.id.ingridientsRecyclerView);
        ingridientsRV.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new IngridientsAdapter(products,activity);
        ingridientsRV.setAdapter(adapter);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ingredients, container, false);
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
