package com.netcracker.petrusev.project2.DAO.employee;

import com.netcracker.petrusev.project2.DAO.DAOInterface;
import com.netcracker.petrusev.project2.beans.entities.office.Employee;
import com.netcracker.petrusev.project2.beans.entities.office.Navigator;
import com.netcracker.petrusev.project2.beans.entities.office.Pilot;
import com.netcracker.petrusev.project2.connections.ConnectionPool;
import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.SQLConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 20.11.2016.
 */
public class DAONavigatorImpl implements  DAOEmployeeInterface<Navigator> {
    @Override
    public void create(Navigator obj) throws SQLException {

    }

    @Override
    public void delete(Navigator obj) throws SQLException {

    }

    @Override
    public Navigator find(Navigator obj) throws SQLException {
        return null;
    }

    @Override
    public Navigator update(Navigator obj) throws SQLException {
        return null;
    }

    @Override
    public List<Navigator> allData() throws SQLException {
        List<Navigator> answer = new ArrayList<>();
        Connection connection = ConnectionPool.INSTANCE.retrieve();
        PreparedStatement statement = connection.prepareStatement(SQLConstants.GET_NAVIGATOR);
        ResultSet set = statement.executeQuery();
        while(set.next()){
            DAOInterface daoInformation = new DAOInformationImpl();
            Navigator navigator = new Navigator();
            Employee employee = (Employee) daoInformation.find(set.getInt(CommandConstants.ID_INFORMATION));
            navigator.setName(employee.getName());
            navigator.setAge(employee.getAge());
            navigator.setExperience(employee.getExperience());
            navigator.setHeight(employee.getHeight());
            navigator.setPassportData(employee.getPassportData());
            navigator.setCategory(set.getString(CommandConstants.CATEGORY));
            answer.add(navigator);
        }
        ConnectionPool.INSTANCE.putBack(connection);
        return answer;
    }
}
