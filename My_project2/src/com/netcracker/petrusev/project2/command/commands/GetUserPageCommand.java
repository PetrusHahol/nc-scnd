package com.netcracker.petrusev.project2.command.commands;

import com.netcracker.petrusev.project2.DAO.DAOFlightImpl;
import com.netcracker.petrusev.project2.DAO.DAOInterface;
import com.netcracker.petrusev.project2.DAO.employee.*;
import com.netcracker.petrusev.project2.DAO.teams.DAOBrigadeImpl;
import com.netcracker.petrusev.project2.beans.entities.flights.Flight;
import com.netcracker.petrusev.project2.beans.entities.office.Navigator;
import com.netcracker.petrusev.project2.beans.entities.office.Pilot;
import com.netcracker.petrusev.project2.beans.entities.office.Radioman;
import com.netcracker.petrusev.project2.beans.entities.office.Stewardess;
import com.netcracker.petrusev.project2.beans.entities.teams.Brigade;
import com.netcracker.petrusev.project2.command.ActionCommand;
import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.EntityConstants;
import com.netcracker.petrusev.project2.constants.PageConstants;
import com.netcracker.petrusev.project2.services.SetRequestData;
import com.netcracker.petrusev.project2.utils.UtilsGregorianCalendar;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 13.11.2016.
 */
public class GetUserPageCommand implements ActionCommand {


    @Override
    public String execute(HttpServletRequest request) {
        SetRequestData setRequests = new SetRequestData();
        try {
            if (request.getParameter(CommandConstants.GROUP).equals(CommandConstants.FLIGHTS))
                request.setAttribute(CommandConstants.GROUP,CommandConstants.FLIGHTS);
                setRequests.setFlight(request);
            if (request.getParameter(CommandConstants.GROUP).equals(CommandConstants.EMPLOYEES)){
                request.setAttribute(CommandConstants.GROUP,CommandConstants.EMPLOYEES);
               setRequests. setEmployee(request);
            }
            if (request.getParameter(CommandConstants.GROUP).equals(CommandConstants.BRIGADES)){
                request.setAttribute(CommandConstants.GROUP,CommandConstants.BRIGADES);
                setRequests.setBrigades(request);
            }
        }catch (SQLException ex){
            return PageConstants.USER_CONTENT;
        }
        catch (NullPointerException ex) {
            return PageConstants.USER_CONTENT;
        }
        return PageConstants.USER_CONTENT;
    }
}
