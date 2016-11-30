package com.bourymbodj.studyhack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class schedule extends AppCompatActivity implements View.OnClickListener {

    private EditText course1, course2, course3, course4, course5, course6, course7;
    private EditText credit1, credit2, credit3, credit4, credit5, credit6, credit7;
    private EditText time1, time2, time3, time4, time5, time6, time7 ;
    private Button save;
    DatabaseHandler db = new DatabaseHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        course1= (EditText) findViewById(R.id.course1);
        credit1=(EditText) findViewById(R.id.credit1);
        time1= (EditText) findViewById(R.id.time1);
        course2= (EditText) findViewById(R.id.course2);
        credit2=(EditText) findViewById(R.id.credit2);
        time2= (EditText) findViewById(R.id.time2);
        course3= (EditText) findViewById(R.id.course3);
        credit3=(EditText) findViewById(R.id.credit3);
        time3= (EditText) findViewById(R.id.time3);
        course4= (EditText) findViewById(R.id.course4);
        credit4=(EditText) findViewById(R.id.credit4);
        time4= (EditText) findViewById(R.id.time4);
        course5= (EditText) findViewById(R.id.course5);
        credit5=(EditText) findViewById(R.id.credit5);
        time5= (EditText) findViewById(R.id.time5);
        course6= (EditText) findViewById(R.id.course6);
        credit6=(EditText) findViewById(R.id.credit6);
        time6= (EditText) findViewById(R.id.time6);
        course7= (EditText) findViewById(R.id.course7);
        credit7=(EditText) findViewById(R.id.credit7);
        time7= (EditText) findViewById(R.id.time7);
        save= (Button)  findViewById(R.id.save);
        save.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {

        String cours1 = course1.getText().toString();
        String hour1 = time1.getText().toString();
        String cours2 = course2.getText().toString();
        String hour2 = time2.getText().toString();
        String cours3 = course3.getText().toString();
        String hour3 = time3.getText().toString();
        String hour4 = time4.getText().toString();
        String cours4 = course4.getText().toString();
        String cours5 = course5.getText().toString();
        String hour5 = time5.getText().toString();
        String cours6 = course6.getText().toString();
        String hour6 = time6.getText().toString();
        String cours7 = course7.getText().toString();
        String hour7 = time7.getText().toString();

        /**
         * CRUD Operations
         * */
        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");

        if((cours1!=null ) && (hour1!=null)) {
            db.addCourse(new CourseInfo(cours1, Double.parseDouble(hour1)));
        }
        if((cours2!=null ) && (hour2!=null)) {
            db.addCourse(new CourseInfo(cours2, Double.parseDouble(hour2)));
        }
        if((cours3!=null ) && (hour3!=null)) {
            db.addCourse(new CourseInfo(cours3, Double.parseDouble(hour3)));
        }
        if((cours4!=null ) && (hour4!=null)) {
            db.addCourse(new CourseInfo(cours4, Double.parseDouble(hour4)));
        }
        if((cours5!=null ) && (hour5!=null)) {
            db.addCourse(new CourseInfo(cours5, Double.parseDouble(hour5)));
        }
        if((cours6!=null ) && (hour6!=null)) {
            db.addCourse(new CourseInfo(cours6, Double.parseDouble(hour6)));
        }
        if((cours7!=null ) && (hour7!=null)) {
            db.addCourse(new CourseInfo(cours7, Double.parseDouble(hour7)));
        }


        //Create Intent object
        Intent openNewActivity = new Intent(getApplicationContext(), welcomepage.class);
        Toast.makeText(getApplicationContext(), "Your new schedule has been saved", Toast.LENGTH_LONG).show();
        startActivity(openNewActivity);
        finish();

    }

    public void setdatabase(DatabaseHandler  data){
        data= this.db;

    }
}
