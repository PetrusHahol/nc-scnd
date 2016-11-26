package com.netcracker.petrusev.project2.DAO;

import com.netcracker.petrusev.project2.beans.entities.office.Employee;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Asus on 12.11.2016.
 */
public interface DAOInterface<T> {
    public void create(T obj) throws SQLException;
    public void delete(int id) throws SQLException;
    public T find(T obj) throws SQLException;
    public void update(T obj) throws SQLException;
    public List<T> getAllData() throws SQLException;
    public T find(Integer obj) throws SQLException;
}
