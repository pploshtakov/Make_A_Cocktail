package com.example.pesho.make_a_cocktail.model.products;

/**
 * Created by Pesho on 8/28/2016.
 */
public  class Product {
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

    public Product(String name, int image, boolean isInShoppingList) {
        this.name = name;
        this.image = image;
        this.isInShoppingList = isInShoppingList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return name != null ? name.equals(product.name) : product.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
