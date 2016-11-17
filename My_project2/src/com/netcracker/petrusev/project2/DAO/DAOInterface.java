package com.netcracker.petrusev.project2.DAO;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Asus on 12.11.2016.
 */
public interface DAOInterface<T> {
    public void create(T obj) throws SQLException;
    public void delete(T obj) throws SQLException;
    public T find(T obj) throws SQLException;
    public T update(T obj) throws SQLException;
    public List<T> allData(T obj) throws SQLException;
}
