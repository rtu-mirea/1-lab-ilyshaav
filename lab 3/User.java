package com.company;

class User {
    String name;
    String login;
    String password;

public  User (String name1,String login1,String password1){
     name=name1; login=login1; password=password1;
    }
public  User (){
        name=""; login=""; password="";
    }

public String getName(){
    return name;
}
public String getLog(){
        return login;
    }
public String getPassword(){
        return password;
    }

}
