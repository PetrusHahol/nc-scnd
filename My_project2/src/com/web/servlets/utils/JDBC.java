package com.web.servlets.utils;
import java.sql.*;
import java.util.logging.*;

/**
 * Created by Asus on 30.10.2016.
 */
public class JDBC {
    private static final String driver = "org.postgresql.Driver";
    public Connection connection = null;

    public JDBC() {
        try {
            String url = "jdbc:postgresql://127.0.0.1:5432/airs";
            String name = "postgres";
            String password = "qwerty12345";
            System.out.println("Драйвер подключен");
            Class.forName(driver);
            connection = DriverManager.getConnection(url, name, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}




