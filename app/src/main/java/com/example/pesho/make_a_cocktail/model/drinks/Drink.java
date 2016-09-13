package com.example.pesho.make_a_cocktail.model.drinks;

import android.app.Activity;

import java.util.ArrayList;
import java.util.TreeSet;

import com.example.pesho.make_a_cocktail.model.exceptions.NoNameException;
import com.example.pesho.make_a_cocktail.model.exceptions.NoRecipeException;
import com.example.pesho.make_a_cocktail.model.products.Product;

/**
 * Created by Pesho on 8/28/2016.
 */
public class Drink {


    private String name;
    private String strInstructions;


    private int idDrink;
    private int image;
    private boolean isFavorite;
    private String strGlass;
    private String strDrinkThumb;

    private TreeSet<Product> products;

    public Drink(String name) throws NoNameException {
        this.setName(name);
        this.products = new TreeSet<Product>();
    }

    public Drink(int idDrink, String name, String instructions, int image)  {
        this.idDrink = idDrink;
        this.strInstructions = instructions;
        this.image = image;
        this.name = name;
        this.products = new TreeSet<Product>();
        DrinksManager.addDrink(this);

    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public void setName(String name) throws NoNameException {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            throw new NoNameException();
        }
    }

    public void setStrInstructions(String strInstructions) throws NoRecipeException {
        if (name != null && !name.isEmpty()) {
            this.strInstructions = strInstructions;
        } else {
            throw new NoRecipeException();
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

    public boolean isFavorite() {
        return isFavorite;
    }

    public int getIdDrink() {
        return idDrink;
    }

    public void setFavorite(boolean b) {
        this.isFavorite = b;
    }
}
