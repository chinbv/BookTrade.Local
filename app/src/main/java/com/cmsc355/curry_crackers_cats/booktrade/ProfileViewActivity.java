package com.cmsc355.curry_crackers_cats.booktrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_view);


        //create list object

        final Button bEdit = (Button) findViewById(R.id.bEdit);
        final Button bLogout = (Button) findViewById(R.id.bLogout);
        final TextView usernameDisplay = (TextView) findViewById(R.id.etUsername);

        //Displays Username
        usernameDisplay.setText(user.getUserName());

        //Sets up function so that when user clicks the Edit button they are taken to the page
        //to edit their profile
        bEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editIntent = new Intent(ProfileViewActivity.this, EtProfileActivity.class);
                ProfileViewActivity.this.startActivity(editIntent);
            }
        });

        //Sets up function so that when user clicks on the logout button they are taken to the
        //login page

        // bLogout.setOnClickListener((new View.OnClickListener() {
        //   @Override
        //  public void onClick(View v) {
        //     Intent logoutIntent = new Intent(ProfileViewActivity.this, Login.class);
        //       ProfileViewActivity.this.startActivity(logoutIntent);
        //   }
        //  }));

    }
}
