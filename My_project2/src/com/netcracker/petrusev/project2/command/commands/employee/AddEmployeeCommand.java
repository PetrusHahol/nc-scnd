package com.netcracker.petrusev.project2.command.commands.employee;

import com.netcracker.petrusev.project2.command.ActionCommand;
import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.PageConstants;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Asus on 21.11.2016.
 */
public class AddEmployeeCommand implements ActionCommand{

    public void stewardess_execute(){

    }
    public void navigator_execute(){

    }
    public void radioman_execute(){

    }
    public void pilot_execute(){

    }

    @Override
    public String execute(HttpServletRequest request) {
        if (request.getParameter(CommandConstants.REG).equals(CommandConstants.TRUE)) {
            String role = request.getParameter(CommandConstants.ROLE);
            if (role.equals("stewardess")) stewardess_execute();// do constants
            if (role.equals("navigator")) navigator_execute();
            if (role.equals("radioman")) radioman_execute();
            if (role.equals("pilot")) pilot_execute();

        } else {
            String role = request.getParameter(CommandConstants.ROLE);
            String info = null;
            if (role.equals("stewardess")) info = "Length_waist";// do constants
            if (role.equals("navigator")) info = "Category";
            if (role.equals("radioman")) info = "Count_foreign_language";
            if (role.equals("pilot")) info = "Mileage";
            request.setAttribute(CommandConstants.INFO, info);
            return PageConstants.ADDEMPLOYEE;
        }
        return "/";
    }
}
