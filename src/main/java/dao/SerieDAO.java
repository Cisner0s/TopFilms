/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Serie;

/**
 *
 * @author jorge
 */
public class SerieDAO implements DAO<Serie>{

    private final Connection conn; 
    
    private final String CREATE = "INSERT INTO serie(TITULO, FECHA_ESTRENO, GENERO, N_EPISODIOS, DURACION_MED_EPISODIO, N_TEMPORADAS, PRESUPUESTO, GANANCIAS, director_id, estudio_id)";
    private final String READ = "SELECT * FROM serie ";
    private final String UPDATE = "UPDATE serie SET TITULO = ?, FECHA_ESTRENO = ?, GENERO = ?, N_EPISODIOS = ?, DURACION_MED_EPISODIO = ?, N_TEMPORADAS = ?, PRESUPUESTO = ?, GANANCIAS = ?, director_id = ?, estudio_id = ? WHERE SERIE_ID = ?";
    private final String DELETE = "DELETE FROM serie WHERE SERIE_ID = ?";
    
    public SerieDAO(Connection conn){
        this.conn = conn;
    }
    
    @Override
    public void create(Serie a) throws DAOException {
        PreparedStatement stat = null; 
        try {
            stat = conn.prepareStatement(CREATE);
            stat.setString(1, a.getTitulo());
            stat.setDate(2, a.getFecha_Estreno());
            stat.setString(3, a.getGenero());
            stat.setInt(4, a.getN_Episodios());
            stat.setDouble(5, a.getDuracion_Med_Episodio());
            stat.setInt(6, a.getN_Temporadas());
            stat.setLong(7, a.getPresupuesto());
            stat.setLong(8, a.getGanacias());
            stat.setInt(9, a.getDirector());
            stat.setInt(10, a.getEstudio());
            stat.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Error en SQL.");
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
    public List read() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Serie a) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int a) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Serie get(int id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
