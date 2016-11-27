package com.netcracker.petrusev.project2.command.commands.flight;

import com.netcracker.petrusev.project2.DAO.DAOFlightImpl;
import com.netcracker.petrusev.project2.DAO.DAOInterface;
import com.netcracker.petrusev.project2.beans.entities.flights.Flight;
import com.netcracker.petrusev.project2.command.ActionCommand;
import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.PageConstants;
import com.netcracker.petrusev.project2.constants.PermissionsConstants;
import com.netcracker.petrusev.project2.utils.UtilsGregorianCalendar;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by Asus on 19.11.2016.
 */
public class AddFlightCommand implements ActionCommand {
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
                } catch (SQLException ex) {
                    return PageConstants.ADDFLIGHT;
                }
            } else return PageConstants.ADDFLIGHT;
            }
        request.setAttribute("message", "Flight was added");
        return PageConstants.USER_CONTENT;
    }
}
