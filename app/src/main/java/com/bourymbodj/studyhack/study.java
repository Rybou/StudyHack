package com.bourymbodj.studyhack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class study extends AppCompatActivity implements View.OnClickListener {

    private Button next;
    private EditText time;
    DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);

        next= (Button) findViewById(R.id.next);
        time= (EditText)findViewById(R.id.editText);
        ArrayList<CourseInfo> courses = GetCourses();
        final ListView lv1 = (ListView) findViewById(R.id.listview);
        lv1.setAdapter(new CustomBaseAdapter(this, courses));


        next.setOnClickListener(this);

      //db.setdatabase(db);



    }

    private ArrayList<CourseInfo> GetCourses(){
        ArrayList<CourseInfo> results = new ArrayList<CourseInfo>();

        CourseInfo sr1 = new CourseInfo();
        sr1.setCoursename("Physics");
        sr1.setHours(3);
        results.add(sr1);

        CourseInfo sr2 = new CourseInfo();
        sr2.setCoursename("Math");
        sr2.setHours(6);
        results.add(sr2);

        CourseInfo sr3 = new CourseInfo();
        sr3.setCoursename("Data Structures");
        sr3.setHours(6);
        results.add(sr3);

        CourseInfo sr4 = new CourseInfo();
        sr4.setCoursename("Philosphy");
        sr4.setHours(3);
        results.add(sr4);

        CourseInfo sr5 = new CourseInfo();
        sr5.setCoursename("Physics");
        sr5.setHours(3);
        results.add(sr5);


        return results;
    }

    @Override
    public void onClick(View v) {

       String time1 = time.getText().toString();
        Intent openActivity = new Intent(getApplicationContext(), Timer.class);

      //Set data in bundle and then set bundle in intent object
        Bundle dataBundle = new Bundle();
        dataBundle.putString("time", time1);
        openActivity.putExtras(dataBundle);

        startActivity(openActivity);
    }
}
