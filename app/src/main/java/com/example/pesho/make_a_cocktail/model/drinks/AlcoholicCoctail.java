package com.example.pesho.make_a_cocktail.model.drinks;

import com.example.pesho.make_a_cocktail.model.exceptions.NoNameException;

/**
 * Created by Pesho on 8/28/2016.
 */
public class AlcoholicCoctail extends Coctail {
    public AlcoholicCoctail(String name) throws NoNameException {
        super(name);
    }
}