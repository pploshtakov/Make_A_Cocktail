package com.example.pesho.make_a_cocktail.model.drinks;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.JsonReader;
import android.util.Log;

import com.example.pesho.make_a_cocktail.R;
import com.example.pesho.make_a_cocktail.model.users.User;
import com.example.pesho.make_a_cocktail.model.users.UsersManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by Pesho on 9/10/2016.
 */
public class DrinksManager {
    private static DrinksManager ourInstance;
    private static TreeMap<Integer, Drink> drinks = new TreeMap<>();


    public static DrinksManager getInstance(Activity activity, String loggedUserName) {
        if (ourInstance == null) {
            return new DrinksManager(activity,loggedUserName);
        }
        return ourInstance;
    }

    private DrinksManager(Activity activity, String loggedUserName) {
//        try {
//            JsonReader json = new JsonReader(new InputStreamReader(new FileInputStream("drinkJSON")));
//        } catch (FileNotFoundException e) {
//            Log.e("Test", "test");
//            e.printStackTrace();
//            return;
//        }
        String key = "drinksForUser" + loggedUserName;
        String json = activity.getSharedPreferences("Make_A_Cocktail", Context.MODE_PRIVATE).getString("drinksForUser" + loggedUserName, "Doesn't have drinks!");
        if (json.equals("Doesn't have drinks!")) {
            UsersManager.addUsersDrinks(loggedUserName);
        }
        try {
            JSONArray jsonArray = new JSONArray(json);
            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject o = jsonArray.getJSONObject(i);
                Drink drink = new Drink(o.getInt("idDrink"),o.getString("strDrink"),o.getString("strInstructions"), R.drawable.margarita_pic);
                DrinksManager.addDrink(drink);
            }
        } catch (JSONException e) {
            Log.e("JSON", e.getMessage());
        }


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
