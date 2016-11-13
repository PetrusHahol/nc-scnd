package DAO;

import java.util.Objects;

/**
 * Created by Asus on 12.11.2016.
 */
public interface DAOInterface<T> {
    public void Create(T obj);
    public void Delete(T obj);
    public T Find(T obj);
}
