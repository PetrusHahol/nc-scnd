package com.netcracker.petrusev.project2.DAO;

import com.netcracker.petrusev.project2.beans.users.User;
import com.netcracker.petrusev.project2.connections.ConnectionPool;
import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.PermissionsConstants;
import com.netcracker.petrusev.project2.constants.SQLConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Asus on 12.11.2016.
 */
public class DAOUserImpl implements DAOInterface<User>{


        @Override
        public void create(User user) throws SQLException{
                Connection connection = ConnectionPool.INSTANCE.retrieve();
                PreparedStatement statement = connection.prepareStatement(SQLConstants.INSERT_USER);
                statement.setString(1, (user.getLogin()));
                statement.setString(2, user.getFirstName());
                statement.setString(3, user.getSecondName());
                statement.setString(4, user.getMail());
                statement.setString(5, user.getPassword());
                statement.setString(6, PermissionsConstants.USER);
                statement.executeUpdate();
                ConnectionPool.INSTANCE.putBack(connection);
        }


        @Override
        public User find(User user) throws SQLException {
                Connection connection = ConnectionPool.INSTANCE.retrieve();
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
                        user.setPriority(set.getString(CommandConstants.PRIORITY));
                        user.setId(set.getInt(CommandConstants.ID));
                }
                ConnectionPool.INSTANCE.putBack(connection);
                return user;
        }

        @Override
        public User update(User obj) throws SQLException {
                throw new UnsupportedOperationException();
        }

        @Override
        public List<User> getAllData() throws SQLException {
                throw new UnsupportedOperationException();
        }

        @Override
        public void delete(int id) throws SQLException {
                Connection connection = ConnectionPool.INSTANCE.retrieve();
                PreparedStatement statement = connection.prepareStatement(SQLConstants.DELETE_USER);
                statement.setInt(1, id);
                statement.execute();
                ConnectionPool.INSTANCE.putBack(connection);
        }

        @Override
        public User find(Integer obj) throws SQLException {
                return null;
        }

}
