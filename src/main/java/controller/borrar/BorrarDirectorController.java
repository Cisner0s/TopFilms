/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.borrar;

import dao.Conexion;
import dao.DAOException;
import dao.DirectorDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.Director;
import view.borrar.BorrarDirectorWindow;

/**
 *
 * @author fran
 */
public class BorrarDirectorController implements ActionListener {
    private final BorrarDirectorWindow borrarDirectorWindow;
    private final DirectorDAO dao;
    public String id;
    private String nombre;
    
    public BorrarDirectorController (BorrarDirectorWindow borrarDirectorWindow) {
        this.borrarDirectorWindow = borrarDirectorWindow;
        this.dao = new DirectorDAO(Conexion.conectar());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        id = borrarDirectorWindow.jTextField1.getText().trim();
        nombre = borrarDirectorWindow.jTextField2.getText().trim();
        
        if (e.getSource() instanceof JButton) {
            JButton botonClicado = (JButton) e.getSource();
            if (botonClicado.equals(borrarDirectorWindow.jButton_BuscarID)){
                try {
                    botonID();
                } catch (DAOException ex) {
                    Logger.getLogger(BorrarDirectorController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (botonClicado.equals(borrarDirectorWindow.jButton_Borrar)){
                try {
                    botonBorrar();
                } catch (DAOException ex) {
                    Logger.getLogger(BorrarDirectorController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (botonClicado.equals(borrarDirectorWindow.jButton_BuscarNombre)){
                try {
                    botonNombre();
                } catch (DAOException ex) {
                    Logger.getLogger(BorrarDirectorController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void botonID() throws DAOException {
        if (!"".equals(id)){
            try {
                int idInt = Integer.parseInt(id);
                String datos = dao.get(idInt).toString();
                borrarDirectorWindow.jTextArea1.setText(datos);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El campo ID debe contener un número.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Rellena el campo Director_ID.");
        }
    }
    
    public void botonBorrar() throws DAOException {
        if (!"".equals(id)) {
            try {
                int idInt = Integer.parseInt(id);
                dao.delete(idInt);
                JOptionPane.showMessageDialog(null, "El director se ha borrado correctamente.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El campo ID debe contener un número.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
    }
    
    public void botonNombre() throws DAOException {
        try{
            if (!"".equals(nombre)) {
                Director director;
                director = dao.get(nombre);
                String datos = director.toString();
                borrarDirectorWindow.jTextField1.setText(Integer.toString(director.getDirector_id()));
                borrarDirectorWindow.jTextArea1.setText(datos);
            }
        } catch(DAOException e){
                    JOptionPane.showMessageDialog(null, "No se ha podido encontrar un actor con ese nombre en la base de datos.",  "Actor no encontrado", JOptionPane.ERROR_MESSAGE);
        }
    }
}
