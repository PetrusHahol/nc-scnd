package com.netcracker.petrusev.project2.command.commands;

import com.netcracker.petrusev.project2.command.ActionCommand;
import com.netcracker.petrusev.project2.constants.PageConstants;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Asus on 13.11.2016.
 */
public class UserContent implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request) {
        return PageConstants.USER_CONTENT;
    }
}
