package com.netcracker.petrusev.project2.command.commands.flight;

import com.netcracker.petrusev.project2.DAO.DAOFlightImpl;
import com.netcracker.petrusev.project2.DAO.DAOInterface;
import com.netcracker.petrusev.project2.beans.entities.flights.Flight;
import com.netcracker.petrusev.project2.command.ActionCommandInterface;
import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.PageConstants;
import com.netcracker.petrusev.project2.constants.PermissionsConstants;
import com.netcracker.petrusev.project2.logger.LoggerError;
import com.netcracker.petrusev.project2.properties.LocaleData;
import com.netcracker.petrusev.project2.utils.UtilsGregorianCalendar;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * @author Petrusev
 * @version 1.0
 *
 */
public class AddFlightCommand implements ActionCommandInterface {
    @Override
    public String execute(HttpServletRequest request) {
        if (request.getSession().getAttribute(CommandConstants.PRIORITY).toString().equals(PermissionsConstants.ADMIN)) {
            if (request.getParameter(CommandConstants.REG).equals(CommandConstants.TRUE)) {
                try {
                    Flight flight = new Flight();
                    System.out.println(request.getParameter(CommandConstants.FROM));
                    flight.setFrom(request.getParameter(CommandConstants.FROM));
                    flight.setTo(request.getParameter(CommandConstants.TO));
                    flight.setDate(UtilsGregorianCalendar.INSTANCE.convertIntoGregorianCalendar(request.getParameter(CommandConstants.DATE)));
                    DAOInterface<Flight> daoFlight = new DAOFlightImpl();
                    daoFlight.create(flight);
                    request.setAttribute(CommandConstants.MESSAGE, LocaleData.INSTANCE.getProperty(CommandConstants.ADD_FLIGHT));
                } catch (SQLException ex) {
                    request.setAttribute(CommandConstants.MESSAGE, LocaleData.INSTANCE.getProperty(CommandConstants.DONT_ADD_FLIGHT));
                    LoggerError.INSTANCE.logError(AddFlightCommand.class, ex.getMessage());
                    return PageConstants.ADDFLIGHT;
                }
            } else return PageConstants.ADDFLIGHT;
            }

        return PageConstants.USER_CONTENT;
    }
}
