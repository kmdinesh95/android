package com.example.geetham15.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class dinesh extends AppCompatActivity {

    EditText user,pass;
    String username,password;
    CheckBox cb;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinesh);

        user = (EditText)findViewById(R.id.l_user);
        pass = (EditText)findViewById(R.id.l_pass);

        cb=(CheckBox)findViewById(R.id.c1);
        login =(Button)findViewById(R.id.btn2);

        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (!b)
                {
                    pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                else
                {
                    pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                }

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = user.getText().toString();
                password =pass.getText().toString();

                if (username.equals("Dinesh") && password.equals("dinesh1234")){


                    Toast.makeText(getApplicationContext(),"Welcome",Toast.LENGTH_SHORT).show();
                    Intent it = new Intent(getApplicationContext(),dd.class);
                    startActivity(it);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Login Failed\n Enter Valid Username and Password",Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
}
