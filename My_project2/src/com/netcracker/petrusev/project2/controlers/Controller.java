package com.netcracker.petrusev.project2.controlers;

import com.netcracker.petrusev.project2.command.ActionCommandInterface;
import com.netcracker.petrusev.project2.command.commands.brigade.AddBrigadeCommand;
import com.netcracker.petrusev.project2.command.finder.FindRequest;
import com.netcracker.petrusev.project2.logger.LoggerError;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by Asus on 06.11.2016.
 */

@WebServlet("/Controller")
public class Controller extends HttpServlet{


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
        ActionCommandInterface findReq = new FindRequest().Command(req);
        String page = findReq.execute(req);
        req.getRequestDispatcher(page).forward(req,resp);
        } catch (ServletException e) {
            LoggerError.INSTANCE.logError(AddBrigadeCommand.class, e.getMessage());

        } catch (IOException e) {
            LoggerError.INSTANCE.logError(AddBrigadeCommand.class, e.getMessage());
        }
    }


}
