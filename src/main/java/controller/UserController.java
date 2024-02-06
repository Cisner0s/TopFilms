/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import model.Usuario;
import view.AjustesUsuarioWindow;
import view.BusquedaWindow;
import view.FilmWindow;
import view.ShowWindow;
import view.UserWindow;

/**
 *
 * @author fran
 */
public class UserController implements ActionListener {
    private final UserWindow userWindow;
    Usuario user;
    
    public UserController(UserWindow userWindow, Usuario user) {
        this.userWindow = userWindow;  
        this.user = user;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton botonClicado = (JButton) e.getSource();
            if (botonClicado.equals(userWindow.jButton_Peliculas)){
                new FilmWindow().setVisible(true);
            } else if (botonClicado.equals(userWindow.jButton_Shows)){
                new ShowWindow().setVisible(true);
            } else if (botonClicado.equals(userWindow.jButton_Ajustes)) {
                new AjustesUsuarioWindow(user).setVisible(true);
            } else if (botonClicado.equals(userWindow.jButton_Busqueda)) {
                new BusquedaWindow().setVisible(true);
            }
        }
    }
}
