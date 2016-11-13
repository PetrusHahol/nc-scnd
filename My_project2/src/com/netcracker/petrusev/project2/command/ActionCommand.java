package com.netcracker.petrusev.project2.command;
import javax.servlet.http.HttpServletRequest;
public interface ActionCommand {

String execute(HttpServletRequest request);

}