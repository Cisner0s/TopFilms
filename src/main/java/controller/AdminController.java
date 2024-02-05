/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import view.AdminWindow;
import view.GestionContenidoWindow;
import view.GestionReseñasWindow;
import view.GestionUsuariosWindow;
import view.LoginWindow;

/**
 *
 * @author DCM
 */
public class AdminController implements ActionListener{
    private final AdminWindow adminWindow;
    
    public AdminController(AdminWindow adminWindow) {
        this.adminWindow = adminWindow;       
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton botonClicado = (JButton) e.getSource();
            if (botonClicado.equals(adminWindow.jButton_GestionReseñas)){
                new GestionReseñasWindow().setVisible(true);
            } else if (botonClicado.equals(adminWindow.jButton_GestionUsuarios)){
                new GestionUsuariosWindow().setVisible(true);
            } else if (botonClicado.equals(adminWindow.jButton_GestionContenido)) {
                new GestionContenidoWindow().setVisible(true);
            } else if (botonClicado.equals(adminWindow.jButton_CerrarSesion)) {
                adminWindow.dispose();
                new LoginWindow().setVisible(true);
            }
        }
    }
}
