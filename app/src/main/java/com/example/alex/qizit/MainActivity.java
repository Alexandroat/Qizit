package com.example.alex.qizit;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseUser;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String fontPath2 ="fonts/LeckerliOne-Regular.ttf";

        /*
         * Creation of the Database
         */
        DbHelper helper = new DbHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();
        DatabaseManager dbm = new DatabaseManager(this);
        //dbm.createCategory(new Category("Ejemplos"));
        //dbm.createQuestion(new Question("¡Primera pregunta de la app!",1,"Sin Dificultad"));
        //dbm.createAnswer(new Answer("No hay respuesta para una buena pregunta",1,true));
       // dbm.getQuestion(1);

        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            // do stuff with the user
            Toast toast = Toast.makeText(getApplicationContext(), "yes logged", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            // show the signup or login screen
            Toast toast = Toast.makeText(getApplicationContext(), "no logged", Toast.LENGTH_SHORT);
            toast.show();
            Intent login = new Intent().setClass(MainActivity.this, LoginActivity.class);
            login.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(login);
        }


    }


    public void OnClick(View v) {

        Intent categories = new Intent().setClass(MainActivity.this, Categories.class);
        startActivity(categories);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            OptionsMenu op = new OptionsMenu(this,getPreferences(id));
            Intent settings = new Intent().setClass(MainActivity.this, OptionsMenu.class);
            startActivity(settings);
            return true;
        }
        if (id == R.id.logout) {
            ParseUser.logOut();
            finish();

        }


        return super.onOptionsItemSelected(item);
    }


}
