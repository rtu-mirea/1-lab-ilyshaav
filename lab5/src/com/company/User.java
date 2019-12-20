package com.company;

public class User {

    String name;
    String login;
    String password;

    public User(){

    }

    public User(String name1, String login1, String password1){
        name = name1;
        login = login1;
        password = password1;

    }

    public boolean Enter(String login1, String password1){
        if ((login.equals(login1)) && (password.equals(password1))){
            return true;
        }
        return false;
    }

}