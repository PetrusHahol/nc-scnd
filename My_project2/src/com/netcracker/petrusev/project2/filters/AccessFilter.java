package com.netcracker.petrusev.project2.filters;

import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.FilterConstants;
import com.netcracker.petrusev.project2.constants.PageConstants;
import com.netcracker.petrusev.project2.constants.PermissionsConstants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Asus on 24.11.2016.
 */
public class AccessFilter implements Filter{


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (request.getSession(false) != null && request.getSession().getAttribute(CommandConstants.PRIORITY) != null) {
            if (request.getParameter(CommandConstants.COMMAND) != null)
            if (request.getParameter(CommandConstants.COMMAND).equals(FilterConstants.SIGNIN)
                || request.getParameter(CommandConstants.COMMAND).equals(FilterConstants.REGISTRATION)) {
                request.getRequestDispatcher(PageConstants.ACCESSEXEPTION).forward(request,response);
            }
        }
        if (request.getSession(false) != null && request.getSession().getAttribute(CommandConstants.PRIORITY) != null) {
            if (request.getParameter(CommandConstants.COMMAND) != null)
            if (request.getSession().getAttribute(CommandConstants.PRIORITY).equals(PermissionsConstants.USER)) {
                if (request.getParameter(CommandConstants.COMMAND).equals(FilterConstants.ADDBRIGADE) ||
                        request.getParameter(CommandConstants.COMMAND).equals(FilterConstants.DELETEBRIGADE) ||
                        request.getParameter(CommandConstants.COMMAND).equals(FilterConstants.DELETEFLIGHT) ||
                        request.getParameter(CommandConstants.COMMAND).equals(FilterConstants.ADDFLIGHT) ||
                        request.getParameter(CommandConstants.COMMAND).equals(FilterConstants.ADDEMPLOYEE) ||
                        request.getParameter(CommandConstants.COMMAND).equals(FilterConstants.DELETEEMPLOYEE)) {
                    request.getRequestDispatcher(PageConstants.ACCESSEXEPTION).forward(request, response);
                }
            }
        }

        if (request.getSession(false) != null && request.getSession().getAttribute(CommandConstants.PRIORITY) != null) {
            if (request.getSession().getAttribute(CommandConstants.PRIORITY).equals(PermissionsConstants.ADMIN)) {
                if (request.getParameter(CommandConstants.COMMAND).equals(FilterConstants.ADDBRIGADE) ||
                        request.getParameter(CommandConstants.COMMAND).equals(FilterConstants.DELETEBRIGADE) ||
                        request.getParameter(CommandConstants.COMMAND).equals(FilterConstants.ADDEMPLOYEE) ||
                        request.getParameter(CommandConstants.COMMAND).equals(FilterConstants.DELETEBRIGADE)) {
                    request.getRequestDispatcher(PageConstants.ACCESSEXEPTION).forward(request, response);
                }
            }
        }

        if (request.getSession(false) != null && request.getSession().getAttribute(CommandConstants.PRIORITY) != null) {
            if (request.getParameter(CommandConstants.COMMAND) != null)
            if (request.getSession().getAttribute(CommandConstants.PRIORITY).equals(PermissionsConstants.DISPATCHER)) {
                if (request.getParameter(CommandConstants.COMMAND).equals(FilterConstants.ADDFLIGHT) ||
                        request.getParameter(CommandConstants.COMMAND).equals(FilterConstants.DELETEFLIGHT)) {
                    request.getRequestDispatcher(PageConstants.ACCESSEXEPTION).forward(request, response);
                }
            }
        }


        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
