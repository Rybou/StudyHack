package com.bourymbodj.studyhack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class studyhack extends AppCompatActivity implements View.OnClickListener {

    private TextView welcome;
    private Button study, schedule;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studyhack);
        welcome= (TextView) findViewById(R.id.text);
        study=(Button) findViewById(R.id.study);
        schedule= (Button) findViewById(R.id.create);

        Intent intentObject = getIntent();
        String userName1=intentObject.getExtras().getString("Username");
        welcome.setText("Welcome " + userName1);

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
