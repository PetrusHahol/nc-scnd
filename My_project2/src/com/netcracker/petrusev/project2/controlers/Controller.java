package com.netcracker.petrusev.project2.controlers;

import com.netcracker.petrusev.project2.beans.users.Admin;
import com.netcracker.petrusev.project2.connections.JDBC;
import com.netcracker.petrusev.project2.command.ActionCommand;
import com.netcracker.petrusev.project2.command.finder.FindRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


/**
 * Created by Asus on 06.11.2016.
 */

@WebServlet("/Controller")
public class Controller extends HttpServlet{

    JDBC user = new JDBC();
    Admin admin = new Admin();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        servletProcessing(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        servletProcessing(req, resp);
    }

    private void servletProcessing(HttpServletRequest req, HttpServletResponse resp){
        try {
        ActionCommand findReq = new FindRequest().Command(req);
        String page = findReq.execute(req);req.getRequestDispatcher(page).forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
