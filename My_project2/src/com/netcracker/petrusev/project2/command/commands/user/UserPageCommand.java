package com.netcracker.petrusev.project2.command.commands.user;

import com.netcracker.petrusev.project2.DAO.DAOFlightImpl;
import com.netcracker.petrusev.project2.beans.entities.flights.Flight;
import com.netcracker.petrusev.project2.command.ActionCommand;
import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.PageConstants;
import com.netcracker.petrusev.project2.constants.SQLConstants;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 13.11.2016.
 */
public class UserPageCommand implements ActionCommand {

    private void setFlight(HttpServletRequest request) throws SQLException{
        List<String> from =  new ArrayList<String>();
        List<String> to =  new ArrayList<String>();
        List<String> date =  new ArrayList<String>();
        DAOFlightImpl daoFlight = new DAOFlightImpl();
        for (Flight iter : daoFlight.allData()){
            from.add(iter.getFrom());
            to.add(iter.getTo());
        }
        request.setAttribute(CommandConstants.from, from);
        request.setAttribute(CommandConstants.to, to);
        request.setAttribute(CommandConstants.size, to.size());

    }


    @Override
    public String execute(HttpServletRequest request) {

        try {
            if (request.getParameter("group").equals("flights"))
                request.setAttribute("group","flights");
                setFlight(request);
        }catch (SQLException ex){
            //тут будут логи)0)0)0
            request.setAttribute("group","ska");
            return PageConstants.USER_CONTENT;
        }
        catch (NullPointerException ex) {
            request.setAttribute("group","ska");
            return PageConstants.USER_CONTENT;
        }
        return PageConstants.USER_CONTENT;
    }
}
