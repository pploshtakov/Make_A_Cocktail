package com.example.pesho.make_a_cocktail;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pesho.make_a_cocktail.model.drinks.AlcoholicCocktail;
import com.example.pesho.make_a_cocktail.model.drinks.Drink;
import com.example.pesho.make_a_cocktail.model.drinks.DrinksManager;
import com.example.pesho.make_a_cocktail.model.drinks.NonAlcoholicCocktail;
import com.example.pesho.make_a_cocktail.model.drinks.Shot;
import com.example.pesho.make_a_cocktail.model.users.UsersManager;

public class AddNewDrinkActivity extends AppCompatActivity {
    private static final int RESULT_LOAD_IMAGE = 111;
    EditText drinkNameET;
    EditText instrET;
    Spinner categorySpinner;
    Spinner glassSpinner;
    CheckBox alcoholicCheckBox;
    Button addImageButton;
    Button addDrinkButton;
    String loggedUser;
    Bitmap bmp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_drink);
        drinkNameET = (EditText) findViewById(R.id.add_new_drink_name_ET);
        instrET = (EditText) findViewById(R.id.add_new_drink_instructions_ET);
        categorySpinner = (Spinner) findViewById(R.id.add_new_drink_category_spinner);
        glassSpinner = (Spinner) findViewById(R.id.add_new_drink_glass_spinner);
        alcoholicCheckBox = (CheckBox) findViewById(R.id.add_new_drink_CB);
        addImageButton = (Button) findViewById(R.id.add_new_drink_up_photo_button);
        addDrinkButton = (Button) findViewById(R.id.add_new_drink_add_drink_button);
        Intent intent = getIntent();
        loggedUser = intent.getStringExtra("loggedUser");

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(adapter);

        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.glasses, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        glassSpinner.setAdapter(adapter1);

        addImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, RESULT_LOAD_IMAGE);
            }
        });

        addDrinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drinkNameET.getText().toString().isEmpty()) {
                    drinkNameET.setError("Please enter a name!");
                    drinkNameET.requestFocus();
                    return;
                }
                if (instrET.getText().toString().isEmpty()) {
                    instrET.setError("Please enter instructions!");
                    instrET.requestFocus();
                    return;
                }
                String category = categorySpinner.getSelectedItem().toString();
                String glass = glassSpinner.getSelectedItem().toString();
                if (category.equals("Categories")){
                    Toast.makeText(AddNewDrinkActivity.this, "Please choose category!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (category.equals("Shot") && !glass.equals("Shot glass")) {
                    Toast.makeText(AddNewDrinkActivity.this, "Any shot must be in a shot glass!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!category.equals("Shot") && glass.equals("Shot glass")) {
                    Toast.makeText(AddNewDrinkActivity.this, "Cocktail can't be in a shot glass!", Toast.LENGTH_SHORT).show();
                    return;
                }
                Drink drink;
                String alcoholic = "NonAlcoholic cocktail";
                if (alcoholicCheckBox.isChecked()) {
                    alcoholic = "Alcoholic cocktail";
                }
                if (category.equals("Alcoholic cocktail")) {
                    int id = DrinksManager.generateDrinkId();
                    drink = new AlcoholicCocktail(id, drinkNameET.getText().toString(), instrET.getText().toString(), R.drawable.bloody_mary_pic, category, "Alcoholic", glass, "null", false  );
                    if (bmp != null) {
                        drink.setBmp(bmp);
                    }
                    setResult(RESULT_OK);
                    UsersManager.addMyDrink(drink, loggedUser);
                    DrinksManager.overwriteSharedPrefsDrinks(loggedUser);
                    finish();
                    return;
                } else if (category.equals("NonAlcoholic cocktail")) {
                    int id = DrinksManager.generateDrinkId();
                    drink = new NonAlcoholicCocktail(id, drinkNameET.getText().toString(), instrET.getText().toString(), R.drawable.bloody_mary_pic, category, "NonAlcoholic", glass, "null", false  );
                    if (bmp != null) {
                        drink.setBmp(bmp);
                    }
                    setResult(RESULT_OK);
                    UsersManager.addMyDrink(drink, loggedUser);
                    DrinksManager.overwriteSharedPrefsDrinks(loggedUser);
                    finish();
                    return;
                } else if (category.equals("Shot")) {
                    int id = DrinksManager.generateDrinkId();
                    drink = new Shot(id, drinkNameET.getText().toString(), instrET.getText().toString(), R.drawable.bloody_mary_pic, category, "Alcoholic", glass, "null", false  );
                    if (bmp != null) {
                        drink.setBmp(bmp);
                    }
                    setResult(RESULT_OK);
                    UsersManager.addMyDrink(drink, loggedUser);
                    DrinksManager.overwriteSharedPrefsDrinks(loggedUser);
                    finish();
                    return;
                }
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor = getContentResolver().query(selectedImage,filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            bmp = BitmapFactory.decodeFile(picturePath);
        }
    }
}
