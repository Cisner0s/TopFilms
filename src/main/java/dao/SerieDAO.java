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
import model.Serie;

/**
 *
 * @author jorge
 */
public class SerieDAO implements DAO<Serie>{

    private final Connection conn; 
    
    private final String CREATE = "INSERT INTO serie(TITULO, FECHA_ESTRENO, GENERO, N_EPISODIOS, DURACION_MED_EPISODIO, N_TEMPORADAS, PRESUPUESTO, GANANCIAS, director_id, estudio_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String READ = "SELECT * FROM serie ";
    private final String UPDATE = "UPDATE serie SET TITULO = ?, FECHA_ESTRENO = ?, GENERO = ?, N_EPISODIOS = ?, DURACION_MED_EPISODIO = ?, N_TEMPORADAS = ?, PRESUPUESTO = ?, GANANCIAS = ?, director_id = ?, estudio_id = ? WHERE SERIE_ID = ?";
    private final String DELETE = "DELETE FROM serie WHERE SERIE_ID = ?";
    private final String GET_BY_ID = "SELECT SERIE_ID, TITULO, FECHA_ESTRENO, GENERO, N_EPISODIOS, DURACION_MED_EPISODIO, N_TEMPORADAS, PRESUPUESTO, GANANCIAS, director_id, estudio_id FROM serie WHERE SERIE_ID = ?";  
    private final String GET_BY_TITULO = "SELECT SERIE_ID, TITULO, FECHA_ESTRENO, GENERO, N_EPISODIOS, DURACION_MED_EPISODIO, N_TEMPORADAS, PRESUPUESTO, GANANCIAS, director_id, estudio_id FROM serie WHERE TITULO = ?";  

    
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
                    stat.close();
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
            stat.setInt(11, a.getSerie_id());
            
            stat.executeUpdate();

            if(stat.executeUpdate() == 0){
                throw new DAOException("Puede que la serie no se haya guardado");
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
    public void delete(int id) throws DAOException {
        PreparedStatement stat = null; 
        try {
            PreparedStatement deletePeliculaActorStmt = conn.prepareStatement("DELETE FROM serie_actor WHERE serie_id = ?");
            deletePeliculaActorStmt.setInt(1, id);
            deletePeliculaActorStmt.executeUpdate();
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
                    stat.close();
                } catch (SQLException ex) {
                    throw new DAOException("Error en SQL");
                }
            }
        }
    }

    public Serie read(int id) throws DAOException {
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
                    stat.close();
                } catch (SQLException e) {
                    throw new DAOException("Error en SQL.", e);
                }
            }
        }
        return serie; 
    }
    
    @Override
     public Serie get(int id) throws DAOException {
        PreparedStatement stat = null; 
        ResultSet rs = null; 
        Serie serie = null; 
        try {
            stat = conn.prepareStatement(GET_BY_ID);
            stat.setInt(1, id);
            rs = stat.executeQuery(); 
            if(rs.next()){
                serie = convertir(rs);
            }else{
                throw new DAOException("No se ha encontrado esa serie.");
            }
        } catch (SQLException e) {
            throw new DAOException("Error en SQL");
        } finally {
            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException e) {
                    throw new DAOException("Error en SQL.", e);
                }
            }
        }
        return serie; 
    }
     
    public Serie get(String titulo) throws DAOException {
        PreparedStatement stat = null; 
        ResultSet rs; 
        Serie serie = null; 
        try {
            stat = conn.prepareStatement(GET_BY_TITULO);
            stat.setString(1, titulo);
            rs = stat.executeQuery(); 
            if(rs.next()){
                serie = convertir(rs);
            }else{
                throw new DAOException("No se ha encontrado esa serie.");
            }
        } catch (SQLException e) {
            throw new DAOException("Error en SQL");
        } finally {
            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException e) {
                    throw new DAOException("Error en SQL.", e);
                }
            }
        }
        return serie; 
    }
    
    private Serie convertir(ResultSet rs) throws SQLException{
        int id = rs.getInt("SERIE_ID");
        String titulo = rs.getString("TITULO");
        Date fechaEst = rs.getDate("FECHA_ESTRENO");
        String genero = rs.getString("GENERO");
        int n_ep = rs.getInt("N_EPISODIOS");
        double dur_med = rs.getDouble("DURACION_MED_EPISODIO");
        int n_temp = rs.getInt("N_TEMPORADAS");
        long presupuesto = rs.getLong("PRESUPUESTO");
        long ganancias = rs.getLong("GANANCIAS");
        int director_id = rs.getInt("director_id");
        int estudio_id = rs.getInt("estudio_id");
        Serie serie = new Serie(titulo, fechaEst, genero, n_ep, dur_med, n_temp, presupuesto, ganancias, director_id, estudio_id);
        serie.setSerie_id(id);
        return serie; 
    }
}
