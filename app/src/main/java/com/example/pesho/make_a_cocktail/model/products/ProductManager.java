package com.example.pesho.make_a_cocktail.model.products;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.pesho.make_a_cocktail.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Simeon Angelov on 19.9.2016 г..
 */
public class ProductManager {
    private static ProductManager ourInstance;
    private ArrayList<Product> products;

    public static ProductManager getInstance(Activity a) {
        if(ourInstance == null){
            ourInstance = new ProductManager(a);
        }
        return ourInstance;
    }

    private ProductManager(Activity activity) {
        String json = activity.getSharedPreferences("Make_A_Cocktail", Context.MODE_PRIVATE).getString("products", "no products");
        try {
        JSONArray jsonProducts = new JSONArray();

        for(int i = 0; i < jsonProducts.length();i++){
            JSONObject obj = jsonProducts.getJSONObject(i);
            Product p = new Product(obj.getString("name"),obj.getInt("image"),obj.getBoolean("isInShop"));
            products.add(p);
        }

        }catch (JSONException e) {
            e.printStackTrace();
        }

    }


    private void fillCollection(){
        Product tequila = new Product("Tequila", R.drawable.tequila ,true);
        Product whiskey = new Product("Whiskey",R.drawable.whiskey ,true);
        Product rum = new Product("Rum",R.drawable.rum ,true);
        Product grenadine = new Product("Grenadine",R.drawable.grenadine ,true);

        products.add(tequila);
        products.add(whiskey);
        products.add(rum);
        products.add(grenadine);

    }

    private void generateJSON(Activity a){
        fillCollection();
        SharedPreferences sharedPref = a.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        String key = "products";
        String value = " ";

        JSONArray jsonProducts = new JSONArray();
        try {
            for (int i = 0; i < products.size();i++) {
                Product p = products.get(i);
                JSONObject jobj = new JSONObject();
                jobj.put("name", p.getName());
                jobj.put("image", p.getImage());
                jobj.put("isInShop", p.isInShoppingList());
                jsonProducts.put(jobj);
            }
        }
        catch(JSONException e){
            Log.e("JSON", e.getMessage());
        }
        value = jsonProducts.toString();

        editor.putString(key, value);
        editor.commit();
    }

}
