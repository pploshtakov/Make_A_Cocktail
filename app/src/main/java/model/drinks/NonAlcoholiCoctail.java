package model.drinks;

import model.exceptions.NoNameException;

/**
 * Created by Pesho on 8/28/2016.
 */
public class NonAlcoholiCoctail extends Coctail {
    public NonAlcoholiCoctail(String name) throws NoNameException {
        super(name);
    }
}
