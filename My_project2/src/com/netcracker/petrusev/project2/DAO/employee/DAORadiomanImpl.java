package com.netcracker.petrusev.project2.DAO.employee;

import com.netcracker.petrusev.project2.DAO.DAOEmployeeImpl;
import com.netcracker.petrusev.project2.DAO.DAOInterface;
import com.netcracker.petrusev.project2.beans.entities.office.Employee;
import com.netcracker.petrusev.project2.beans.entities.office.Radioman;
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
public class DAORadiomanImpl implements DAOInterface<Radioman> {
    @Override
    public Radioman find(Radioman obj) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void create(Radioman obj) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.retrieve();
        PreparedStatement statement = connection.prepareStatement(SQLConstants.ADD_RADIOMAN);
        DAOInterface<Employee> daoInformation = new DAOEmployeeImpl();
        daoInformation.create(obj);
        statement.setInt(1, obj.getCountForeignLanguage());
        statement.setInt(2 , DataMemory.INSTANCE.getId());
        statement.execute();
        statement.close();
        ConnectionPool.INSTANCE.putBack(connection);
    }

    @Override
    public void delete(int id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.retrieve();
        PreparedStatement statement = connection.prepareStatement(SQLConstants.DELETE_RADIOMAN);
        statement.setInt(1, id);
        ResultSet set = statement.executeQuery();
        while(set.next()){
            DAOInterface<Employee> daoInformation = new DAOEmployeeImpl();
            daoInformation.delete(Integer.valueOf(set.getString(CommandConstants.ID_INFORMATION)));
        }
        set.close();
        statement.close();
        ConnectionPool.INSTANCE.putBack(connection);
    }

    @Override
    public Radioman find(Integer id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.retrieve();
        PreparedStatement statement = connection.prepareStatement(SQLConstants.FIND_RADIOMAN);
        statement.setInt(1, id);
        ResultSet set = statement.executeQuery();
        Radioman radioman = new Radioman();
        while(set.next()){
            DAOInterface<Employee> daoInformation = new DAOEmployeeImpl();
            daoInformation.find(Integer.valueOf(set.getString(CommandConstants.ID_INFORMATION)));
            Employee employee =(Employee) daoInformation.find(Integer.valueOf(set.getString(CommandConstants.ID_INFORMATION)));
            radioman.setName(employee.getName());
            radioman.setAge(employee.getAge());
            radioman.setExperience(employee.getExperience());
            radioman.setHeight(employee.getHeight());
            radioman.setPassportData(employee.getPassportData());
            radioman.setCountForeignLanguage(set.getInt(CommandConstants.COUNT_FOREIGN_LANGUAGE));
        }
        ConnectionPool.INSTANCE.putBack(connection);
        set.close();
        statement.close();
        return radioman;
    }

    @Override
    public void update(Radioman obj) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Radioman> getAllData() throws SQLException {
        List<Radioman> answer = new ArrayList<>();
        Connection connection = ConnectionPool.INSTANCE.retrieve();
        PreparedStatement statement = connection.prepareStatement(SQLConstants.GET_RADIOMAN);
        ResultSet set = statement.executeQuery();
        while(set.next()){
            DAOInterface daoInformation = new DAOEmployeeImpl();
            Radioman radioman = new Radioman();
            Employee employee = (Employee) daoInformation.find(set.getInt(CommandConstants.ID_INFORMATION));
            radioman.setName(employee.getName());
            radioman.setAge(employee.getAge());
            radioman.setExperience(employee.getExperience());
            radioman.setHeight(employee.getHeight());
            radioman.setPassportData(employee.getPassportData());
            radioman.setCountForeignLanguage(set.getInt(CommandConstants.COUNT_FOREIGN_LANGUAGE));
            radioman.setId(set.getInt(CommandConstants.ID));
            answer.add(radioman);
        }
        ConnectionPool.INSTANCE.putBack(connection);
        set.close();
        statement.close();
        return answer;
    }
}
