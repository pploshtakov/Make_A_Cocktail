package com.example.pesho.make_a_cocktail.model.drinks;

import android.app.Activity;
import android.content.Context;
import android.util.JsonReader;
import android.util.Log;

import com.example.pesho.make_a_cocktail.R;
import com.example.pesho.make_a_cocktail.model.users.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by Pesho on 9/10/2016.
 */
public class DrinksManager {
    private static DrinksManager ourInstance;
    private static TreeMap<Integer, Drink> drinks = new TreeMap<>();


    public static DrinksManager getInstance(Activity activity) {
        if (ourInstance == null) {
            return new DrinksManager(activity);
        }
        return ourInstance;
    }

    private DrinksManager(Activity activity) {
//        try {
//            JsonReader json = new JsonReader(new InputStreamReader(new FileInputStream("drinkJSON")));
//        } catch (FileNotFoundException e) {
//            Log.e("Test", "test");
//            e.printStackTrace();
//            return;
//        }

        Drink drink1 = new Drink(13060, "Margarita", "Rub rim of cocktail glass with lime juice, dip rim in salt. Shake all ingredients with ice, strain into the salt-rimmed glass, and serve.", R.drawable.margarita_pic);
        Drink drink2 = new Drink(13061, "Margarita", "Rub rim of cocktail glass with lime juice, dip rim in salt. Shake all ingredients with ice, strain into the salt-rimmed glass, and serve.", R.drawable.margarita_pic);
        Drink drink3 = new Drink(13062, "Margarita", "Rub rim of cocktail glass with lime juice, dip rim in salt. Shake all ingredients with ice, strain into the salt-rimmed glass, and serve.", R.drawable.margarita_pic);
        Drink drink4 = new Drink(13063, "Margarita", "Rub rim of cocktail glass with lime juice, dip rim in salt. Shake all ingredients with ice, strain into the salt-rimmed glass, and serve.", R.drawable.margarita_pic);
        Drink drink5 = new Drink(13064, "Margarita", "Rub rim of cocktail glass with lime juice, dip rim in salt. Shake all ingredients with ice, strain into the salt-rimmed glass, and serve.", R.drawable.margarita_pic);
        Drink drink6 = new Drink(13065, "Margarita", "Rub rim of cocktail glass with lime juice, dip rim in salt. Shake all ingredients with ice, strain into the salt-rimmed glass, and serve.", R.drawable.margarita_pic);
        Drink drink7 = new Drink(13066, "Margarita", "Rub rim of cocktail glass with lime juice, dip rim in salt. Shake all ingredients with ice, strain into the salt-rimmed glass, and serve.", R.drawable.margarita_pic);
        Drink drink8 = new Drink(13067, "Margarita", "Rub rim of cocktail glass with lime juice, dip rim in salt. Shake all ingredients with ice, strain into the salt-rimmed glass, and serve.", R.drawable.margarita_pic);
        Drink drink9 = new Drink(13068, "Margarita", "Rub rim of cocktail glass with lime juice, dip rim in salt. Shake all ingredients with ice, strain into the salt-rimmed glass, and serve.", R.drawable.margarita_pic);
        Drink drink10 = new Drink(13069, "Margarita", "Rub rim of cocktail glass with lime juice, dip rim in salt. Shake all ingredients with ice, strain into the salt-rimmed glass, and serve.", R.drawable.margarita_pic);
        Drink drink11 = new Drink(130610, "Margarita", "Rub rim of cocktail glass with lime juice, dip rim in salt. Shake all ingredients with ice, strain into the salt-rimmed glass, and serve.", R.drawable.margarita_pic);
        Drink drink12 = new Drink(130611, "Margarita", "Rub rim of cocktail glass with lime juice, dip rim in salt. Shake all ingredients with ice, strain into the salt-rimmed glass, and serve.", R.drawable.margarita_pic);
        Drink drink13 = new Drink(130612, "Margarita", "Rub rim of cocktail glass with lime juice, dip rim in salt. Shake all ingredients with ice, strain into the salt-rimmed glass, and serve.", R.drawable.margarita_pic);

    }
    public static ArrayList<Drink> getList() {
        ArrayList<Drink> drinks1 = new ArrayList<>();
        drinks1.addAll(drinks.values());
        return drinks1;
    }

    public static void addDrink(Drink drink) {
        drinks.put(drink.getIdDrink(), drink);
    }
}
