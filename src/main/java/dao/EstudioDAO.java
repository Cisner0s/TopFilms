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
import model.Estudio;

/**
 *
 * @author jorge
 */
public class EstudioDAO implements DAO<Estudio>{

    private final Connection conn; 
    
    final String INSERT = "INSERT INTO estudio(NOMBRE, PROPIETARIO, FECHA_FUNDACION, PATRIMONIO, SEDES) VALUES(?, ?, ?, ?, ?)";
    final String READ = "SELECT DIRECTOR_ID, NOMBRE, PROPIETARIO, FECHA_FUNDACION, PATRIMONIO, SEDES FROM estudio"; 
    final String UPDATE = "UPDATE estudio SET NOMBRE = ?, PROPIETARIO = ?, FECHA_FUNDACION = ?, PATRIMONIO= ?, SEDES= ? WHERE ESTUDIO_ID = ?"; 
    final String DELETE = "DELETE FROM estudio WHERE ESTUDIO_ID = ?";
    final String GET = "SELECT DIRECTOR_ID, NOMBRE, PROPIETARIO, FECHA_FUNDACION, PATRIMONIO, SEDES FROM estudio WHERE ESTUDIO_ID = ?";   
    
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
            stat.setInt(4, a.getPatrimonio());
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
        ResultSet rs; 
        List<Estudio> estudios = new ArrayList<>(); 
        try {
            stat = conn.prepareStatement(READ);
            rs = stat.executeQuery(); 
            while(rs.next()){
                estudios.add(convertir(rs));
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
            stat.setInt(4, a.getPatrimonio());
            stat.setString(5, a.getSedes());
        } catch(SQLException e){
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
    
    private Estudio convertir(ResultSet rs) throws SQLException{
        int id = rs.getInt("DIRECTOR_ID");
        String nombre = rs.getString("NOMBRE");
        String prop = rs.getString("PROPIETARIO");
        Date fechaFund = rs.getDate("FECHA_FUNDACION");
        int patrimonio = rs.getInt("PATRIMONIO");
        String sedes = rs.getString("SEDES");
        Estudio estudio = new Estudio(nombre, prop, fechaFund, patrimonio, sedes);
        estudio.setEstudio_id(id);
        return estudio;
    }
    
}