package com.example.pesho.make_a_cocktail;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.SearchView;
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

import com.example.pesho.make_a_cocktail.model.drinks.DrinksManager;
import com.example.pesho.make_a_cocktail.model.users.UsersManager;

public class TestShopActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,IngredientsFragment.OnFragmentInteractionListener,ProfileFragment.OnFragmentInteractionListener, CocktailsFragment.Communicator {
    NavigationView navigationView;
    String loggedUser;
    Toolbar toolbar;
    Toolbar toolbar1;
    private static final int ADD_NEW_DRINK = 1;
    private static final int EDIT_PROFILE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_shop);

        UsersManager.getInstance(this);
        Intent intent = getIntent();
        this.loggedUser = intent.getStringExtra("loggedUser");
        DrinksManager.getInstance(this, loggedUser);

        //set fragment
        CocktailsFragment fragment = new CocktailsFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar1 = (Toolbar) findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar1);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.test_shop, menu);
//        return true;
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.test_shop, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);

        SearchManager searchManager = (SearchManager) TestShopActivity.this.getSystemService(Context.SEARCH_SERVICE);

        SearchView searchView = null;
        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(TestShopActivity.this.getComponentName()));
        }
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
            CocktailsFragment fragment = new CocktailsFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
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
//            toolbar = (Toolbar) findViewById(R.id.toolbar);
//            toolbar1 = (Toolbar) findViewById(R.id.myToolbar);
//            setSupportActionBar(toolbar1);
//            setSupportActionBar(toolbar);
        } else if (id == R.id.nav_random_drink) {
            //set fragment
            RandomDrinkFragment fragment = new RandomDrinkFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
//            toolbar = (Toolbar) findViewById(R.id.toolbar);
//            toolbar1 = (Toolbar) findViewById(R.id.myToolbar);
//            setSupportActionBar(toolbar1);
//            setSupportActionBar(toolbar);
        } else if (id == R.id.nav_profile) {
           Intent intent = new Intent(TestShopActivity.this, ProfileActivity.class);
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
            Intent intent = new Intent(TestShopActivity.this, AddNewDrinkActivity.class);
            intent.putExtra("loggedUser", loggedUser);
            startActivityForResult(intent, ADD_NEW_DRINK);
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




}
