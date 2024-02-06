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
    public List<Serie> read() throws DAOException {
        PreparedStatement stat = null; 
        ResultSet rs = null; 
        List<Serie> series = new ArrayList<>();
        try {
            stat = conn.prepareStatement(READ);
            rs = stat.executeQuery(); 
            while(rs.next()){
                series.add(convertir(rs));
            }
        } catch (SQLException e) {
            throw new DAOException("Error en SQL");
        } finally {
            if(stat != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new DAOException("Error en SQL.", e);
                }
            }
        }
        return series; 
    }

    @Override
    public void update(Serie a) throws DAOException {
        PreparedStatement stat = null; 
        try {
            stat = conn.prepareStatement(UPDATE);
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
            if(stat.executeUpdate() == 0){
                throw new DAOException("Puede que la serie no se haya guardado");
            }
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
    public void delete(int id) throws DAOException {
        PreparedStatement stat = null; 
        try {
            stat = conn.prepareStatement(DELETE);
            stat.setInt(1, id);
            if(stat.executeUpdate() == 0){
                throw new DAOException("Puede que la serie no se haya borrado correctamente.");
            }
        } catch (SQLException e) {
            throw new DAOException("Error en SQL");
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
    public Serie get(int id) throws DAOException {
        PreparedStatement stat = null; 
        ResultSet rs = null; 
        Serie serie = null; 
        try {
            stat = conn.prepareStatement(READ);
            rs = stat.executeQuery(); 
            if(rs.next()){
                serie = convertir(rs);
            }else{
                throw new DAOException("No se ha encontrado ese actor.");
            }
        } catch (SQLException e) {
            throw new DAOException("Error en SQL");
        } finally {
            if(stat != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new DAOException("Error en SQL.", e);
                }
            }
        }
        return serie; 
    }
    
    private Serie convertir(ResultSet rs) throws SQLException{
        int id = rs.getInt(1);
        String titulo = rs.getString(2);
        Date fechaEst = rs.getDate(3);
        String genero = rs.getString(4);
        int n_ep = rs.getInt(5);
        double dur_med = rs.getDouble(6);
        int n_temp = rs.getInt(7);
        long presupuesto = rs.getLong(8);
        long ganancias = rs.getLong(9);
        int director_id = rs.getInt(10);
        int estudio_id = rs.getInt(11);
        Serie serie = new Serie(titulo, fechaEst, genero, n_ep, dur_med, n_temp, presupuesto, ganancias, director_id, estudio_id);
        serie.setSerie_id(id);
        return serie; 
    }

}
