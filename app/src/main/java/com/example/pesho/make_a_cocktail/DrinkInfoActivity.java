package com.example.pesho.make_a_cocktail;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkInfoActivity extends AppCompatActivity {
    ImageView drinkIV;
    TextView titleTV;
    TextView instrTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_info);
        drinkIV = (ImageView) findViewById(R.id.info_image);
        titleTV = (TextView) findViewById(R.id.info_title_TV);
        instrTV = (TextView) findViewById(R.id.info_instructions_TV);
        Intent intent = getIntent();
        int image = Integer.parseInt(intent.getStringExtra("image"));
        String title = intent.getStringExtra("title");
        String instr = intent.getStringExtra("instructions");
        drinkIV.setImageResource(image);
        titleTV.setText(title);
        instrTV.setText(instr);
    }
}
