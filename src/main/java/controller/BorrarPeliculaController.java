/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.Conexion;
import dao.DAOException;
import dao.PeliculaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.Pelicula;
import view.BorrarPeliculaWindow;

/**
 *
 * @author fran
 */
public class BorrarPeliculaController implements ActionListener {
    private final BorrarPeliculaWindow borrarPeliculaWindow;
    private final PeliculaDAO dao;
    public String id;
    private String titulo;
    
    public BorrarPeliculaController (BorrarPeliculaWindow borrarPeliculaWindow) {
        this.borrarPeliculaWindow = borrarPeliculaWindow;
        this.dao = new PeliculaDAO(Conexion.conectar());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        id = borrarPeliculaWindow.jTextField1.getText().trim();
        titulo = borrarPeliculaWindow.jTextField2.getText().trim();

        if (e.getSource() instanceof JButton) {
            JButton botonClicado = (JButton) e.getSource();
            if (botonClicado.equals(borrarPeliculaWindow.jButton_BuscarID)){
                try {
                    botonID();
                } catch (DAOException ex) {
                    Logger.getLogger(BorrarPeliculaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (botonClicado.equals(borrarPeliculaWindow.jButton2)){
                try {
                    botonBorrar();
                } catch (DAOException ex) {
                    Logger.getLogger(BorrarPeliculaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (botonClicado.equals(borrarPeliculaWindow.jButton_BuscarTitulo)){
                try {
                    botonTitulo();
                } catch (DAOException ex) {
                    Logger.getLogger(BorrarPeliculaController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void botonID() throws DAOException {
        if (!"".equals(id)){
            try {
                int idInt = Integer.parseInt(id);
                try{
                String datos = dao.get(idInt).toString();
                borrarPeliculaWindow.jTextArea1.setText(datos);
                } catch (DAOException e){
                    JOptionPane.showMessageDialog(null, "No se ha podido encontrar una pelicula con ese ID en la base de datos.",  "Pelicula no encontrada", JOptionPane.ERROR_MESSAGE);

                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El campo ID debe contener un número.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Rellena el campo Pelicula_ID.");
        }
    }
    
    public void botonTitulo() throws DAOException {
        try{
            if (!"".equals(titulo)) {
                Pelicula pelicula;
                pelicula = dao.get(titulo);
                String datos = pelicula.toString();
                borrarPeliculaWindow.jTextField1.setText(Integer.toString(pelicula.getPelicula_id()));
                borrarPeliculaWindow.jTextArea1.setText(datos);
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
                JOptionPane.showMessageDialog(null, "La pelicula se ha borrado correctamente.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El campo ID debe contener un número.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
    }
}
