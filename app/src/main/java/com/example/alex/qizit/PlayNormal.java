package com.example.alex.qizit;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class PlayNormal extends ActionBarActivity {

    DatabaseManager databaseManager;
    Question question;
    Answer answer;

    TextView textViewPregunta;
    Button buttonRespuesta1;
    Button buttonRespuesta2;
    Button buttonRespuesta3;
    Button buttonRespuesta4;


    Random random = new Random();
    //int randomNum = random.nextInt((max - min) + 1) + min;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_normal);

         textViewPregunta = (TextView) findViewById(R.id.textViewPregunta);
         buttonRespuesta1 = (Button)findViewById(R.id.buttonRespuesta1);
         buttonRespuesta2 = (Button)findViewById(R.id.buttonRespuesta2);
         buttonRespuesta3 = (Button)findViewById(R.id.buttonRespuesta3);
         buttonRespuesta4 = (Button)findViewById(R.id.buttonRespuesta4);


            getRandomIdQuestion();
            loadQuestion();

    }



    public int getRandomIdQuestion(){
        int randomIdQuestion = random.nextInt((databaseManager.getMaxIdQuestion() - 1) + 1) + 1;
        return randomIdQuestion;
    }


    public void loadQuestion(){

        question= databaseManager.getQuestion(getRandomIdQuestion());
        textViewPregunta.setText(question.questionText);

        databaseManager.getAnswer(question.getId());
        answer = databaseManager.getAnswer(5);


    }






}