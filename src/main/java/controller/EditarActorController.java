/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ActorDAO;
import dao.Conexion;
import dao.DAOException;
import dao.UsuarioDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import view.editar.EditarActorWindow;
import view.GestionUsuariosWindow;

/**
 *
 * @author fran
 */
public class EditarActorController implements ActionListener{
    private final EditarActorWindow editarActorWindow;
    private final ActorDAO dao;
    
    public EditarActorController(EditarActorWindow editarActorWindow) {
        this.editarActorWindow = editarActorWindow;
        this.dao = new ActorDAO(Conexion.conectar());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() instanceof JButton) {
            JButton botonClicado = (JButton) e.getSource();
            if (botonClicado.equals(editarActorWindow.jButton5)){
                try {
                    botonID();
                } catch (DAOException ex) {
                    Logger.getLogger(GestionUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (botonClicado.equals(editarActorWindow.jButton4)){
                try {
                    botonEditar();
                } catch (DAOException ex) {
                    Logger.getLogger(GestionUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void botonID() throws DAOException {
        
    }
    
    public void botonEditar() throws DAOException {

    }
}
