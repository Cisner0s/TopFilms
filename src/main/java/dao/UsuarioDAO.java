/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.EstatusUsuarios;
import model.RolUsuarios;
import model.Usuario;

/**
 *
 * @author jorge
 */
public class UsuarioDAO implements DAO<Usuario>{

    private final Connection conn; 
    
    final String INSERT = "INSERT INTO usuario(NICK, CONTRASENA, NOMBRE, ROL, ESTATUS) VALUES(?, ?, ?, ?, ?)";
    final String READ = "SELECT USUARIO_ID, NICK, CONTRASENA, NOMBRE, ROL, ESTATUS FROM usuario"; 
    final String UPDATE = "UPDATE usuario SET NICK = ?, CONTRASENA = ?, NOMBRE = ?, ROL= ?, ESTATUS= ? WHERE USUARIO_ID = ?"; 
    final String DELETE = "DELETE FROM usuario WHERE USUARIO_ID = ?";
    final String GET_ID = "SELECT USUARIO_ID, NICK, CONTRASENA, NOMBRE, ROL, ESTATUS FROM usuario WHERE USUARIO_ID = ?"; 
    final String GET_NICK = "SELECT USUARIO_ID, NICK, CONTRASENA, NOMBRE, ROL, ESTATUS FROM usuario WHERE NICK = ?";
    final String LOGIN = "SELECT COUNT(*) FROM usuario WHERE NICK = ? AND CONTRASENA = ?"; 
    final String REGISTER = "SELECT COUNT(*) FROM usuario WHERE NICK = ?";
    
    public UsuarioDAO(Connection conn){
        this.conn = conn; 
    }
    
    @Override
    public void create(Usuario a) throws DAOException {
        PreparedStatement stat = null; 
        try{
            stat = conn.prepareStatement(INSERT); 
            stat.setString(1, a.getNickName()); 
            stat.setString(2, a.getContraseña());
            stat.setString(3, a.getNombreCompleto());
            stat.setString(4, a.getRol().name());
            stat.setString(5, a.getEstatus().name());
            if(stat.executeUpdate() == 0){
                throw new DAOException("Puede que no se haya guardado.");
            }
            try (PreparedStatement statement = conn.prepareStatement("SELECT LAST_INSERT_ID()")) {
                ResultSet rs = statement.executeQuery();
                if (rs.next()) {
                    int idGenerado = rs.getInt(1);
                    a.setUsuario_id(idGenerado);
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
    public List<Usuario> read() throws DAOException {
        PreparedStatement stat = null; 
        ResultSet rs; 
        List<Usuario> usuarios = new ArrayList<>(); 
        try {
            stat = conn.prepareStatement(READ);
            rs = stat.executeQuery(); 
            while(rs.next()){
                usuarios.add(convertir(rs));
            }
        }catch(SQLException e){
            throw new DAOException("Error en SQL", e);
        }finally{
            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException e) {
                    throw new DAOException("Error en SQL.", e);
                }
            }
        }
        return usuarios;
    }

    @Override
    public void update(Usuario a) throws DAOException {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(UPDATE);
            
            stat.setString(1, a.getNickName()); 
            stat.setString(2, a.getContraseña());
            stat.setString(3, a.getNombreCompleto());
            stat.setString(4, a.getRol().name());
            stat.setString(5, a.getEstatus().name());
            stat.setInt(6, a.getUsuario_id());
            
             stat.executeUpdate();
             
        } catch(SQLException e){
            throw new DAOException("Error en SQL", e);
        }finally{
            if(stat != null){
                try {
                    stat.close();
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
                    stat.close();
                } catch (SQLException e) {
                    throw new DAOException("Error en SQL.", e);
                }
            }
        }
    }

    @Override
    public Usuario get(int id) throws DAOException {
        PreparedStatement stat = null; 
        ResultSet rs = null; 
        Usuario usuario = null; 
        try{
            stat = conn.prepareStatement(GET_ID);
            stat.setInt(1, id);
            rs = stat.executeQuery();
            if(rs.next()){
                usuario = convertir(rs);
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
       
        return usuario;
    }
    
    public Usuario get(String nickName) throws DAOException{
        PreparedStatement stat = null; 
        ResultSet rs = null; 
        Usuario usuario = null; 
        try{
            stat = conn.prepareStatement(GET_NICK);
            stat.setString(1, nickName);
            rs = stat.executeQuery();
            if(rs.next()){
                usuario = convertir(rs);
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
       
        return usuario;
    }
    
    public boolean login(String nickName, String password) throws DAOException{
        PreparedStatement stat = null; 
        ResultSet rs = null; 
        try{
            stat = conn.prepareStatement(LOGIN);
            stat.setString(1, nickName);
            stat.setString(2, password);
            rs = stat.executeQuery();
            if(rs.next()){
                int count = rs.getInt(1);
                return count > 0; 
            }
        }catch(SQLException e){
            throw new DAOException("Error en SQL");
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
        return false;
    }
    
    public boolean register(String nickName) throws DAOException{
        PreparedStatement stat = null; 
        ResultSet rs = null; 
        try {
            stat = conn.prepareStatement(REGISTER);
            stat.setString(1, nickName);
            rs = stat.executeQuery();
            if(rs.next()){
                int count = rs.getInt(1);
                return count == 0; 
            }
        } catch (SQLException e) {
            throw new DAOException("Error en SQL");
        } finally {
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
        return true; 
    }
    
    private Usuario convertir(ResultSet rs) throws SQLException{
        int id = rs.getInt("USUARIO_ID");
        String nick = rs.getString("NICK");
        String pass = rs.getString("CONTRASENA");
        String fullName = rs.getString("NOMBRE");
        String rolString = rs.getString("ROL");
        RolUsuarios rol = RolUsuarios.valueOf(rolString);
        String estatusString = rs.getString("ESTATUS");
        EstatusUsuarios estatus = EstatusUsuarios.valueOf(estatusString);
        Usuario usuario = new Usuario(nick, pass, fullName, rol, estatus);
        usuario.setUsuario_id(id);
        return usuario;
    }
}
