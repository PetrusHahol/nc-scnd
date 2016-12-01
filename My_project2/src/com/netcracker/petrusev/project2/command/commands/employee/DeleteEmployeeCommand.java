package com.netcracker.petrusev.project2.command.commands.employee;

import com.netcracker.petrusev.project2.DAO.DAOInterface;
import com.netcracker.petrusev.project2.DAO.employee.*;
import com.netcracker.petrusev.project2.beans.entities.office.Navigator;
import com.netcracker.petrusev.project2.beans.entities.office.Pilot;
import com.netcracker.petrusev.project2.beans.entities.office.Radioman;
import com.netcracker.petrusev.project2.beans.entities.office.Stewardess;
import com.netcracker.petrusev.project2.command.ActionCommandInterface;
import com.netcracker.petrusev.project2.command.commands.brigade.DeleteBrigadeCommand;
import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.EntityConstants;
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
public class DeleteEmployeeCommand implements ActionCommandInterface {


    private void navigatorExecute(HttpServletRequest request) throws SQLException{
        DAOInterface<Navigator> daoNavigator = new DAONavigatorImpl();
        daoNavigator.delete(Integer.valueOf(request.getParameter(CommandConstants.ID)));
    }

    private void pilotExecute(HttpServletRequest request)  throws SQLException{
        DAOInterface<Pilot> daoPilot = new DAOPilotImpl();
        daoPilot.delete(Integer.valueOf(request.getParameter(CommandConstants.ID)));
    }

    private void radiomanExecute(HttpServletRequest request)  throws SQLException{
        DAOInterface<Radioman> daoRadioman = new DAORadiomanImpl();
        daoRadioman.delete(Integer.valueOf(request.getParameter(CommandConstants.ID)));
    }

    private void stewardessExecute(HttpServletRequest request) throws SQLException {
        DAOInterface<Stewardess> daoStewardess = new DAOStewardessImpl();
        daoStewardess.delete(Integer.valueOf(request.getParameter(CommandConstants.ID)));
    }

    @Override
    public String execute(HttpServletRequest request) {
        try {
            if (request.getParameter(CommandConstants.ROLE).equals(EntityConstants.NAVIGATOR))
                navigatorExecute(request);
            if (request.getParameter(CommandConstants.ROLE).equals(EntityConstants.STEWARDESS))
                stewardessExecute(request);
            if (request.getParameter(CommandConstants.ROLE).equals(EntityConstants.PILOT)) pilotExecute(request);
            if (request.getParameter(CommandConstants.ROLE).equals(EntityConstants.RADIOMAN)) radiomanExecute(request);
            request.setAttribute(CommandConstants.MESSAGE, LocaleData.INSTANCE.getProperty(CommandConstants.DELETE_EMPLOYEE));
            return PageConstants.EMPLOYEE_MENU;
        } catch (SQLException ex){
            request.setAttribute(CommandConstants.MESSAGE, LocaleData.INSTANCE.getProperty(CommandConstants.DONT_DELETE_EMPLOYEE));
            LoggerError.INSTANCE.logError(DeleteBrigadeCommand.class, ex.getMessage());
            return PageConstants.EMPLOYEE_MENU;
        }
    }

}
