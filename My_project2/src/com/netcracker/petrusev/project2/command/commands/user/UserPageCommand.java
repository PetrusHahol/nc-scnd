package com.netcracker.petrusev.project2.command.commands.user;

import com.netcracker.petrusev.project2.DAO.DAOFlightImpl;
import com.netcracker.petrusev.project2.DAO.employee.*;
import com.netcracker.petrusev.project2.beans.entities.flights.Flight;
import com.netcracker.petrusev.project2.beans.entities.office.Navigator;
import com.netcracker.petrusev.project2.beans.entities.office.Pilot;
import com.netcracker.petrusev.project2.beans.entities.office.Radioman;
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
        List<String> from =  new ArrayList<>();
        List<String> to =  new ArrayList<>();
        List<String> date =  new ArrayList<>();
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

        DAOEmployeeInterface<Stewardess> daoStewardess = new DAOStewardessImpl();
        List<Stewardess> stewardesses = daoStewardess.allData();
        DAOEmployeeInterface<Pilot> daoPilot = new DAOPilotImpl();
        List<Pilot> pilots = daoPilot.allData();
        DAOEmployeeInterface<Navigator> daoNavigator = new DAONavigatorImpl();
        List<Navigator> navigators = daoNavigator.allData();
        DAOEmployeeInterface<Radioman>  daoRadioman = new DAORadiomanImpl();
        List<Radioman> radiomans = daoRadioman.allData();
        request.setAttribute("radiomans", radiomans);
        request.setAttribute("radiomans_size", radiomans.size() - 1);//do constants
        request.setAttribute("pilots_size", pilots.size()-1);
        request.setAttribute("pilots", pilots);
        request.setAttribute("stewardess_size", stewardesses.size()-1);
        request.setAttribute("stewardess", stewardesses);
        request.setAttribute("navigators_size", navigators.size() - 1);
        request.setAttribute("navigators" , navigators);
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
            request.setAttribute("GROUP","ska");//do constants
            return PageConstants.USER_CONTENT;
        }
        return PageConstants.USER_CONTENT;
    }
}
