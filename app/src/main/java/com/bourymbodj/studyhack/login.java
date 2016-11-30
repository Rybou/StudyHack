package com.bourymbodj.studyhack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login extends AppCompatActivity implements View.OnClickListener {

    private EditText username, password;
    private Button log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.passWord);
        log = (Button) findViewById(R.id.login);
        log.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        //Create Intent object
        Intent openNewActivity = new Intent(getApplicationContext(), studyhack.class);

        //Set data in bundle and then set bundle in intent object
        Bundle dataBundle = new Bundle();
        String user= username.getText().toString();
        dataBundle.putString("Username", user);
        openNewActivity.putExtras(dataBundle);

        startActivity(openNewActivity);

    }
}