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
import view.CriticoWindow;
import view.LoginWindow;
import view.UserWindow;

/**
 *
 * @author DCM
 */
public class LoginActionController implements ActionListener{

    private final LoginWindow loginWindow; 
    private final UsuarioDAO dao; 
    
    public LoginActionController(LoginWindow loginWindow){
        this.loginWindow = loginWindow; 
        this.dao = new UsuarioDAO(Conexion.conectar()); 
        loginWindow.jButton_Acceder.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            login();
        } catch (DAOException ex) {
        }
    }
    
    public void login() throws DAOException{
        String nickName = loginWindow.getNickName();
        String password = loginWindow.getPassword();
        System.out.println("'" + nickName + "'");
        if (!"Nombre de usuario".equals(nickName) && !"Contraseña".equals(password)) {
            
            if(dao.login(nickName, password)){
                
                Usuario user = dao.get(nickName);
                
                if(user.getEstatus() != EstatusUsuarios.INACTIVO){
                    switch(user.getRol()){
                        case USUARIO: 
                            loginWindow.dispose();
                            new UserWindow().setVisible(true);
                            break;
                        case CRITICO: 
                            loginWindow.dispose();
                            new CriticoWindow().setVisible(true);
                            break;
                        case ADMIN: 
                            loginWindow.dispose();
                            new AdminWindow().setVisible(true);
                            break;
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Su cuenta de usuario"
                            + " ha sido marcada como inactiva. Le recomendamos "
                            + "que se ponga en contacto con los administradores "
                            + "del sistema para solicitar que su cuenta sea reactivada.");
                }
                
                
            }else{
                JOptionPane.showMessageDialog(null, "Datos introducidos incorrectos");
            }

            /*
            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select ROL, ESTATUS from usuario where NICK = '" + user
                        + "' and CONTRASENA = '" + pass + "'");

                ResultSet rs = pst.executeQuery();
                if (rs.next()) {

                    String tipo_nivel = rs.getString("ROL");
                    String estatus = rs.getString("ESTATUS");

                    if (tipo_nivel.equalsIgnoreCase("ADMIN") && estatus.equalsIgnoreCase("Activo")) {
                        //dispose(); Hace que el JFrame sea destruido y limpiado por el sistema operativo.
                        dispose();
                        new AdminWindow().setVisible(true);
                    } else if (tipo_nivel.equalsIgnoreCase("CRITICO") && estatus.equalsIgnoreCase("ACTIVO")) {
                        dispose();
                        new CriticoWindow().setVisible(true);
                    } else if (tipo_nivel.equalsIgnoreCase("USUARIO") && estatus.equalsIgnoreCase("ACTIVO")) {
                        dispose();
                        new UserWindow().setVisible(true);
                    }

                } else {
                    intentos -= 1;
                    txt_user.setText("Nombre de usuario");
                    txt_user.setForeground(Color.gray);
                    txt_password.setText("Contraseña");
                    txt_password.setForeground(Color.gray);
                    txt_password.setEchoChar((char) 0);
                    if (intentos == 0){
                        JOptionPane.showMessageDialog(null, "No le quedan más intentos, vuelva más tarde.");
                        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
                        jButton_Acceder.setEnabled(false);
                        scheduler.schedule(() -> jButton_Acceder.setEnabled(true), 10, TimeUnit.MINUTES);
                        intentos = 3;
                    } else {
                        JOptionPane.showMessageDialog(null, "Datos de acceso incorrectos. Le quedan " + intentos + " intento(s).");
                    }
                }

            } catch (SQLException e) {
                System.err.println("Error en el botón Acceder." + e);
                JOptionPane.showMessageDialog(null, "¡¡ERROR al iniciar!!, contacte al administrador.");
            }
            */
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
    }
    
}
