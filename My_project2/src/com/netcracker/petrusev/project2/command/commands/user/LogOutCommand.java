package com.netcracker.petrusev.project2.command.commands.user;

import com.netcracker.petrusev.project2.command.ActionCommand;
import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.PageConstants;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Asus on 13.11.2016.
 */
public class LogOutCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().invalidate();
        return PageConstants.MAIN;
    }
}
