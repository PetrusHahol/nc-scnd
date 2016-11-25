package com.netcracker.petrusev.project2.command.commands.employee;

import com.netcracker.petrusev.project2.DAO.employee.*;
import com.netcracker.petrusev.project2.beans.entities.office.Navigator;
import com.netcracker.petrusev.project2.beans.entities.office.Pilot;
import com.netcracker.petrusev.project2.beans.entities.office.Radioman;
import com.netcracker.petrusev.project2.beans.entities.office.Stewardess;
import com.netcracker.petrusev.project2.command.ActionCommand;
import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.EntityConstants;
import com.netcracker.petrusev.project2.constants.PageConstants;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by Asus on 22.11.2016.
 */
public class DeleteEmployeeCommand implements ActionCommand{


    private void navigatorExecute(HttpServletRequest request) throws SQLException{
        DAOEmployeeInterface<Navigator> daoNavigator = new DAONavigatorImpl();
        daoNavigator.delete(Integer.valueOf(request.getParameter(CommandConstants.ID)));
    }

    private void pilotExecute(HttpServletRequest request)  throws SQLException{
        DAOEmployeeInterface<Pilot> daoPilot = new DAOPilotImpl();
        daoPilot.delete(Integer.valueOf(request.getParameter(CommandConstants.ID)));
    }

    private void radiomanExecute(HttpServletRequest request)  throws SQLException{
        DAOEmployeeInterface<Radioman> daoRadioman = new DAORadiomanImpl();
        daoRadioman.delete(Integer.valueOf(request.getParameter(CommandConstants.ID)));
    }

    private void stewardessExecute(HttpServletRequest request) throws SQLException {
        DAOEmployeeInterface<Stewardess> daoStewardess = new DAOStewardessImpl();
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
            return PageConstants.EMPLOYEE_MENU;
        } catch (SQLException ex){
            return PageConstants.EMPLOYEE_MENU;
        }
    }

}
