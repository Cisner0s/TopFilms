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
    
    final String INSERT = "INSERT INTO pelicula(TITULO, SINOPSIS, GENERO, FECHA_ESTRENO, PRESUPUESTO, GANANCIAS, IMAGEN, director_id, ESTUDIO_ESTUDIO_ID) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    final String READ = "SELECT PELICULA_ID, TITULO, SINOPSIS, GENERO, FECHA_ESTRENO, PRESUPUESTO, GANANCIAS, IMAGEN, director_id, ESTUDIO_ESTUDIO_ID FROM pelicula"; 
    final String UPDATE = "UPDATE pelicula SET TITULO = ?, SINOPSIS = ?, GENERO = ?, FECHA_ESTRENO = ?, PRESUPUESTO = ?, GANANCIAS = ?, IMAGEN = ?, director_id = ?, ESTUDIO_ESTUDIO_ID = ? WHERE PELICULA_ID = ?"; 
    final String DELETE = "DELETE FROM pelicula WHERE PELICULA_ID = ?";
    final String GET = "SELECT TITULO, SINOPSIS, GENERO, FECHA_ESTRENO, PRESUPUESTO, GANANCIAS, IMAGEN, director_id, ESTUDIO_ESTUDIO_ID FROM pelicula WHERE PELICULA_ID = ?";  
    
    public PeliculaDAO(Connection conn){
        this.conn = conn;
    }

    @Override
    public void create(Pelicula a) throws DAOException {
        PreparedStatement stat = null; 
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setString(1, a.getTitulo());
            stat.setString(2, a.getSinopsis());
            stat.setString(3, a.getGenero());
            stat.setDate(4, a.getFecha_Estreno());
            stat.setLong(5, a.getPresupuesto());
            stat.setLong(6, a.getGanancias());
            stat.setString(7, a.getImagen());
            stat.setLong(8, a.getGanancias());
        } catch (Exception e) {
        } finally {
            if(stat != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL");
                }
            }
        }
    }

    @Override
    public List<Pelicula> read() throws DAOException {  
        PreparedStatement stat = null; 
        ResultSet rs; 
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
                    conn.close();
                } catch (SQLException e) {
                    throw new DAOException("Error en SQL.", e);
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
            stat = conn.prepareStatement(GET);
            stat.setInt(1, id);
            rs = stat.executeQuery();
            if(rs.next()){
                pelicula = (Pelicula) rs;
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
    
    public Pelicula convertir(ResultSet rs) throws SQLException{
        int id = rs.getInt(1);
        String titulo = rs.getString(2);
        String sinopsis = rs.getString(3);
        String genero = rs.getString(4);
        Date fechaEstreno = rs.getDate(5);
        long presupuesto = rs.getLong(6);
        long ganancias = rs.getLong(7);
        String imagen = rs.getString(8);
        int id_director = rs.getInt(9);
        int id_estudio = rs.getInt(10);
        Pelicula pelicula = new Pelicula(titulo, sinopsis, genero, fechaEstreno, presupuesto, ganancias, imagen, id_director, id_estudio);
        pelicula.setPelicula_id(id);
        return pelicula;
    }
    
}
