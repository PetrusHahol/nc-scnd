package com.netcracker.petrusev.project2.command.commands;

import com.netcracker.petrusev.project2.command.ActionCommand;
import com.netcracker.petrusev.project2.constants.PageConstants;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Asus on 24.11.2016.
 */
public class GetAccessExceptionCommand implements ActionCommand{
    @Override
    public String execute(HttpServletRequest request) {
        return PageConstants.NO_ACCESS;
    }
}
