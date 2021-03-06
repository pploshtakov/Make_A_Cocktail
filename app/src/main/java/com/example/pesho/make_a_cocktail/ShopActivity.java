package com.example.pesho.make_a_cocktail;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.os.AsyncTaskCompat;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pesho.make_a_cocktail.model.drinks.Drink;
import com.example.pesho.make_a_cocktail.model.drinks.DrinksManager;
import com.example.pesho.make_a_cocktail.model.products.Product;
import com.example.pesho.make_a_cocktail.model.products.ProductManager;
import com.example.pesho.make_a_cocktail.model.users.UsersManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ShopActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,IngredientsFragment.OnFragmentInteractionListener, AllDrinksFragment.Communicator, IngredientsFragment.Communicator {
    NavigationView navigationView;
    String loggedUser;
    Toolbar toolbar;
    TabLayout toolbar1;
    DrawerLayout myDrawer;
    SearchView searchView;
    private static final int ADD_NEW_DRINK = 1;
    private static final int EDIT_PROFILE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        UsersManager.getInstance(this);
        Intent intent = getIntent();
        this.loggedUser = intent.getStringExtra("loggedUser");
        UsersManager.saveLastLoggedUser(loggedUser);
        DrinksManager.getInstance(this, loggedUser);
        ArrayList<Drink> drs = DrinksManager.getList();
        for (Drink d: drs) {
            new ImageFromUrlTask(ShopActivity.this).execute(d);
        }
        UsersManager.loadUserData(loggedUser);

        //set fragment
        AllDrinksFragment fragment = new AllDrinksFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
        myDrawer = (DrawerLayout) findViewById(R.id.drawer_layout   );
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar1 = (TabLayout) findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        toolbar1.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //create random ingredients arraylist
                ArrayList<Product> products = new ArrayList<>();
                Product tequila = new Product("Tequila", R.drawable.tequila ,true);
                Product whiskey = new Product("Whiskey",R.drawable.whiskey ,true);
                Product rum = new Product("Rum",R.drawable.rum ,true);
                Product grenadine = new Product("Grenadine",R.drawable.grenadine ,true);

                products.add(tequila);
                products.add(whiskey);
                products.add(rum);
                products.add(grenadine);

                Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
                if (tab.getText().toString().equals("Shop")) {
                    if (fragment instanceof IngredientsFragment)
                        ((IngredientsFragment) fragment).refreshList(products, "Shop");
                    return;
                } else if (tab.getText().toString().equals("Shopping list")) {
                    if (fragment instanceof IngredientsFragment)
                        ((IngredientsFragment) fragment).refreshList(UsersManager.getShoppingList(loggedUser).getProducts(), "Shopping list");
                    return;
                } else if (tab.getText().toString().equals("Bar shelf")) {
                    if (fragment instanceof IngredientsFragment)
                        ((IngredientsFragment) fragment).refreshList(UsersManager.getBarShelf(loggedUser).getProducts(), "Bar Shelf");
                    return;
                } else {
                    fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
                    switch (tab.getText().toString()) {
                        case "All":
                            if (fragment instanceof AllDrinksFragment)
                            ((AllDrinksFragment) fragment).refreshList(DrinksManager.getList());
                            break;
                        case "Cocktails":
                            if (fragment instanceof AllDrinksFragment)
                                ((AllDrinksFragment) fragment).refreshList(DrinksManager.getCocktailsList());
                            Toast.makeText(ShopActivity.this, "Cocktails", Toast.LENGTH_SHORT).show();
                            break;
                        case "Shots":
                            if (fragment instanceof AllDrinksFragment)
                                ((AllDrinksFragment) fragment).refreshList(DrinksManager.getShotsList());
                            Toast.makeText(ShopActivity.this, "Shots", Toast.LENGTH_SHORT).show();
                            break;
                        case "Favorite":
                            if (fragment instanceof AllDrinksFragment)
                                ((AllDrinksFragment) fragment).refreshList(UsersManager.getFavoriteList(loggedUser));
                            Toast.makeText(ShopActivity.this, "Favorite", Toast.LENGTH_SHORT).show();
                            break;
                        case "My drinks":
                            if (fragment instanceof AllDrinksFragment)
                                ((AllDrinksFragment) fragment).refreshList(UsersManager.getMyDrinks(loggedUser));
                            Toast.makeText(ShopActivity.this, "MyDrinks", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    //get search menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.test_shop, menu);
//        return true;
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.shop, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);

        SearchManager searchManager = (SearchManager) ShopActivity.this.getSystemService(Context.SEARCH_SERVICE);

        searchView = null;
        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(ShopActivity.this.getComponentName()));
        }
        //set on Query text listener
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            Fragment fr;
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            //get text
            @Override
            public boolean onQueryTextChange(String newText) {
                fr = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
                if (fr instanceof AllDrinksFragment) {
                    ((AllDrinksFragment) fr).search(newText);
                } else {
                    ((IngredientsFragment)fr).search(newText);
                }
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_drinks) {
            //set fragment
            AllDrinksFragment fragment = new AllDrinksFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
            myDrawer.closeDrawers();
            toolbar1.removeAllTabs();
            toolbar1.addTab(toolbar1.newTab().setText("All"));
            toolbar1.addTab(toolbar1.newTab().setText("Cocktails"));
            toolbar1.addTab(toolbar1.newTab().setText("Shots"));
            toolbar1.addTab(toolbar1.newTab().setText("Favorite"));
            toolbar1.addTab(toolbar1.newTab().setText("My drinks"));
            toolbar1.setTabMode(TabLayout.MODE_SCROLLABLE);
//            toolbar = (Toolbar) findViewById(R.id.toolbar);
//            toolbar1 = (Toolbar) findViewById(R.id.myToolbar);
//            setSupportActionBar(toolbar1);
//            setSupportActionBar(toolbar);
        } else if (id == R.id.nav_ingredients) {
            //set fragment
            IngredientsFragment fragment = new IngredientsFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
            myDrawer.closeDrawers();
            toolbar1.removeAllTabs();
            toolbar1.addTab(toolbar1.newTab().setText("Shop"));
            toolbar1.addTab(toolbar1.newTab().setText("Shopping list"));
            toolbar1.addTab(toolbar1.newTab().setText("Bar shelf"));
            toolbar1.setTabMode(TabLayout.MODE_FIXED);
//            toolbar = (Toolbar) findViewById(R.id.toolbar);
//            toolbar1 = (Toolbar) findViewById(R.id.myToolbar);
//            setSupportActionBar(toolbar1);
//            setSupportActionBar(toolbar);
        } else if (id == R.id.nav_random_drink) {
            //set fragment
//            RandomDrinkFragment fragment = new RandomDrinkFragment();
//            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//            fragmentTransaction.replace(R.id.fragment_container, fragment);
//            fragmentTransaction.commit();
//            toolbar = (Toolbar) findViewById(R.id.toolbar);
//            toolbar1 = (Toolbar) findViewById(R.id.myToolbar);
//            setSupportActionBar(toolbar1);
//            setSupportActionBar(toolbar);
            Intent intent = new Intent(ShopActivity.this, DrinkInfoActivity.class);
            Drink d = DrinksManager.getRandomDrink();
            intent.putExtra("idDrink", d.getIdDrink());
            startActivity(intent);
        } else if (id == R.id.nav_profile) {
           Intent intent = new Intent(ShopActivity.this, ProfileActivity.class);
            intent.putExtra("username",loggedUser);
            startActivityForResult(intent, EDIT_PROFILE);
        } else if (id == R.id.nav_new_drink) {
            //set fragment
//            NewDrinksFragment fragment = new NewDrinksFragment();
//            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//            fragmentTransaction.replace(R.id.fragment_container, fragment);
//            fragmentTransaction.commit();
//            toolbar = (Toolbar) findViewById(R.id.toolbar);
//            toolbar1 = (Toolbar) findViewById(R.id.myToolbar);
//            setSupportActionBar(toolbar1);
//            setSupportActionBar(toolbar);
            Intent intent = new Intent(ShopActivity.this, AddNewDrinkActivity.class);
            intent.putExtra("loggedUser", loggedUser);
            startActivityForResult(intent, ADD_NEW_DRINK);
        } else if (id == R.id.nav_logout) {
            Intent intent = new Intent(ShopActivity.this, LoginActivity.class);
            UsersManager.logout();
            startActivity(intent);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public String getLoggedUserName() {
        return loggedUser;
    }



    @Override
    protected void onDestroy() {
//        DrinksManager.setFavorite(loggedUser);
//        Log.e("FavoriteOnDestroy", "????????????");
        super.onDestroy();
    }

    public static class ImageFromUrlTask extends AsyncTask<Drink, Void, Bitmap> {
        private Activity activity;
        ImageFromUrlTask(Activity activity) {
            this.activity = activity;
        }
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (activity instanceof DrinkInfoActivity) {
                ImageView iv = (ImageView) activity.findViewById(R.id.info_image);
                iv.setImageBitmap(bitmap);
            }
        }

        @Override
        protected Bitmap doInBackground(Drink... params) {
            URL url = null;
            try {
                url = new URL(params[0].getStrDrinkThumb());
            } catch (MalformedURLException e) {
                return null;
            }
            Bitmap bmp = null;
            try {
                bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            } catch (IOException e) {
                return null;
            }
            params[0].setBmp(bmp);
            return bmp;
        }
    }
    //check connection
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }
}
