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
import model.Actor;
import model.PeliculaActor;
import model.Serie;
import model.SerieActor;

/**
 *
 * @author jorge
 */
public class SerieActorDAO implements DAO<SerieActor>{

    private final Connection conn; 

    private final String CREATE = "INSERT INTO serie_actor(serie_id, actor_id) VALUES(?, ?)"; 
    private final String OBTENER_SERIES = "SELECT s.* FROM serie s " + 
                                             "INNER JOIN serie_actor sa ON s.SERIE_ID = sa.serie_id " + 
                                             "INNER JOIN actor a ON sa.actor_id = a.ACTOR_ID " + 
                                             "WHERE a.ACTOR_ID = ?"; 
    private final String OBTENER_PELICULAS = "SELECT serie.* " + 
                                             "FROM serie " + 
                                             "JOIN serie_actor ON serie.SERIE_ID = serie_actor.serie_id " + 
                                             "WHERE serie_actor.actor_id = ?"; 
    
    
    private final String OBTENER_ACTORES = "SELECT actor.* " + 
                                           "FROM actor " + 
                                           "JOIN serie_actor ON actor.ACTOR_ID = serie_actor.actor_id " + 
                                           "WHERE serie_actor.serie_id = ?";  
    
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
            e.printStackTrace();
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
    
    public List<Actor> obtenerActores(int idSerie) throws DAOException{
        PreparedStatement stat = null; 
        ResultSet rs = null; 
        List<Actor> actores = new ArrayList<>();
        try {
            stat = conn.prepareStatement(OBTENER_ACTORES);
            stat.setInt(1, idSerie);
            rs = stat.executeQuery();
            while(rs.next()){
                actores.add(convertirActores(rs));
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
        return actores; 
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
    
    private Actor convertirActores(ResultSet rs) throws SQLException{
        int id = rs.getInt("ACTOR_ID");
        String nombre = rs.getString("NOMBRE");
        String sexo = rs.getString("SEXO");
        Date fechaNac = rs.getDate("FECHA_NACIMIENTO");
        String lugarNac = rs.getString("LUGAR_NACIMIENTO");
        String nacionalidad = rs.getString("NACIONALIDAD");
        String premios = rs.getString("PREMIOS");
        Actor actor = new Actor(nombre, sexo, fechaNac, lugarNac, nacionalidad, premios);
        actor.setId(id);
        return actor;
    }
    
}
