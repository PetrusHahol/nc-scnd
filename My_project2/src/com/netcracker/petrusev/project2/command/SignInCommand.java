package com.netcracker.petrusev.project2.command;

import com.netcracker.petrusev.project2.connections.ConnectionPool;
import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.PageConstants;
import com.netcracker.petrusev.project2.constants.PoolConstants;
import com.netcracker.petrusev.project2.constants.SQLConstants;
import com.sun.jndi.ldap.pool.Pool;
import com.sun.jndi.ldap.pool.PooledConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignInCommand implements ActionCommand {
  private static ConnectionPool pool = new ConnectionPool();

  @Override
  public String execute(HttpServletRequest request) {
    try {
      Connection connection = pool.retrieve();
      String nameUser = null;
      PreparedStatement statement = connection.prepareStatement(SQLConstants.GET_USER_BY_LOGIN_AND_PASSWORD);
      try {
        statement.setString(1, request.getParameter(request.getParameter(CommandConstants.FIRST_PASSWORD)));
        statement.setString(2, request.getParameter(CommandConstants.FIRST_PASSWORD));
        ResultSet user = statement.executeQuery();
        while (user.next()){
          nameUser = user.getString(CommandConstants.LOGIN);
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("user", nameUser);
        return PageConstants.USER_CONTENT;
      } catch (Exception ex) {
        return PageConstants.SIGN_IN;
      }
    } catch (SQLException e) {
      return PageConstants.SIGN_IN;
    }
  }
}
