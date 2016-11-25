package com.netcracker.petrusev.project2.DAO;

import com.netcracker.petrusev.project2.beans.entities.flights.Flight;
import com.netcracker.petrusev.project2.beans.entities.office.Employee;
import com.netcracker.petrusev.project2.beans.entities.office.EmptyEmployee;
import com.netcracker.petrusev.project2.connections.ConnectionPool;
import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.PermissionsConstants;
import com.netcracker.petrusev.project2.constants.SQLConstants;
import com.netcracker.petrusev.project2.utils.UtilsGregorianCalendar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 17.11.2016.
 */
public class DAOFlightImpl implements DAOInterface<Flight>{
    @Override
    public void create(Flight obj) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.retrieve();
        java.sql.Date date = new java.sql.Date(obj.getDate().getTime().getTime());
        PreparedStatement statement = connection.prepareStatement(SQLConstants.GET_FLIGHT_BY_DATA);//validation
        statement.setString(1, (obj.getFrom()));
        statement.setString(2, obj.getTo());
        statement.setDate(3, date);
        if (!statement.executeQuery().next()) {
            statement = connection.prepareStatement(SQLConstants.INSERT_FLIGHT);
            statement.setString(1, (obj.getFrom()));
            statement.setString(2, obj.getTo());
            statement.setDate(3, date);
            statement.executeUpdate();
        }
        ConnectionPool.INSTANCE.putBack(connection);
    }

    @Override
    public void delete(int id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.retrieve();
        PreparedStatement statement = connection.prepareStatement(SQLConstants.DELETE_FLIGHT);
        statement.setInt(1, id);
        statement.executeUpdate();
        ConnectionPool.INSTANCE.putBack(connection);
    }


    @Override
    public Flight find(Flight obj) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Flight update(Flight obj) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Flight> getAllData() throws SQLException {
        List<Flight> answer = new ArrayList<>();
        Connection connection  = ConnectionPool.INSTANCE.retrieve();
        PreparedStatement statement = connection.prepareStatement(SQLConstants.GET_ALL_FLIGHT);
        ResultSet set = statement.executeQuery();
        while(set.next()){
            Flight flight = new Flight();
            flight.setFrom(set.getString(CommandConstants.FROM));
            flight.setTo(set.getString(CommandConstants.TO));
            flight.setDate(UtilsGregorianCalendar.INSTANCE.convertIntoGregorianCalendar(set.getTimestamp(CommandConstants.DATE)));
            flight.setId(set.getInt(CommandConstants.ID));
            answer.add(flight);
        }
        ConnectionPool.INSTANCE.putBack(connection);
        return answer;
    }

    @Override
    public Flight find(Integer id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.retrieve();
        PreparedStatement statement = connection.prepareStatement(SQLConstants.FIND_FLIGHT);
        statement.setInt(1, id);
        Flight flight = new Flight();
        ResultSet set = statement.executeQuery();
        while (set.next()){
            flight.setFrom(set.getString(CommandConstants.FROM));
            flight.setTo(set.getString(CommandConstants.TO));
            flight.setDate(UtilsGregorianCalendar.INSTANCE.convertIntoGregorianCalendar(set.getString(CommandConstants.DATE)));
        }
        ConnectionPool.INSTANCE.putBack(connection);
        return flight;
    }
}
