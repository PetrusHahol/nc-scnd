package com.netcracker.petrusev.project2.command.commands;

import com.netcracker.petrusev.project2.command.ActionCommand;
import com.netcracker.petrusev.project2.constants.PageConstants;

import javax.servlet.http.HttpServletRequest;


/**
 * @author Petrusev
 * @version 1.0
 *
 */
public class GetAccessExceptionCommand implements ActionCommand{
    @Override
    public String execute(HttpServletRequest request) {
        return PageConstants.NO_ACCESS;
    }
}
