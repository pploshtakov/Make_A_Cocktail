package com.example.pesho.make_a_coctail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import static com.example.pesho.make_a_coctail.R.array.drinks;

public class ShopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        //menu spinner
        Spinner menuSpinner = (Spinner) findViewById(R.id.SPMenu);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.menu, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        menuSpinner.setAdapter(adapter);
        //categories spinner
        Spinner categorieSpinner = (Spinner) findViewById(R.id.SPCategories);
        ArrayAdapter categories = ArrayAdapter.createFromResource(this, R.array.categories, android.R.layout.simple_spinner_item);
        categories.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorieSpinner.setAdapter(categories);
        //list of drinks
        ListView drinks = (ListView) findViewById(R.id.SPListView);
        ArrayAdapter drinkAdapter = ArrayAdapter.createFromResource(this, R.array.drinks, android.R.layout.simple_list_item_1);
        drinks.setAdapter(drinkAdapter);

    }
}
