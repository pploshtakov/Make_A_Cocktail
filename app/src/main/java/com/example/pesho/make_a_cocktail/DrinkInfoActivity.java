package com.example.pesho.make_a_cocktail;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pesho.make_a_cocktail.model.drinks.Drink;
import com.example.pesho.make_a_cocktail.model.drinks.DrinksManager;

public class DrinkInfoActivity extends AppCompatActivity {
    ImageView drinkIV;
    TextView titleTV;
    TextView instrTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_info);
        drinkIV = (ImageView) findViewById(R.id.info_image);
        titleTV = (TextView) findViewById(R.id.info_title_TV);
        instrTV = (TextView) findViewById(R.id.info_instructions_TV);
        Intent intent = getIntent();
        Drink drink = DrinksManager.getDrink(intent.getIntExtra("idDrink", 0));
        drinkIV.setImageResource(drink.getImage());
        titleTV.setText(drink.getName());
        instrTV.setText(drink.getStrInstructions());
    }
}
