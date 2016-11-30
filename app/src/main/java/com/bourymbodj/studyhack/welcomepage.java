package com.bourymbodj.studyhack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class welcomepage extends AppCompatActivity implements View.OnClickListener {
    private TextView welcome;
    private Button study, schedule;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomepage);
        welcome= (TextView) findViewById(R.id.text);
        study=(Button) findViewById(R.id.study);
        schedule= (Button) findViewById(R.id.create);


        welcome.setText("Time to get work done !");

        study.setOnClickListener(this);
        schedule.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Intent openActivity = new Intent(getApplicationContext(), studyhack.class);
        switch (v.getId()) {
            case R.id.study:
                // Study
                //Create Intent object
                openActivity = new Intent(getApplicationContext(), study.class);

                break;
            case R.id.create:
                // Create schedule
                //Create Intent object
                openActivity = new Intent(getApplicationContext(), schedule.class);

                break;

        }

        startActivity(openActivity);

    }
    }

