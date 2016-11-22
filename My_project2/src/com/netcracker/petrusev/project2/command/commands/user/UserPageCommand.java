package com.netcracker.petrusev.project2.command.commands.user;

import com.netcracker.petrusev.project2.DAO.DAOFlightImpl;
import com.netcracker.petrusev.project2.DAO.DAOInterface;
import com.netcracker.petrusev.project2.DAO.employee.*;
import com.netcracker.petrusev.project2.DAO.team.DAOBrigadeImpl;
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
        List<Integer> id = new ArrayList<>();
        DAOFlightImpl daoFlight = new DAOFlightImpl();
        for (Flight iter : daoFlight.getAllData()){
            from.add(iter.getFrom());
            to.add(iter.getTo());
            date.add(UtilsGregorianCalendar.INSTANCE.convertFromGregorianCalendar(iter.getDate()));
            id.add(iter.getId());
        }
        request.setAttribute(CommandConstants.ID, id);
        request.setAttribute(CommandConstants.FROM, from);
        request.setAttribute(CommandConstants.TO, to);
        request.setAttribute(CommandConstants.DATE, date);
        request.setAttribute(CommandConstants.SIZE, to.size()-1);
    }

    private void setEmployee(HttpServletRequest request) throws SQLException{

        DAOEmployeeInterface<Stewardess> daoStewardess = new DAOStewardessImpl();
        List<Stewardess> stewardesses = daoStewardess.getAllData();
        DAOEmployeeInterface<Pilot> daoPilot = new DAOPilotImpl();
        List<Pilot> pilots = daoPilot.getAllData();
        DAOEmployeeInterface<Navigator> daoNavigator = new DAONavigatorImpl();
        List<Navigator> navigators = daoNavigator.getAllData();
        DAOEmployeeInterface<Radioman>  daoRadioman = new DAORadiomanImpl();
        List<Radioman> radiomans = daoRadioman.getAllData();
        request.setAttribute(EntityConstants.RADIOMAN, radiomans);
        request.setAttribute(EntityConstants.PILOT, pilots);
        request.setAttribute(EntityConstants.STEWARDESS, stewardesses);
        request.setAttribute(EntityConstants.NAVIGATOR , navigators);
    }

    private void setBrigades(HttpServletRequest request) throws  SQLException{
        DAOInterface<Brigade> daoBrigade = new DAOBrigadeImpl();
        List<Brigade> brigades = daoBrigade.getAllData();
        request.setAttribute(CommandConstants.BRIGADES, brigades);
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
            if (request.getParameter(CommandConstants.GROUP).equals(CommandConstants.BRIGADES)){
                request.setAttribute(CommandConstants.GROUP,CommandConstants.BRIGADES);
                setBrigades(request);
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
