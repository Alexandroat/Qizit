package com.example.alex.qizit;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by karlosc on 28/01/2015.
 */
public class YepApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "ROs4ggumPE0AW4gG0Eh0pJkIebVSVKfX9Bajsmaa", "YT77oBPIYRaMhvWF5d4MimUbjyI7GbcolOyTWCIW");
    }
}
