package com.netcracker.petrusev.project2.DAO;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Petrusev
 * @version 1.0
 *
 */
public interface DAOInterface<T> {
    void create(T obj) throws SQLException;
    void delete(int id) throws SQLException;
    void update(T obj) throws SQLException;
    List<T> getAllData() throws SQLException;
    T find(T obj) throws SQLException;
    T find(Integer obj) throws SQLException;
}
