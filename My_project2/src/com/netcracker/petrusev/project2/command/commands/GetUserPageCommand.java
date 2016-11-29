package com.netcracker.petrusev.project2.command.commands;

import com.netcracker.petrusev.project2.command.ActionCommand;
import com.netcracker.petrusev.project2.command.commands.brigade.AddBrigadeCommand;
import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.PageConstants;
import com.netcracker.petrusev.project2.services.SetRequestData;
import com.netcracker.petrusev.project2.logger.LoggerError;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

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
            LoggerError.INSTANCE.logError(AddBrigadeCommand.class, ex.getMessage());
            return PageConstants.USER_CONTENT;
        }
        catch (NullPointerException ex) {
            LoggerError.INSTANCE.logError(AddBrigadeCommand.class, ex.getMessage());
            return PageConstants.USER_CONTENT;
        }
        return PageConstants.USER_CONTENT;
    }
}
