package com.netcracker.petrusev.project2.command.commands.user;

import com.netcracker.petrusev.project2.command.ActionCommand;
import com.netcracker.petrusev.project2.constants.PageConstants;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Asus on 13.11.2016.
 */
public class UserPageCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        return PageConstants.USER_CONTENT;
    }
}
