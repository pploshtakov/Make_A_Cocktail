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

    }

}
