package com.netcracker.petrusev.project2.DAO.employee;

import com.netcracker.petrusev.project2.DAO.DAOEmployeeImpl;
import com.netcracker.petrusev.project2.DAO.DAOInterface;
import com.netcracker.petrusev.project2.beans.entities.office.Employee;
import com.netcracker.petrusev.project2.beans.entities.office.Navigator;
import com.netcracker.petrusev.project2.command.commands.brigade.AddBrigadeCommand;
import com.netcracker.petrusev.project2.connections.ConnectionPool;
import com.netcracker.petrusev.project2.connections.DataMemory;
import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.SQLConstants;
import com.netcracker.petrusev.project2.logger.LoggerError;

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
        statement.close();
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
        set.close();
        statement.close();
    }

    @Override
    public Navigator find(Integer id)  {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet set = null;
        Navigator navigator = null;
        try {
            connection = ConnectionPool.INSTANCE.retrieve();
            statement = connection.prepareStatement(SQLConstants.FIND_NAVIGATOR);
            statement.setInt(1, id);
            set = statement.executeQuery();
            navigator = new Navigator();
            while (set.next()) {
                DAOInterface<Employee> daoInformation = new DAOEmployeeImpl();
                daoInformation.find(Integer.valueOf(set.getString(CommandConstants.ID_INFORMATION)));
                Employee employee = (Employee) daoInformation.find(Integer.valueOf(set.getString(CommandConstants.ID_INFORMATION)));
                navigator.setName(employee.getName());
                navigator.setAge(employee.getAge());
                navigator.setExperience(employee.getExperience());
                navigator.setHeight(employee.getHeight());
                navigator.setPassportData(employee.getPassportData());
                navigator.setCategory(set.getString(CommandConstants.CATEGORY));
            }
        } catch (SQLException e) {
            LoggerError.INSTANCE.logError(AddBrigadeCommand.class, e.getMessage());
        } finally {
            try {
                set.close();
                statement.close();
            } catch (SQLException ex){
                LoggerError.INSTANCE.logError(AddBrigadeCommand.class, ex.getMessage());
            }
            finally {
                ConnectionPool.INSTANCE.putBack(connection);
            }
        }
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
        set.close();
        statement.close();
        return answer;
    }

    @Override
    public Navigator find(Navigator obj) throws SQLException {
        throw new UnsupportedOperationException();
    }
}
