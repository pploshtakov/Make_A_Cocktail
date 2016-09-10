package com.example.pesho.make_a_cocktail.model.drinks;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.example.pesho.make_a_cocktail.model.users.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
        String json = loadJSON();
        Log.e("Load json", json);
//        try {
//            JSONArray jsonArray = new JSONArray(json);
//            for(int i = 0; i < jsonArray.length(); i++) {
//                JSONObject o = jsonArray.getJSONObject(i);
//                Drink drink = new Drink(o.getString("name"), o.getString("userName"), o.getString("password"), o.getString("email"));
//                drinks.put(user.getUserName(), user);
//            }
//        } catch (JSONException e) {
//            Log.e("JSON", e.getMessage());
//        }
    }

    private String loadJSON() {
        String json = null;
        try {
            File file = new File("drinksJSON");
            FileInputStream is = new FileInputStream(file);

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
