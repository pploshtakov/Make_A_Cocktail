package model.storage;

import java.util.TreeSet;

import model.products.Product;

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
