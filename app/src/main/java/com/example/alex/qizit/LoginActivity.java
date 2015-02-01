package com.example.alex.qizit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;


/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void ShowSignUpActivity(View view) {
        Intent signup = new Intent(LoginActivity.this, SignUpActivity.class);
        startActivity(signup);
    }

    public void LoginIntoParse(View view) {
        EditText userName = (EditText) findViewById(R.id.userNameEditText);
        EditText passWord = (EditText) findViewById(R.id.passWordEditText);

        ParseUser.logInInBackground(String.valueOf(userName.getText()), String.valueOf(passWord.getText()), new
                LogInCallback() {
                    public void done(ParseUser user, ParseException e) {
                        if (user != null) {
                            // Hooray! The user is logged in.
                            Toast toast = Toast.makeText(getApplicationContext(), "Login OK", Toast.LENGTH_SHORT);
                            toast.show();
                            finish();

                        } else {
                            // Signup failed.
                            Toast toast = Toast.makeText(getApplicationContext(), "Login Failded", Toast.LENGTH_SHORT);
                            toast.show();

                        }
                    }
                });
    }



}