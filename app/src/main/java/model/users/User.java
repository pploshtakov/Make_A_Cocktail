package model.users;

import java.util.TreeSet;

import model.drinks.Drink;
import model.exceptions.NoNameException;
import model.storage.BarShelf;
import model.storage.ShopList;

/**
 * Created by Pesho on 8/28/2016.
 */
public class User {
    private String userName;
    private String pass;
    private BarShelf myShelf;
    private ShopList myShopList;
    private TreeSet<Drink> favorite;
    private TreeSet<Drink> myDrinks;

    public User(String userName, String pass) throws NoNameException {
        this.setUserName(userName);
        this.setPass(pass);
        myShelf = new BarShelf();
        myShopList = new ShopList();
        this.favorite = new TreeSet<Drink>();
        this.myDrinks = new TreeSet<Drink>();
    }

    public void setUserName(String userName) throws NoNameException {
        if (userName != null && !userName.isEmpty()) {
            this.userName = userName;
        } else {
            throw new NoNameException();
        }
    }

    public void setPass(String pass) {
        //TODO validate password
        this.pass = pass;
    }
}
