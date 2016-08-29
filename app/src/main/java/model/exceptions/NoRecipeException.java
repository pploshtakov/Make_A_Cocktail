package model.exceptions;

/**
 * Created by Pesho on 8/28/2016.
 */
public class NoRecipeException extends Exception {
    @Override
    public String getMessage() {
        return "Do not typed recipe!";
    }
}
