package com.example.pesho.make_a_cocktail.model.drinks;



/**
 * Created by Pesho on 8/28/2016.
 */
public abstract class Cocktail extends Drink {


    public Cocktail(int idDrink, String name, String instructions, int image, String strCategory, String strAlcoholic, String strGlass, String strDrinkThumb, boolean isFavorite) {
        super(idDrink, name, instructions, image, strCategory, strAlcoholic, strGlass, strDrinkThumb, isFavorite);
    }
}
