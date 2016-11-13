package com.netcracker.petrusev.project2.constants;

import java.text.Format;

/**
 * Created by Asus on 12.11.2016.
 */
public  class SQLConstants {


    public static String addUser(String login, String first_name, String second_name, String mail, String password, boolean priority){
        return  "INSERT INTO USERS(login, first_name, second_name, " +
                "mail, password, priority) VALUES('"+login+"','"+first_name+"','"+second_name+"','"+mail
                +"','"+password+"','"+toString(priority)+"')";
    }


    private static String toString(boolean priority) {
        if (priority) return "true";
        return "false";
    }
}
