package com.example.dinesh.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class signup extends AppCompatActivity {

    EditText user,email,pass,repass,mbl;
    Button register;

    String username,emailid,password,retypepassword,mobileno;

    public final Pattern EMAILPATTERN = Pattern.compile(
            "[a-zA-Z0-9+._%-+]{1,256}" +
                    "@" +
                    "gmail" +
                    "(" +
                    "." +
                    "com" +
                    ")+"
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        user = (EditText)findViewById(R.id.user);
        email = (EditText)findViewById(R.id.email);
        pass = (EditText)findViewById(R.id.pass);
        repass = (EditText)findViewById(R.id.repass);
        mbl = (EditText)findViewById(R.id.mbl);

        register =(Button)findViewById(R.id.reg);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 username = user.getText().toString();
                emailid = email.getText().toString();
                password = pass.getText().toString();
                retypepassword = repass.getText().toString();
                mobileno = mbl.getText().toString();


                if (username.equalsIgnoreCase("") || password.equalsIgnoreCase("") || retypepassword.equalsIgnoreCase("")||mobileno.equalsIgnoreCase("")) {

                    Toast.makeText(getApplicationContext(), "Please Fill Something", Toast.LENGTH_SHORT).show();

                } else if (!password.equals(retypepassword)) {

                    Toast.makeText(getApplicationContext(), " password does not match", Toast.LENGTH_SHORT).show();

                } else if (!checkEmail(emailid)) {

                    Toast.makeText(getApplicationContext(), "please check your mail id", Toast.LENGTH_SHORT).show();

                } else if (!mobileno.equals(mobileno)) {
                    Toast.makeText(getApplicationContext(), "please Enter 10digit Number", Toast.LENGTH_SHORT).show();

                }

                else{
                    Splash.editor.putString("Username",username);
                    Splash.editor.putString("Emailid",emailid);
                    Splash.editor.putString("Password",password);
                    Splash.editor.putString("Mobileno",mobileno);
                    Splash.editor.commit();

                    Toast.makeText(getApplicationContext(),"Everything ok",Toast.LENGTH_SHORT).show();


                }

            }
        });
    }



    private boolean checkEmail(String emailid) {
        return EMAILPATTERN.matcher(emailid).matches();
    }

}
