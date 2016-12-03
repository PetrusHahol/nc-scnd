package com.netcracker.petrusev.project2.DAO;

import com.netcracker.petrusev.project2.beans.entities.office.Employee;
import com.netcracker.petrusev.project2.beans.entities.office.EmptyEmployee;
import com.netcracker.petrusev.project2.connections.ConnectionPool;
import com.netcracker.petrusev.project2.connections.DataMemory;
import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.SQLConstants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Petrusev
 * @version 1.0
 *
 */
public class DAOEmployeeImpl implements DAOInterface<Employee> {
    @Override
    public void create(Employee obj) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.retrieve();
        PreparedStatement info_statement = connection.prepareStatement(SQLConstants.ADD_INFORMATION);
        info_statement.setString(1,obj.getName());
        info_statement.setInt(2,obj.getAge());
        info_statement.setInt(3,obj.getHeight());
        info_statement.setInt(4,obj.getExperience());
        info_statement.setString(5,obj.getPassportData());
        ResultSet set = info_statement.executeQuery();
        while (set.next()){
            DataMemory.INSTANCE.setId(set.getInt(CommandConstants.ID));
        }
        ConnectionPool.INSTANCE.putBack(connection);
        set.close();
    }


    @Override
    public void delete(int id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.retrieve();
        PreparedStatement statement = connection.prepareStatement(SQLConstants.DELETE_INFORMATION);
        statement.setInt(1, id);
        statement.execute();
        ConnectionPool.INSTANCE.putBack(connection);
        statement.close();
    }

    @Override
    public Employee find(Integer id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.retrieve();
        Employee employee =  new EmptyEmployee();
        PreparedStatement statement = connection.prepareStatement(SQLConstants.GET_INFORMATION);
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
        statement.close();
        return employee;
    }

    @Override
    public Employee find(Employee obj) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(Employee obj) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Employee> getAllData() throws SQLException {
        throw new UnsupportedOperationException();
    }
}
