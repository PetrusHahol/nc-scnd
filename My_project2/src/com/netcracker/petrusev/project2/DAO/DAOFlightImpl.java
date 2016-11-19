package com.netcracker.petrusev.project2.DAO;

import com.netcracker.petrusev.project2.beans.entities.flights.Flight;
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
        PreparedStatement statement = connection.prepareStatement(SQLConstants.INSERT_FLIGHT);
        java.sql.Date date = new java.sql.Date(obj.getDate().getTime().getTime());

        statement.setString(1, (obj.getFrom()));
        statement.setString(2, obj.getTo());
        statement.setDate(3, date);
        statement.executeUpdate();
        ConnectionPool.INSTANCE.putBack(connection);
    }

    @Override
    public void delete(Flight obj) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Flight find(Flight obj) throws SQLException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Flight update(Flight obj) throws SQLException {
        throw new UnsupportedOperationException();
    }
//15/37/40/04/228228


    @Override
    public List<Flight> allData() throws SQLException {
        List<Flight> answer = new ArrayList<>();
        Connection connection  = ConnectionPool.INSTANCE.retrieve();
        PreparedStatement statement = connection.prepareStatement(SQLConstants.GET_ALL_FLIGHT);
        ResultSet set = statement.executeQuery();
        while(set.next()){
            Flight flight = new Flight();
            flight.setFrom(set.getString(CommandConstants.FROM));
            flight.setTo(set.getString(CommandConstants.TO));
            flight.setDate(UtilsGregorianCalendar.INSTANCE.convertIntoGregorianCalendar(set.getTimestamp(CommandConstants.DATE)));
            answer.add(flight);
        }
        ConnectionPool.INSTANCE.putBack(connection);
        return answer;
    }
}
