/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.EstudioDAO;
import dao.Conexion;
import dao.DAOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.Estudio;
import view.BorrarEstudioWindow;

/**
 *
 * @author fran
 */
public class BorrarEstudioController implements ActionListener {
    private final BorrarEstudioWindow borrarEstudioWindow;
    private final EstudioDAO dao;
    public String id;
    private String nombre;
    
    public BorrarEstudioController (BorrarEstudioWindow borrarEstudioWindow) {
        this.borrarEstudioWindow = borrarEstudioWindow;
        this.dao = new EstudioDAO(Conexion.conectar());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        id = borrarEstudioWindow.jTextField1.getText().trim();
        nombre = borrarEstudioWindow.jTextField2.getText().trim();
        if (e.getSource() instanceof JButton) {
            JButton botonClicado = (JButton) e.getSource();
            if (botonClicado.equals(borrarEstudioWindow.jButton_BuscarID)){
                try {
                    botonID();
                } catch (DAOException ex) {
                    Logger.getLogger(BorrarEstudioController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (botonClicado.equals(borrarEstudioWindow.jButton2)){
                try {
                    botonBorrar();
                } catch (DAOException ex) {
                    Logger.getLogger(BorrarEstudioController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (botonClicado.equals(borrarEstudioWindow.jButton_BuscarNombre)){
                        System.out.println("prueba 2");

                try {
                    botonNombre();
                } catch (DAOException ex) {
                    Logger.getLogger(BorrarEstudioController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void botonID() throws DAOException {
        if (!"".equals(id)){
            try {
                int idInt = Integer.parseInt(id);
                String datos = dao.get(idInt).toString();
                borrarEstudioWindow.jTextArea1.setText(datos);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El campo ID debe contener un número.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Rellena el campo Estudio_ID.");
        }
    }
    
    public void botonBorrar() throws DAOException {
        int idInt;
        if (!"".equals(id)) {
            try {
                idInt = Integer.parseInt(id);
                dao.delete(idInt);
                JOptionPane.showMessageDialog(null, "El estudio se ha borrado correctamente.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El campo ID debe contener un número.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
    }
    
    public void botonNombre() throws DAOException {
        System.out.println("prueba 1");
        
        try{
            if (!"".equals(nombre)) {
                Estudio estudio;
                estudio = dao.get(nombre);
                String datos = estudio.toString();
                borrarEstudioWindow.jTextField1.setText(Integer.toString(estudio.getEstudio_id()));
                borrarEstudioWindow.jTextArea1.setText(datos);
            }
        } catch(DAOException e){
                    JOptionPane.showMessageDialog(null, "No se ha podido encontrar un actor con ese nombre en la base de datos.",  "Actor no encontrado", JOptionPane.ERROR_MESSAGE);
        }
    }
}
