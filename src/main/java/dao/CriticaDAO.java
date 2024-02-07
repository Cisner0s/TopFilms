/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import model.Critica;

/**
 *
 * @author jorge
 */
public class CriticaDAO implements DAO<Critica>{
    private final Connection conn; 
    
    private final String CREATE = "INSERT INTO critica(TITULO, TEXTO, USUARIO_ID, PELICULA_ID, SERIE_ID) VALUES(?, ?, ?, ?, ?)";
    private final String READ = "SELECT * FROM critica";
    private final String GET_PELICULA = "SELECT critica.* " +
                                        "FROM critica " + 
                                        "INNER JOIN usuario ON critica.USUARIO_ID = usuario.USUARIO_ID " + 
                                        "WHERE critica.PELICULA_ID = ?"; 
    private final String GET_SERIE = "SELECT critica.* " +
                                        "FROM critica " + 
                                        "INNER JOIN usuario ON critica.USUARIO_ID = usuario.USUARIO_ID " + 
                                        "WHERE critica.SERIE_ID = ?"; 
    
    
    public CriticaDAO(Connection conn){
        this.conn = conn; 
    }
    
    @Override
    public void create(Critica a) throws DAOException {
        PreparedStatement stat = null; 
        try {
            stat = conn.prepareStatement(CREATE);
            
            Integer serie = a.getSerie_id();
            Integer pelicula = a.getPelicula_id(); 
            
            stat.setString(1, a.getTitulo());
            stat.setString(2, a.getTexto());
            stat.setInt(3, a.getUsuario_id());
            if(pelicula != null){
                stat.setInt(4, pelicula);
                stat.setNull(5, Types.INTEGER);
            }else{
                stat.setNull(4, Types.INTEGER);
                stat.setInt(5, serie);
            }
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
    public List<Critica> read() throws DAOException {
        PreparedStatement stat = null; 
        ResultSet rs = null; 
        List<Critica> criticas = new ArrayList<>();
        try {
            stat = conn.prepareStatement(READ);
            rs = stat.executeQuery();
            while(rs.next()){
                criticas.add(convertir(rs));
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
        return criticas; 
    }

    @Override
    public void update(Critica a) throws DAOException {
    }

    @Override
    public void delete(int a) throws DAOException {
    }

    @Override
    public Critica get(int id) throws DAOException {
        return null; 
    }
    
    public List<Critica> getCriticasPeliculas(int peliculaId) throws DAOException{
        PreparedStatement stat = null; 
        ResultSet rs = null; 
        List<Critica> criticas = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GET_PELICULA);
            stat.setInt(1, peliculaId);
            rs = stat.executeQuery();
            while(rs.next()){
                criticas.add(convertir(rs));
            }
        } catch (SQLException e) {
            throw new DAOException("Erro en SQL", e);
        } finally {
            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL.", ex);
                }
            }
            if(rs != null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }
        return criticas; 
    }
    
    public List<Critica> getCriticasSeries(int serieId) throws DAOException{
        PreparedStatement stat = null; 
        ResultSet rs = null; 
        List<Critica> criticas = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GET_SERIE);
            stat.setInt(1, serieId);
            rs = stat.executeQuery();
            while(rs.next()){
                criticas.add(convertir(rs));
            }
        } catch (SQLException e) {
            throw new DAOException("Erro en SQL", e);
        } finally {
            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL.", ex);
                }
            }
            if(rs != null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }
        return criticas; 
    }
    
    private Critica convertir(ResultSet rs) throws SQLException{
        int id = rs.getInt(1);
        String titulo = rs.getString(2);
        String texto = rs.getString(3);
        Integer usuario_id = rs.getInt(4);
        Integer pelicula_id = rs.getInt(5);
        Integer serie_id = rs.getInt(6);
        Critica critica = new Critica(titulo, texto, pelicula_id, serie_id, usuario_id);
        critica.setCritica_id(id);
        return critica; 
    }
}
