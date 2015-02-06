//package com.example.alex.qizit;
//
//import android.content.Context;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
///**
//* Created by VLad on 03/02/2015.
//*/
//public class DbHelper extends SQLiteOpenHelper {
//    final static String DB_NAME = "Qizit.db";
//    final static int DB_version = 1;
//    final static String TAG = DbHelper.class.getName();
//
//    /*
//     *  Table info
//     */
//
//    //QUESTION
//    static final String TABLE_QUESTION = "QUESTION";
//    static final String COLUMN_QUESTION_ID = "_id";
//    static final String COLUMN_QUESTION_TEXT = "QUESTION_TEXT";
//    static final String COLUMN_QUESTION_FK_CATEGORY = "FK_CATEGORY";
//    static final String COLUMN_QUESTION_DIFFICULTY = "DIFFICULTY";
//    //ANSWER
//    static final String TABLE_ANSWER = "ANSWER";
//    static final String COLUMN_ANSWER_ID = "_id";
//    static final String COLUMN_ANSWER_TEXT = "ANSWER_TEXT";
//    static final String COLUMN_ANSWER_FK_QUESTION = "FK_QUESTION";
//    static final String COLUMN_ANSWER_ISTRUE = "IS_TRUE";
//    //CATEGORY
//    static final String TABLE_CATEGORIES = "CATEGORY";
//    static final String COLUMN_CATEGORY_ID = "_id";
//    static final String COLUMN_CATEGORY_TEXT = "CATEGORY_TEXT";
//
//    static final String CREATE_TABLE_QUESTION = "CREATE TABLE " + TABLE_QUESTION + "(" + COLUMN_QUESTION_ID + "INTEGER PRIMARY KEY AUTOINCREMENT " + COLUMN_QUESTION_TEXT + " TEXT NOT NULL " + COLUMN_QUESTION_FK_CATEGORY + " INTEGER NOT NULL " + COLUMN_QUESTION_DIFFICULTY + " TEXT NOT NULL );";
//    static final String CREATE_TABLE_ANSWER = "CREATE TABLE " + TABLE_ANSWER + "(" + COLUMN_ANSWER_ID + "INTEGER PRIMARY KEY AUTOINCREMENT " + COLUMN_ANSWER_TEXT + " TEXT NOT NULL " + COLUMN_ANSWER_FK_QUESTION + " INTEGER NOT NULL " + COLUMN_ANSWER_ISTRUE + " TEXT NOT NULL );";
//    static final String CREATE_TABLE_CATEGORY = "CREATE TABLE " + TABLE_CATEGORIES + "(" + COLUMN_CATEGORY_ID + "INTEGER PRIMARY KEY AUTOINCREMENT " + COLUMN_CATEGORY_TEXT + " TEXT NOT NULL );";
//
//
//    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, name, factory, version);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(CREATE_TABLE_ANSWER);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//
//    }
//}
