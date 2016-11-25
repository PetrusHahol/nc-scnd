package com.netcracker.petrusev.project2.command.commands.brigade;

import com.netcracker.petrusev.project2.DAO.DAOInterface;
import com.netcracker.petrusev.project2.DAO.teams.DAOBrigadeImpl;
import com.netcracker.petrusev.project2.beans.entities.teams.Brigade;
import com.netcracker.petrusev.project2.command.ActionCommand;
import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.PageConstants;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by Asus on 24.11.2016.
 */
public class DeleteBrigadeCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        try {
            DAOInterface<Brigade> daoBrigade = new DAOBrigadeImpl();
            daoBrigade.delete(Integer.valueOf(request.getParameter(CommandConstants.ID)));
            return PageConstants.USER_CONTENT;
        }
        catch (SQLException ex){
            return PageConstants.USER_CONTENT;
            //логи
        }
    }
}
