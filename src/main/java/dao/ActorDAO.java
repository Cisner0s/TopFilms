/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        } catch (SQLException e) {
            throw new DAOException("Error en SQL.", e);
        }finally{
            if(stat != null){
                try{
                    stat.close();
                }catch(SQLException e){
                    throw new DAOException("Error en SQL.", e); 
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
    public void delete(Actor actor) throws DAOException {
        PreparedStatement stat = null; 
        try{
            stat = conn.prepareStatement(DELETE);
            stat.setInt(1, actor.getId());
            if(stat.executeUpdate() == 0){
                throw new DAOException("Puede que no se haya actualizado la base de datos correctamente");
            }
        }catch(SQLException e){
            throw new DAOException("Error en SQL", e);
        }finally{
            if(stat != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new DAOException("Error en SQL.", e);
                }
            }
        }
    }

    @Override
    public Actor get(int id) throws DAOException {
        PreparedStatement stat = null; 
        ResultSet rs = null; 
        Actor actor = null; 
        try{
            stat = conn.prepareStatement(GET);
            stat.setInt(1, id);
            rs = stat.executeQuery();
            if(rs.next()){
                actor = convertir(rs);
            }else{
                throw new DAOException("No se ha encontrado ese actor");
            }
        }catch(SQLException e){
            throw new DAOException("Error en SQL.", e);
        }finally{
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new DAOException("Error en SQL", e);
                }
            }
            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException e) {
                    throw new DAOException("Error en SQL", e);
                }
            }
        }
        
        return actor;
    }
    
    private Actor convertir(ResultSet rs) throws SQLException{
        int id = rs.getInt("ACTOR_ID");
        String nombre = rs.getString("NOMBRE");
        String sexo = rs.getString("SEXO");
        Date fechaNac = rs.getDate("FECHA_NACIMIENTO");
        String lugarNac = rs.getString("LUGAR_NACIMIENTO");
        String nacionalidad = rs.getString("NACIONALIDAD");
        String premios = rs.getString("PREMIOS");
        String imagen = rs.getString("IMAGEN");
        return new Actor(id, nombre, sexo, fechaNac, lugarNac, nacionalidad, premios, imagen);
    }
    
}
