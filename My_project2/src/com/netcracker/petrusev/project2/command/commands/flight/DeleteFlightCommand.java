package com.netcracker.petrusev.project2.command.commands.flight;

import com.netcracker.petrusev.project2.DAO.DAOFlightImpl;
import com.netcracker.petrusev.project2.DAO.DAOInterface;
import com.netcracker.petrusev.project2.beans.entities.flights.Flight;
import com.netcracker.petrusev.project2.command.ActionCommand;
import com.netcracker.petrusev.project2.command.commands.user.UserPageCommand;
import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.PageConstants;
import com.netcracker.petrusev.project2.constants.SQLConstants;
import com.netcracker.petrusev.project2.utils.UtilsGregorianCalendar;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by Asus on 19.11.2016.
 */
public class DeleteFlightCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        try {
            DAOInterface<Flight> daoFlight = new DAOFlightImpl();
            daoFlight.delete(Integer.valueOf(request.getParameter(CommandConstants.ID)));
            return PageConstants.USER_CONTENT;
        }
        catch (SQLException ex){
            return PageConstants.USER_CONTENT;
            //логи
        }
    }
}
