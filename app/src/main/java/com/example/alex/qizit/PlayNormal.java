package com.example.alex.qizit;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class PlayNormal extends ActionBarActivity {

    EditText editTextQuestion;
    Button buttonAnswer1;
    Button buttonAnswer2;
    Button buttonAnswer3;
    Button buttonAnswer4;

    DatabaseManager databaseManager;
    Question question;
    Answer answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_normal);

        databaseManager = new DatabaseManager(this);

        editTextQuestion = (EditText) findViewById(R.id.editTextQuestion);
        buttonAnswer1 = (Button) findViewById(R.id.buttonAnswer1);
        buttonAnswer2 = (Button) findViewById(R.id.buttonAnswer2);
        buttonAnswer3 = (Button) findViewById(R.id.buttonAnswer3);
        buttonAnswer4 = (Button) findViewById(R.id.buttonAnswer4);

        loadQuestion();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_play_normal, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public int createRandomNrOfQuestion() {
        int minNumber = 1;
        int maxNumber = databaseManager.getMaxNumQuestion();
        int mRandom = minNumber + (int) (Math.random() * ((maxNumber - minNumber) + 1));
        return mRandom;
    }


    public void loadQuestion() {
        int theNumber = createRandomNrOfQuestion();
        Answer actualAnswer = null;

        question = databaseManager.getQuestion(theNumber);
        String questionText = question.getQuestionText();
        editTextQuestion.setText(questionText);

        ArrayList<Answer> answers;
        answers = databaseManager.getAnswer(theNumber);

/*
        for(Answer answer1:answers){
            buttonAnswer1.setText(answer1.getAnswerText());

        }
*/
        try {

            actualAnswer = answers.get(0);
            buttonAnswer1.setText(actualAnswer.getAnswerText());

            actualAnswer = answers.get(1);
            buttonAnswer2.setText(actualAnswer.getAnswerText());

            actualAnswer = answers.get(2);
            buttonAnswer3.setText(actualAnswer.getAnswerText());

            actualAnswer = answers.get(3);
            buttonAnswer4.setText(actualAnswer.getAnswerText());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error load answers");
        }


    }


    public void onClickAnyAnswer(View view) {
    }


}//end class
