package com.parse.starter;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


import org.junit.Test;

public class MainActivityTest {


    @Test
    public void signupLogin() {
        ParseUser newUser = new ParseUser();
        newUser.setUsername("testCase1");
        newUser.setPassword("password1");

        newUser.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Log.i("Signup", "Login  Success!");
                } else {
                    Log.i("Signup", "Login Failed!");
                }
            }
        });
    }
}