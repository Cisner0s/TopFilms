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
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Estudio;

/**
 *
 * @author jorge
 */
public class EstudioDAO implements DAO<Estudio>{

    private final Connection conn; 
    
    final String INSERT = "INSERT INTO estudio(NOMBRE, PROPIETARIO, FECHA_FUNDACION, PATRIMONIO, SEDES) VALUES(?, ?, ?, ?, ?)";
    final String READ = "SELECT ESTUDIO_ID, NOMBRE, PROPIETARIO, FECHA_FUNDACION, PATRIMONIO, SEDES FROM estudio"; 
    final String UPDATE = "UPDATE estudio SET NOMBRE = ?, PROPIETARIO = ?, FECHA_FUNDACION = ?, PATRIMONIO= ?, SEDES= ? WHERE ESTUDIO_ID = ?"; 
    final String DELETE = "DELETE FROM estudio WHERE ESTUDIO_ID = ?";
    final String GET = "SELECT ESTUDIO_ID, NOMBRE, PROPIETARIO, FECHA_FUNDACION, PATRIMONIO, SEDES FROM estudio WHERE ESTUDIO_ID = ?";   
    final String GET_BY_NAME = "SELECT ESTUDIO_ID, NOMBRE, PROPIETARIO, FECHA_FUNDACION, PATRIMONIO, SEDES FROM estudio WHERE NOMBRE = ?"; 
    final String EXIST_NOMBRE = "SELECT COUNT(*) FROM estudio WHERE NOMBRE = ?"; 

    public EstudioDAO(Connection conn){
        this.conn = conn; 
    }
    
    @Override
    public void create(Estudio a) throws DAOException {
        PreparedStatement stat = null; 
        try{
            stat = conn.prepareStatement(INSERT); 
            stat.setString(1, a.getNombre()); 
            stat.setString(2, a.getPropietario());
            stat.setDate(3, a.getFecha_Fundacion());
            stat.setLong(4, a.getPatrimonio());
            stat.setString(5, a.getSedes());
            if(stat.executeUpdate() == 0){
                throw new DAOException("Puede que no se haya guardado.");
            }
            try (PreparedStatement statement = conn.prepareStatement("SELECT LAST_INSERT_ID()")) {
                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    int idGenerado = rs.getInt(1);
                    a.setEstudio_id(idGenerado);
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
    public List<Estudio> read() throws DAOException {
        PreparedStatement stat = null; 
        ResultSet rs = null; 
        List<Estudio> estudios = new ArrayList<>(); 
        try {
            stat = conn.prepareStatement(READ);
            rs = stat.executeQuery(); 
            while(rs.next()){
                estudios.add(convertir(rs));
            }
        }catch(SQLException e){
            System.out.println(e);
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
                    throw new DAOException("Error en SQL.", ex);
                }
            }
        }
        return estudios;
    }

    @Override
    public void update(Estudio a) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(UPDATE);
            stat.setString(1, a.getNombre());
            stat.setString(1, a.getNombre()); 
            stat.setString(2, a.getPropietario());
            stat.setDate(3, a.getFecha_Fundacion());
            stat.setLong(4, a.getPatrimonio());
            stat.setString(5, a.getSedes());
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
            try{
                if(stat.executeUpdate() == 0){
                   throw new DAOException("Puede que no se haya actualizado la base de datos correctamente");
                }
            } catch(SQLIntegrityConstraintViolationException e){
                    throw new DAOException("El contenido que se trata de borrar viola la integridad de la base de datos.");
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
    public Estudio get(int id) throws DAOException {
        PreparedStatement stat = null; 
        ResultSet rs = null; 
        Estudio estudio = null; 
        try{
            stat = conn.prepareStatement(GET);
            stat.setInt(1, id);
            rs = stat.executeQuery();
            if(rs.next()){
                estudio = convertir(rs);
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
       
        return estudio;
    }
    
    public Estudio get(String nombre) throws DAOException {
        PreparedStatement stat = null; 
        ResultSet rs = null; 
        Estudio estudio = null; 
        try{
            stat = conn.prepareStatement(GET_BY_NAME);
            stat.setString(1, nombre);
            rs = stat.executeQuery();
            if(rs.next()){
                estudio = convertir(rs);
            }else{
                throw new DAOException("No se ha encontrado ese estudio");
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
       
        return estudio;
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
    
    private Estudio convertir(ResultSet rs) throws SQLException{
        int id = rs.getInt("ESTUDIO_ID");
        String nombre = rs.getString("NOMBRE");
        String prop = rs.getString("PROPIETARIO");
        Date fechaFund = rs.getDate("FECHA_FUNDACION");
        long patrimonio = rs.getLong("PATRIMONIO");
        String sedes = rs.getString("SEDES");
        Estudio estudio = new Estudio(nombre, prop, fechaFund, patrimonio, sedes);
        estudio.setEstudio_id(id);
        return estudio;
    }
    
}
