package dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T,ID> {
    boolean add(T object) throws Exception;

    boolean update(T object) throws SQLException, ClassNotFoundException;

    boolean delete(ID id) throws SQLException, ClassNotFoundException;

    T get(ID id) throws SQLException, ClassNotFoundException;

    ArrayList<T> getAll() throws SQLException, ClassNotFoundException;
}
