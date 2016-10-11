package com.cmsc355.curry_crackers_cats.booktrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvSignOutLink;
    Button bSignOut;
    //    This is going to be replaced by profile
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        bSignOut = (Button) findViewById(R.id.bSignOut);
//        tvSignOutLink = (TextView) findViewById(R.id.);

        bSignOut.setOnClickListener(this);
//        tvSignOutLink.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.bSignOut:
                startActivity(new Intent(this, Login.class));
                break;

//            case R.id.tvSignOutLink:
//                startActivity(new Intent(this, Login.class));
//                break;
        }
    }
}
