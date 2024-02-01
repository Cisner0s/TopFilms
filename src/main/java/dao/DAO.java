package dao;

import java.util.List;

public interface DAO<T> {
    
    
    // CRUD 
    void create(T a) throws DAOException;
    List<T> read() throws DAOException;
    void update(T a) throws DAOException; 
    void delete(T a) throws DAOException; 
    
    // Adicionales
    T get(int id) throws DAOException;  

}


