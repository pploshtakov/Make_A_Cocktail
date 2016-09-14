package com.example.pesho.make_a_cocktail;

import android.os.UserManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.pesho.make_a_cocktail.model.users.UsersManager;

public class ProfileActivity extends AppCompatActivity {

    EditText editNameET;
    EditText editAddressET;
    EditText editOldPassET;
    EditText editNewPassET;
    EditText editNewPass2ET;

    Button editNameButton;
    Button editAddressButton;
    Button editPassButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        editNameET = (EditText) findViewById(R.id.newNameET);
        editAddressET = (EditText) findViewById(R.id.newAddressET);
        editOldPassET = (EditText) findViewById(R.id.oldPasswrodET);
        editNewPassET = (EditText) findViewById(R.id.newPasswordET);
        editNewPass2ET = (EditText) findViewById(R.id.newPassword2ET);

        editNameButton = (Button) findViewById(R.id.editNameButton);
        editAddressButton = (Button) findViewById(R.id.editAddressButton);
        editPassButton = (Button) findViewById(R.id.editPasswordButton);

        //TODO: change values in shared preffs
        editNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        editAddressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        editPassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check if old password is correct
               if (UsersManager.getInstance(ProfileActivity.this).checkPass
                       (getIntent().getStringExtra("username"),editOldPassET.getText().toString())){
                   //check if new passwords match
                   if(editNameET.getText().toString().equals(editNewPass2ET.toString())){

                   }
               }
            }
        });
    }
}
