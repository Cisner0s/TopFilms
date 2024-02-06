/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ActorDAO;
import dao.Conexion;
import dao.DAOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.Actor;
import view.BorrarActorWindow;

/**
 *
 * @author fran
 */
public class BorrarActorController implements ActionListener {
    private final BorrarActorWindow borrarActorWindow;
    private final ActorDAO dao;
    public String id;
    private String nombre;
    
    public BorrarActorController (BorrarActorWindow borrarActorWindow) {
        this.borrarActorWindow = borrarActorWindow;
        this.dao = new ActorDAO(Conexion.conectar());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        id = borrarActorWindow.jTextField1.getText().trim();
        nombre = borrarActorWindow.jTextField2.getText().trim();
        
        if (e.getSource() instanceof JButton) {
            JButton botonClicado = (JButton) e.getSource();
            
            if (botonClicado.equals(borrarActorWindow.jButton_BuscarID)){
                try {
                    botonID();
                } catch (DAOException ex) {
                    Logger.getLogger(BorrarActorController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (botonClicado.equals(borrarActorWindow.jButton_Borrar)){
                try {
                    botonBorrar();
                } catch (DAOException ex) {
                    Logger.getLogger(BorrarActorController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (botonClicado.equals(borrarActorWindow.jButton_BuscarNombre)){
                try {
                    botonNombre();
                } catch (DAOException ex) {
                    Logger.getLogger(BorrarActorController.class.getName()).log(Level.SEVERE, null, ex);
                }            
            }
        }
    }
    
    public void botonID() throws DAOException {
        if (!"".equals(id)){
            try {
                int idInt = Integer.parseInt(id);
                String datos = dao.get(idInt).toString();
                borrarActorWindow.jTextArea1.setText(datos);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El campo ID debe contener un número.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Rellena el campo Actor_ID.");
        }
    }
    
    public void botonNombre() throws DAOException {
        System.out.println("Nombre: " + nombre );
        
        try{
            if (!"".equals(nombre)) {
                Actor actor;
                actor = dao.get(nombre);
                String datos = actor.toString();
                borrarActorWindow.jTextField1.setText(Integer.toString(actor.getId()));
                borrarActorWindow.jTextArea1.setText(datos);
            }
        } catch(DAOException e){
                    JOptionPane.showMessageDialog(null, "No se ha podido encontrar un actor con ese nombre en la base de datos.",  "Actor no encontrado", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void botonBorrar() throws DAOException {
        int idInt;
        if (!"".equals(id)) {
            try {
                idInt = Integer.parseInt(id);
                dao.delete(idInt);
                JOptionPane.showMessageDialog(null, "El actor se ha borrado correctamente.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El campo ID debe contener un número.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
    }
}
