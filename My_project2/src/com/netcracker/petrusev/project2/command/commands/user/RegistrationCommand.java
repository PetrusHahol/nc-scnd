package com.netcracker.petrusev.project2.command.commands.user;
import com.netcracker.petrusev.project2.DAO.DAOUserImpl;
import com.netcracker.petrusev.project2.beans.users.User;
import com.netcracker.petrusev.project2.command.ActionCommand;
import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.PageConstants;
import com.netcracker.petrusev.project2.properties.LocaleData;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class RegistrationCommand implements ActionCommand {

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
        return password1.equals(password2);
    }

    private String setParameters(){
        try {
            User user = new User();
            user.setLogin(login);
            user.setFirstName(firstName);
            user.setSecondName(secondName);
            user.setMail(mail);
            user.setPassword(password1);
            DAOUserImpl daoUser = new DAOUserImpl();
            daoUser.create(user);
        } catch (SQLException e) {
            return PageConstants.REGISTRATION;
        }

        return  PageConstants.MAIN;
    }

    @Override
     public String execute(HttpServletRequest request) {

        String registration = request.getParameter(CommandConstants.REG);

        if (registration.equals(CommandConstants.TRUE)){
              if (getParameters(request)) {
                  request.setAttribute(CommandConstants.MESSAGE, LocaleData.INSTANCE.getProperty(CommandConstants.ADD_USER));
                  return setParameters();
              }
        }

      return PageConstants.REGISTRATION;
     }
}