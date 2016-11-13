package com.netcracker.petrusev.project2.command.commands;
import com.netcracker.petrusev.project2.command.ActionCommand;
import com.netcracker.petrusev.project2.connections.ConnectionPool;
import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.PageConstants;
import com.netcracker.petrusev.project2.constants.SQLConstants;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationCommand implements ActionCommand {
    private static ConnectionPool pool = new ConnectionPool();

    private String page = null;
    private String login = null;
    private String firstName = null;
    private String secondName = null;
    private String mail = null;
    private String password1 = null;
    private String password2 = null;

    private boolean getParameters(HttpServletRequest request) {
        login = request.getParameter(CommandConstants.LOGIN);
        firstName = request.getParameter(CommandConstants.FIRST_NAME);
        secondName = request.getParameter(CommandConstants.SECOND_NAME);
        mail = request.getParameter(CommandConstants.MAIL);
        password1 = request.getParameter(CommandConstants.FIRST_PASSWORD);
        password2 = request.getParameter(CommandConstants.SECOND_PASSWORD);
        return (password1.equals(password2) && !login.equals("") &&
                !firstName.equals("") && !secondName.equals("") && !password1.equals(""));
    }

    private String setParameters(){
        try {
            Connection connection = pool.retrieve();
            PreparedStatement statement = connection.prepareStatement(SQLConstants.INSERT_USER);
            statement.setString(1, login);
            statement.setString(2, firstName);
            statement.setString(3, secondName);
            statement.setString(4, mail);
            statement.setString(5, password1);
            statement.setBoolean(6, false);
            statement.executeUpdate();
            pool.putBack(connection);
        } catch (SQLException e) {
            return PageConstants.REGISTRATION;
        }

        return  PageConstants.MAIN;
    }

    @Override
     public String execute(HttpServletRequest request) {

        String registration = request.getParameter(CommandConstants.REG);

        if (registration.equals(CommandConstants.TRUE)){
              if (getParameters(request))
                  return setParameters();
        }

      return PageConstants.REGISTRATION;
     }
}