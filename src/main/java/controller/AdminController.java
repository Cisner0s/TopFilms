/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.AdminWindow;
import view.GestionContenidoWindow;
import view.GestionReseñasWindow;
import view.GestionUsuariosWindow;
import view.LoginWindow;

/**
 *
 * @author DCM
 */
public class AdminController{
    private final AdminWindow adminWindow;
    
    public AdminController(AdminWindow adminWindow) {
        this.adminWindow = adminWindow;
        buttons();
    }
    
    public void buttons(){
        adminWindow.jButton_GestionReseñas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GestionReseñasWindow().setVisible(true);
            }
        });
        
        adminWindow.jButton_GestionUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GestionUsuariosWindow().setVisible(true);
            }
        });
        
        adminWindow.jButton_GestionContenido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GestionContenidoWindow().setVisible(true);
            }
        });
        
        adminWindow.jButton_CerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminWindow.dispose();
                new LoginWindow().setVisible(true);
            }
        });
    }
}
