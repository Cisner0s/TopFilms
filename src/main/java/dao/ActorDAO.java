package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Actor;

public class ActorDAO implements DAO<Actor>{

    private final Connection conn;
    
    final String INSERT = "INSERT INTO actor(NOMBRE, SEXO, FECHA_NACIMIENTO, LUGAR_NACIMIENTO, NACIONALIDAD, PREMIOS, IMAGEN) VALUES(?, ?, ?, ?, ?, ?, ?)";
    final String READ = "SELECT ACTOR_ID, NOMBRE, SEXO, FECHA_NACIMIENTO, LUGAR_NACIMIENTO, NACIONALIDAD, PREMIOS, IMAGEN FROM actor"; 
    final String UPDATE = "UPDATE actor SET NOMBRE = ?, SEXO = ?, FECHA_NACIMIENTO = ?, LUGAR_NACIMIENTO = ?, NACIONALIDAD = ?, PREMIOS = ?, IMAGEN = ? WHERE ACTOR_ID = ?"; 
    final String DELETE = "DELETE FROM actor WHERE ACTOR_ID = ?";
    final String GET = "SELECT ACTOR_ID, NOMBRE, SEXO, FECHA_NACIMIENTO, LUGAR_NACIMIENTO, NACIONALIDAD, PREMIOS, IMAGEN FROM actor WHERE ACTOR_ID = ?";   
    
    public ActorDAO(Connection conn){
        this.conn = conn; 
    }
    
    @Override
    public void create(Actor actor) throws DAOException{   
        PreparedStatement stat = null; 
        try{
            stat = conn.prepareStatement(INSERT); 
            stat.setString(1, actor.getNombre()); 
            stat.setString(2, actor.getSexo());
            stat.setDate(3, actor.getFechaNacimiento());
            stat.setString(4, actor.getLugarNacimiento());
            stat.setString(5, actor.getNacionalidad());
            stat.setString(6, actor.getPremios());
            stat.setString(7, actor.getImagen());
            if(stat.executeUpdate() == 0){
                throw new DAOException("Puede que no se haya guardado.");
            }
            try (PreparedStatement statement = conn.prepareStatement("SELECT LAST_INSERT_ID()")) {
                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    int idGenerado = rs.getInt(1);
                    actor.setId(idGenerado);
                }
            }
        } catch (SQLException e) {
            throw new DAOException("Error en SQL.", e);
        }finally{
            if(stat != null){
                try{
                    stat.close();
                }catch(SQLException e){
                    throw new DAOException("Error en SQL.", e); 
                }
            }
        }
    }
    
    
    @Override
    public List<Actor> read() throws DAOException {
        PreparedStatement stat = null; 
        ResultSet rs; 
        List<Actor> actores = new ArrayList<>(); 
        try {
            stat = conn.prepareStatement(READ);
            rs = stat.executeQuery(); 
            while(rs.next()){
                actores.add(convertir(rs));
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
        return actores;
    }

    @Override
    public void update(Actor a) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(UPDATE);
            stat.setString(1, a.getNombre());
            stat.setString(2, a.getSexo());
            stat.setDate(3, a.getFechaNacimiento());
            stat.setString(4, a.getLugarNacimiento());
            stat.setString(5, a.getNacionalidad());
            stat.setString(6, a.getPremios());
            stat.setString(7, a.getImagen());
        } catch(SQLException e){
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
    public void delete(int id) throws DAOException {
        PreparedStatement stat = null; 
        try{
            stat = conn.prepareStatement(DELETE);
            stat.setInt(1, id);
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
    public Actor get(int id) throws DAOException {
        PreparedStatement stat = null; 
        ResultSet rs = null; 
        Actor actor = null; 
        try{
            stat = conn.prepareStatement(GET);
            stat.setInt(1, id);
            rs = stat.executeQuery();
            if(rs.next()){
                actor = convertir(rs);
            }else{
                throw new DAOException("No se ha encontrado ese actor");
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
        
        return actor;
    }
    
    private Actor convertir(ResultSet rs) throws SQLException{
        int id = rs.getInt("ACTOR_ID");
        String nombre = rs.getString("NOMBRE");
        String sexo = rs.getString("SEXO");
        Date fechaNac = rs.getDate("FECHA_NACIMIENTO");
        String lugarNac = rs.getString("LUGAR_NACIMIENTO");
        String nacionalidad = rs.getString("NACIONALIDAD");
        String premios = rs.getString("PREMIOS");
        String imagen = rs.getString("IMAGEN");
        Actor actor = new Actor(nombre, sexo, fechaNac, lugarNac, nacionalidad, premios, imagen);
        actor.setId(id);
        return actor;
    }
}
