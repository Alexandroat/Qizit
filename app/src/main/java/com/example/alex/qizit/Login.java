package com.example.alex.qizit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.app.Activity;
import android.view.View;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

/**
 * Created by karlosc on 23/01/2015.
 */

    public class Login extends Activity {
        /** Called when the activity is first created. */
        @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

    }

public void ShowRegisterActivity(View view){
    Intent register = new Intent(Login.this, Registro.class);
    startActivity(register);
}

    public void LoginIntoParse(View view){
        EditText userName = (EditText) findViewById(R.id.editText);
        EditText passWord = (EditText) findViewById(R.id.editText2);

        ParseUser.logInInBackground(String.valueOf(userName.getText()), String.valueOf(passWord.getText()), new
                LogInCallback() {
                    public void done(ParseUser user, ParseException e) {
                        if (user != null) {
                            // Hooray! The user is logged in.
                            Toast toast = Toast.makeText(getApplicationContext(), "Login OK", Toast.LENGTH_SHORT);
                            toast.show();

                        } else {
                            // Signup failed.
                            Toast toast = Toast.makeText(getApplicationContext(), "Login Failded", Toast.LENGTH_SHORT);
                            toast.show();

                        }
                        }
                    });
      }


}