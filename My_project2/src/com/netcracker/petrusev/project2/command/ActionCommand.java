package com.netcracker.petrusev.project2.command;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Petrusev
 * @version 1.0
 *
 */
public interface ActionCommand {

String execute(HttpServletRequest request);

}