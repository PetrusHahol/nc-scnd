package com.netcracker.petrusev.project2.command.commands;

import com.netcracker.petrusev.project2.command.ActionCommand;
import com.netcracker.petrusev.project2.connections.ConnectionPool;
import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.PageConstants;
import com.netcracker.petrusev.project2.constants.PermissionsConstants;
import com.netcracker.petrusev.project2.constants.SQLConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignInCommand implements ActionCommand {
  private static ConnectionPool pool = new ConnectionPool();

  private ResultSet getUser(HttpServletRequest request) {
    try {
      Connection connection = pool.retrieve();
      PreparedStatement statement = connection.prepareStatement(SQLConstants.GET_USER_BY_LOGIN_AND_PASSWORD);
      System.err.println(request.getParameter(CommandConstants.LOGIN));
      statement.setString(1, request.getParameter(CommandConstants.LOGIN));
      statement.setString(2, request.getParameter(CommandConstants.FIRST_PASSWORD));
      pool.putBack(connection);
      return statement.executeQuery();
    } catch (SQLException ex) {
      return null;
    }
  }

  private boolean setSession(ResultSet user, HttpServletRequest request) {
    String name = null;
    try {
      while (user.next()) {
        name = user.getString(CommandConstants.LOGIN);
      }

      if (name == null)
        return false;
      HttpSession session = request.getSession(true);
      session.setAttribute(PermissionsConstants.USER, name);
      return true;

    } catch (SQLException ex) {
      return false;
    }
  }

  @Override
  public String execute(HttpServletRequest request) {
    if (request.getParameter(CommandConstants.AUTHORIZATION).equals(CommandConstants.TRUE)) {
      if (setSession(getUser(request), request))
        return PageConstants.USER_CONTENT_REQUEST;
      else
        return PageConstants.SIGN_IN;
    }
    return PageConstants.SIGN_IN;
  }
}
