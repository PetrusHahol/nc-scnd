package com.web.command;
import javax.servlet.http.HttpServletRequest;
public class RegistrationCommand implements ActionCommand {
 @Override
 public String execute(HttpServletRequest request) {
  //создание
  return "/registration.jsp";
 }
}