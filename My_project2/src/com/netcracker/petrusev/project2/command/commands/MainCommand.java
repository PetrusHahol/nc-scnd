package com.netcracker.petrusev.project2.command.commands;
import com.netcracker.petrusev.project2.command.ActionCommand;
import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.PageConstants;
import com.netcracker.petrusev.project2.constants.PermissionsConstants;

import javax.servlet.http.HttpServletRequest;

public class MainCommand implements ActionCommand {

 @Override
 public String execute(HttpServletRequest request) {
  try {
   System.err.println();
   if (request.getSession().getAttribute(PermissionsConstants.USER).toString() != null)
    return PageConstants.USER_CONTENT_REQUEST;
  } catch (Exception ex) {
   return PageConstants.MAIN;
  }
  return PageConstants.MAIN;
 }
}