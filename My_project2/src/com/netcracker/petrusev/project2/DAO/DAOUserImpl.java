package com.netcracker.petrusev.project2.DAO;

import com.netcracker.petrusev.project2.beans.users.User;
import com.netcracker.petrusev.project2.connections.ConnectionPool;
import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.SQLConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 * Created by Asus on 12.11.2016.
 */
public class DAOUserImpl<T> implements DAOInterface{

        private static ConnectionPool pool = new ConnectionPool();

        @Override
        public void create(Object obj) throws SQLException{
                Connection connection = pool.retrieve();
                User user = (User) obj;
                PreparedStatement statement = connection.prepareStatement(SQLConstants.INSERT_USER);
                statement.setString(1, (user.getLogin()));
                statement.setString(2, user.getFirstName());
                statement.setString(3, user.getSecondName());
                statement.setString(4, user.getMail());
                statement.setString(5, user.getPassword());
                statement.setString(6, CommandConstants.FALSE);
                statement.executeUpdate();
                pool.putBack(connection);
        }

        @Override
        public void delete(Object obj) {

        }

        @Override
        public Object find(Object obj) throws SQLException {
                Connection connection = pool.retrieve();
                User user = (User) obj;
                PreparedStatement statement = connection.prepareStatement(SQLConstants.GET_USER_BY_LOGIN_AND_PASSWORD);
                statement.setString(1,user.getLogin());
                statement.setString(2,user.getPassword());
                ResultSet set = statement.executeQuery();
                user.setLogin(null);
                user.setPassword(null);
                while (set.next()) {
                        user.setLogin(set.getString(CommandConstants.LOGIN));
                        user.setFirstName(set.getString(CommandConstants.FIRST_NAME));
                        user.setSecondName(set.getString(CommandConstants.SECOND_NAME));
                }
                pool.putBack(connection);
                return user;
        }
}
