package com.example.pesho.make_a_cocktail.model.drinks;

import android.app.Activity;
import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.TreeSet;


import com.example.pesho.make_a_cocktail.model.products.Product;

/**
 * Created by Pesho on 8/28/2016.
 */
public abstract class Drink {
    private int idDrink;
    private String name;
    private int image;
    private String strCategory;
    private String strAlcoholic;
    private String strGlass;
    private String strDrinkThumb;
    private String strInstructions;
    private boolean isFavorite;
    private Bitmap bmp;


    private TreeSet<Product> products;

    public Drink(int idDrink, String name, String instructions, int image, String strCategory, String strAlcoholic, String strGlass, String strDrinkThumb, boolean isFavorite)  {
        this.idDrink = idDrink;
        this.strInstructions = instructions;
        this.image = image;
        this.name = name;
        this.strCategory = strCategory;
        this.strAlcoholic = strAlcoholic;
        this.strGlass = strGlass;
        this.strDrinkThumb = strDrinkThumb;
        this.isFavorite = isFavorite;
        this.products = new TreeSet<Product>();
        DrinksManager.addDrink(this);

    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public void setStrInstructions(String strInstructions) {
        if (name != null && !name.isEmpty()) {
            this.strInstructions = strInstructions;
        }
    }

    public void addProducts (Product... products ) {
        for (int i = 0; i < products.length; i++) {
            this.products.add(products[i]);
        }
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public String getStrAlcoholic() {
        return strAlcoholic;
    }

    public String getStrGlass() {
        return strGlass;
    }

    public String getStrDrinkThumb() {
        return strDrinkThumb;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public int getIdDrink() {
        return idDrink;
    }

    public void setFavorite(boolean b) {
        this.isFavorite = b;
    }

    public void setIdDrink(int idDrink) {
        this.idDrink = idDrink;
    }

    public Bitmap getBmp() {
        return bmp;
    }

    public void setBmp(Bitmap bmp) {
        this.bmp = bmp;
    }

}
