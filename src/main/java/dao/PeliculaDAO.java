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
import model.Pelicula;

/**
 *
 * @author jorge
 */
public class PeliculaDAO implements DAO<Pelicula>{

    
    private final Connection conn;
    
    final String INSERT = "INSERT INTO pelicula(DURACION, TITULO, SINOPSIS, GENERO, FECHA_ESTRENO, PRESUPUESTO, GANANCIAS, IMAGEN, director_id, ESTUDIO_ESTUDIO_ID) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    final String READ = "SELECT * FROM pelicula"; 
    final String UPDATE = "UPDATE pelicula SET TITULO = ?, DURACION = ?, SINOPSIS = ?, GENERO = ?, FECHA_ESTRENO = ?, PRESUPUESTO = ?, GANANCIAS = ?, IMAGEN = ?, director_id = ?, ESTUDIO_ESTUDIO_ID = ? WHERE PELICULA_ID = ?"; 
    final String DELETE = "DELETE FROM pelicula WHERE PELICULA_ID = ?";
    final String GET_ID = "SELECT PELICULA_ID, TITULO, DURACION, SINOPSIS, GENERO, FECHA_ESTRENO, PRESUPUESTO, GANANCIAS, IMAGEN, director_id, ESTUDIO_ESTUDIO_ID FROM pelicula WHERE PELICULA_ID = ?";  
    final String GET_BY_TITULO = "SELECT PELICULA_ID, TITULO, DURACION, SINOPSIS, GENERO, FECHA_ESTRENO, PRESUPUESTO, GANANCIAS, IMAGEN, director_id, ESTUDIO_ESTUDIO_ID FROM pelicula WHERE TITULO = ?";  
    final String GET_TITULO = "SELECT * FROM pelicula WHERE TITULO = ?"; 
    final String GET_DIRECTOR = "SELECT p.* " + 
                                "FROM pelicula p " + 
                                "JOIN director d ON p.director_id = d.DIRECTOR_ID " + 
                                "WHERE d.DIRECTOR_ID = ?";
    final String GET_ESTUDIO = "SELECT p.* " + 
                                "FROM pelicula p " + 
                                "JOIN estudio e ON p.ESTUDIO_ESTUDIO_ID = e.ESTUDIO_ID " + 
                                "WHERE e.ESTUDIO_ID = ?";
    
    public PeliculaDAO(Connection conn){
        this.conn = conn;
    }

    @Override
    public void create(Pelicula a) throws DAOException {
        PreparedStatement stat = null; 
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setInt(1, a.getDuracion());
            stat.setString(2, a.getTitulo());
            stat.setString(3, a.getSinopsis());
            stat.setString(4, a.getGenero());
            stat.setDate(5, a.getFecha_Estreno());
            stat.setLong(6, a.getPresupuesto());
            stat.setLong(7, a.getGanancias());
            stat.setString(8, a.getImagen());
            stat.setInt(9, a.getDirector());
            stat.setInt(10, a.getEstudio());
            if(stat.executeUpdate() == 0){
                throw new DAOException("Puede que la pelicula no se haya creado correctamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException("Error en SQL");
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
    public List<Pelicula> read() throws DAOException {  
        PreparedStatement stat = null; 
        ResultSet rs = null; 
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            stat = conn.prepareStatement(READ);
            rs = stat.executeQuery(); 
            while(rs.next()){
                peliculas.add(convertir(rs));
            }
        } catch (SQLException e) {
            throw new DAOException("Error en SQL.");
        } finally {
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
                    throw new DAOException("Error en SQL");
                }
            }
        }
        return peliculas;
    }

    @Override
    public void update(Pelicula a) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void delete(int a) throws DAOException {
        PreparedStatement stat = null; 
        try{
            stat = conn.prepareStatement(DELETE);
            stat.setInt(1, a);
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
    public Pelicula get(int id) throws DAOException {
        PreparedStatement stat = null; 
        ResultSet rs = null; 
        Pelicula pelicula = null; 
        try{
            stat = conn.prepareStatement(GET_ID);
            stat.setInt(1, id);
            rs = stat.executeQuery();
            if(rs.next()){
                pelicula = convertir(rs);
            }else{
                throw new DAOException("No se ha encontrado la pelicula");
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
        
        return pelicula;
    }
    
    public Pelicula get(String titulo) throws DAOException {
        PreparedStatement stat = null; 
        ResultSet rs = null; 
        Pelicula pelicula = null; 
        try{
            stat = conn.prepareStatement(GET_BY_TITULO);
            stat.setString(1, titulo);
            rs = stat.executeQuery();
            if(rs.next()){
                pelicula = convertir(rs);
            }else{
                throw new DAOException("No se ha encontrado la pelicula");
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
        
        return pelicula;
    }
    
    public Pelicula peliculaPorTitulo(String titulo) throws DAOException{
        PreparedStatement stat = null; 
        ResultSet rs = null; 
        Pelicula pelicula = null; 
        try {
            stat = conn.prepareStatement(GET_TITULO);
            stat.setString(1, titulo);
            rs = stat.executeQuery(); 
            if(rs.next()){
                pelicula = convertir(rs);
            }else{
                throw new DAOException("No se ha podido encontrar la pelicula con ese nombre");
            }
        } catch (SQLException e) {
            throw new DAOException("Error en SQL", e);
        } finally {
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new DAOException("Error en SQL rs", e);
                }
            }
            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException e) {
                    throw new DAOException("Error en SQL stat", e);
                }
            } 
        }
        return pelicula; 
    }
    
    public List<Pelicula> getPeliculasDirector(int id) throws DAOException{
        PreparedStatement stat = null; 
        ResultSet rs = null; 
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GET_DIRECTOR);
            stat.setInt(1, id);
            rs = stat.executeQuery();
            while(rs.next()){
                peliculas.add(convertir(rs));
            }
        } catch (SQLException e) {
            throw new DAOException("Error en SQL", e);
        } finally {
            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
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
        return peliculas; 
    }
    
    public List<Pelicula> getPeliculasEstudio(int id) throws DAOException{
        PreparedStatement stat = null; 
        ResultSet rs = null; 
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GET_ESTUDIO);
            stat.setInt(1, id);
            rs = stat.executeQuery();
            while(rs.next()){
                peliculas.add(convertir(rs));
            }
        } catch (SQLException e) {
            throw new DAOException("Error en SQL", e);
        } finally {
            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL", ex);
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
        return peliculas; 
    }
    
    private Pelicula convertir(ResultSet rs) throws SQLException{
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
    
}
