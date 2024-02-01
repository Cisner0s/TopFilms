/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Actor;

/**
 *
 * @author jorge
 */
public class ActorDAO implements DAO<Actor>{

    private Connection conn;
    
    final String INSERT = "INSERT INTO actor(ACTOR_ID, NOMBRE, SEXO, FECHA_NACIMIENTO, LUGAR_NACIMIENTO, NACIONALIDAD, PREMIOS, IMAGEN) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    final String READ = "SELECT ACTOR_ID, NOMBRE, SEXO, FECHA_NACIMIENTO, LUGAR_NACIMIENTO, NACIONALIDAD, PREMIOS, IMAGEN FROM actor"; 
    final String UPDATE = "UPDATE actor SET NOMBRE = ?, SEXO = ?, FECHA_NACIMIENTO = ?, LUGAR_NACIMIENTO = ?, NACIONALIDAD = ?, PREMIOS = ?, IMAGEN = ? WHERE ACTOR_ID = ?"; 
    final String DELETE = "DELETE FROM actor WHERE ACTOR_ID = ?";
    final String GET = "SELECT ACTOR_ID, NOMBRE, SEXO, FECHA_NACIMIENTO, LUGAR_NACIMIENTO, NACIONALIDAD, PREMIOS, IMAGEN FROM actor WHERE ACTOR_ID = ?";   
    
    public ActorDAO(Connection conn){
        this.conn = conn; 
    }
    
    @Override
    public void create(Actor actor) throws DAOException{   
        PreparedStatement stat = null; 
        try{
            stat = conn.prepareStatement(INSERT); 
            stat.setInt(1, actor.getId());
            stat.setString(2, actor.getNombre()); 
            stat.setString(3, actor.getSexo());
            stat.setDate(4, actor.getFechaNacimiento());
            stat.setString(5, actor.getLugarNacimiento());
            stat.setString(6, actor.getNacionalidad());
            stat.setString(7, actor.getPremios());
            stat.setString(8, actor.getImagen());
            if(stat.executeUpdate() == 0){
                throw new DAOException("Puede que no se haya guardado.");
            }
        } catch (SQLException ex) {
            throw new DAOException("Error en SQL.", ex);
        }finally{
            if(stat != null){
                try{
                    stat.close();
                }catch(SQLException ex){
                    throw new DAOException("Error en SQL.", ex); 
                }
            }
        }
    }
    
    
    @Override
    public List<Actor> read() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Actor a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Actor a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Actor get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
