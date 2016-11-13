package com.netcracker.petrusev.project2.command.commands;
import com.netcracker.petrusev.project2.command.ActionCommand;
import com.netcracker.petrusev.project2.constants.PageConstants;

import javax.servlet.http.HttpServletRequest;

public class MainCommand implements ActionCommand {

 @Override
 public String execute(HttpServletRequest request) {

  return PageConstants.MAIN;
 }
}