package com.company;

public class Student extends User {

    int qcount = 0;
    int rightansw = 0;
    boolean am_I_Admin;

    public Student(){

    }

    public Student(String name1, String login1, String password1, int qcount1, int rightansw1, boolean am_I1){
        super(name1, login1, password1);
        qcount = qcount1;
        rightansw = rightansw1;
        am_I_Admin = am_I1;
    }



    public boolean Am_I_Admin(){
        return am_I_Admin;
    }
}