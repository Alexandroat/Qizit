package com.example.alex.qizit;

/**
 * Created by karlosc on 23/01/2015.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class Registro extends Activity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;

    }

    public void RegisterButt(View view) {
        EditText userName = (EditText) findViewById(R.id.username);
        EditText passWord = (EditText) findViewById(R.id.pass);
        EditText email = (EditText) findViewById(R.id.mail);

        ParseUser user = new ParseUser();
        user.setUsername(String.valueOf(userName.getText()));
        user.setPassword(String.valueOf(passWord.getText()));
        user.setEmail(String.valueOf(email.getText()));

        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    // Hooray! Let them use the app now.
                    Toast toast = Toast.makeText(getApplicationContext(), "Username Registered", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    // Sign up didn't succeed.
                    Toast toast = Toast.makeText(getApplicationContext(), "Registration Faild", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }


}