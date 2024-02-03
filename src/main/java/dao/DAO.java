package dao;

import java.util.List;

public interface DAO<T> {
    
    
    // CRUD 
    void create(T a) throws DAOException;
    List<T> read() throws DAOException;
    void update(T a) throws DAOException; 
    void delete(int a) throws DAOException; 
    
    // Adicionales
    T get(int id) throws DAOException;  

}


