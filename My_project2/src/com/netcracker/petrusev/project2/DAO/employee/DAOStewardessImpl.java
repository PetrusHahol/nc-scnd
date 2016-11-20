package com.netcracker.petrusev.project2.DAO.employee;

import com.netcracker.petrusev.project2.DAO.DAOInterface;
import com.netcracker.petrusev.project2.beans.entities.office.Employee;
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
 * Created by Asus on 18.11.2016.
 */
public class DAOStewardessImpl implements DAOEmployeeInterface<Stewardess> {

    @Override
    public void create(Stewardess obj) throws SQLException {

    }

    @Override
    public void delete(Stewardess obj) throws SQLException {

    }

    @Override
    public Stewardess find(Stewardess obj) throws SQLException {
        return null;
    }

    @Override
    public Stewardess update(Stewardess obj) throws SQLException {
        return null;
    }

    @Override
    public List<Stewardess> allData() throws SQLException {
        List<Stewardess> answer = new ArrayList<>();
        Connection connection = ConnectionPool.INSTANCE.retrieve();
        PreparedStatement statement = connection.prepareStatement(SQLConstants.GET_STEWARDESS);
        ResultSet set = statement.executeQuery();
        while(set.next()){
            DAOInterface daoInformation = new DAOInformationImpl();
            Stewardess stewardess = new Stewardess();
            Employee employee = (Employee) daoInformation.find(set.getInt(CommandConstants.ID_INFORMATION));
            stewardess.setAge(employee.getAge());
            stewardess.setExperience(employee.getExperience());
            stewardess.setHeight(employee.getHeight());
            stewardess.setPassportData(employee.getPassportData());
            stewardess.setLengthWaist(set.getInt(CommandConstants.LENGTH_WAIST));
            answer.add(stewardess);
        }
        ConnectionPool.INSTANCE.putBack(connection);
        return answer;
    }
}
