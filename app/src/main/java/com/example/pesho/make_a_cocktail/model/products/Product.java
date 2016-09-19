package com.example.pesho.make_a_cocktail.model.products;

/**
 * Created by Pesho on 8/28/2016.
 */
public abstract class Product {
    private String name;
    private int image;
    private int quanttity;
    private boolean isInShoppingList;

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public boolean isInShoppingList() {
        return isInShoppingList;
    }
}
