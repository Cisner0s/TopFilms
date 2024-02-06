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
import model.EstatusUsuarios;
import static model.EstatusUsuarios.ACTIVO;
import static model.EstatusUsuarios.INACTIVO;
import model.RolUsuarios;
import static model.RolUsuarios.ADMIN;
import static model.RolUsuarios.CRITICO;
import static model.RolUsuarios.USUARIO;
import model.Usuario;
import view.AjustesUsuarioWindow;

/**
 *
 * @author relam
 */
public class AjustesUsuarioController implements ActionListener {
    private final AjustesUsuarioWindow ajustesUsuarioWindow;
    private final UsuarioDAO dao;
    public Usuario user;
    
    public AjustesUsuarioController(AjustesUsuarioWindow ajustesUsuarioWindow, Usuario user) {
        this.ajustesUsuarioWindow = ajustesUsuarioWindow;
        this.user = user;
        this.dao = new UsuarioDAO(Conexion.conectar());
        ajustesUsuarioWindow.jTextField_Username.setText(user.getNickName());
        ajustesUsuarioWindow.jTextField_Contraseña.setText(user.getContraseña());
        ajustesUsuarioWindow.jTextField_NombreCompleto.setText(user.getNombreCompleto());
        if (user.getEstatus().equals(ACTIVO)){
            ajustesUsuarioWindow.jComboBox_Estatus.setSelectedIndex(0);
        } else if (user.getEstatus().equals(INACTIVO)) {
            ajustesUsuarioWindow.jComboBox_Estatus.setSelectedIndex(1);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton botonClicado = (JButton) e.getSource();
            if (botonClicado.equals(ajustesUsuarioWindow.jButton_Editar)){
                try {
                    botonEditar();
                } catch (DAOException ex) {
                    Logger.getLogger(AjustesUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (botonClicado.equals(ajustesUsuarioWindow.jButton_Borrar)){
                try {
                    botonBorrar();
                } catch (DAOException ex) {
                    Logger.getLogger(AjustesUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void botonEditar() throws DAOException {
        String u = ajustesUsuarioWindow.jTextField_Username.getText().trim();
        String pswd = ajustesUsuarioWindow.jTextField_Contraseña.getText().trim();
        String name = ajustesUsuarioWindow.jTextField_NombreCompleto.getText();
        int status = ajustesUsuarioWindow.jComboBox_Estatus.getSelectedIndex();
        RolUsuarios roleS = USUARIO;
        EstatusUsuarios statusS = ACTIVO;
        
         switch (status) {
                case 0 -> statusS = ACTIVO
;                case 1 -> statusS = INACTIVO;
                default -> {
            }
        }
         
        if (!"".equals(u) && !"".equals(pswd) && !"".equals(name) && !"".equals(status)) {
                Usuario us = new Usuario(u, pswd, name, roleS, statusS);
                us.setUsuario_id(user.getUsuario_id());
                dao.update(us);
                JOptionPane.showMessageDialog(null, "El usuario se ha editado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
    }
    
    public void botonBorrar() throws DAOException {
        dao.delete(user.getUsuario_id());
    }
}
