package com.netcracker.petrusev.project2.command.commands.flight;

import com.netcracker.petrusev.project2.DAO.DAOFlightImpl;
import com.netcracker.petrusev.project2.DAO.DAOInterface;
import com.netcracker.petrusev.project2.beans.entities.flights.Flight;
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
public class DeleteFlightCommand implements ActionCommandInterface {
    @Override
    public String execute(HttpServletRequest request) {
        try {
            DAOInterface<Flight> daoFlight = new DAOFlightImpl();
            daoFlight.delete(Integer.valueOf(request.getParameter(CommandConstants.ID)));
            request.setAttribute(CommandConstants.MESSAGE, LocaleData.INSTANCE.getProperty(CommandConstants.DELETE_FLIGHT));
            return PageConstants.USER_CONTENT;
        }
        catch (SQLException ex){
            request.setAttribute(CommandConstants.MESSAGE, LocaleData.INSTANCE.getProperty(CommandConstants.DONT_DELETE_FLIGHT));
            LoggerError.INSTANCE.logError(DeleteFlightCommand.class, ex.getMessage());
            return PageConstants.USER_CONTENT;
        }
    }
}
