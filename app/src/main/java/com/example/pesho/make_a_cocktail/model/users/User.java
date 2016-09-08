package com.example.pesho.make_a_cocktail.model.users;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.TreeMap;
import java.util.TreeSet;

import com.example.pesho.make_a_cocktail.model.drinks.Drink;
import com.example.pesho.make_a_cocktail.model.exceptions.NoNameException;
import com.example.pesho.make_a_cocktail.model.storage.BarShelf;
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
        this.favorite = new TreeSet<Drink>();
        this.myDrinks = new TreeSet<Drink>();
    }

    public void setUserName(String userName) throws NoNameException {
        if (userName != null && !userName.isEmpty()) {
            this.userName = userName;
        } else {
            throw new NoNameException();
        }
    }

    public void setPass(String pass) {
        //TODO validate password
        this.pass = pass;
    }

    public String getName() {
        return name;
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

}
