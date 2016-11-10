package com.web.command;
import javax.servlet.http.HttpServletRequest;

public class MainCommand implements ActionCommand {

@Override
public String execute(HttpServletRequest request) {

 return "/main.jsp";
}
}