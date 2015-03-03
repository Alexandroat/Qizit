package com.example.alex.qizit;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class OptionsMenu extends ActionBarActivity {
    SharedPreferences mSharedPreferences;
    private SharedPreferences appPrefs;
    final static String KEY_STORAGE = "Storage";
    private EditText editText;
    final static String PREFERENCIA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public OptionsMenu(Context context, SharedPreferences appPrefs) {
        this.appPrefs = appPrefs;

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

    }

    public OptionsMenu() {
    }



    static {
        PREFERENCIA = "editTextPref";
    }

    private void onClickGuardar(View v){
        this.editText = editText;
        appPrefs.edit()
                .clear()
                .putString(PREFERENCIA, this.editText.getText().toString())
                .commit();
        this.editText.getText().clear();
    }

    public void onClickCargar(View v){
        String pref = appPrefs.getString(PREFERENCIA,"");
        editText.setText(pref);
    }
}
