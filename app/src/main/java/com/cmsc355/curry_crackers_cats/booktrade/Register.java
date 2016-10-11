package com.cmsc355.curry_crackers_cats.booktrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity implements View.OnClickListener {


    Button bSignUp;
    EditText etUsername, etEmail, etCEmail, etPassword, etREPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etCEmail = (EditText) findViewById(R.id.etCEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etREPassword = (EditText) findViewById(R.id.etREPassword);
        bSignUp = (Button) findViewById(R.id.bSignUp);

        bSignUp.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.bSignUp:
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                String confirmPassword = etREPassword.getText().toString();
                if(password.compareTo(confirmPassword) != 0) {

                }
                String email = etEmail.getText().toString();
                String confirmEmail = etCEmail.getText().toString();

                User registerData = new User(username, password, email);

                break;
        }
    }
}
