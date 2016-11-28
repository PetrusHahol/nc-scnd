package com.netcracker.petrusev.project2.command.commands.locale;

import com.netcracker.petrusev.project2.command.ActionCommand;
import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.PageConstants;
import com.netcracker.petrusev.project2.properties.LocaleData;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Asus on 29.11.2016.
 */
public class SetLanguage implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        LocaleData.INSTANCE.setLocale(request.getParameter(CommandConstants.LANGUAGE));
        return PageConstants.USER_CONTENT;
    }
}
