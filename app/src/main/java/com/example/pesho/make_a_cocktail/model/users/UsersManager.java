package com.example.pesho.make_a_cocktail.model.users;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.pesho.make_a_cocktail.model.drinks.Drink;
import com.example.pesho.make_a_cocktail.model.drinks.DrinkJSON;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Pesho on 9/2/2016.
 */
public class UsersManager {
    private static UsersManager ourInstance;
    private static Activity activity;
    private static HashMap<String, User> users = new HashMap<>();

    public static UsersManager getInstance(Activity activity) {
        if (ourInstance == null) {
            return new UsersManager(activity);
        }
        return ourInstance;
    }

    private UsersManager(Activity activity) {
        this.activity = activity;
        String json = activity.getSharedPreferences("Make_A_Cocktail", Context.MODE_PRIVATE).getString("registeredUsers", "No registered users!");
        try {
            JSONArray jsonArray = new JSONArray(json);
            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject o = jsonArray.getJSONObject(i);
                User user = new User(o.getString("name"), o.getString("userName"), o.getString("password"), o.getString("email"));
                users.put(user.getUserName(), user);
            }
        } catch (JSONException e) {
            Log.e("JSON", e.getMessage());
        }
    }

    public static void registerUser(Activity activity, User user) {
        users.put(user.getUserName(), user);
        SharedPreferences prefs = activity.getSharedPreferences("Make_A_Cocktail", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        String key = "registeredUsers";
        String value = "";
        JSONArray jsonUsers = new JSONArray();
        try {
            for (User u : users.values()) {
                    JSONObject o = new JSONObject();
                    o.put("name", u.getName());
                    o.put("userName", u.getUserName());
                    o.put("password", u.getPass());
                    o.put("email", u.getEmail());
                    jsonUsers.put(o);
                }
            value = jsonUsers.toString();
            } catch (JSONException e) {
                Log.e("JSON", e.getMessage());
            }
        editor.putString(key, value);
        editor.commit();

        //make SharedPrefs with all drinks for this user
        addUsersDrinks(user.getUserName());
    }

    public static boolean checkUsernameIsFree (String name) {
        return !users.containsKey(name);
    }

    public static boolean checkPass(String name, String pass) {
        if (users.containsKey(name)) {
            User user = users.get(name);
            return pass.equals(user.getPass());
        }
        return false;
    }

    public static void addUsersDrinks(String userName) {
        User u = users.get(userName);
        SharedPreferences prefs = activity.getSharedPreferences("Make_A_Cocktail", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        String key = "drinksForUser" + userName;
        String value = DrinkJSON.drinks;
        editor.putString(key, value);
        editor.commit();
    }

    public static void addFavoriteDrink(String loggedUser, Drink drink) {
        users.get(loggedUser).addToFavorite(drink);
        users.get(loggedUser).saveFavoriteList(activity);
    }

    public static void removeFavoriteDrink(String loggedUser, Drink drink) {
        users.get(loggedUser).removeFromFavorite(drink);
    }


}

