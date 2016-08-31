package com.example.pesho.make_a_coctail;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private static final int REQUEST_FOR_REGISTER = 1;
    Button register;
    Button login;
    Button regByFace;
    EditText userName;
    EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        register = (Button) findViewById(R.id.LPRegisterButton);
        login = (Button) findViewById(R.id.LPLoginButton);
        regByFace = (Button) findViewById(R.id.LPFacebookLoginButton);
        pass = (EditText) findViewById(R.id.loginPassText);
        userName = (EditText) findViewById(R.id.loginNameText);
        pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reg = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivityForResult(reg,REQUEST_FOR_REGISTER);
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
