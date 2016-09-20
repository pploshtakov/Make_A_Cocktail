package com.example.pesho.make_a_cocktail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pesho.make_a_cocktail.model.drinks.Drink;
import com.example.pesho.make_a_cocktail.model.drinks.DrinksManager;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class DrinkInfoActivity extends AppCompatActivity {
    ImageView drinkIV;
    TextView titleTV;
    TextView instrTV;
    TextView categoryTV;
    TextView glassTV;
    TextView alcoholicTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_info);
        drinkIV = (ImageView) findViewById(R.id.info_image);
        titleTV = (TextView) findViewById(R.id.info_title_TV);
        instrTV = (TextView) findViewById(R.id.info_instructions_TV);
        categoryTV = (TextView) findViewById(R.id.drink_info_category_TV);
        glassTV = (TextView) findViewById(R.id.drink_info_glass_TV);
        alcoholicTV = (TextView) findViewById(R.id.drink_info_alcoholic_TV);
        Intent intent = getIntent();
        Drink drink = DrinksManager.getDrink(intent.getIntExtra("idDrink", 0));
        if (drink.getBmp() != null) {
            drinkIV.setImageBitmap(drink.getBmp());
        }
        //check internet connection, check for url and set image from url or default
        else if (drink.getStrDrinkThumb() != null && !drink.getStrDrinkThumb().equals("null") && isNetworkConnected() && !drink.getStrDrinkThumb().isEmpty()) {
            new ImageFromUrlTask(DrinkInfoActivity.this).execute(drink);
        } else {
            drinkIV.setImageResource(drink.getImage());
        }
        titleTV.setText(drink.getName());
        instrTV.setText(drink.getStrInstructions());
        categoryTV.setText(drink.getStrCategory());
        glassTV.setText(drink.getStrGlass());
        alcoholicTV.setText(drink.getStrAlcoholic());
    }
    //check connection
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    public class ImageFromUrlTask extends AsyncTask<Drink, Void, Bitmap> {
        private Activity activity;
        ImageFromUrlTask(Activity activity) {
            this.activity = activity;
        }
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            ImageView iv = (ImageView) activity.findViewById(R.id.info_image);
            iv.setImageBitmap(bitmap);
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
}





