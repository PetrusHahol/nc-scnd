package com.netcracker.petrusev.project2.command.commands.user;

import com.netcracker.petrusev.project2.DAO.DAOUserImpl;
import com.netcracker.petrusev.project2.beans.users.User;
import com.netcracker.petrusev.project2.command.ActionCommand;
import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.PageConstants;
import com.netcracker.petrusev.project2.logger.LoggerError;
import com.netcracker.petrusev.project2.properties.LocaleData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * @author Petrusev
 * @version 1.0
 *
 */
public class SignInCommand implements ActionCommand {
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
        request.setAttribute(CommandConstants.MESSAGE, LocaleData.INSTANCE.getProperty(CommandConstants.DONT_SIGN_IN));
        LoggerError.INSTANCE.logError(SignInCommand.class, ex.getMessage());
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
      session.setAttribute(CommandConstants.LOGIN, user.getLogin());
      session.setAttribute(CommandConstants.FIRST_NAME, user.getFirstName());
      session.setAttribute(CommandConstants.SECOND_NAME, user.getSecondName());
      session.setAttribute(CommandConstants.PRIORITY, user.getPriority());
      session.setAttribute(CommandConstants.ID, user.getId());
      return true;
  }

  @Override
  public String execute(HttpServletRequest request) {
    if (request.getParameter(CommandConstants.AUTHORIZATION).equals(CommandConstants.TRUE)) {
      if (setSession(getUser(request), request)) {
        return PageConstants.USER_CONTENT_REQUEST;
      }
      else
        return PageConstants.SIGN_IN;
    }
    return PageConstants.SIGN_IN;
  }
}
