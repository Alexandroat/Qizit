package com.example.alex.qizit;

import android.app.Application;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ApplicationTestCase;
import android.test.TouchUtils;
import android.text.method.Touch;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseUser;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ActivityInstrumentationTestCase2<LoginActivity> {

    private EditText usuario;
    private EditText contraseña;
    private Button buttonlogin;
    private LoginActivity la;

    public ApplicationTest() {

        super(LoginActivity.class);
    }

    protected void setUp() throws Exception {
        super.setUp();
        la = getActivity();
        usuario = (EditText) la.findViewById(R.id.userNameEditText);
        contraseña = (EditText) la.findViewById(R.id.passWordEditText);
        buttonlogin = (Button) la.findViewById(R.id.loginButton);


    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    private static final String USUARIO = "DAVID";
    private static final String CONTRASEÑA = "DAVID";

    public void test(){

        if(ParseUser.getCurrentUser()!=null){
            ParseUser.logOut();
        }
           else  {
            //VALOR DEL USUARIO
            TouchUtils.tapView(this, usuario);
            getInstrumentation().sendStringSync(USUARIO);

            //VALOR DE LA CONTRASEÑA
            TouchUtils.tapView(this, contraseña);
            getInstrumentation().sendStringSync(CONTRASEÑA);

            //BOTÓN LOGIN
            TouchUtils.clickView(this, buttonlogin);

            assertTrue("Todo fue bien", ParseUser.getCurrentUser()!=null);
        }
    }
}
