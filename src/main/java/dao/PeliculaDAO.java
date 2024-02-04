/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import model.Pelicula;

/**
 *
 * @author jorge
 */
public class PeliculaDAO implements DAO<Pelicula>{

    
    private final Connection conn;
    
    final String INSERT = "INSERT INTO pelicula(TITULO, SINOPSIS, GENERO, FECHA_ESTRENO, PRESUPUESTO, GANANCIAS, IMAGEN, director_id, ESTUDIO_ESTUDIO_ID) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    final String READ = "SELECT TITULO, SINOPSIS, GENERO, FECHA_ESTRENO, PRESUPUESTO, GANANCIAS, IMAGEN, director_id, ESTUDIO_ESTUDIO_ID FROM pelicula"; 
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
            stat.setInt(5, a.getPresupuesto());
            stat.setInt(6, a.getGanancias());
            stat.setString(7, a.getImagen());
            stat.setInt(8, a.getGanancias());
        } catch (Exception e) {
        } finally {
        }
    }

    @Override
    public List<Pelicula> read() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Pelicula a) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int a) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Pelicula get(int id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
