package com.example.pesho.make_a_cocktail.model.drinks;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
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
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

/**
 * Created by Pesho on 9/10/2016.
 */
public class DrinksManager {
    private static int addedDrinks = 0;
    private static DrinksManager ourInstance;
    private static TreeMap<Integer, Drink> drinks = new TreeMap<>();
    private static Activity activity;

    public static int generateDrinkId() {
        return addedDrinks++;
    }

    public static Drink getDrink(int idDrink) {
        return drinks.get(idDrink);
    }

    public static Drink getRandomDrink() {
        List<Integer> idS = new ArrayList<>();
        idS.addAll(drinks.keySet());
        int r = new Random().nextInt(idS.size());
        return drinks.get(idS.get(r));
    }

    public static ArrayList<Drink> getCocktailsList() {
        ArrayList<Drink> cocktails = new ArrayList<>();
        for (Drink d : drinks.values()) {
            if (d instanceof Cocktail) {
                cocktails.add(d);
            }
        }
        return cocktails;
    }

    public static ArrayList<Drink> getShotsList() {
        ArrayList<Drink> shots = new ArrayList<>();
        for (Drink d : drinks.values()) {
            if (d instanceof Shot) {
                shots.add(d);
            }
        }
        return shots;
    }


    public enum DrinksCategories {Alcoholic, NonAlcoholic, Shot};


    public static DrinksManager getInstance(Activity act, String loggedUserName) {
        if (ourInstance == null) {
            activity = act;
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
        String json = activity.getSharedPreferences("Make_A_Cocktail", Context.MODE_PRIVATE).getString("drinksForUser" + loggedUserName, "Doesn't have drinks!");
        if (json.equals("Doesn't have drinks!")) {
            UsersManager.addUsersDrinks(loggedUserName);
        }
        json = activity.getSharedPreferences("Make_A_Cocktail", Context.MODE_PRIVATE).getString("drinksForUser" + loggedUserName, "Doesn't have drinks!");
        addedDrinks = activity.getSharedPreferences("Make_A_Cocktail", Context.MODE_PRIVATE).getInt("addedDrinksID", 0);
        try {
            JSONArray jsonArray = new JSONArray(json);
            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject o = jsonArray.getJSONObject(i);
                Drink drink;
                boolean b = false;
                if (o.getString("strCategory").equals("Shot")) {
                    if (o.has("isFavorite")) {
                        b = o.getBoolean("isFavorite");
                    }
                    drink = new Shot(o.getInt("idDrink"),o.getString("strDrink"),o.getString("strInstructions"), R.drawable.margarita_pic, o.getString("strCategory"), o.getString("strAlcoholic"), o.getString("strGlass"),o.getString("strDrinkThumb"), b);
                } else if (o.getString("strAlcoholic").equals(DrinksCategories.Alcoholic)) {
                    if (o.has("isFavorite")) {
                        b = o.getBoolean("isFavorite");
                    }
                    drink = new AlcoholicCocktail(o.getInt("idDrink"),o.getString("strDrink"),o.getString("strInstructions"), R.drawable.margarita_pic, o.getString("strCategory"), o.getString("strAlcoholic"), o.getString("strGlass"),o.getString("strDrinkThumb"), b);
                } else {
                    if (o.has("isFavorite")) {
                        b = o.getBoolean("isFavorite");
                    }
                    drink = new NonAlcoholicCocktail(o.getInt("idDrink"),o.getString("strDrink"),o.getString("strInstructions"), R.drawable.margarita_pic, o.getString("strCategory"), o.getString("strAlcoholic"), o.getString("strGlass"),o.getString("strDrinkThumb"), b);
                }
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

    public static boolean addDrink(Drink drink) {
        if (drinks.containsKey(drink.getIdDrink())) {
            return false;
        }
        drinks.put(drink.getIdDrink(), drink);
        return true;
    }

    public static void overwriteSharedPrefsDrinks(String loggedUser) {
        SharedPreferences prefs = activity.getSharedPreferences("Make_A_Cocktail", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        String key = "drinksForUser" + loggedUser;
        String value = "";
        JSONArray jsonDrinks = new JSONArray();
        try {
            for (Drink d : drinks.values()) {
                JSONObject o = new JSONObject();
                o.put("idDrink", d.getIdDrink());
                o.put("strDrink", d.getName());
                o.put("strInstructions", d.getStrInstructions());
                o.put("strCategory", d.getStrCategory());
                o.put("strAlcoholic", d.getStrAlcoholic());
                o.put("strGlass", d.getStrGlass());
                o.put("strDrinkThumb", d.getStrDrinkThumb());
                o.put("isFavorite", d.isFavorite());

                jsonDrinks.put(o);
            }
            value = jsonDrinks.toString();
        } catch (JSONException e) {
            Log.e("JSON", e.getMessage());
        }
        editor.putString(key, value);
        editor.putInt("addedDrinksID", addedDrinks);
        editor.commit();

    }




}
