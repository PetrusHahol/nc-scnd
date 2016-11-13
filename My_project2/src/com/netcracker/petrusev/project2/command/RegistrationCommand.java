package com.netcracker.petrusev.project2.command;
import com.netcracker.petrusev.project2.connections.JDBC;
import com.netcracker.petrusev.project2.constants.SQLConstants;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

public class RegistrationCommand implements ActionCommand {
    private String page = null;
    private String login = null;
    private String firstName = null;
    private String secondName = null;
    private String mail = null;
    private String password1 = null;
    private String password2 = null;

    private boolean getParameters(HttpServletRequest request) {
        login = request.getParameter("login");
        firstName = request.getParameter("firstname");
        secondName = request.getParameter("secondname");
        mail = request.getParameter("mail");
        password1 = request.getParameter("password1");
        password2 = request.getParameter("password2");
        return (password1.equals(password2) && login !=null &&
                firstName != null && secondName != null && password1!=null);
    }

    private String setParameters(){
        try {
            JDBC jdbc = new JDBC();
            Connection connection = jdbc.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQLConstants.addUser(login,firstName, secondName,mail,password1,false));
        } catch (SQLException e) {
            e.printStackTrace();
            return "/jsps/registration.jsp";
        }

        return  "/jsps/main.jsp";
    }

    @Override
     public String execute(HttpServletRequest request) {

        String registration = request.getParameter("reg");

        if (registration.equals("true")){
              if (getParameters(request))
                  return setParameters();
        }

      return "/jsps/registration.jsp";
     }
}