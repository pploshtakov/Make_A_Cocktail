package com.example.pesho.make_a_cocktail;

import android.os.UserManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pesho.make_a_cocktail.model.users.UsersManager;

import org.w3c.dom.Text;

public class ProfileActivity extends AppCompatActivity {

    EditText editNameET;
    EditText editAddressET;
    EditText editOldPassET;
    EditText editNewPassET;
    EditText editNewPass2ET;

    Button editNameButton;
    Button editAddressButton;
    Button editPassButton;

    TextView helloUserTV;
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

        helloUserTV = (TextView) findViewById(R.id.helloUserTV);
        helloUserTV.setText("Hello " +
                UsersManager.getInstance(ProfileActivity.this).getName(getIntent().getStringExtra("username")));

        //TODO: change values in shared preffs
        editNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            UsersManager.getInstance(ProfileActivity.this).changeData("name",getIntent().getStringExtra("username"),editNameET.getText().toString());
            }
        });

        editAddressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UsersManager.getInstance(ProfileActivity.this).changeData("email",getIntent().getStringExtra("username"),editAddressET.getText().toString());
            }
        });

        //TODO fix: method is never entered by click !?!
        editPassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //check if old password is correct
                Log.e("pass method", "entered");
               if (UsersManager.getInstance(ProfileActivity.this).checkPass
                       (getIntent().getStringExtra("username"),editOldPassET.getText().toString())){

                   //check if new passwords match
                   if(editNewPassET.getText().toString().equals(editNewPass2ET.toString())){
                       UsersManager.getInstance(ProfileActivity.this).changeData("password",getIntent().getStringExtra("username"),editNewPassET.getText().toString());
                   }
               }
            }
        });
    }
}
