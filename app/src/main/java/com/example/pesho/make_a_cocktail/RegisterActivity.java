package com.example.pesho.make_a_cocktail;

import android.app.Activity;
import android.content.Intent;
import android.os.UserManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pesho.make_a_cocktail.model.users.User;
import com.example.pesho.make_a_cocktail.model.users.UsersManager;

import org.json.JSONArray;

public class RegisterActivity extends AppCompatActivity {
    Button register;
    EditText name;
    EditText userName;
    EditText pass;
    EditText repeatPass;
    EditText email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        UsersManager.getInstance(RegisterActivity.this);
        register = (Button) findViewById(R.id.RPRegisterButton);
        name = (EditText) findViewById(R.id.RPNameText);
        userName = (EditText) findViewById(R.id.RPUserText);
        pass = (EditText) findViewById(R.id.RPPasswordText);
        repeatPass = (EditText) findViewById(R.id.RPRepeatPassword);
        email = (EditText) findViewById(R.id.RPEmail);
        //set on pass and repeatPass InputType password
        pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        repeatPass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 = name.getText().toString();
                String userName1 = userName.getText().toString();
                String pass1 = pass.getText().toString();
                String email1 = email.getText().toString();
                if (!UsersManager.checkUsernameIsFree(userName1)|| userName1.isEmpty()) {
                    userName.setError("User name isn't available!");
                    return;
                } else if (name1.isEmpty()) {
                    name.setError("Please enter a name!");
                    return;
                } else if (!pass1.equals(repeatPass.getText().toString())|| pass1.isEmpty()) {
                    repeatPass.setError("The password don't match!");
                    //TODO check for weak password
                    return;
                } else if (email1.isEmpty() || !email1.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")) {
                    email.setError("Incorrect email!");
                    return;
                } else {

                    User user = new User(name1, userName1, pass1, email1);
                    UsersManager.registerUser(RegisterActivity.this, user);
                    Intent intent = new Intent();
                    intent.putExtra("userName", userName1);
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }
            }
        });

    }
}
