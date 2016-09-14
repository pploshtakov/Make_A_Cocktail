package com.example.pesho.make_a_cocktail.model.drinks;

import com.example.pesho.make_a_cocktail.model.exceptions.NoNameException;

/**
 * Created by Pesho on 8/28/2016.
 */
public class AlcoholicCocktail extends Cocktail {

    public AlcoholicCocktail(int idDrink, String name, String instructions, int image, String strCategory, String strAlcoholic, String strGlass, String strDrinkThumb, boolean isFavorite) {
        super(idDrink, name, instructions, image, strCategory, strAlcoholic, strGlass, strDrinkThumb, isFavorite);
    }
}
