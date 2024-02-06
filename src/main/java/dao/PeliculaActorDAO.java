/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.PeliculaActor;

/**
 *
 * @author jorge
 */
public class PeliculaActorDAO implements DAO<PeliculaActor>{
    
    private final Connection conn; 

    private final String CREATE = "INSERT INTO pelicula_actor(pelicula_id, actor_id) VALUES(?, ?)"; 
    
    public PeliculaActorDAO(Connection conn){
        this.conn = conn; 
    }
    
    @Override
    public void create(PeliculaActor a) throws DAOException {
        PreparedStatement stat = null; 
        try {
            stat = conn.prepareStatement(CREATE);
            stat.setInt(1, a.getPelicula_id());
            stat.setInt(2, a.getActor_id());
            if(stat.executeUpdate() == 0){
                throw new DAOException("No se puedo crear la relación pelicula/actor correctamente");
            }
        } catch (SQLException e) {
            throw new DAOException("Error en SQL.");
        } finally {
            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL");
                }
            }
        }
    }

    @Override
    public List read() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(PeliculaActor a) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int a) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PeliculaActor get(int id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private PeliculaActor convertir(ResultSet rs){
        return null; 
    }
    
}
