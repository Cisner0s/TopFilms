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
import model.PeliculaActor;
import model.Serie;
import model.SerieActor;

/**
 *
 * @author jorge
 */
public class SerieActorDAO implements DAO<SerieActor>{

    private final Connection conn; 

    private final String CREATE = "INSERT INTO serie_actor(serie, actor_id) VALUES(?, ?)"; 
    private final String OBTENER_SERIES = "SELECT s.* FROM serie s " + 
                                             "INNER JOIN serie_actor sa ON s.SERIE_ID = sa.serie_id " + 
                                             "INNER JOIN actor a ON sa.actor_id = a.ACTOR_ID " + 
                                             "WHERE a.ACTOR_ID = ?"; 
    
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
    
    public List<Serie> obtenerSeries(int idActor) throws DAOException{
        PreparedStatement stat = null; 
        ResultSet rs = null; 
        List<Serie> series = new ArrayList<>();
        try {
            stat = conn.prepareStatement(OBTENER_SERIES);
            stat.setInt(1, idActor);
            rs = stat.executeQuery();
            while(rs.next()){
                series.add(convertirSeries(rs));
            }
        } catch (SQLException e) {
            throw new DAOException("Error en SQL", e);
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
                    rs.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL.", ex);
                }
            }
        }
        return series; 
    }
    
    private Serie convertirSeries(ResultSet rs) throws SQLException{
        int id = rs.getInt("SERIE_ID");
        String titulo = rs.getString("TITULO");
        Date fechaEst = rs.getDate("FECHA_ESTRENO");
        String genero = rs.getString("GENERO");
        int n_ep = rs.getInt("N_EPISODIOS");
        double dur_med = rs.getDouble("DURACION_MED_EPISODIO");
        int n_temp = rs.getInt("N_TEMPORADAS");
        int presupuesto = rs.getInt("PRESUPUESTO");
        int ganancias = rs.getInt("GANANCIAS");
        int director_id = rs.getInt("director_id");
        int estudio_id = rs.getInt("estudio_id");
        Serie serie = new Serie(titulo, fechaEst, genero, n_ep, dur_med, n_temp, presupuesto, ganancias, director_id, estudio_id);
        serie.setSerie_id(id);
        return serie; 
    }
    
}
