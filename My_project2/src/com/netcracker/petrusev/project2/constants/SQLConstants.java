package com.netcracker.petrusev.project2.constants;

/**
 * @author Petrusev
 * @version 1.0
 *
 */
public  class SQLConstants {
    public static final String UPDATE_FLIGHT = "UPDATE FLIGHT SET " +(char)(34) +"from"+(char)(34)
            +" = ? , "+(char)(34) +"to" + (char)(34) +" =? , flight_date = ? WHERE id = ?";


    public static final String GET_FLIGHT_BY_DATA =  "SELECT * FROM FLIGHT WHERE " +(char)(34) +"from"+(char)(34) + " = ? AND " +(char)(34) +"to" + (char)(34) +" = ? AND flight_date = ?";
    public static final String GET_USER_BY_LOGIN = "SELECT * FROM USERS WHERE login = ?";
    public static final String GET_USER_BY_LOGIN_AND_PASSWORD = "SELECT * FROM users WHERE " +
                                                        " login = ? AND password = ?";
    public static final String GET_ALL_FLIGHT = "SELECT * FROM FLIGHT";
    public static final String GET_STEWARDESS = "SELECT * FROM STEWARDESS";
    public static final String GET_NAVIGATOR = "SELECT * FROM NAVIGATOR";
    public static final String GET_PILOT = "SELECT * FROM PILOT";
    public static final String GET_RADIOMAN = "SELECT * FROM RADIOMAN";
    public static final String GET_INFORMATION = "SELECT * FROM INFORMATION where id = ?";
    public static final String GET_ALL_BRIGADES = "SELECT * FROM BRIGADE";
    public static final String GET_ALL_BRIGADES_BY_ID_FLIGHT = "SELECT * FROM BRIGADE WHERE id_flight = ?";

    public static final String INSERT_FLIGHT = "INSERT INTO FLIGHT("+(char)(34) +"from"+(char)(34) +", "+(char)(34) +"to" + (char)(34) +", flight_date) VALUES(?, ?, ?)";
    public static final String INSERT_USER= "INSERT INTO USERS(login, firstname, secondname, " + //need refactor
            "mail, password, priority) VALUES(?, ?, ?, ?, ?, ? )";
    public static final String ADD_NAVIGATOR = "INSERT INTO NAVIGATOR(category, id_information) values(? , ? )";
    public static final String ADD_STEWARDESS = "INSERT INTO STEWARDESS(length_waist, id_information) values(? , ? )";
    public static final String ADD_PILOT = "INSERT INTO PILOT(mileage, id_information) values(? , ? )";
    public static final String ADD_RADIOMAN = "INSERT INTO RADIOMAN(count_foreign_language, id_information) values(? , ? )";
    public static final String ADD_BRIGADE = "INSERT INTO BRIGADE(id_first_pilot, id_second_pilot, id_stewardess, id_navigator, id_radioman,id_flight) values(?, ?, ? , ? , ?, ?)";
    public static final String ADD_INFORMATION = "INSERT INTO INFORMATION(name,age,height,experience,passport_data) VALUES(?, ? , ? , ?, ?)  RETURNING id";


    public static final String DELETE_BRIGADE = "DELETE FROM BRIGADE WHERE id = ?";
    public static final String DELETE_USER= "DELETE FROM USERS WHERE id = ?";
    public static final String DELETE_FLIGHT = "DELETE FROM FLIGHT WHERE id = ?";
    public static final String DELETE_NAVIGATOR = "DELETE FROM NAVIGATOR WHERE id = ? RETURNING id_information";
    public static final String DELETE_STEWARDESS = "DELETE FROM STEWARDESS WHERE id = ? RETURNING id_information";
    public static final String DELETE_PILOT = "DELETE FROM PILOT WHERE id = ? RETURNING id_information";
    public static final String DELETE_RADIOMAN = "DELETE FROM RADIOMAN WHERE id = ? RETURNING id_information";
    public static final String DELETE_INFORMATION = "DELETE FROM INFORMATION WHERE id = ?";

    public static final String FIND_NAVIGATOR = "SELECT * FROM NAVIGATOR WHERE id = ?";
    public static final String FIND_PILOT = "SELECT * FROM PILOT WHERE id = ?";
    public static final String FIND_STEWARDESS = "SELECT * FROM STEWARDESS WHERE id = ?";
    public static final String FIND_RADIOMAN = "SELECT * FROM RADIOMAN WHERE id = ?";
    public static final String FIND_FLIGHT = "SELECT * FROM FLIGHT WHERE id = ?";
    p[dfskskdfg;lksdjfg;lksjdfl;gkjsd;lkfgj;lskdfjg;lsdjfg;lsdjfg;ljsdf;lgkj]



}
