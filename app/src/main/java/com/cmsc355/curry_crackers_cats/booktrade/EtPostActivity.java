package com.cmsc355.curry_crackers_cats.booktrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EtPostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_et_post);

        //Temporary test object to ensure that the code functions
        User user = new User("Name", "password", "email");
        final Textbook tempTextbook = new Textbook("title", "good", "$5.00", "this is a test", user.getUserId());
        final DBHandler database = new DBHandler(getApplicationContext());
        database.addUser(user);

        //Creates text fields to edit
        final EditText etTitle = (EditText) findViewById(R.id.etTitle);
        final EditText etISBN = (EditText) findViewById(R.id.etISBN);
        final EditText etPrice = (EditText) findViewById(R.id.etPrice);
        final EditText etDescription = (EditText) findViewById(R.id.etDescription);
        final EditText etCondition = (EditText) findViewById(R.id.etCondition);

        final Button bSave = (Button) findViewById(R.id.bSave);
        final Button bSold = (Button) findViewById(R.id.bSold);

        bSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String title = etTitle.getText().toString();
                final String ISBN = etISBN.getText().toString();
                final String price = etPrice.getText().toString();
                final String description = etDescription.getText().toString();
                final String condition = etCondition.getText().toString();

                //Will update the textbook object
                tempTextbook.setTitle(title);
               // tempTextbook.setPrice(price);//ISSUE
                tempTextbook.setCondition(condition);
                tempTextbook.setDescription(description);
                //tempTextbook.setISBN(ISBN);

                //Will update the database
                database.updateTextbook(tempTextbook);

                Intent saveIntent = new Intent(EtPostActivity.this, ProfileViewActivity.class);
                EtPostActivity.this.startActivity(saveIntent);
            }
        });

        bSold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.deleteTextbook(tempTextbook.getTextbookId());
                Intent soldIntent = new Intent(EtPostActivity.this, ProfileViewActivity.class);
                EtPostActivity.this.startActivity(soldIntent);
            }
        });

    }
}
