package com.netcracker.petrusev.project2.DAO;

import java.sql.SQLException;

/**
 * Created by Asus on 12.11.2016.
 */
public interface DAOInterface<T> {
    public void create(T obj) throws SQLException;
    public void delete(T obj);
    public T find(T obj) throws SQLException;
}
