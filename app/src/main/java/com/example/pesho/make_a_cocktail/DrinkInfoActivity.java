package com.example.pesho.make_a_cocktail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pesho.make_a_cocktail.model.drinks.Drink;
import com.example.pesho.make_a_cocktail.model.drinks.DrinksManager;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class DrinkInfoActivity extends AppCompatActivity {
    ImageView drinkIV;
    TextView titleTV;
    TextView instrTV;
    TextView categoryTV;
    TextView glassTV;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_info);
        drinkIV = (ImageView) findViewById(R.id.info_image);
        titleTV = (TextView) findViewById(R.id.info_title_TV);
        instrTV = (TextView) findViewById(R.id.info_instructions_TV);
        categoryTV = (TextView) findViewById(R.id.drink_info_category_TV);
        glassTV = (TextView) findViewById(R.id.drink_info_glass_TV);
        Intent intent = getIntent();
        Drink drink = DrinksManager.getDrink(intent.getIntExtra("idDrink", 0));
        if (drink.getBmp() != null) {
            drinkIV.setImageBitmap(drink.getBmp());
        } else {
            drinkIV.setImageResource(drink.getImage());
        }
        titleTV.setText(drink.getName());
        instrTV.setText("Instructions: \n" + drink.getStrInstructions());
        categoryTV.setText("Category: \n" + drink.getStrCategory());
        glassTV.setText("Glass \n" + drink.getStrGlass());
    }


}





