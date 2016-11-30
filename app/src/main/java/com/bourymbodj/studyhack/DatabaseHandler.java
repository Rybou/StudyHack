package com.bourymbodj.studyhack;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bourymbodj on 16-11-12.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 2;

    // Database Name
    private static final String DATABASE_NAME = "courseInformation";

    // Contacts table name
    private static final String TABLE_COURSEINFO = "courseInfo";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_COURSE = "course";
    private static final String KEY_HOURS = "hours";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_COURSEINFO + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_COURSE + " TEXT,"
                + KEY_HOURS + " DOUBLE" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COURSEINFO);

        // Create tables again
        onCreate(db);
    }
    // Adding new course
    public void addCourse(CourseInfo course) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_COURSE, course.getCourseName()); // Contact Name
        values.put(KEY_HOURS, course.getHours()); // Contact Phone Number

        // Inserting Row
        db.insert(TABLE_COURSEINFO, null, values);
        db.close(); // Closing database connection
    }
    // Getting single course
    public CourseInfo getCourse (int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_COURSEINFO, new String[] { KEY_ID,
                        KEY_COURSE, KEY_HOURS }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        CourseInfo course = new CourseInfo(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), Double.parseDouble(cursor.getString(2)));
        // return contact
        return course;
    }
    public List<CourseInfo> getAllCourses() {
        List<CourseInfo> courseList = new ArrayList<CourseInfo>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_COURSEINFO;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                CourseInfo course = new CourseInfo();
                course.setId(Integer.parseInt(cursor.getString(0)));
                course.setCoursename(cursor.getString(1));
                course.setHours(Double.parseDouble(cursor.getString(2)));
                // Adding course to list
                courseList.add(course);
            } while (cursor.moveToNext());
        }

        // return courseList list
        return courseList;
    }
    // Getting course Count
    public int getCourseCount() {
        String countQuery = "SELECT  * FROM " + TABLE_COURSEINFO;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

    // Updating single course
    public int updateCourse(CourseInfo course) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_COURSE, course.getCourseName());
        values.put(KEY_HOURS, course.getHours());

        // updating row
        return db.update(TABLE_COURSEINFO, values, KEY_ID + " = ?",
                new String[]{String.valueOf(course.getId())});
    }
    // Deleting single course
    public void deleteContact(CourseInfo course) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_COURSEINFO, KEY_ID + " = ?",
                new String[]{String.valueOf(course.getId())});
        db.close();
    }
}