package com.netcracker.petrusev.project2.DAO.employee;

import com.netcracker.petrusev.project2.DAO.DAOInformationImpl;
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
 * Created by Asus on 20.11.2016.
 */
public class DAORadiomanImpl implements DAOEmployeeInterface<Radioman> {
    @Override
    public void create(Radioman obj) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.retrieve();
        PreparedStatement statement = connection.prepareStatement(SQLConstants.ADD_RADIOMAN);
        DAOInterface<Employee> daoInformation = new DAOInformationImpl();
        daoInformation.create(obj);
        statement.setInt(1, obj.getCountForeignLanguage());
        statement.setInt(2 , DataMemory.INSTANCE.getId());
        statement.execute();
        ConnectionPool.INSTANCE.putBack(connection);
    }

    @Override
    public void delete(int id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.retrieve();
        PreparedStatement statement = connection.prepareStatement(SQLConstants.DELETE_RADIOMAN);
        statement.setInt(1, id);
        ResultSet set = statement.executeQuery();
        while(set.next()){
            DAOInterface<Employee> daoInformation = new DAOInformationImpl();
            daoInformation.delete(Integer.valueOf(set.getString(CommandConstants.ID_INFORMATION)));
        }
        ConnectionPool.INSTANCE.putBack(connection);
    }

    @Override
    public Radioman find(Radioman obj) throws SQLException {
        return null;
    }

    @Override
    public Radioman update(Radioman obj) throws SQLException {
        return null;
    }

    @Override
    public List<Radioman> getAllData() throws SQLException {
        List<Radioman> answer = new ArrayList<>();
        Connection connection = ConnectionPool.INSTANCE.retrieve();
        PreparedStatement statement = connection.prepareStatement(SQLConstants.GET_RADIOMAN);
        ResultSet set = statement.executeQuery();
        while(set.next()){
            DAOInterface daoInformation = new DAOInformationImpl();
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
        return answer;
    }
}
