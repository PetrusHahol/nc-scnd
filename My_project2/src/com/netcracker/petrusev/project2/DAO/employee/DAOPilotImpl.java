package com.netcracker.petrusev.project2.DAO.employee;

import com.netcracker.petrusev.project2.DAO.DAOInformationImpl;
import com.netcracker.petrusev.project2.DAO.DAOInterface;
import com.netcracker.petrusev.project2.beans.entities.office.Employee;
import com.netcracker.petrusev.project2.beans.entities.office.Navigator;
import com.netcracker.petrusev.project2.beans.entities.office.Pilot;
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
public class DAOPilotImpl implements DAOEmployeeInterface<Pilot> {
    @Override
    public void create(Pilot obj) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.retrieve();
        PreparedStatement statement = connection.prepareStatement(SQLConstants.ADD_PILOT);
        DAOInterface<Employee> daoInformation = new DAOInformationImpl();
        daoInformation.create(obj);
        statement.setInt(1, obj.getMileage());
        statement.setInt(2 , DataMemory.INSTANCE.getId());
        statement.execute();
        ConnectionPool.INSTANCE.putBack(connection);
    }

    @Override
    public void delete(int id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.retrieve();
        PreparedStatement statement = connection.prepareStatement(SQLConstants.DELETE_PILOT);
        statement.setInt(1, id);
        ResultSet set = statement.executeQuery();
        while(set.next()){
            DAOInterface<Employee> daoInformation = new DAOInformationImpl();
            daoInformation.delete(Integer.valueOf(set.getString(CommandConstants.ID_INFORMATION)));
        }
        ConnectionPool.INSTANCE.putBack(connection);
    }

    @Override
    public Pilot find(int id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.retrieve();
        PreparedStatement statement = connection.prepareStatement(SQLConstants.FIND_PILOT);
        statement.setInt(1, id);
        ResultSet set = statement.executeQuery();
        Pilot pilot = new Pilot();
        while(set.next()){
            DAOInterface<Employee> daoInformation = new DAOInformationImpl();
            daoInformation.find(Integer.valueOf(set.getString(CommandConstants.ID_INFORMATION)));
            Employee employee =(Employee) daoInformation.find(Integer.valueOf(set.getString(CommandConstants.ID_INFORMATION)));
            pilot.setName(employee.getName());
            pilot.setAge(employee.getAge());
            pilot.setExperience(employee.getExperience());
            pilot.setHeight(employee.getHeight());
            pilot.setPassportData(employee.getPassportData());
            pilot.setMileage(set.getInt(CommandConstants.MILEAGE));
        }
        ConnectionPool.INSTANCE.putBack(connection);
        return pilot;
    }

    @Override
    public Pilot update(Pilot obj) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Pilot> getAllData() throws SQLException {
        List<Pilot> answer = new ArrayList<>();
        Connection connection = ConnectionPool.INSTANCE.retrieve();
        PreparedStatement statement = connection.prepareStatement(SQLConstants.GET_PILOT);
        ResultSet set = statement.executeQuery();
        while(set.next()){
            DAOInterface daoInformation = new DAOInformationImpl();
            Pilot pilot = new Pilot();
            Employee employee = (Employee) daoInformation.find(set.getInt(CommandConstants.ID_INFORMATION));
            pilot.setName(employee.getName());
            pilot.setAge(employee.getAge());
            pilot.setExperience(employee.getExperience());
            pilot.setHeight(employee.getHeight());
            pilot.setPassportData(employee.getPassportData());
            pilot.setMileage(set.getInt(CommandConstants.MILEAGE));
            pilot.setId(set.getInt(CommandConstants.ID));
            answer.add(pilot);
        }
        ConnectionPool.INSTANCE.putBack(connection);
        return answer;
    }
}
