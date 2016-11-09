package com.web.servlets;

import com.web.administrators.Admin;
import com.web.utils.JDBC;

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

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = admin.info();
            ResultSet answer = preparedStatement.executeQuery();
            List<String> from = new ArrayList();
            List<String> to = new ArrayList();
            List<String> date = new ArrayList();

            while (answer.next()) {
                from.add(answer.getString("city_from"));
                to.add(answer.getString("city_to"));
                date.add(answer.getTimestamp("flight_date").toString());
            }
            req.setAttribute("from", from);
            req.setAttribute("to", to);
            req.setAttribute("date", date);
            System.out.println(date.size()-1);
            req.setAttribute("size", date.size()-1);

        } catch (SQLException e) {
            System.out.println("SKAAAAAAAA((9((");
        }
        System.out.println("SKAAAAAAAA");
        System.err.println(req);
        System.err.println(resp);
        try {
            System.out.println();
            System.out.println(req.getParameter("username"));
            String name = req.getParameter("command") + ".jsp";
            req.getRequestDispatcher(name).forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
