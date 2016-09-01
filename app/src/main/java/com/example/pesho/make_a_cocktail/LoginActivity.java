package com.example.pesho.make_a_cocktail;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pesho.make_a_cocktail.model.users.User;

public class LoginActivity extends AppCompatActivity {
    private static final int REQUEST_FOR_REGISTER = 1;
    Button register;
    Button login;
    Button regByFace;
    EditText userName;
    EditText pass;
    Dialog successfulReg;
    Dialog errorLogin;
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

        errorLogin = new Dialog(this);
        errorLogin.setContentView(R.layout.dialog_wrong_user_or_pass);
        errorLogin.setTitle("Error!");
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(LoginActivity.this, TestShopActivity.class);
                if (User.checkPass(userName.getText().toString(), pass.getText().toString())) {
                    startActivity(login);
                    finish();
                } else {
                   errorLogin.show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        successfulReg = new Dialog(this);
        successfulReg.setContentView(R.layout.dialog_successful_registration);
        successfulReg.setTitle("Congratulations!");
        if (requestCode == REQUEST_FOR_REGISTER && resultCode == Activity.RESULT_OK) {
            if (data.hasExtra("userName")) {
                userName.setText(data.getExtras().get("userName").toString());
                successfulReg.show();
            }
        }
    }
}
