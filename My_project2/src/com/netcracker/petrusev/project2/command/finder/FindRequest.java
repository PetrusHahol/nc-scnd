package com.netcracker.petrusev.project2.command.finder;

import com.netcracker.petrusev.project2.command.ActionCommandInterface;
import com.netcracker.petrusev.project2.command.enums.RequestsEnum;
import com.netcracker.petrusev.project2.command.commands.MainCommand;
import com.netcracker.petrusev.project2.constants.CommandConstants;

import javax.servlet.http.HttpServletRequest;


/**
 * @author Petrusev
 * @version 1.0
 *
 */
public class FindRequest {
    public ActionCommandInterface Command(HttpServletRequest request){
        String command = request.getParameter(CommandConstants.COMMAND);
        ActionCommandInterface current = null;
        try {
            RequestsEnum currentEnum = RequestsEnum.valueOf(command.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            current = new MainCommand();
        }
        return current;
    }
}
