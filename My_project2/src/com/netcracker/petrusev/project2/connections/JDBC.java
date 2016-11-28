package com.netcracker.petrusev.project2.connections;
import java.sql.*;

/**
 * Created by Asus on 30.10.2016.
 */
public class JDBC {
    private static final String driver = "org.postgresql.Driver";
    public Connection connection = null;
    private static final String url = "jdbc:postgresql://127.0.0.1:5432/airs?useEncoding=yes&amp;characterEncoding=UTF-8";
    private static final String name = "postgres";
    private static final String password = "qwerty12345";

    public JDBC() {
        try {
            Class.forName(driver);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, name, password);
            } catch (SQLException e) {
                System.err.println("Bugagagaga_ERROR:)");
            }
        }
        return connection;
    }
}




