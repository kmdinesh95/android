package com.example.geetham15.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

ProgressDialog prg;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=(TextView)findViewById(R.id.t);
        tv.startAnimation(AnimationUtils.makeInAnimation(MainActivity.this,true));


        prg =new ProgressDialog(this);
        prg.setMessage("loading");
        prg.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        prg.show();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                prg.cancel();

                Intent it= new Intent(MainActivity.this,Main2Activity.class);
                startActivity(it);
            }
        },3000);


    }
}
