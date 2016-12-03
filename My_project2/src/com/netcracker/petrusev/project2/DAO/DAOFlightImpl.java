package com.netcracker.petrusev.project2.DAO;

import com.netcracker.petrusev.project2.beans.entities.flights.Flight;
import com.netcracker.petrusev.project2.connections.ConnectionPool;
import com.netcracker.petrusev.project2.constants.CommandConstants;
import com.netcracker.petrusev.project2.constants.SQLConstants;
import com.netcracker.petrusev.project2.utils.UtilsGregorianCalendar;

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
public class DAOFlightImpl implements DAOInterface<Flight>{

    /**
     * This is void if data access object. In this part create new object
     * of Flight and write his in data based with help open pool connections!
     * Create void have correct of data validation.
     *
     * @param  obj object of Flight with need parameters
     *
     */
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
    } else throw new SQLException("error");
        ConnectionPool.INSTANCE.putBack(connection);
        statement.close();
    }

    @Override
    public void delete(int id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.retrieve();
        PreparedStatement statement = connection.prepareStatement(SQLConstants.DELETE_FLIGHT);
        statement.setInt(1, id);
        statement.execute();
        ConnectionPool.INSTANCE.putBack(connection);
    }


    @Override
    public Flight find(Flight obj) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(Flight obj) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.retrieve();
        java.sql.Date date = new java.sql.Date(obj.getDate().getTime().getTime());
        PreparedStatement statement = connection.prepareStatement(SQLConstants.GET_FLIGHT_BY_DATA);//validation
        statement.setString(1, (obj.getFrom()));
        statement.setString(2, obj.getTo());
        statement.setDate(3, date);
        if (!statement.executeQuery().next()) {
            statement = connection.prepareStatement(SQLConstants.UPDATE_FLIGHT);
            statement.setString(1, (obj.getFrom()));
            statement.setString(2, obj.getTo());
            statement.setDate(3, date);
            statement.setInt(4,obj.getId());
            statement.executeUpdate();
        }
        statement.close();
        ConnectionPool.INSTANCE.putBack(connection);
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
        set.close();
        statement.close();
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
            flight.setId(id);
            flight.setFrom(set.getString(CommandConstants.FROM));
            flight.setTo(set.getString(CommandConstants.TO));
            flight.setDate(UtilsGregorianCalendar.INSTANCE.convertIntoGregorianCalendar(set.getTimestamp(CommandConstants.DATE)));
        }
        ConnectionPool.INSTANCE.putBack(connection);
        set.close();
        statement.close();
        return flight;
    }
}
