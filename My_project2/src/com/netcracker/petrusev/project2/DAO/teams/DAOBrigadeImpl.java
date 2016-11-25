package com.netcracker.petrusev.project2.DAO.teams;

import com.netcracker.petrusev.project2.DAO.DAOFlightImpl;
import com.netcracker.petrusev.project2.DAO.DAOInterface;
import com.netcracker.petrusev.project2.DAO.employee.*;
import com.netcracker.petrusev.project2.beans.entities.flights.Flight;
import com.netcracker.petrusev.project2.beans.entities.office.Navigator;
import com.netcracker.petrusev.project2.beans.entities.office.Pilot;
import com.netcracker.petrusev.project2.beans.entities.office.Radioman;
import com.netcracker.petrusev.project2.beans.entities.office.Stewardess;
import com.netcracker.petrusev.project2.beans.entities.teams.Brigade;
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
 * Created by Asus on 23.11.2016.
 */
public class DAOBrigadeImpl implements DAOInterface<Brigade>{

    @Override
    public void create(Brigade obj) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.retrieve();
        PreparedStatement statement = connection.prepareStatement(SQLConstants.GET_ALL_BRIGADES_BY_ID_FLIGHT);
        statement.setInt(1,obj.getId_flight());
        if (!statement.executeQuery().next()) {
            statement = connection.prepareStatement(SQLConstants.ADD_BRIGADE);
            statement.setInt(1, obj.getId_first_pilot());
            statement.setInt(2, obj.getId_second_pilot());
            statement.setInt(3, obj.getId_stewardess());
            statement.setInt(4, obj.getId_navigator());
            statement.setInt(5, obj.getId_radioman());
            statement.setInt(6, obj.getId_flight());
            statement.execute();
        }
        ConnectionPool.INSTANCE.putBack(connection);
    }

    @Override
    public void delete(int id) throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.retrieve();
        PreparedStatement statement = connection.prepareStatement(SQLConstants.DELETE_BRIGADE);
        statement.setInt(1, id);
        statement.execute();
        ConnectionPool.INSTANCE.putBack(connection);
    }

    @Override
    public Brigade find(Brigade obj) throws SQLException {
        return null;
    }

    @Override
    public Brigade update(Brigade obj) throws SQLException {
        return null;
    }

    @Override
    public List<Brigade> getAllData() throws SQLException {
        Connection connection = ConnectionPool.INSTANCE.retrieve();
        PreparedStatement statement = connection.prepareStatement(SQLConstants.GET_ALL_BRIGADES);
        ResultSet set = statement.executeQuery();
        List<Brigade> answer = new ArrayList<>();
        while (set.next()){
            Brigade brigade = new Brigade();
            DAOEmployeeInterface<Stewardess> daoStewardess = new DAOStewardessImpl();
            DAOEmployeeInterface<Pilot> daoPilot = new DAOPilotImpl();
            DAOEmployeeInterface<Radioman> daoRadioman = new DAORadiomanImpl();
            DAOEmployeeInterface<Navigator> daoNavigator = new DAONavigatorImpl();
            DAOInterface<Flight> daoFlight = new DAOFlightImpl();
            brigade.setId(set.getInt(CommandConstants.ID));
            brigade.setStewardess(daoStewardess.find(set.getInt(CommandConstants.ID_STEWARDESS)));
            brigade.setFirstPilot(daoPilot.find(set.getInt(CommandConstants.ID_FIRST_PILOT)));
            brigade.setSecondPilot(daoPilot.find(set.getInt(CommandConstants.ID_SECOND_PILOT)));
            brigade.setNavigator(daoNavigator.find(set.getInt(CommandConstants.ID_NAVIGATOR)));
            brigade.setRadioman(daoRadioman.find(set.getInt(CommandConstants.ID_RADIOMAN)));
            brigade.setFlight(daoFlight.find(set.getInt(CommandConstants.ID_FLIGHT)));
            answer.add(brigade);
        }
        ConnectionPool.INSTANCE.putBack(connection);
        return answer;
    }

    @Override
    public Brigade find(Integer obj) throws SQLException {
        return null;
    }
}
