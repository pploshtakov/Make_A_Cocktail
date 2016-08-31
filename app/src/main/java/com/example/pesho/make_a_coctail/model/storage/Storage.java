package com.example.pesho.make_a_coctail.model.storage;

import java.util.TreeSet;

import com.example.pesho.make_a_coctail.model.products.Product;

/**
 * Created by Pesho on 8/28/2016.
 */
public abstract class Storage {
    private TreeSet<Product> products;

    public boolean addProduct (Product product) {
      return products.add(product);
    }

    public boolean removeProduct (Product product) {
        return products.remove(product);
    }
}
