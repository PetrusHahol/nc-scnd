package com.web.command.finder;

import com.web.command.ActionCommand;
import com.web.command.MainCommand;
import com.web.command.enums.RequestsEnum;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Asus on 10.11.2016.
 */
public class FindRequest {
    public ActionCommand Command(HttpServletRequest request){
        String command = request.getParameter("command");
        ActionCommand current = null;
        try {
            RequestsEnum currentEnum = RequestsEnum.valueOf(command.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            current = new MainCommand();
        }
        return current;
    }
}
