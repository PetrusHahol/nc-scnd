package com.netcracker.petrusev.project2.command.commands;

import com.netcracker.petrusev.project2.DAO.DAOUserImpl;
import com.netcracker.petrusev.project2.beans.users.User;
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
  private static DAOUserImpl daoUser = new DAOUserImpl();

  private User getUser(HttpServletRequest request) {
    User user = new User();
    try {
      user.setLogin(request.getParameter(CommandConstants.LOGIN));
      user.setPassword(request.getParameter(CommandConstants.FIRST_PASSWORD));
      user = (User) daoUser.find(user);
      return user;
    }
      catch (SQLException ex) {
      return null;
    }
  }

  private boolean setSession(User user, HttpServletRequest request) {
    String login = null;
    String firstName = null;
    String secondName = null;
      if (user.getLogin() == null)
        return false;
      HttpSession session = request.getSession(true);
      session.setAttribute(PermissionsConstants.USER, user.getLogin());
      session.setAttribute(CommandConstants.FIRST_NAME, user.getFirstName());
      session.setAttribute(CommandConstants.SECOND_NAME, user.getSecondName());
      return true;
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
