package com.example.dinesh.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AnimationUtils;
import android.widget.TextView;


public class Splash extends AppCompatActivity {

    public static String logincheck;

    public static SharedPreferences sp;
    public  static SharedPreferences.Editor editor;
    TextView welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        welcome = (TextView)findViewById(R.id.tview);
        welcome.startAnimation(AnimationUtils.makeInAnimation(getApplicationContext(),true));

        // Initializing the shared preference
        sp = getSharedPreferences("ABC", 0);
        editor = sp.edit();

        // check here if user is login or not
        logincheck = sp.getString("logincheck", null);



        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

/*
                if (logincheck != null && !logincheck.toString().trim().equals("")) {

                    Intent send = new Intent(getApplicationContext(), Display.class);
                    startActivity(send);
                }

                else {*/

                    Intent send = new Intent(getApplicationContext(),signup.class);
                    startActivity(send);




            }

        }, 4000);

    }

}
