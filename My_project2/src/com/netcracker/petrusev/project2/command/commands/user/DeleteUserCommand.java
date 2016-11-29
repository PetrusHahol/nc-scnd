package com.netcracker.petrusev.project2.command.commands.user;

import com.netcracker.petrusev.project2.DAO.DAOUserImpl;
import com.netcracker.petrusev.project2.command.ActionCommand;
import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.PageConstants;
import com.netcracker.petrusev.project2.logger.LoggerError;
import com.netcracker.petrusev.project2.properties.LocaleData;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by Asus on 17.11.2016.
 */
public class DeleteUserCommand implements ActionCommand{

    @Override
    public String execute(HttpServletRequest request) {
        DAOUserImpl daoUser = new DAOUserImpl();
        try {
            daoUser.delete(Integer.valueOf(request.getSession().getAttribute(CommandConstants.ID).toString()));
            request.getSession().invalidate();
            request.setAttribute(CommandConstants.MESSAGE, LocaleData.INSTANCE.getProperty(CommandConstants.DELETE_USER));
        }
        catch (SQLException ex){
            LoggerError.INSTANCE.logError(DeleteUserCommand.class, ex.getMessage());
            request.setAttribute(CommandConstants.MESSAGE, LocaleData.INSTANCE.getProperty(CommandConstants.DONT_DELETE_USER));
            return PageConstants.MAIN;
        }
        return PageConstants.SIGN_IN;
    }


}
