package com.netcracker.petrusev.project2.DAO.employee;

import com.netcracker.petrusev.project2.DAO.DAOInformationImpl;
import com.netcracker.petrusev.project2.DAO.DAOInterface;
import com.netcracker.petrusev.project2.beans.entities.office.Employee;
import com.netcracker.petrusev.project2.beans.entities.office.Stewardess;
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
public class DAOStewardessImpl implements DAOEmployeeInterface<Stewardess> {

    @Override
    public void create(Stewardess obj) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.retrieve();
        PreparedStatement statement = connection.prepareStatement(SQLConstants.ADD_STEWARDESS);
        DAOInterface<Employee> daoInformation = new DAOInformationImpl();
        daoInformation.create(obj);
        statement.setInt(1, obj.getLengthWaist());
        statement.setInt(2 , DataMemory.INSTANCE.getId());
        statement.execute();
        ConnectionPool.INSTANCE.putBack(connection);
    }

    @Override
    public void delete(int id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.retrieve();
        PreparedStatement statement = connection.prepareStatement(SQLConstants.DELETE_STEWARDESS);
        statement.setInt(1, id);
        ResultSet set = statement.executeQuery();
        while(set.next()){
            DAOInterface<Employee> daoInformation = new DAOInformationImpl();
            daoInformation.delete(Integer.valueOf(set.getString(CommandConstants.ID_INFORMATION)));
        }
        ConnectionPool.INSTANCE.putBack(connection);
    }

    @Override
    public Stewardess find(int id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.retrieve();
        PreparedStatement statement = connection.prepareStatement(SQLConstants.FIND_STEWARDESS);
        statement.setInt(1, id);
        ResultSet set = statement.executeQuery();
        Stewardess stewardess = new Stewardess();
        while(set.next()){
            DAOInterface<Employee> daoInformation = new DAOInformationImpl();
            daoInformation.find(Integer.valueOf(set.getString(CommandConstants.ID_INFORMATION)));
            Employee employee =(Employee) daoInformation.find(Integer.valueOf(set.getString(CommandConstants.ID_INFORMATION)));
            stewardess.setName(employee.getName());
            stewardess.setAge(employee.getAge());
            stewardess.setExperience(employee.getExperience());
            stewardess.setHeight(employee.getHeight());
            stewardess.setPassportData(employee.getPassportData());
            stewardess.setLengthWaist(set.getInt(CommandConstants.LENGTH_WAIST));
        }
        ConnectionPool.INSTANCE.putBack(connection);
        return stewardess;
    }

    @Override
    public Stewardess update(Stewardess obj) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Stewardess> getAllData() throws SQLException {
        List<Stewardess> answer = new ArrayList<>();
        Connection connection = ConnectionPool.INSTANCE.retrieve();
        PreparedStatement statement = connection.prepareStatement(SQLConstants.GET_STEWARDESS);
        ResultSet set = statement.executeQuery();
        while(set.next()){
            DAOInterface daoInformation = new DAOInformationImpl();
            Stewardess stewardess = new Stewardess();
            Employee employee = (Employee) daoInformation.find(set.getInt(CommandConstants.ID_INFORMATION));
            stewardess.setName(employee.getName());
            stewardess.setAge(employee.getAge());
            stewardess.setExperience(employee.getExperience());
            stewardess.setHeight(employee.getHeight());
            stewardess.setPassportData(employee.getPassportData());
            stewardess.setLengthWaist(set.getInt(CommandConstants.LENGTH_WAIST));
            stewardess.setId(set.getInt(CommandConstants.ID));
            answer.add(stewardess);
        }
        ConnectionPool.INSTANCE.putBack(connection);
        return answer;
    }
}
