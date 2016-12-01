package com.netcracker.petrusev.project2.connections;
import com.netcracker.petrusev.project2.command.commands.brigade.AddBrigadeCommand;
import com.netcracker.petrusev.project2.logger.LoggerError;

import java.sql.*;


/**
 * @author Petrusev
 * @version 1.0
 *
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
            LoggerError.INSTANCE.logError(AddBrigadeCommand.class, e.getMessage());
        }
    }

    public Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, name, password);
            } catch (SQLException e) {
                LoggerError.INSTANCE.logError(AddBrigadeCommand.class, e.getMessage());
            }
        }
        return connection;
    }
}




