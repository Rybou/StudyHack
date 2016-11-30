package com.bourymbodj.studyhack;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Timer extends ActionBarActivity implements OnClickListener {
    Button buttonStart;
    ProgressBar progressBar;
    TextView textCounter;
    int time1;
    MyCountDownTimer myCountDownTimer;
     Button stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        buttonStart = (Button) findViewById(R.id.start);
        stop= (Button)findViewById(R.id.stop);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        textCounter = (TextView) findViewById(R.id.counter);

       // Intent intentObject = getIntent();
       // time1= Integer.parseInt(intentObject.getExtras().getString("Username"));

        stop.setOnClickListener(this);
        buttonStart.setOnClickListener(this);
     /*    buttonStart.setOnClickListener(new OnClickListener() {

          @Override
            public void onClick(View v) {
                progressBar.setProgress(100);
                myCountDownTimer = new MyCountDownTimer(  100000, 500);
                myCountDownTimer.start();
            }
        });
*/
    }


    @Override
    public void onClick(View v) {

        if (v.getId()==R.id.stop) {

            progressBar.setProgress(100);
            myCountDownTimer = new MyCountDownTimer( 1, 500);
            myCountDownTimer.start();
        }
        else if (v.getId()==R.id.start){
            progressBar.setProgress(100);
            myCountDownTimer = new MyCountDownTimer( 600000, 500);
            myCountDownTimer.start();

        }

    }

    public class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }



    @Override
    public void onTick(long millisUntilFinished) {
        textCounter.setText(String.valueOf(formatMilliSecondsToTime(millisUntilFinished)));
        int progress = (int) (millisUntilFinished / 100);
        progressBar.setProgress(progress);
    }

    @Override
    public void onFinish() {
        textCounter.setText("Finished");
        progressBar.setProgress(0);
    }

    private String formatMilliSecondsToTime(long milliseconds) {

        int seconds = (int) (milliseconds / 1000) % 60;
        int minutes = (int) ((milliseconds / (1000 * 60)) % 60);
        int hours = (int) ((milliseconds / (1000 * 60 * 60)) % 24);
        return twoDigitString(hours) + " : " + twoDigitString(minutes) + " : "
                + twoDigitString(seconds);
    }

    private String twoDigitString(long number) {

        if (number == 0) {
            return "00";
        }

        if (number / 10 == 0) {
            return "0" + number;
        }

        return String.valueOf(number);

    }
}
}


