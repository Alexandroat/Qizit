package com.example.alex.qizit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

/**
 * Created by VLad on 30/01/2015.
 */
public class SignUpActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    public void SignUpButton(View view) {
        EditText userName = (EditText) findViewById(R.id.userNameEditText);
        EditText passWord = (EditText) findViewById(R.id.passWordEditText);
        EditText email = (EditText) findViewById(R.id.emailEditText);

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
                    finish();

                } else {
                    // Sign up didn't succeed.
                    Toast toast = Toast.makeText(getApplicationContext(), "Registration Faild", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

    }

    public void showLoginActivity(View view) {




        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            // do stuff with the user
            Toast toast = Toast.makeText(getApplicationContext(), "yes logged", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            // show the signup or login screen
            Toast toast = Toast.makeText(getApplicationContext(), "no logged", Toast.LENGTH_SHORT);
            toast.show();
            Intent signup = new Intent(SignUpActivity.this, LoginActivity.class);
            startActivity(signup);

        }







        finish();

    }


}
