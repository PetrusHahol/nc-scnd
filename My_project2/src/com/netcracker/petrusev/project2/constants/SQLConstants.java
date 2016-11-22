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

    public static final String DELETE_USER_BY_LOGIN_AND_NAME = "DELETE FROM USERS WHERE login = ? " +
                                                               "AND firstname = ? AND secondname = ?";

    public static final String GET_ALL_FLIGHT = "SELECT * FROM FLIGHT";

    public static final String GET_STEWARDESS = "SELECT * FROM STEWARDESS";
    public static final String GET_NAVIGATOR = "SELECT * FROM NAVIGATOR";
    public static final String GET_PILOT = "SELECT * FROM PILOT";
    public static final String GET_RADIOMAN = "SELECT * FROM RADIOMAN";

    public static final String GET_INFORMATION = "SELECT * FROM INFORMATION where id = ?";

    public static final String INSERT_FLIGHT = "INSERT INTO FLIGHT("+(char)(34) +"from"+(char)(34) +", "+(char)(34) +"to" + (char)(34) +", flight_date) VALUES(?, ?, ?)";

    public static final String DELETE_FLIGHT = "DELETE FROM FLIGHT WHERE "+(char)(34) +"from"+(char)(34) +"=? AND "+(char)(34) +"to" + (char)(34) +"=? AND flight_date = ?";

    public static final String ADD_NAVIGATOR = "INSERT INTO NAVIGATOR(category, id_information) values(? , ? )";
    public static final String ADD_STEWARDESS = "INSERT INTO STEWARDESS(length_waist, id_information) values(? , ? )";
    public static final String ADD_PILOT = "INSERT INTO PILOT(mileage, id_information) values(? , ? )";
    public static final String ADD_RADIOMAN = "INSERT INTO RADIOMAN(count_foreign_language, id_information) values(? , ? )";

    public static final String ADD_INFORMATION = "INSERT INTO INFORMATION(name,age,height,experience,passport_data) VALUES(?, ? , ? , ?, ?)  RETURNING id";

    public static final String DELETE_NAVIGATOR = "DELETE FROM NAVIGATOR WHERE id = ? RETURNING id_information";
    public static final String DELETE_STEWARDESS = "DELETE FROM STEWARDESS WHERE id = ? RETURNING id_information";
    public static final String DELETE_PILOT = "DELETE FROM PILOT WHERE id = ? RETURNING id_information";
    public static final String DELETE_RADIOMAN = "DELETE FROM RADIOMAN WHERE id = ? RETURNING id_information";

    public static final String DELETE_INFORMATION = "DELETE FROM INFORMATION WHERE id = ?";


}
