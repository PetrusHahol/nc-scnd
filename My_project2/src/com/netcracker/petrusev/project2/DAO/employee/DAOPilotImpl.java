package com.netcracker.petrusev.project2.DAO.employee;

import com.netcracker.petrusev.project2.DAO.DAOInterface;
import com.netcracker.petrusev.project2.beans.entities.office.Employee;
import com.netcracker.petrusev.project2.beans.entities.office.Pilot;
import com.netcracker.petrusev.project2.beans.entities.office.Stewardess;
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
public class DAOPilotImpl implements DAOEmployeeInterface<Pilot> {
    @Override
    public void create(Pilot obj) throws SQLException {

    }

    @Override
    public void delete(Pilot obj) throws SQLException {

    }

    @Override
    public Pilot find(Pilot obj) throws SQLException {
        return null;
    }

    @Override
    public Pilot update(Pilot obj) throws SQLException {
        return null;
    }

    @Override
    public List<Pilot> allData() throws SQLException {
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
            answer.add(pilot);
        }
        ConnectionPool.INSTANCE.putBack(connection);
        return answer;
    }
}
