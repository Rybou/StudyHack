package com.bourymbodj.studyhack;

/**
 * Created by bourymbodj on 16-11-12.
 */
public class CourseInfo {

        private int   id  ;
        private String coursename;
        private double hours;

    public CourseInfo(){
        id = 0;
        coursename = "";
        hours = 0;
    }
        public CourseInfo(int cr, String name , double hrs){
            id = cr;
            coursename = name;
            hours = hrs;
        }
    public CourseInfo( String name , double hrs){

        coursename = name;
        hours = hrs;
    }
        public void setCoursename(String crsname){
            coursename = crsname;
        }
        public void setId(int id){
           this.id=id;
        }
        public void setHours (double hrs){
            hours = hrs;
        }
        public String getCourseName(){
            return coursename;
        }
        public int getId(){
            return id  ;
        }
        public double getHours(){
            return hours;
        }
    }


