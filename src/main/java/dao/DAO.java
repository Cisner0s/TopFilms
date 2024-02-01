package dao;

import java.util.List;

public interface DAO<T> {
    
    
    // CRUD 
    void create(T a);
    List<T> read();
    void update(T a); 
    void delete(T a); 
    
    // Adicionales
    T get(int id); 

}


