package com.netcracker.petrusev.project2.DAO;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Petrusev
 * @version 1.0
 *
 */
public interface DAOInterface<T> {
    public void create(T obj) throws SQLException;
    public void delete(int id) throws SQLException;
    public T find(T obj) throws SQLException;
    public void update(T obj) throws SQLException;
    public List<T> getAllData() throws SQLException;
    public T find(Integer obj) throws SQLException;
}
