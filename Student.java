package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by a on 1/18/2016.
 */
public class Student implements java.io.Serializable {
    private String firstName = null;
    private String lastName = null;
    private String middleName = null;
    private String grade = null;
    private long id = 0;
    private String currentSchool = null;
    private char gender = 'N';
    private String dob=null;

    public Student() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getGrade() {
        return grade;
    }

    public char getGender() {
        return gender;
    }

    public long getId() {
        return id;
    }

    public String getDob() {
        return dob;
    }

    public String getCurrentSchool() {
        return currentSchool;
    }

    public void setFirstName(String first) {
        firstName = first;
    }

    public void setLastName(String last) {
        lastName = last;
    }

    public void setMiddleName(String middle) {
        middleName = middle;
    }
    public void setGrade(String grades){
        grade=grades;
    }
    public void setId(long ids){
        id = ids;
    }
    public void setCurrentSchool(String currentSc){
        currentSchool=currentSc;
        }
    public void setGender(char gende){
        gender=gende;
    }
    public void setDob(String dobb){
        dob=dobb;
    }

}


