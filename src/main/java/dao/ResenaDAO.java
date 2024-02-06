/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Resena;

/**
 *
 * @author jorge
 */
public class ResenaDAO implements DAO<Resena>{

    private final Connection conn; 
    
    private final String CREATE = "INSERT INTO resena(TITULO, TEXTO, USUARIO_ID, PELICULA_ID, SERIE_ID) VALUES(?, ?, ?, ?, ?)";
    private final String READ = "SELECT * FROM renesa";
    
    public ResenaDAO(Connection conn){
        this.conn = conn; 
    }
    
    @Override
    public void create(Resena a) throws DAOException {
        PreparedStatement stat = null; 
        try {
            stat = conn.prepareStatement(CREATE);
            stat.setString(1, a.getTituloResena());
            stat.setString(2, a.getTextoResena());
            stat.setInt(3, a.getUsuario());
            stat.setInt(4, a.getPelicula());
            stat.setInt(5, a.getSerie());
            if(stat.executeUpdate() == 0){
                throw new DAOException("No se pudo crear la reseña.");
            }
        } catch (SQLException e) {
            throw new DAOException("Error en SQL");
        } finally {
            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL.");
                }
            }
        }
    }

    @Override
    public List<Resena> read() throws DAOException {
        PreparedStatement stat = null; 
        ResultSet rs = null; 
        List<Resena> resenas = new ArrayList<>();
        try {
            stat = conn.prepareStatement(READ);
            rs = stat.executeQuery();
            while(rs.next()){
                resenas.add(convertir(rs));
            }
        } catch (Exception e) {
        } finally {
            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL");
                }
            }
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL");
                }
            }
        }
        return resenas; 
    }

    @Override
    public void update(Resena a) throws DAOException {
    }

    @Override
    public void delete(int a) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Resena get(int id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private Resena convertir(ResultSet rs) throws SQLException{
        int id = rs.getInt(1);
        String titulo = rs.getString(2);
        String texto = rs.getString(3);
        Integer usuario_id = rs.getInt(4);
        Integer pelicula_id = rs.getInt(5);
        Integer serie_id = rs.getInt(6);
        Resena resena = new Resena(titulo, texto, usuario_id, pelicula_id, serie_id);
        resena.setResena_id(id);
        return resena; 
    }
    
}
