package com.netcracker.petrusev.project2.command.commands.employee;

import com.netcracker.petrusev.project2.DAO.employee.*;
import com.netcracker.petrusev.project2.beans.entities.office.*;
import com.netcracker.petrusev.project2.command.ActionCommandInterface;
import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.EntityConstants;
import com.netcracker.petrusev.project2.constants.PageConstants;
import com.netcracker.petrusev.project2.logger.LoggerError;
import com.netcracker.petrusev.project2.properties.LocaleData;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;


/**
 * @author Petrusev
 * @version 1.0
 *
 */
public class AddEmployeeCommand implements ActionCommandInterface {

    private Employee getEmployee(HttpServletRequest request){
            Employee employee = new EmptyEmployee();
            employee.setName(request.getParameter(CommandConstants.NAME));
            employee.setAge(Integer.valueOf(request.getParameter(CommandConstants.AGE)));
            employee.setHeight(Integer.valueOf(request.getParameter(CommandConstants.HEIGHT)));
            employee.setExperience(Integer.valueOf(request.getParameter(CommandConstants.EXPERIENCE)));
            employee.setPassportData(request.getParameter(CommandConstants.PASSPORT_DATA));
        return employee;
    }

    private void stewardess_execute(HttpServletRequest request) throws SQLException{
        Employee employee = getEmployee(request);
        Stewardess stewardess = new Stewardess(employee.getName(), employee.getAge(), employee.getHeight()
                                               , employee.getExperience(), employee.getPassportData());
        stewardess.setLengthWaist(Integer.valueOf(request.getParameter(CommandConstants.LENGTH_WAIST)));
        DAOEmployeeInterface<Stewardess> daoEmployee = new DAOStewardessImpl();
        daoEmployee.create(stewardess);
    }

    private void navigatorExecute(HttpServletRequest request) throws SQLException{
        Employee employee =getEmployee(request);
        Navigator navigator = new Navigator(employee.getName(), employee.getAge(), employee.getHeight()
                , employee.getExperience(), employee.getPassportData());
        navigator.setCategory(request.getParameter(CommandConstants.CATEGORY));
        DAOEmployeeInterface<Navigator> daoEmployee = new DAONavigatorImpl();
        daoEmployee.create(navigator);
    }

    private void radiomanExecute(HttpServletRequest request) throws SQLException{
        Employee employee =getEmployee(request);
        Radioman radioman = new Radioman(employee.getName(), employee.getAge(), employee.getHeight()
                , employee.getExperience(), employee.getPassportData());
        radioman.setCountForeignLanguage(Integer.valueOf(request.getParameter(CommandConstants.COUNT_FOREIGN_LANGUAGE)));
        DAOEmployeeInterface<Radioman> daoEmployee = new DAORadiomanImpl();
        daoEmployee.create(radioman);
    }

    private void pilotExecute(HttpServletRequest request) throws SQLException{
        Employee employee = getEmployee(request);
        Pilot pilot = new Pilot(employee.getName(), employee.getAge(), employee.getHeight()
                , employee.getExperience(), employee.getPassportData());
        pilot.setMileage(Integer.valueOf(request.getParameter(CommandConstants.MILEAGE)));
        DAOEmployeeInterface<Pilot> daoEmployee = new DAOPilotImpl();
        daoEmployee.create(pilot);
    }

    @Override
    public String execute(HttpServletRequest request) {
        if (request.getParameter(CommandConstants.REG).equals(CommandConstants.TRUE)) {
            String role = request.getParameter(CommandConstants.ROLE);
            try {
                if (role.equals(EntityConstants.STEWARDESS)) stewardess_execute(request);
                if (role.equals(EntityConstants.NAVIGATOR)) navigatorExecute(request);
                if (role.equals(EntityConstants.RADIOMAN)) radiomanExecute(request);
                if (role.equals(EntityConstants.PILOT)) pilotExecute(request);
                request.setAttribute(CommandConstants.MESSAGE, LocaleData.INSTANCE.getProperty(CommandConstants.ADD_EMPLOYEE));
            }catch (SQLException ex){
                request.setAttribute(CommandConstants.MESSAGE, LocaleData.INSTANCE.getProperty(CommandConstants.DONT_ADD_EMPLOYEE));
                LoggerError.INSTANCE.logError(AddEmployeeCommand.class, ex.getMessage());
                return PageConstants.ADDEMPLOYEE;
            }

        } else {
            String role = request.getParameter(CommandConstants.ROLE);
            String info = null;
            if (role.equals(EntityConstants.STEWARDESS)) info = CommandConstants.LENGTH_WAIST;
            if (role.equals(EntityConstants.NAVIGATOR)) info = CommandConstants.CATEGORY;
            if (role.equals(EntityConstants.RADIOMAN)) info = CommandConstants.COUNT_FOREIGN_LANGUAGE;
            if (role.equals(EntityConstants.PILOT)) info =  CommandConstants.MILEAGE;
            request.setAttribute(CommandConstants.ROLE, role);
            request.setAttribute(CommandConstants.INFO, info);
            return PageConstants.ADDEMPLOYEE;
        }
        return PageConstants.EMPLOYEE_MENU;
    }
}
