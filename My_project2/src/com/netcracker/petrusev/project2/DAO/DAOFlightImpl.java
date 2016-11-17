package com.netcracker.petrusev.project2.DAO;

import com.netcracker.petrusev.project2.beans.entities.flights.Flight;
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
 * Created by Asus on 17.11.2016.
 */
public class DAOFlightImpl implements DAOInterface<Flight>{
    @Override
    public void create(Flight obj) throws SQLException {

    }

    @Override
    public void delete(Flight obj) throws SQLException {

    }

    @Override
    public Flight find(Flight obj) throws SQLException {
        return null;
    }

    @Override
    public Flight update(Flight obj) throws SQLException {
        return null;
    }
//15/37/40/04/228228

    @Override
    public List<Flight> allData() throws SQLException {
        List<Flight> answer = new ArrayList<>();
        Connection connection  = ConnectionPool.INSTANS.retrieve();
        PreparedStatement statement = connection.prepareStatement(SQLConstants.GET_ALL_FLIGHT);
        ResultSet set = statement.executeQuery();
        while(set.next()){
            Flight flight = new Flight();
            flight.setFrom(set.getString(CommandConstants.from));
            flight.setTo(set.getString(CommandConstants.to));
            //flight.setDate(set.getTimestamp(CommandConstants.date)); do date
            answer.add(flight);
        }
        ConnectionPool.INSTANS.putBack(connection);
        return answer;
    }
}
