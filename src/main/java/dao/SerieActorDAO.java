/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import model.PeliculaActor;
import model.SerieActor;

/**
 *
 * @author jorge
 */
public class SerieActorDAO implements DAO<SerieActor>{

    private final Connection conn; 

    private final String CREATE = "INSERT INTO serie_actor(serie, actor_id) VALUES(?, ?)"; 
    
    public SerieActorDAO(Connection conn){
        this.conn = conn; 
    }
    
    @Override
    public void create(SerieActor a) throws DAOException {
        PreparedStatement stat = null; 
        try {
            stat = conn.prepareStatement(CREATE);
            stat.setInt(1, a.getSerie_id());
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
    public List<SerieActor> read() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(SerieActor a) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int a) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SerieActor get(int id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
