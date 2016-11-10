package com.web.command;

import javax.servlet.http.HttpServletRequest;

public class SignInCommand implements ActionCommand {
  private static final String PARAM_NAME_LOGIN = "login";
  private static final String PARAM_NAME_PASSWORD = "password";

  @Override
  public String execute(HttpServletRequest request) {
    /*
    String page = null;
    // извлечение из запроса логина и пароля
    String login = request.getParameter(PARAM_NAME_LOGIN);
    String pass = request.getParameter(PARAM_NAME_PASSWORD);
    // проверка логина и пароля
    if (LoginLogic.checkAdminLogin(login, pass)) {
      request.setAttribute("user", login);
      HttpSession session = request.getSession(true);
      session.setAttribute("userType", ClientType.ADMINISTRATOR);
      // определение пути к main.jsp
      page = ConfigurationManager.getProperty("path.page.main");
    } else if (LoginLogic.checkUserLogin(login, pass)) {
      request.setAttribute("user", login);
      HttpSession session = request.getSession(true);
      session.setAttribute("userType", ClientType.USER);
      // определение пути к main.jsp
      page = ConfigurationManager.getProperty("path.page.user");
    } else {
      request.setAttribute("errorLoginPassMessage", MessageManager.getProperty("message.loginerror"));
      request.getSession().setAttribute("userType", ClientType.GUEST);
      page = ConfigurationManager.getProperty("path.page.login");
    }
    */
    return "/signin.jsp";
  }
}
