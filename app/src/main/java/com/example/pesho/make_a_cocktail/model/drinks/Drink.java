package com.example.pesho.make_a_cocktail.model.drinks;

import java.util.TreeSet;

import com.example.pesho.make_a_cocktail.model.exceptions.NoNameException;
import com.example.pesho.make_a_cocktail.model.exceptions.NoRecipeException;
import com.example.pesho.make_a_cocktail.model.products.Product;

/**
 * Created by Pesho on 8/28/2016.
 */
public abstract class Drink {
    private String name;
    private String recipe;
    private TreeSet<Product> products;

    public Drink(String name) throws NoNameException {
        this.setName(name);
        this.products = new TreeSet<Product>();
    }

    public void setName(String name) throws NoNameException {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            throw new NoNameException();
        }
    }

    public void setRecipe(String recipe) throws NoRecipeException {
        if (name != null && !name.isEmpty()) {
            this.recipe = recipe;
        } else {
            throw new NoRecipeException();
        }
    }

    public void addProducts (Product... products ) {
        for (int i = 0; i < products.length; i++) {
            this.products.add(products[i]);
        }
    }


}
