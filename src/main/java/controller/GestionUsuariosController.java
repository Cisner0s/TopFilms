/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.Conexion;
import dao.DAOException;
import dao.UsuarioDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.Usuario;
import model.EstatusUsuarios;
import static model.EstatusUsuarios.ACTIVO;
import static model.EstatusUsuarios.INACTIVO;
import model.RolUsuarios;
import static model.RolUsuarios.USUARIO;
import static model.RolUsuarios.CRITICO;
import static model.RolUsuarios.ADMIN;
import view.GestionUsuariosWindow;

/**
 *
 * @author fran
 */
public class GestionUsuariosController implements ActionListener {
    private final GestionUsuariosWindow gestionUsuariosWindow;
    private final UsuarioDAO dao;
    public String username;
    public String id;
    public String u;
    public String pswd;
    public String name;
    public RolUsuarios roleS;
    public int role;
    public EstatusUsuarios statusS;
    public int status;
    
    public GestionUsuariosController(GestionUsuariosWindow gestionUsuariosWindow) {
        this.gestionUsuariosWindow = gestionUsuariosWindow;
        this.dao = new UsuarioDAO(Conexion.conectar());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        username = gestionUsuariosWindow.jTextField_Username.getText().trim();
        id = gestionUsuariosWindow.jTextField_UsuarioID.getText().trim();
        u = gestionUsuariosWindow.jTextField_NombreUsuario.getText().trim();
        pswd = gestionUsuariosWindow.jTextField_Contraseña.getText().trim();
        name = gestionUsuariosWindow.jTextField_NombreCompleto.getText();
        status = gestionUsuariosWindow.jComboBox_Estatus.getSelectedIndex();
        role = gestionUsuariosWindow.jComboBox_Rol.getSelectedIndex();
        
        switch (role) {
                case 0 -> roleS = USUARIO;
                case 1 -> roleS = CRITICO;
                case 2 -> roleS = ADMIN;
                default -> {
            }
        }
        
         switch (status) {
                case 0 -> statusS = ACTIVO
;                case 1 -> statusS = INACTIVO;
                default -> {
            }
        }
        
        if (e.getSource() instanceof JButton) {
            JButton botonClicado = (JButton) e.getSource();
            if (botonClicado.equals(gestionUsuariosWindow.jButton_Crear)){
                try {
                    botonCrear();
                } catch (DAOException ex) {
                    Logger.getLogger(GestionUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (botonClicado.equals(gestionUsuariosWindow.jButton_BuscarPorUsername)){
                try {
                    botonUsername();
                } catch (DAOException ex) {
                    Logger.getLogger(GestionUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (botonClicado.equals(gestionUsuariosWindow.jButton_Editar)) {
                try {
                    botonEditar();
                } catch (DAOException ex) {
                    Logger.getLogger(GestionUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (botonClicado.equals(gestionUsuariosWindow.jButton_Borrar)) {
                try {
                    botonBorrar();
                } catch (DAOException ex) {
                    Logger.getLogger(GestionUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (botonClicado.equals(gestionUsuariosWindow.jButton_BuscarPorID)) {
                try {
                    botonID();
                } catch (DAOException ex) {
                    Logger.getLogger(GestionUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void botonCrear() throws DAOException {
        if (!"".equals(u) && !"".equals(pswd) && !"".equals(u) && !"".equals(status)) {
                Usuario user = new Usuario(u, pswd, name, roleS, statusS);
                dao.create(user);
                JOptionPane.showMessageDialog(null, "El usuario se ha creado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
    }
    
    public void botonUsername() throws DAOException {
        try{
            if (!"".equals(username)) {
                Usuario user = dao.get(username);
                gestionUsuariosWindow.jTextField_NombreUsuario.setText(user.getNickName());
                gestionUsuariosWindow.jTextField_Contraseña.setText(user.getContraseña());
                gestionUsuariosWindow.jTextField_NombreCompleto.setText(user.getNombreCompleto());
                gestionUsuariosWindow.jTextField_UsuarioID.setText(Integer.toString(user.getUsuario_id()));

                if (user.getEstatus().equals(ACTIVO)){
                        gestionUsuariosWindow.jComboBox_Estatus.setSelectedIndex(0);
                } else if (user.getEstatus().equals(INACTIVO)) {
                        gestionUsuariosWindow.jComboBox_Estatus.setSelectedIndex(1);
                }

                switch (user.getRol()) {
                    case USUARIO -> gestionUsuariosWindow.jComboBox_Rol.setSelectedIndex(0);
                    case CRITICO -> gestionUsuariosWindow.jComboBox_Rol.setSelectedIndex(1);
                    case ADMIN -> gestionUsuariosWindow.jComboBox_Rol.setSelectedIndex(2);
                    default -> {
                    }
                }
            }
        } catch(DAOException e){
                    JOptionPane.showMessageDialog(null, "No se ha podido encontrar un usuario con ese nombre en la base de datos.",  "Usuario no encontrado", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void botonEditar() throws DAOException {
        if (!"".equals(u) && !"".equals(pswd) && !"".equals(name) && !"".equals(status)) {
                Usuario user = new Usuario(u, pswd, name, roleS, statusS);
                user.setUsuario_id(Integer.parseInt(id));
                dao.update(user);
                JOptionPane.showMessageDialog(null, "El usuario se ha editado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
    }
    
    public void botonBorrar() throws DAOException {
        int idInt;
        if (!"".equals(id)) {
            try {
                idInt = Integer.parseInt(id);
                dao.delete(idInt);
                JOptionPane.showMessageDialog(null, "El usuario se ha borrado correctamente.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El campo ID debe contener un número.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
    }
    
    public void botonID() throws DAOException {
        int idInt;
        
        try{
            if (!"".equals(id)) {
                try {
                    idInt = Integer.parseInt(id);
                    Usuario user = dao.get(idInt);
                    gestionUsuariosWindow.jTextField_Username.setText(user.getNickName());
                    gestionUsuariosWindow.jTextField_NombreUsuario.setText(user.getNickName());
                    gestionUsuariosWindow.jTextField_Contraseña.setText(user.getContraseña());
                    gestionUsuariosWindow.jTextField_NombreCompleto.setText(user.getNombreCompleto());
                    if (user.getEstatus().equals(ACTIVO)){
                        gestionUsuariosWindow.jComboBox_Estatus.setSelectedIndex(0);
                    } else if (user.getEstatus().equals(INACTIVO)) {
                        gestionUsuariosWindow.jComboBox_Estatus.setSelectedIndex(1);
                    }

                    switch (user.getRol()) {
                    case USUARIO -> gestionUsuariosWindow.jComboBox_Rol.setSelectedIndex(0);
                    case CRITICO -> gestionUsuariosWindow.jComboBox_Rol.setSelectedIndex(1);
                    case ADMIN -> gestionUsuariosWindow.jComboBox_Rol.setSelectedIndex(2);
                    default -> {
                    }
                }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "El campo ID debe contener un número.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
            }
        } catch (DAOException e) {
            JOptionPane.showMessageDialog(null, "No se ha podido encontrar un usuario con ese ID en la base de datos.",  "Usuario no encontrado", JOptionPane.ERROR_MESSAGE);
        }   
    }
}