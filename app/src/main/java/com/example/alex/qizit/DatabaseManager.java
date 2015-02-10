package com.example.alex.qizit;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by alejandro on 08/02/15.
 */
public class DatabaseManager {
    private DbHelper helper;
    private SQLiteDatabase db;
    /*
     *  Information of all the tables and columns
     */

    //QUESTION
    static final String TABLE_QUESTION = "QUESTION";
    static final String COLUMN_QUESTION_ID = "_id";
    static final String COLUMN_QUESTION_TEXT = "QUESTION_TEXT";
    static final String COLUMN_QUESTION_FK_CATEGORY = "FK_CATEGORY";
    static final String COLUMN_QUESTION_DIFFICULTY = "DIFFICULTY";
    //ANSWER
    static final String TABLE_ANSWER = "ANSWER";
    static final String COLUMN_ANSWER_ID = "_id";
    static final String COLUMN_ANSWER_TEXT = "ANSWER_TEXT";
    static final String COLUMN_ANSWER_FK_QUESTION = "FK_QUESTION";
    static final String COLUMN_ANSWER_ISTRUE = "IS_TRUE";
    //CATEGORY
    static final String TABLE_CATEGORIES = "CATEGORY";
    static final String COLUMN_CATEGORY_ID = "_id";
    static final String COLUMN_CATEGORY_TEXT = "CATEGORY_TEXT";

    static final String CREATE_TABLE_QUESTION = "CREATE TABLE " + TABLE_QUESTION +
                                                "(" + COLUMN_QUESTION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                                                    + COLUMN_QUESTION_TEXT + " TEXT NOT NULL, "
                                                    + COLUMN_QUESTION_FK_CATEGORY + " INTEGER NOT NULL, "
                                                    + COLUMN_QUESTION_DIFFICULTY + " TEXT NOT NULL, FOREIGN KEY ( "
                                                    + COLUMN_QUESTION_FK_CATEGORY + " ) REFERENCES "
                                                    + TABLE_CATEGORIES + " ( " + COLUMN_CATEGORY_ID + " ) );";

    static final String CREATE_TABLE_ANSWER = "CREATE TABLE " + TABLE_ANSWER +
                                                "(" + COLUMN_ANSWER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                                                    + COLUMN_ANSWER_TEXT + " TEXT NOT NULL, "
                                                    + COLUMN_ANSWER_FK_QUESTION + " INTEGER NOT NULL, "
                                                    + COLUMN_ANSWER_ISTRUE + " INTEGER NOT NULL, FOREIGN KEY ( "
                                                    + COLUMN_ANSWER_FK_QUESTION + ") REFERENCES "
                                                    + TABLE_QUESTION + " ( " + COLUMN_QUESTION_ID + " ) );";

    static final String CREATE_TABLE_CATEGORY = "CREATE TABLE " + TABLE_CATEGORIES +
                                                "(" + COLUMN_CATEGORY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                                                    + COLUMN_CATEGORY_TEXT + " TEXT NOT NULL );";

    /*public DatabaseManager(Context context) {

        helper = new DbHelper(context);
        db = helper.getWritableDatabase();
    }

    public ContentValues generateContentValues() {

    }*/
}
