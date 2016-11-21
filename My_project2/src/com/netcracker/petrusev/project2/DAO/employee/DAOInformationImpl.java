package com.netcracker.petrusev.project2.DAO.employee;

import com.netcracker.petrusev.project2.DAO.DAOInterface;
import com.netcracker.petrusev.project2.beans.entities.office.Employee;
import com.netcracker.petrusev.project2.beans.entities.office.EmptyEmployee;
import com.netcracker.petrusev.project2.connections.ConnectionPool;
import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.SQLConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Asus on 20.11.2016.
 */
public class DAOInformationImpl implements DAOInterface<Employee> {
    @Override
    public void create(Employee obj) throws SQLException {

    }

    @Override
    public void delete(Employee obj) throws SQLException {

    }

    @Override
    public Employee find(Integer id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.retrieve();
        Employee employee =  new EmptyEmployee();
        PreparedStatement statement = connection.prepareStatement(SQLConstants.GET_EMPLOYEE);
        statement.setInt(1, id);
        ResultSet setInfo = statement.executeQuery();
        while (setInfo.next()) {
            employee.setName(setInfo.getString(CommandConstants.NAME));
            employee.setAge(setInfo.getInt(CommandConstants.AGE));
            employee.setExperience(setInfo.getInt(CommandConstants.EXPERIENCE));
            employee.setHeight(setInfo.getInt(CommandConstants.HEIGHT));
            employee.setPassportData(setInfo.getString(CommandConstants.PASSPORT_DATA));
        }
        ConnectionPool.INSTANCE.putBack(connection);
        return employee;
    }

    @Override
    public Employee find(Employee obj) throws SQLException {
        return null;
    }

    @Override
    public Employee update(Employee obj) throws SQLException {
        return null;
    }

    @Override
    public List<Employee> allData() throws SQLException {
        return null;
    }
}
