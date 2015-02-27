package com.example.alex.qizit;

import com.example.alex.qizit.LoginActivity;
import com.example.alex.qizit.R;
import com.parse.ParseUser;

import android.support.v7.app.ActionBarActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.app.Activity;
import android.app.Application;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ApplicationTestCase;
import android.test.TouchUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */

public class MyLoginTest extends ActivityInstrumentationTestCase2<LoginActivity> {

    private static final String USERNAME = "vlad";
    private static final String PASSWORD = "1 2 3 4";

    private LoginActivity loginActivity;
    private EditText userName;
    private EditText passWord;
    private Button login;

   // private menu menuMain;


    public MyLoginTest() {
        super(LoginActivity.class);
    }


    protected void setUp() throws Exception {
        super.setUp();
        loginActivity = getActivity();
        userName = (EditText)   loginActivity.findViewById(R.id.userNameEditText);
        passWord = (EditText) loginActivity.findViewById(R.id.passWordEditText);
        login = (Button) loginActivity.findViewById(R.id.loginButton);

       // menuMain = () loginActivity.onCreateOptionsMenu()


    }


    public void testLogIn() {
        if(ParseUser.getCurrentUser()!=null) {
            ParseUser.logOut();
        } else {
            TouchUtils.tapView(this, userName);
            getInstrumentation().sendStringSync(USERNAME);
            TouchUtils.tapView(this, passWord);
            sendKeys(PASSWORD);
            TouchUtils.clickView(this, login);
            assertTrue("should logIn..", ParseUser.getCurrentUser()!=null);
        }
    }
/*
    public void testLogOut(){
        TouchUtils.tapView(this, menuLogOut);
        assertTrue("should logOut..", ParseUser.getCurrentUser() == null);
    }
*/
}