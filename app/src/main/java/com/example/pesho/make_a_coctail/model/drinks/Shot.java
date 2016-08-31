package com.example.pesho.make_a_coctail.model.drinks;

import com.example.pesho.make_a_coctail.model.exceptions.NoNameException;

/**
 * Created by Pesho on 8/28/2016.
 */
public class Shot extends Drink {

    public Shot(String name) throws NoNameException {
        super(name);
    }
}
