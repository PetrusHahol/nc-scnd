package com.netcracker.petrusev.project2.command.commands.employee;

import com.netcracker.petrusev.project2.DAO.DAOInterface;
import com.netcracker.petrusev.project2.DAO.employee.*;
import com.netcracker.petrusev.project2.beans.entities.office.*;
import com.netcracker.petrusev.project2.command.ActionCommand;
import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.PageConstants;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by Asus on 21.11.2016.
 */
public class AddEmployeeCommand implements ActionCommand{

    private Employee getEmployee(HttpServletRequest request){
            Employee employee = new EmptyEmployee();
            employee.setName(request.getParameter(CommandConstants.NAME));
            employee.setAge(Integer.getInteger(request.getParameter(CommandConstants.AGE)));
            employee.setHeight(Integer.getInteger(request.getParameter(CommandConstants.HEIGHT)));
            employee.setExperience(Integer.getInteger(request.getParameter(CommandConstants.EXPERIENCE)));
            employee.setPassportData(request.getParameter(CommandConstants.PASSPORT_DATA));
        return employee;
    }

    private void stewardess_execute(HttpServletRequest request) throws SQLException{
        Employee employee = getEmployee(request);
        Stewardess stewardess = new Stewardess(employee.getName(), employee.getAge(), employee.getHeight()
                                               , employee.getExperience(), employee.getPassportData());
        stewardess.setLengthWaist(Integer.getInteger(request.getParameter(CommandConstants.LENGTH_WAIST)));
        DAOEmployeeInterface<Stewardess> daoEmployee = new DAOStewardessImpl();
        daoEmployee.create(stewardess);
    }
    private void navigator_execute(HttpServletRequest request) throws SQLException{
        Employee employee =getEmployee(request);
        Navigator navigator = new Navigator(employee.getName(), employee.getAge(), employee.getHeight()
                , employee.getExperience(), employee.getPassportData());
        navigator.setCategory(request.getParameter(CommandConstants.CATEGORY));
        DAOEmployeeInterface<Navigator> daoEmployee = new DAONavigatorImpl();
        daoEmployee.create(navigator);
    }
    private void radioman_execute(HttpServletRequest request) throws SQLException{
        Employee employee =getEmployee(request);
        Radioman radioman = new Radioman(employee.getName(), employee.getAge(), employee.getHeight()
                , employee.getExperience(), employee.getPassportData());
        radioman.setCountForeignLanguage(Integer.getInteger(request.getParameter(CommandConstants.COUNT_FOREIGN_LANGUAGE)));
        DAOEmployeeInterface<Radioman> daoEmployee = new DAORadiomanImpl();
        daoEmployee.create(radioman);
    }
    private void pilot_execute(HttpServletRequest request) throws SQLException{
        Employee employee =getEmployee(request);
        Pilot pilot = new Pilot(employee.getName(), employee.getAge(), employee.getHeight()
                , employee.getExperience(), employee.getPassportData());
        pilot.setMileage(Integer.getInteger(request.getParameter(CommandConstants.MILEAGE)));
        DAOEmployeeInterface<Pilot> daoEmployee = new DAOPilotImpl();
        daoEmployee.create(pilot);
    }

    @Override
    public String execute(HttpServletRequest request) {
        if (request.getParameter(CommandConstants.REG).equals(CommandConstants.TRUE)) {
            String role = request.getParameter(CommandConstants.ROLE);
            try {
                if (role.equals("stewardess")) stewardess_execute(request);// do constants
                if (role.equals("navigator")) navigator_execute(request);
                if (role.equals("radioman")) radioman_execute(request);
                if (role.equals("pilot")) pilot_execute(request);
            }catch (SQLException ex){
                return PageConstants.ADDEMPLOYEE;
            }

        } else {
            String role = request.getParameter(CommandConstants.ROLE);
            String info = null;
            if (role.equals("stewardess")) info = "Length_waist";// do constants
            if (role.equals("navigator")) info = "Category";
            if (role.equals("radioman")) info = "Count_foreign_language";
            if (role.equals("pilot")) info = "Mileage";
            request.setAttribute(CommandConstants.ROLE, role);
            request.setAttribute(CommandConstants.INFO, info);
            return PageConstants.ADDEMPLOYEE;
        }
        return "/";
    }
}
