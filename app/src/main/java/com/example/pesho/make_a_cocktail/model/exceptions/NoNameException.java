package com.example.pesho.make_a_cocktail.model.exceptions;

/**
 * Created by Pesho on 8/28/2016.
 */
public class NoNameException extends Exception {
    @Override
    public String getMessage() {
        return "Input a name!";
    }
}
