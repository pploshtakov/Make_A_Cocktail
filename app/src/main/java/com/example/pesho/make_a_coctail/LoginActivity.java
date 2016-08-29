package com.example.pesho.make_a_coctail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button register = (Button) findViewById(R.id.LPRegisterButton);
        Button login = (Button) findViewById(R.id.LPLoginButton);
        Button regByFace = (Button) findViewById(R.id.LPFacebookLoginButton);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reg = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(reg);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent test = new Intent(LoginActivity.this, ShopActivity.class);
                startActivity(test);
            }
        });
    }
}
