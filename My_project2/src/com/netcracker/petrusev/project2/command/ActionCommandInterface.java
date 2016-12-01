package com.netcracker.petrusev.project2.command;
import javax.servlet.http.HttpServletRequest;

public interface ActionCommandInterface {

String execute(HttpServletRequest request);

}