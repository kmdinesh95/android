package com.example.geetham15.myapplication;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Main2Activity extends AppCompatActivity {


        EditText user,pass,repass,mail;
        Button register;

String username,password,retypepass,email;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);
            register = (Button) findViewById(R.id.reg);
            user=(EditText)findViewById(R.id.u);
            pass=(EditText)findViewById(R.id.p);
            repass=(EditText)findViewById(R.id.rp);
            mail=(EditText)findViewById(R.id.mail);



            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    username=user.getText().toString();
                    password=pass.getText().toString();
                    retypepass= repass.getText().toString();
                    email=mail.getText().toString();

                    if (username.equals("")||password.equals("")|| retypepass.equals("")||email.equals("")){
                        Toast.makeText(getApplicationContext(),"All fields are mandatory",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Registered successfully",Toast.LENGTH_SHORT).show();

                        Intent it =new Intent(getApplicationContext(),dinesh.class);
                        startActivity(it);
                    }
                }
            });

        }
    }