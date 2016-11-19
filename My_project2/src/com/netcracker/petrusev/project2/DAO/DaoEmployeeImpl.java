package com.netcracker.petrusev.project2.DAO;

import com.netcracker.petrusev.project2.beans.entities.office.Employee;
import com.netcracker.petrusev.project2.beans.entities.office.Stewardess;
import com.netcracker.petrusev.project2.connections.ConnectionPool;
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
public class DAOEmployeeImpl implements DAOInterface<Employee>{


    @Override
    public void create(Employee obj) throws SQLException {
    }

    @Override
    public void delete(Employee obj) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Employee find(Employee obj) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Employee update(Employee obj) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Employee> allData() throws SQLException {
        List<Employee> answer = new ArrayList<Employee>();
        Connection connection = ConnectionPool.INSTANCE.retrieve();
        PreparedStatement statement = connection.prepareStatement(SQLConstants.GET_STEWARDESS);
        ResultSet set = statement.executeQuery();
        while(set.next()){
            statement = connection.prepareStatement(SQLConstants.GET_EMPLOYEE);
            Stewardess stewardess = new Stewardess();
            stewardess.setLengthWaist(set.getInt("length_waist"));
            statement.setInt(1,set.getInt("id_information"));
            ResultSet setInfo = statement.executeQuery();
            while (setInfo.next()) {
                stewardess.setAge(setInfo.getInt("age"));
                stewardess.setExperience(setInfo.getInt("experience"));
                stewardess.setHeight(setInfo.getInt("height"));
                stewardess.setPassportData(setInfo.getString("passport_data"));
            }
            answer.add(stewardess);
        }
        ConnectionPool.INSTANCE.putBack(connection);
        return answer;
    }
}
