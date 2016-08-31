package com.example.pesho.make_a_coctail.model.users;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

import com.example.pesho.make_a_coctail.model.drinks.Drink;
import com.example.pesho.make_a_coctail.model.exceptions.NoNameException;
import com.example.pesho.make_a_coctail.model.storage.BarShelf;
import com.example.pesho.make_a_coctail.model.storage.ShopList;

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

    //test methods for register users
    public static void registerUser(User user) {
        users.put(user.userName, user);
    }

    public static boolean chechUsernameIsFree (String name) {
        return !users.containsKey(name);
    }

    public static boolean checkPass(String name, String pass) {
        if (users.containsKey(name)) {
            User user = users.get(name);
            return pass.equals(user.pass);
        }
        return false;
    }
}
