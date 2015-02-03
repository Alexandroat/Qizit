package com.example.alex.qizit;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.SQLException;

/**
 * Created by alex on 30/01/15.
 */
public class SQLiteHelper /*extends SQLiteOpenHelper*/ {

    static final String DATABASE_NAME = "ContactDB";
    static final int DATABASE_VERSION = 1;

    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        //super(context, name, factory, version, errorHandler);
    }

   /* @Override
    public void onCreate(SQLiteDatabase db) {
        try {
           // db.execSQL(CREATE_TABLE_CONTACT);
        } catch (SQLException e) {
            //Log.e(TAG, "SQLException ", e);

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }*/
}
