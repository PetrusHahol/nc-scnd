package com.netcracker.petrusev.project2.connections;

import com.netcracker.petrusev.project2.constants.PoolConstants;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

public enum ConnectionPool {
        INSTANS;

    private static String url;
    private  Vector<Connection> availableConns = new Vector<Connection>();
    private  Vector<Connection> usedConns = new Vector<Connection>();

    private JDBC jdbc;

    {
        for (int i = 0; i< PoolConstants.COUNT_FREE_CONN; i++)
            jdbc = new JDBC();
            availableConns.add(jdbc.getConnection());
    }

    private Connection getConnection() {
        return jdbc.getConnection();
    }

    public synchronized Connection retrieve() throws SQLException {

        Connection newConn = null;
        if (availableConns.size() == 0) {
            newConn = getConnection();
        } else {
            newConn = (Connection) availableConns.lastElement();
            availableConns.removeElement(newConn);
        }
        usedConns.addElement(newConn);
        return newConn;
    }

    public synchronized void putBack(Connection c) throws NullPointerException {
        if (c != null) {
            if (usedConns.removeElement(c)) {
                availableConns.addElement(c);
            } else {
                throw new NullPointerException("Error connection");
            }
        }
    }

    public int getAvailableConnsCnt() {
        return availableConns.size();
    }
}