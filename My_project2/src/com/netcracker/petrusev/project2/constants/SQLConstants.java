package com.netcracker.petrusev.project2.constants;

import java.text.Format;

/**
 * Created by Asus on 12.11.2016.
 */
public  class SQLConstants {
    public static final String INSERT_USER= "INSERT INTO USERS(login, firstname, secondname, " +
                                            "mail, password, priority) VALUES(?, ?, ?, ?, ?, ? )";

    public static final String GET_USER_BY_LOGIN_AND_PASSWORD = "SELECT * FROM users WHERE " +
                                                        " login = ? AND password = ?";
}
