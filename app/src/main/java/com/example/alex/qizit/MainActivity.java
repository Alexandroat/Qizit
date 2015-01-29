package com.example.alex.qizit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableRow;

public class MainActivity extends ActionBarActivity {

    private TableRow button;
    // Cambio introducido
    private boolean isLogged = false;
    static final int RESULT_CODE_LOGIN = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (TableRow) findViewById(R.id.btnOnePlayer);
        // TODO: Cambio introducido (Cambiar cuando tengamos el Parser Funcionando)

        SharedPreferences miPref = PreferenceManager.getDefaultSharedPreferences(this);

        isLogged = miPref.getBoolean("isLogged",false);

        openLogin();


    }

    public void openLogin (){
        if (!isLogged) {
            Intent login = new Intent().setClass(MainActivity.this, LoginActivity.class);
            login.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            login.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
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
            Intent settings = new Intent().setClass(MainActivity.this, OptionsMenu.class);
            startActivity(settings);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

   /* @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == RESULT_CODE_LOGIN){
            if(resultCode==RESULT_OK){

                if (data.getData().toString().equals("true")) isLogged = true;
                else isLogged = false;
            }
            else{

            }
        }

    }*/
}
