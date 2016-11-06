package com.web.servlets;

import com.web.servlets.utils.JDBC;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by Asus on 06.11.2016.
 */
public class firstServlet extends HttpServlet{
    JDBC user = new JDBC();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("inf", 150);
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = user.getConnection().prepareStatement("SELECT * FROM information");
            ResultSet answer = preparedStatement.executeQuery();
            while (answer.next()) {
                System.out.println("Номер в выборке #" + answer.getRow()
                        + "\t Номер в базе #" + answer.getInt("id")
                        + "\t" + answer.getInt("age"));
            }

        } catch (SQLException e) {
            System.out.println("SKAAAAAAAA");
        }
        System.out.println("SKAAAAAAAA");
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
