package com.example.hima.recyclingfacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;
import retrofit2.Call;
import retrofit2.Response;

public class RecyclingFactsActivity extends AppCompatActivity {

        // هنا سنعرف المتغيرات
        private TextView factTextView;
        private Button factButton,tweet;
        private  TwitterLoginButton loginButton;
        private RecyclingFactsGenerator recyclingFactsGenerator;

        private static final String TAG = "TAG_FACT";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_recycling_facts);

            // تعين المتغيرات
            factTextView = (TextView) findViewById(R.id.factTextView);
            factButton = (Button) findViewById(R.id.factButton);
            tweet = (Button) findViewById(R.id.sendTweet);
            loginButton = (TwitterLoginButton) findViewById(R.id.logIn_Twitter);
            recyclingFactsGenerator = new RecyclingFactsGenerator(this);


            // تعريف السامع
            View.OnClickListener onClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String fact = recyclingFactsGenerator.generateFact();

                    factTextView.setText(fact);

                    Toast.makeText(RecyclingFactsActivity.this, getResources().getString(R.string.button_pressed), Toast.LENGTH_SHORT).show();
                }
            };

            // تعين سامع للزر
            factButton.setOnClickListener(onClickListener);

            Toast.makeText(RecyclingFactsActivity.this, getResources().getString(R.string.app_started), Toast.LENGTH_LONG).show();

            //تعين خصائص زر التسجيل عبر تويتر

            loginButton.setCallback(new Callback<TwitterSession>() {
                @Override
                public void success(Result<TwitterSession> result) {
                    // Do something with result, which provides a TwitterSession for making API calls
                    loginButton.setVisibility(View.GONE);
                    tweet.setVisibility(View.VISIBLE);
                }

                @Override
                public void failure(TwitterException exception) {
                    // Do something on failure
                }
            });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Pass the activity result to the login button.
        loginButton.onActivityResult(requestCode, resultCode, data);
    }

}

