package com.netcracker.petrusev.project2.DAO.employee;

import com.netcracker.petrusev.project2.DAO.DAOEmployeeImpl;
import com.netcracker.petrusev.project2.DAO.DAOInterface;
import com.netcracker.petrusev.project2.beans.entities.office.Employee;
import com.netcracker.petrusev.project2.beans.entities.office.Navigator;
import com.netcracker.petrusev.project2.connections.ConnectionPool;
import com.netcracker.petrusev.project2.connections.DataMemory;
import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.SQLConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Petrusev
 * @version 1.0
 *
 */
public class DAONavigatorImpl implements  DAOInterface<Navigator> {
    @Override
    public void create(Navigator obj) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.retrieve();
        PreparedStatement statement = connection.prepareStatement(SQLConstants.ADD_NAVIGATOR);
        DAOInterface<Employee> daoInformation = new DAOEmployeeImpl();
        daoInformation.create(obj);
        statement.setString(1, (String) obj.getCategory());
        statement.setInt(2 , DataMemory.INSTANCE.getId());
        statement.execute();
        ConnectionPool.INSTANCE.putBack(connection);
    }

    @Override
    public void delete(int id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.retrieve();
        PreparedStatement statement = connection.prepareStatement(SQLConstants.DELETE_NAVIGATOR);
        statement.setInt(1, id);
        ResultSet set = statement.executeQuery();
        while(set.next()){
            DAOInterface<Employee> daoInformation = new DAOEmployeeImpl();
            daoInformation.delete(Integer.valueOf(set.getString(CommandConstants.ID_INFORMATION)));
        }
        ConnectionPool.INSTANCE.putBack(connection);
    }

    @Override
    public Navigator find(Integer id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.retrieve();
        PreparedStatement statement = connection.prepareStatement(SQLConstants.FIND_NAVIGATOR);
        statement.setInt(1, id);
        ResultSet set = statement.executeQuery();
        Navigator navigator = new Navigator();
        while(set.next()){
            DAOInterface<Employee> daoInformation = new DAOEmployeeImpl();
            daoInformation.find(Integer.valueOf(set.getString(CommandConstants.ID_INFORMATION)));
            Employee employee =(Employee) daoInformation.find(Integer.valueOf(set.getString(CommandConstants.ID_INFORMATION)));
            navigator.setName(employee.getName());
            navigator.setAge(employee.getAge());
            navigator.setExperience(employee.getExperience());
            navigator.setHeight(employee.getHeight());
            navigator.setPassportData(employee.getPassportData());
            navigator.setCategory(set.getString(CommandConstants.CATEGORY));
        }
        ConnectionPool.INSTANCE.putBack(connection);
        return navigator;
    }

    @Override
    public void update(Navigator obj) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Navigator> getAllData() throws SQLException {
        List<Navigator> answer = new ArrayList<>();
        Connection connection = ConnectionPool.INSTANCE.retrieve();
        PreparedStatement statement = connection.prepareStatement(SQLConstants.GET_NAVIGATOR);
        ResultSet set = statement.executeQuery();
        while(set.next()){
            DAOInterface daoInformation = new DAOEmployeeImpl();
            Navigator navigator = new Navigator();
            Employee employee = (Employee) daoInformation.find(set.getInt(CommandConstants.ID_INFORMATION));
            navigator.setName(employee.getName());
            navigator.setAge(employee.getAge());
            navigator.setExperience(employee.getExperience());
            navigator.setHeight(employee.getHeight());
            navigator.setPassportData(employee.getPassportData());
            navigator.setCategory(set.getString(CommandConstants.CATEGORY));
            navigator.setId(set.getInt(CommandConstants.ID));
            answer.add(navigator);
        }
        ConnectionPool.INSTANCE.putBack(connection);
        return answer;
    }

    @Override
    public Navigator find(Navigator obj) throws SQLException {
        throw new UnsupportedOperationException();
    }
}
