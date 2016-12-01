package com.netcracker.petrusev.project2.command.commands;

import com.netcracker.petrusev.project2.command.ActionCommandInterface;
import com.netcracker.petrusev.project2.constants.PageConstants;

import javax.servlet.http.HttpServletRequest;


/**
 * @author Petrusev
 * @version 1.0
 *
 */
public class GetAccessExceptionCommand implements ActionCommandInterface {
    @Override
    public String execute(HttpServletRequest request) {
        return PageConstants.NO_ACCESS;
    }
}
