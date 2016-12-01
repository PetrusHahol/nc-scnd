package com.netcracker.petrusev.project2.command.commands.user;
import com.netcracker.petrusev.project2.DAO.DAOUserImpl;
import com.netcracker.petrusev.project2.beans.users.User;
import com.netcracker.petrusev.project2.command.ActionCommandInterface;
import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.PageConstants;
import com.netcracker.petrusev.project2.logger.LoggerError;
import com.netcracker.petrusev.project2.properties.LocaleData;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * @author Petrusev
 * @version 1.0
 *
 */
public class RegistrationCommand implements ActionCommandInterface {

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

    private String setParameters() throws SQLException{
            User user = new User();
            user.setLogin(login);
            user.setFirstName(firstName);
            user.setSecondName(secondName);
            user.setMail(mail);
            user.setPassword(password1);
            DAOUserImpl daoUser = new DAOUserImpl();
            daoUser.create(user);
        return  PageConstants.MAIN;
    }

    @Override
     public String execute(HttpServletRequest request) {

        String registration = request.getParameter(CommandConstants.REG);
            try {
                if (registration.equals(CommandConstants.TRUE)) {
                    if (getParameters(request)) {
                        request.setAttribute(CommandConstants.MESSAGE, LocaleData.INSTANCE.getProperty(CommandConstants.ADD_USER));
                        return setParameters();
                    }
                }
            } catch (SQLException e) {
                request.setAttribute(CommandConstants.MESSAGE, LocaleData.INSTANCE.getProperty(CommandConstants.DONT_ADD_USER));
                LoggerError.INSTANCE.logError(RegistrationCommand.class, e.getMessage());
                return PageConstants.REGISTRATION;
            }
        return PageConstants.REGISTRATION;
    }

}