package com.example.pesho.make_a_cocktail.model.users;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

import com.example.pesho.make_a_cocktail.R;
import com.example.pesho.make_a_cocktail.model.drinks.AlcoholicCocktail;
import com.example.pesho.make_a_cocktail.model.drinks.Drink;
import com.example.pesho.make_a_cocktail.model.drinks.DrinksManager;
import com.example.pesho.make_a_cocktail.model.drinks.NonAlcoholicCocktail;
import com.example.pesho.make_a_cocktail.model.drinks.Shot;
import com.example.pesho.make_a_cocktail.model.storage.BarShelf;
import com.example.pesho.make_a_cocktail.model.storage.Shop;
import com.example.pesho.make_a_cocktail.model.storage.ShopList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Pesho on 8/28/2016.
 */
public class User {
    //test variable for safe users
    public static TreeMap<String, User> users = new TreeMap<>();

    private String name;
    private String userName;
    private String pass;
    private String email;
    private BarShelf myShelf;
    private ShopList myShopList;
    private TreeSet<Drink> favorite;
    private TreeSet<Drink> myDrinks;

    public User(String name, String userName, String pass, String email) {
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.pass = pass;
        myShelf = new BarShelf();
        myShopList = new ShopList();
        this.favorite = new TreeSet<Drink>(new Comparator<Drink>() {
            @Override
            public int compare(Drink lhs, Drink rhs) {
                return lhs.getName().compareTo(rhs.getName());
            }
        });
        this.myDrinks = new TreeSet<Drink>(new Comparator<Drink>() {
            @Override
            public int compare(Drink lhs, Drink rhs) {
                return lhs.getName().compareTo(rhs.getName());
            }
        });
    }

    public void setUserName(String userName) {
        if (userName != null && !userName.isEmpty()) {
            this.userName = userName;
        }
    }

    public void setPass(String pass) {
        //TODO validate password
        this.pass = pass;
    }

    public BarShelf getMyShelf() {
        return myShelf;
    }

    public ShopList getMyShopList() {
        return myShopList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPass() {
        return pass;
    }

    public String getEmail() {
        return email;
    }

    public void addToFavorite(Drink drink) {
        favorite.add(drink);
    }

    public void removeFromFavorite(Drink drink, Activity activity) {
        favorite.remove(drink);
        saveFavoriteList(activity);
    }

    public void saveFavoriteList(Activity activity) {
        SharedPreferences prefs = activity.getSharedPreferences("Make_A_Cocktail", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        String key = "favoriteForUser" + this.userName;
        String value = "";
        JSONArray jsonUsers = new JSONArray();
        try {
            for (Drink d : favorite) {
                JSONObject o = new JSONObject();
                o.put("idDrink", d.getIdDrink());
                o.put("strDrink", d.getName());
                o.put("strInstructions", d.getStrInstructions());
                o.put("strCategory", d.getStrCategory());
                o.put("strAlcoholic", d.getStrAlcoholic());
                o.put("strGlass", d.getStrGlass());
                o.put("strDrinkThumb", d.getStrDrinkThumb());
                o.put("isFavorite", d.isFavorite());
                jsonUsers.put(o);
            }
            value = jsonUsers.toString();
        } catch (JSONException e) {
            Log.e("JSON", e.getMessage());
        }
        editor.putString(key, value);
        editor.commit();
    }

    public void loadUserLists(Activity activity) {
        String json = activity.getSharedPreferences("Make_A_Cocktail", Context.MODE_PRIVATE).getString("favoriteForUser" + this.userName, "Doesn't have drinks!");
        try {
            JSONArray jsonArray = new JSONArray(json);
            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject o = jsonArray.getJSONObject(i);
                Drink drink;
                boolean b = o.getBoolean("isFavorite");
                if (o.getString("strCategory").equals(DrinksManager.DrinksCategories.Shot)) {
                    drink = new Shot(o.getInt("idDrink"),o.getString("strDrink"),o.getString("strInstructions"), R.drawable.margarita_pic, o.getString("strCategory"), o.getString("strAlcoholic"), o.getString("strGlass"),o.getString("strDrinkThumb"), b);
                } else if (o.getString("strAlcoholic").equals(DrinksManager.DrinksCategories.Alcoholic)) {
                    drink = new AlcoholicCocktail(o.getInt("idDrink"),o.getString("strDrink"),o.getString("strInstructions"), R.drawable.margarita_pic, o.getString("strCategory"), o.getString("strAlcoholic"), o.getString("strGlass"),o.getString("strDrinkThumb"), b);
                } else {
                    drink = new NonAlcoholicCocktail(o.getInt("idDrink"),o.getString("strDrink"),o.getString("strInstructions"), R.drawable.margarita_pic, o.getString("strCategory"), o.getString("strAlcoholic"), o.getString("strGlass"),o.getString("strDrinkThumb"), b);
                }
                addToFavorite(drink);
                saveFavoriteList(activity);
            }
        } catch (JSONException e) {
            Log.e("JSON", e.getMessage());
        }
        json = activity.getSharedPreferences("Make_A_Cocktail", Context.MODE_PRIVATE).getString("myDrinkForUser" + this.userName, "Doesn't have drinks!");
        try {
            JSONArray jsonArray = new JSONArray(json);
            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject o = jsonArray.getJSONObject(i);
                Drink drink;
                if (o.getString("strCategory").equals("Shot")) {
                    drink = new Shot(o.getInt("idDrink"),o.getString("strDrink"),o.getString("strInstructions"), R.drawable.margarita_pic, o.getString("strCategory"), o.getString("strAlcoholic"), o.getString("strGlass"),o.getString("strDrinkThumb"), o.getBoolean("isFavorite"));
                } else if (o.getString("strAlcoholic").equals(DrinksManager.DrinksCategories.Alcoholic)) {
                    drink = new AlcoholicCocktail(o.getInt("idDrink"),o.getString("strDrink"),o.getString("strInstructions"), R.drawable.margarita_pic, o.getString("strCategory"), o.getString("strAlcoholic"), o.getString("strGlass"),o.getString("strDrinkThumb"), o.getBoolean("isFavorite"));
                } else {
                    drink = new NonAlcoholicCocktail(o.getInt("idDrink"),o.getString("strDrink"),o.getString("strInstructions"), R.drawable.margarita_pic, o.getString("strCategory"), o.getString("strAlcoholic"), o.getString("strGlass"),o.getString("strDrinkThumb"), o.getBoolean("isFavorite"));
                }
                if (favorite.contains(drink)) {
                    drink.setFavorite(true);
                }
                myDrinks.add(drink);
            }
        } catch (JSONException e) {
            Log.e("JSON", e.getMessage());
        }
    }

    public ArrayList<Drink> getFavoriteDrinks() {
        return new ArrayList<Drink>(favorite);
    }

    public ArrayList<Drink> getMyDrinksList() {
        ArrayList<Drink> drinks = new ArrayList<>();
        drinks.addAll(myDrinks);
        return drinks;
    }

    public void addMyDrink(Drink drink , Activity activity) {
        myDrinks.add(drink);
        SharedPreferences prefs = activity.getSharedPreferences("Make_A_Cocktail", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        String key = "myDrinkForUser" + this.userName;
        String value = "";
        JSONArray myDr = new JSONArray();
        try {
            for (Drink d : this.myDrinks) {
                JSONObject o = new JSONObject();
                o.put("idDrink", d.getIdDrink());
                o.put("strDrink", d.getName());
                o.put("strInstructions", d.getStrInstructions());
                o.put("strCategory", d.getStrCategory());
                o.put("strAlcoholic", d.getStrAlcoholic());
                o.put("strGlass", d.getStrGlass());
                o.put("strDrinkThumb", d.getStrDrinkThumb());
                o.put("isFavorite", d.isFavorite());
                myDr.put(o);
            }
            value = myDr.toString();
        } catch (JSONException e) {
            Log.e("JSON", e.getMessage());
        }
        editor.putString(key, value);
        editor.commit();
    }
}
