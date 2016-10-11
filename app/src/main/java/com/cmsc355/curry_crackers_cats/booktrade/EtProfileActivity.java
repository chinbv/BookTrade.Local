package com.cmsc355.curry_crackers_cats.booktrade;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EtProfileActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_et_profile);

        //Temporary objects used for testing
        final User user = new User("Name", "password", "email");
        final DBHandler database = new DBHandler(getApplicationContext());
        database.addUser(user);


        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etEmail = (EditText) findViewById(R.id.etEmail);
        final EditText etConfirmEmail = (EditText) findViewById(R.id.etConfirmEmail);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final EditText etConfirmPassword = (EditText) findViewById(R.id.etConfirmPassword);
        final Button bSave = (Button) findViewById(R.id.bSave);

        //Sets up function so that when user clicks on the Save button they are taken to the main
        //profile screen

        bSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent saveIntent = new Intent(EtProfileActivity.this, ProfileViewActivity.class);
                EtProfileActivity.this.startActivity(saveIntent);
                final String username = etUsername.getText().toString();
                final String email = etEmail.getText().toString();
                final String confirmEmail = etConfirmEmail.getText().toString();
                final String password = etPassword.getText().toString();
                final String confirmPassword = etConfirmPassword.getText().toString();

                user.setUserName(username);
                user.setEmail(email);
                user.setPassword(password);

                database.updateUser(user);

            }
        });
    }
}
