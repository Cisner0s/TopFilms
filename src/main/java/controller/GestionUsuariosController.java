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
    public String status;
    
    public GestionUsuariosController(GestionUsuariosWindow gestionUsuariosWindow) {
        this.gestionUsuariosWindow = gestionUsuariosWindow;
        this.dao = new UsuarioDAO(Conexion.conectar());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        username = gestionUsuariosWindow.jTextField22.getText().trim();
        id = gestionUsuariosWindow.jTextField23.getText().trim();
        u = gestionUsuariosWindow.jTextField21.getText().trim();
        pswd = gestionUsuariosWindow.jTextField34.getText().trim();
        name = gestionUsuariosWindow.jTextField35.getText();
        status = gestionUsuariosWindow.jTextField38.getText().trim();
        role = gestionUsuariosWindow.jComboBox_Rol.getSelectedIndex();
        
        switch (role) {
                case 0 -> roleS = USUARIO;
                case 1 -> roleS = CRITICO;
                case 2 -> roleS = ADMIN;
                default -> {
            }
        }
        
        if (e.getSource() instanceof JButton) {
            JButton botonClicado = (JButton) e.getSource();
            if (botonClicado.equals(gestionUsuariosWindow.jButton4)){
                try {
                    botonCrear();
                } catch (DAOException ex) {
                    Logger.getLogger(GestionUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (botonClicado.equals(gestionUsuariosWindow.jButton5)){
                try {
                    botonUsername();
                } catch (DAOException ex) {
                    Logger.getLogger(GestionUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (botonClicado.equals(gestionUsuariosWindow.jButton6)) {
                try {
                    botonEditar();
                } catch (DAOException ex) {
                    Logger.getLogger(GestionUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (botonClicado.equals(gestionUsuariosWindow.jButton7)) {
                try {
                    botonBorrar();
                } catch (DAOException ex) {
                    Logger.getLogger(GestionUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (botonClicado.equals(gestionUsuariosWindow.jButton8)) {
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
            if ("Activo".equals(status)){
                statusS = ACTIVO;
                Usuario user = new Usuario(u, pswd, name, roleS, statusS);
                dao.create(user);
                JOptionPane.showMessageDialog(null, "El usuario se ha creado correctamente.");
            } else if ("Inactivo".equals(status)) {
                statusS = INACTIVO;
                Usuario user = new Usuario(u, pswd, name, roleS, statusS);
                dao.create(user);
                JOptionPane.showMessageDialog(null, "El usuario se ha creado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El estado debe ser 'Activo' o 'Inactivo'.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
    }
    
    public void botonUsername() throws DAOException {
        if (!"".equals(username)) {
            Usuario user = dao.get(username);
            gestionUsuariosWindow.jTextField21.setText(user.getNickName());
            gestionUsuariosWindow.jTextField34.setText(user.getContraseña());
            gestionUsuariosWindow.jTextField35.setText(user.getNombreCompleto());
            if (user.getEstatus().equals(ACTIVO)){
                gestionUsuariosWindow.jTextField38.setText("Activo");
            } else if (user.getEstatus().equals(INACTIVO)) {
                gestionUsuariosWindow.jTextField38.setText("Inactivo");
            }
        
            if (user.getRol().equals(0)){ 
                gestionUsuariosWindow.jComboBox_Rol.setSelectedIndex(0);
            } else if (user.getRol().equals(1)) {
                gestionUsuariosWindow.jComboBox_Rol.setSelectedIndex(1);
            } else if (user.getRol().equals(2)) {
                gestionUsuariosWindow.jComboBox_Rol.setSelectedIndex(2);
            }
        }
    }
    
    public void botonEditar() throws DAOException {
        if (!"".equals(u) && !"".equals(pswd) && !"".equals(u) && !"".equals(status)) {
            if ("Activo".equals(status)){
                statusS = ACTIVO;
                Usuario user = new Usuario(u, pswd, name, roleS, statusS);
                dao.update(user);
                JOptionPane.showMessageDialog(null, "El usuario se ha editado correctamente.");
            } else if ("Inactivo".equals(status)) {
                statusS = INACTIVO;
                Usuario user = new Usuario(u, pswd, name, roleS, statusS);
                dao.update(user);
                JOptionPane.showMessageDialog(null, "El usuario se ha editado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El estado debe ser 'Activo' o 'Inactivo'.");
            }
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
                JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
    }
    
    public void botonID() throws DAOException {
        int idInt;
        if (!"".equals(id)) {
            try {
                idInt = Integer.parseInt(id);
                Usuario user = dao.get(idInt);
                gestionUsuariosWindow.jTextField22.setText(user.getNickName());
                gestionUsuariosWindow.jTextField21.setText(user.getNickName());
                gestionUsuariosWindow.jTextField34.setText(user.getContraseña());
                gestionUsuariosWindow.jTextField35.setText(user.getNombreCompleto());
                if (user.getEstatus().equals(ACTIVO)){
                    gestionUsuariosWindow.jTextField38.setText("Activo");
                } else if (user.getEstatus().equals(INACTIVO)) {
                    gestionUsuariosWindow.jTextField38.setText("Inactivo");
                }
        
                if (user.getRol().equals(0)){ 
                    gestionUsuariosWindow.jComboBox_Rol.setSelectedIndex(0);
                } else if (user.getRol().equals(1)) {
                    gestionUsuariosWindow.jComboBox_Rol.setSelectedIndex(1);
                } else if (user.getRol().equals(2)) {
                    gestionUsuariosWindow.jComboBox_Rol.setSelectedIndex(2);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
    }
}