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
import model.Actor;
import model.Pelicula;
import model.PeliculaActor;

/**
 *
 * @author jorge
 */
public class PeliculaActorDAO implements DAO<PeliculaActor>{
    
    private final Connection conn; 

    private final String CREATE = "INSERT INTO pelicula_actor(pelicula_id, actor_id) VALUES(?, ?)"; 
    private final String OBTENER_PELICULAS = "SELECT pelicula.* " + 
                                             "FROM pelicula " + 
                                             "JOIN pelicula_actor ON pelicula.PELICULA_ID = pelicula_actor.pelicula_id " + 
                                             "WHERE pelicula_actor.actor_id = ?"; 
    
    
    private final String OBTENER_ACTORES = "SELECT actor.* " + 
                                           "FROM actor " + 
                                           "JOIN pelicula_actor ON actor.ACTOR_ID = pelicula_actor.actor_id " + 
                                           "WHERE pelicula_actor.pelicula_id = ?";  
    
    public PeliculaActorDAO(Connection conn){
        this.conn = conn; 
    }
    
    @Override
    public void create(PeliculaActor a) throws DAOException {
        PreparedStatement stat = null; 
        try {
            stat = conn.prepareStatement(CREATE);
            stat.setInt(1, a.getPelicula_id());
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
    public List read() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(PeliculaActor a) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int a) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PeliculaActor get(int id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public List<Pelicula> obtenerPeliculas(int idActor) throws DAOException{
        PreparedStatement stat = null; 
        ResultSet rs = null; 
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            stat = conn.prepareStatement(OBTENER_PELICULAS);
            stat.setInt(1, idActor);
            rs = stat.executeQuery();
            while(rs.next()){
                peliculas.add(convertirPeliculas(rs));
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
        return peliculas; 
    }
    
    public List<Actor> obtenerActores(int idPelicula) throws DAOException{
        PreparedStatement stat = null; 
        ResultSet rs = null; 
        List<Actor> actores = new ArrayList<>();
        try {
            stat = conn.prepareStatement(OBTENER_ACTORES);
            stat.setInt(1, idPelicula);
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
    
    private PeliculaActor convertir(ResultSet rs){
        return null; 
    }
    
    private Pelicula convertirPeliculas(ResultSet rs) throws SQLException{
        int id = rs.getInt("PELICULA_ID");
        int duracion = rs.getInt("DURACION");
        String titulo = rs.getString("TITULO");
        String sinopsis = rs.getString("SINOPSIS");
        String genero = rs.getString("GENERO");
        Date fechaEstreno = rs.getDate("FECHA_ESTRENO");
        long presupuesto = rs.getLong("PRESUPUESTO");
        long ganancias = rs.getLong("GANANCIAS");
        String imagen = rs.getString("IMAGEN");
        int id_director = rs.getInt("director_id");
        int id_estudio = rs.getInt("ESTUDIO_ESTUDIO_ID");
        Pelicula pelicula = new Pelicula(titulo, duracion, sinopsis, genero, fechaEstreno, presupuesto, ganancias, imagen, id_director, id_estudio);
        pelicula.setPelicula_id(id);
        return pelicula;
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
