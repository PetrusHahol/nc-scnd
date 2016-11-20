package com.netcracker.petrusev.project2.command.commands.user;

import com.netcracker.petrusev.project2.DAO.DAOFlightImpl;
import com.netcracker.petrusev.project2.DAO.employee.DAOStewardessImpl;
import com.netcracker.petrusev.project2.beans.entities.flights.Flight;
import com.netcracker.petrusev.project2.beans.entities.office.Stewardess;
import com.netcracker.petrusev.project2.command.ActionCommand;
import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.PageConstants;
import com.netcracker.petrusev.project2.utils.UtilsGregorianCalendar;

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
            date.add(UtilsGregorianCalendar.INSTANCE.convertFromGregorianCalendar(iter.getDate()));
        }
        request.setAttribute(CommandConstants.FROM, from);
        request.setAttribute(CommandConstants.TO, to);
        request.setAttribute(CommandConstants.DATE, date);
        request.setAttribute(CommandConstants.SIZE, to.size()-1);
    }

    public void setEmployee(HttpServletRequest request) throws SQLException{
        List<Integer> age =  new ArrayList<Integer>();
        List<Integer> height =  new ArrayList<Integer>();
        DAOStewardessImpl daoEmployee = new DAOStewardessImpl();
        List<Stewardess> stewardesses = daoEmployee.allData();
        //for (Stewardess iter : daoEmployee.allData()){
          //  age.add(iter.getAge());
           // height.add(iter.getHeight());
        //}
        request.setAttribute("stewardess_size", stewardesses.size()-1);
        request.setAttribute("stewardess", stewardesses);

    }


    @Override
    public String execute(HttpServletRequest request) {

        try {
            if (request.getParameter(CommandConstants.GROUP).equals(CommandConstants.FLIGHTS))
                request.setAttribute(CommandConstants.GROUP,CommandConstants.FLIGHTS);
                setFlight(request);
            if (request.getParameter(CommandConstants.GROUP).equals(CommandConstants.EMPLOYEES)){
                request.setAttribute(CommandConstants.GROUP,CommandConstants.EMPLOYEES);
                setEmployee(request);
            }
        }catch (SQLException ex){
            //тут будут логи)0)0)0
            request.setAttribute("GROUP","ska");
            return PageConstants.USER_CONTENT;
        }
        catch (NullPointerException ex) {
            request.setAttribute("GROUP","ska");
            return PageConstants.USER_CONTENT;
        }
        return PageConstants.USER_CONTENT;
    }
}
