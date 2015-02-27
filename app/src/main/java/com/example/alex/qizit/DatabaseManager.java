package com.example.alex.qizit;
//
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

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

    /*
      *Create Tables
      */
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

    public DatabaseManager(Context context) {

        helper = new DbHelper(context);
        db = helper.getWritableDatabase();
    }

   /* public ContentValues generateContentValues() {

    }*/

    public SQLiteDatabase openWriteable() {
        return helper.getWritableDatabase();
    }

    public void close(SQLiteDatabase database) {
        database.close();
    }

    public void createQuestion(Question question) {
        SQLiteDatabase database = openWriteable();
        database.beginTransaction();
        ContentValues questionValues = new ContentValues();
        questionValues.put(COLUMN_QUESTION_TEXT, question.getQuestionText());
        questionValues.put(COLUMN_QUESTION_FK_CATEGORY, question.getFkCategory());
        questionValues.put(COLUMN_QUESTION_DIFFICULTY, question.getDificulty());

        database.insert(TABLE_QUESTION, null, questionValues);
        database.setTransactionSuccessful();
        database.endTransaction();
        close(database);

    }

    public void createAnswer(Answer answer) {
        SQLiteDatabase database = openWriteable();
        database.beginTransaction();
        ContentValues questionValues = new ContentValues();
        questionValues.put(COLUMN_QUESTION_TEXT, answer.getAnswerText());
        questionValues.put(COLUMN_QUESTION_FK_CATEGORY, answer.getFkQuestion());
        questionValues.put(COLUMN_QUESTION_DIFFICULTY, answer.getIsTrue());

        database.insert(TABLE_ANSWER, null, questionValues);
        database.setTransactionSuccessful();
        database.endTransaction();
        close(database);

    }

    public void createCategory(Category category) {
        SQLiteDatabase database = openWriteable();
        database.beginTransaction();
        ContentValues questionValues = new ContentValues();
        questionValues.put(COLUMN_QUESTION_TEXT, category.getName());

        database.insert(TABLE_CATEGORIES, null, questionValues);
        database.setTransactionSuccessful();
        database.endTransaction();
        close(database);

    }

    public void deleteQuestion(int questionId) {
        SQLiteDatabase database = openWriteable();
        database.beginTransaction();
        database.delete(TABLE_ANSWER,
                String.format("%s=%d", COLUMN_ANSWER_FK_QUESTION, questionId),
                null);
        database.delete(TABLE_QUESTION,
                String.format("%s=%d", COLUMN_QUESTION_ID, questionId),
                null);

        database.setTransactionSuccessful();
        database.endTransaction();
        close(database);
    }

    public void deleteAnswer(int answerId) {
        SQLiteDatabase database = openWriteable();
        database.beginTransaction();
        /*database.delete(TABLE_QUESTION,
                String.format("%s=%d", COLUMN_ANSWER_FK_QUESTION, answerId),
                null);*/
        database.delete(TABLE_ANSWER,
                String.format("%s=%d", COLUMN_ANSWER_ID, answerId),
                null);
        database.setTransactionSuccessful();
        database.endTransaction();
        close(database);
    }

    public void deleteCategory(int categoryId) {
        SQLiteDatabase database = openWriteable();
        database.beginTransaction();
        database.delete(TABLE_QUESTION,
                String.format("%s=%d", COLUMN_QUESTION_FK_CATEGORY, categoryId),
                null);
        /*database.delete(TABLE_ANSWER,
                String.format("%s=%d", COLUMN_ANSWER_FK_QUESTION, ),
                null); Eliminar respuestas de una pregunta*/
        database.delete(TABLE_CATEGORIES,
                String.format("%s=%d", COLUMN_CATEGORY_ID, categoryId),
                null);
        database.setTransactionSuccessful();
        database.endTransaction();
        close(database);
    }

    public Question getQuestion(int id){

        SQLiteDatabase db = openWriteable();

        Cursor cursor =
                db.query(TABLE_QUESTION,
                        new String[] {COLUMN_QUESTION_ID, COLUMN_QUESTION_TEXT, COLUMN_QUESTION_FK_CATEGORY, COLUMN_QUESTION_DIFFICULTY},
                        " id = ?",
                        new String[] { String.valueOf(id) },
                        null,
                        null,
                        null,
                        null);


        if (cursor != null)
            cursor.moveToFirst();

        Question question = new Question();
        question.setId(Integer.parseInt(cursor.getString(0)));
        question.setQuestionText(cursor.getString(1));
        question.setFkCategory(Integer.parseInt(cursor.getString(2)));
        question.setDificulty(cursor.getString(3));


        Log.d("getQuestion(" + id + ")", question.toString());

        return question;
    }

    public Answer getAnswer(int id){

        SQLiteDatabase db = openWriteable();

        Cursor cursor =
                db.query(TABLE_ANSWER,
                        new String[] {COLUMN_ANSWER_ID, COLUMN_ANSWER_TEXT, COLUMN_ANSWER_FK_QUESTION, COLUMN_ANSWER_ISTRUE},
                        " id = ?",
                        new String[] { String.valueOf(id) },
                        null,
                        null,
                        null,
                        null);


        if (cursor != null)
            cursor.moveToFirst();

        Answer answer = new Answer();
        answer.setId(Integer.parseInt(cursor.getString(0)));
        answer.setAnswerText(cursor.getString(1));
        answer.setFkQuestion(Integer.parseInt(cursor.getString(2)));
        answer.setIsTrue(Boolean.parseBoolean(cursor.getString(3)));


        Log.d("getAnswer(" + id + ")", answer.toString());

        return answer;
    }

    public Category getCategory(int id){

        SQLiteDatabase db = openWriteable();

        Cursor cursor =
                db.query(TABLE_QUESTION,
                        new String[] {COLUMN_QUESTION_ID, COLUMN_QUESTION_TEXT},
                        " id = ?",
                        new String[] { String.valueOf(id) },
                        null,
                        null,
                        null,
                        null);


        if (cursor != null)
            cursor.moveToFirst();

        Category category = new Category();
        category.setId(Integer.parseInt(cursor.getString(0)));
        category.setName(cursor.getString(1));

        Log.d("getCategory(" + id + ")", category.toString());

        return category;
    }




        //va??
    public int getMaxIdQuestion(){
        String countQuery = "SELECT  * FROM " + TABLE_QUESTION;
        Cursor cursor = db.rawQuery(countQuery, null);
        int cnt = cursor.getCount();
        cursor.close();
        return cnt;
    }

    //va??
    public void getAnswersOfQuestion(int idQuestion){
        String getAnswersOfQuestionQuery = "SELECT * FROM " + TABLE_ANSWER + " WHERE " + COLUMN_ANSWER_FK_QUESTION + " = " + idQuestion;

        Cursor cursor = db.rawQuery(getAnswersOfQuestionQuery, null);
        Answer[] answers=new Answer[cursor.getCount()];


        for(int i = 0; i<cursor.getCount(); i++){
   // answers[i]= new Answer(cursor.get, cursor.getString(2), cursor.getInt(3))
        }

    }


}
