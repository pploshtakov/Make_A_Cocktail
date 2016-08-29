package model.drinks;

import model.exceptions.NoNameException;

/**
 * Created by Pesho on 8/28/2016.
 */
public class Shot extends Drink {

    public Shot(String name) throws NoNameException {
        super(name);
    }
}
