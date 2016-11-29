package com.netcracker.petrusev.project2.command.commands.flight;

import com.netcracker.petrusev.project2.DAO.DAOFlightImpl;
import com.netcracker.petrusev.project2.DAO.DAOInterface;
import com.netcracker.petrusev.project2.beans.entities.flights.Flight;
import com.netcracker.petrusev.project2.command.ActionCommand;
import com.netcracker.petrusev.project2.command.commands.brigade.AddBrigadeCommand;
import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.PageConstants;
import com.netcracker.petrusev.project2.properties.LocaleData;
import com.netcracker.petrusev.project2.utils.UtilsGregorianCalendar;
import com.netcracker.petrusev.project2.logger.LoggerError;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Calendar;

/**
 * Created by Asus on 26.11.2016.
 */
public class UpdateFlightCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        try {
            if (request.getParameter(CommandConstants.REG).equals(CommandConstants.FALSE)) {
                DAOInterface<Flight> daoFlight = new DAOFlightImpl();
                request.setAttribute(CommandConstants.FLIGHT, daoFlight.find(Integer.valueOf(request.getParameter(CommandConstants.ID))));
                request.setAttribute(CommandConstants.DATE, Calendar.DATE);
                request.setAttribute(CommandConstants.YEAR, Calendar.YEAR);
                request.setAttribute(CommandConstants.MONTH, Calendar.MONTH);
                return PageConstants.UPDATE_FLIGHT;

            } else {
                Flight flight = new Flight();
                flight.setId(Integer.valueOf(request.getParameter(CommandConstants.ID)));
                flight.setFrom(request.getParameter(CommandConstants.FROM));
                flight.setTo(request.getParameter(CommandConstants.TO));
                flight.setDate(UtilsGregorianCalendar.INSTANCE.convertIntoGregorianCalendar(request.getParameter(CommandConstants.DATE)));
                DAOInterface<Flight> daoFlight = new DAOFlightImpl();
                daoFlight.update(flight);
            }
        }
        catch (SQLException ex){
            LoggerError.INSTANCE.logError(AddBrigadeCommand.class, ex.getMessage());
            return PageConstants.USER_CONTENT;
        }
        request.setAttribute(CommandConstants.MESSAGE, LocaleData.INSTANCE.getProperty(CommandConstants.UPDATE_FLIGHT));
        return PageConstants.USER_CONTENT;
    }
}
