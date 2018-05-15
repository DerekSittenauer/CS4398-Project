package com.parse.starter;

import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UsersActivityTest {

    @Test
    public void onCreate(View view) {

            CheckedTextView checkedTextView = (CheckedTextView) view;

            if (checkedTextView.isChecked()) {
                Log.i("Info","Checked!");
                ParseUser.getCurrentUser().add("isFollowing", "testCase2");
            } else {
                Log.i("Info", "NOT Checked!");
                ParseUser.getCurrentUser().getList("isFollowing").remove("testCase2");
                List tempUsers = ParseUser.getCurrentUser().getList("isFollowing");
                ParseUser.getCurrentUser().remove("isFollowing");
                ParseUser.getCurrentUser().put("isFollowing",tempUsers);
            }
            ParseUser.getCurrentUser().saveInBackground();
    }

    @Test
    public void onOptionsItemSelected() {
            Log.i("Info", "testCase3");

            ParseObject tweet = new ParseObject("Tweet");
            tweet.put("tweet","testCase3");
            tweet.put("username", ParseUser.getCurrentUser().getUsername());

            tweet.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        Log.i("Info", "Post Sent!");
                    } else {
                        Log.i("Info", "Post Failed!");
                    }
                }
            });
        }
}