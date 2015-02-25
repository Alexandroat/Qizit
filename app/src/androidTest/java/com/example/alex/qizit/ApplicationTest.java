package com.example.alex.qizit;

import com.parse.ParseUser;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.EditText;


/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ActivityInstrumentationTestCase2<LoginActivity> {

    private EditText usr;
    private EditText pwd;
    private Button btnLogin;

    private LoginActivity loginActivity;

    private static final String USER = "Alex";
    private static final String PWD = "1 2 3 4";

    public ApplicationTest() {
        super(LoginActivity.class);
    }
    protected void setUp() throws Exception {
        super.setUp();
        loginActivity = getActivity();
        usr = (EditText) loginActivity.findViewById(R.id.userNameEditText);
        pwd = (EditText) loginActivity.findViewById(R.id.passWordEditText);
        btnLogin = (Button) loginActivity.findViewById(R.id.loginButton);

    }

    public void testLogIn() {
        if(ParseUser.getCurrentUser()!=null) {
            ParseUser.logOut();
        } else {
            //Value on EditText User
            TouchUtils.tapView(this, usr);
            getInstrumentation().sendStringSync(USER);
            //Value on EditText Password
            TouchUtils.tapView(this, pwd);
            sendKeys(PWD);
            // click on Login button
            TouchUtils.clickView(this, btnLogin);

            assertTrue("Logged successfully ", ParseUser.getCurrentUser()!=null);
        }

    }

}