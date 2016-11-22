package com.netcracker.petrusev.project2.command.commands.user;

import com.netcracker.petrusev.project2.DAO.DAOUserImpl;
import com.netcracker.petrusev.project2.beans.users.User;
import com.netcracker.petrusev.project2.command.ActionCommand;
import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.PageConstants;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by Asus on 17.11.2016.
 */
public class DeleteUserCommand implements ActionCommand{

    @Override
    public String execute(HttpServletRequest request) {
        DAOUserImpl daoUser = new DAOUserImpl();
        try {
            daoUser.delete(Integer.valueOf(request.getSession().getAttribute(CommandConstants.ID).toString()));
            request.getSession().invalidate();
        }
        catch (SQLException ex){
            return PageConstants.MAIN;
        }
        return PageConstants.SIGN_IN;
    }


}
