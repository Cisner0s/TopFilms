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
import javax.swing.JOptionPane;
import model.EstatusUsuarios;
import model.RolUsuarios;
import model.Usuario;
import view.AdminWindow;
import view.LoginWindow;
import view.RegisterWindow;
import view.UserWindow;

/**
 *
 * @author DCM
 */
public class RegisterController implements ActionListener{

    RegisterWindow regWindow; 
    UsuarioDAO dao; 
    
    public RegisterController(RegisterWindow regWindow){
        this.regWindow = regWindow;
        this.dao = new UsuarioDAO(Conexion.conectar());
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == regWindow.jButton_Registrarme){
            try {
                register();
            } catch (DAOException ex) {
            }
        }
        
        if(e.getSource() == regWindow.jComboBox_Rol){
            String selectedRole = (String) regWindow.jComboBox_Rol.getSelectedItem();

            // Habilitar o deshabilitar campos según la opción seleccionada
            if ("Administrador (Especial)".equals(selectedRole) || "Critico (Especial)".equals(selectedRole)) {
                regWindow.jPasswordField_ContraseñaRol.setEnabled(true);
                regWindow.jLabel_ContraseñaRol.setEnabled(true);

            } else {
                regWindow.jPasswordField_ContraseñaRol.setEnabled(false);
                regWindow.jLabel_ContraseñaRol.setEnabled(false);
            }
        }
        
        if(e.getSource() == regWindow.jButton_Atras){
            regWindow.dispose();
            new LoginWindow().setVisible(true);
        }
    }
    
    private void register() throws DAOException{
        if(regWindow.camposCompletos()){
            String nickName = regWindow.jTextField_Username.getText(); 
            String pass = new String(regWindow.jPasswordField_Contraseña.getPassword());
            String fullname = regWindow.jTextField_NombreCompleto.getText().trim();
            RolUsuarios rol = convertirJComboBox((String)regWindow.jComboBox_Rol.getSelectedItem());
            
           if(dao.register(nickName)){
               Usuario newUser = new Usuario(nickName, pass, fullname, rol, EstatusUsuarios.ACTIVO); 
               dao.create(newUser);
               
               switch(newUser.getRol()){
                    case USUARIO: 
                        regWindow.dispose();
                        new UserWindow(newUser).setVisible(true);
                        break;
                    case CRITICO: 
                        regWindow.dispose();
                        new UserWindow(newUser).setVisible(true);
                        break;
                    case ADMIN: 
                        regWindow.dispose();
                        new AdminWindow().setVisible(true);
                        break;
                }
           }else{
               JOptionPane.showMessageDialog(null, "Ya existe un usuario con ese nickname");
           }
        }else{
            JOptionPane.showMessageDialog(null, "Completa todos los campos.");
        }
    }
    
    private RolUsuarios convertirJComboBox(String option){
        switch(option){
            case "Usuario":
                return RolUsuarios.USUARIO;
            case "Critico (Especial)": 
                return RolUsuarios.CRITICO;
            case "Administrador (Especial)":
                return RolUsuarios.ADMIN; 
        }
        return null;
    } 
    
}
