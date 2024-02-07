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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Director;

/**
 *
 * @author jorge
 */
public class DirectorDAO implements DAO<Director>{
    
    private final Connection conn; 
    
    final String INSERT = "INSERT INTO director(NOMBRE, SEXO, FECHA_NACIMIENTO, LUGAR_NACIMIENTO, NACIONALIDAD, NOMINACIONES, PREMIOS) VALUES(?, ?, ?, ?, ?, ?, ?)";
    final String READ = "SELECT DIRECTOR_ID, NOMBRE, SEXO, FECHA_NACIMIENTO, LUGAR_NACIMIENTO, NACIONALIDAD, NOMINACIONES, PREMIOS FROM director"; 
    final String UPDATE = "UPDATE director SET NOMBRE = ?, SEXO = ?, FECHA_NACIMIENTO = ?, LUGAR_NACIMIENTO = ?, NACIONALIDAD = ?, NOMINACIONES = ?, PREMIOS = ? WHERE DIRECTOR_ID = ?"; 
    final String DELETE = "DELETE FROM director WHERE DIRECTOR_ID = ?";
    final String GET = "SELECT DIRECTOR_ID, NOMBRE, SEXO, FECHA_NACIMIENTO, LUGAR_NACIMIENTO, NACIONALIDAD, NOMINACIONES, PREMIOS FROM director WHERE DIRECTOR_ID = ?";   
    final String GET_BY_NAME = "SELECT DIRECTOR_ID, NOMBRE, SEXO, FECHA_NACIMIENTO, LUGAR_NACIMIENTO, NACIONALIDAD, NOMINACIONES, PREMIOS FROM director WHERE NOMBRE = ?";   
    final String EXIST_NOMBRE = "SELECT COUNT(*) FROM director WHERE NOMBRE = ?"; 
    
    public DirectorDAO(Connection conn){
        this.conn = conn; 
    }

    @Override
    public void create(Director a) throws DAOException {
        PreparedStatement stat = null; 
        try{
            stat = conn.prepareStatement(INSERT); 
            stat.setString(1, a.getNombre()); 
            stat.setString(2, a.getSexo());
            stat.setDate(3, a.getFecha_Nacimiento());
            stat.setString(4, a.getLugar_nacimiento());
            stat.setString(5, a.getNacionalidad());
            stat.setString(6, a.getNominaciones());
            stat.setString(7, a.getPremios());
            if(stat.executeUpdate() == 0){
                throw new DAOException("Puede que no se haya guardado.");
            }
            try (PreparedStatement statement = conn.prepareStatement("SELECT LAST_INSERT_ID()")) {
                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    int idGenerado = rs.getInt(1);
                    a.setDirector_id(idGenerado);
                }
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
    public List<Director> read() throws DAOException {
        PreparedStatement stat = null; 
        ResultSet rs = null; 
        List<Director> directores = new ArrayList<>(); 
        try {
            stat = conn.prepareStatement(READ);
            rs = stat.executeQuery(); 
            while(rs.next()){
                directores.add(convertir(rs));
            }
        }catch(SQLException e){
            throw new DAOException("Error en SQL", e);
        }finally{
            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException e) {
                    throw new DAOException("Error en SQL.", e);
                }
            }
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }
        return directores;
    }

    @Override
    public void update(Director a) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(UPDATE);
            stat.setString(1, a.getNombre());
            stat.setString(2, a.getSexo());
            stat.setDate(3, a.getFecha_Nacimiento());
            stat.setString(4, a.getLugar_nacimiento());
            stat.setString(5, a.getNacionalidad());
            stat.setString(6, a.getNominaciones());
            stat.setString(7, a.getPremios());
        } catch(SQLException e){
            throw new DAOException("Error en SQL", e);
        }finally{
            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException e) {
                    throw new DAOException("Error en SQL.", e);
                }
            }
        }
    }

    @Override
    public void delete(int id) throws DAOException {
        PreparedStatement stat = null; 
        try{
            stat = conn.prepareStatement(DELETE);
            stat.setInt(1, id);
            
            if(stat.executeUpdate() == 0){
                throw new DAOException("Puede que no se haya actualizado la base de datos correctamente");
            }
            
        }catch(SQLException e){
            throw new DAOException("Error en SQL", e);
        }finally{
            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException e) {
                    throw new DAOException("Error en SQL.", e);
                }
            }
        }
    }

    @Override
    public Director get(int id) throws DAOException {
        PreparedStatement stat = null; 
        ResultSet rs = null; 
        Director director = null; 
        try{
            stat = conn.prepareStatement(GET);
            stat.setInt(1, id);
            rs = stat.executeQuery();
            if(rs.next()){
                director = convertir(rs);
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
        
        return director;
    }
    
    public Director get(String name) throws DAOException {
        PreparedStatement stat = null; 
        ResultSet rs = null; 
        Director director = null; 
        try{
            stat = conn.prepareStatement(GET_BY_NAME);
            stat.setString(1, name);
            rs = stat.executeQuery();
            if(rs.next()){
                director = convertir(rs);
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
        
        return director;
    }
    
    public boolean exist(String nombre) throws DAOException{
        PreparedStatement stat = null; 
        ResultSet rs = null; 
        try {
            stat = conn.prepareStatement(EXIST_NOMBRE);
            stat.setString(1, nombre);
            rs = stat.executeQuery();
            if(rs.next()){
                int count = rs.getInt(1);
                return count > 0; 
            }
        } catch (SQLException e) {
            throw new DAOException("Error en SQL");
        } finally {
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
        return false; 
    }
    
    private Director convertir(ResultSet rs) throws SQLException{
        int id = rs.getInt("DIRECTOR_ID");
        String nombre = rs.getString("NOMBRE");
        String sexo = rs.getString("SEXO");
        Date fechaNac = rs.getDate("FECHA_NACIMIENTO");
        String lugarNac = rs.getString("LUGAR_NACIMIENTO");
        String nacionalidad = rs.getString("NACIONALIDAD");
        String nominaciones = rs.getString("NOMINACIONES");
        String premios = rs.getString("PREMIOS");
        Director director = new Director(nombre, sexo, fechaNac, lugarNac, nacionalidad, premios, nominaciones);
        director.setDirector_id(id);
        return director;
    }
    
}
