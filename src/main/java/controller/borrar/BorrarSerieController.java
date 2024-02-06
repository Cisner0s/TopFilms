/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.borrar;

import dao.Conexion;
import dao.DAOException;
import dao.SerieDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.Serie;
import view.borrar.BorrarSerieWindow;

/**
 *
 * @author fran
 */
public class BorrarSerieController implements ActionListener {
    private final BorrarSerieWindow borrarSerieWindow;
    private final SerieDAO dao;
    public String id;
    private String titulo;
    
    public BorrarSerieController (BorrarSerieWindow borrarSerieWindow) {
        this.borrarSerieWindow = borrarSerieWindow;
        this.dao = new SerieDAO(Conexion.conectar());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        id = borrarSerieWindow.jTextField1.getText().trim();
        titulo = borrarSerieWindow.jTextField2.getText().trim();
        
        if (e.getSource() instanceof JButton) {
            JButton botonClicado = (JButton) e.getSource();
            if (botonClicado.equals(borrarSerieWindow.jButton_BuscarID)){
                try {
                    botonID();
                } catch (DAOException ex) {
                    Logger.getLogger(BorrarSerieController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (botonClicado.equals(borrarSerieWindow.jButton2)){
                try {
                    botonBorrar();
                } catch (DAOException ex) {
                    Logger.getLogger(BorrarSerieController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  else if (botonClicado.equals(borrarSerieWindow.jButton_BuscarTitulo)){
                try {
                    botonTitulo();
                } catch (DAOException ex) {
                    Logger.getLogger(BorrarSerieController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void botonID() throws DAOException {
        if (!"".equals(id)){
            try {
                int idInt = Integer.parseInt(id);
                String datos = dao.get(idInt).toString();
                borrarSerieWindow.jTextArea1.setText(datos);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El campo ID debe contener un número.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Rellena el campo Serie_ID.");
        }
    }
    
        public void botonTitulo() throws DAOException {
        try{
            if (!"".equals(titulo)) {
                Serie serie;
                serie = dao.get(titulo);
                String datos = serie.toString();
                borrarSerieWindow.jTextField1.setText(Integer.toString(serie.getSerie_id()));
                borrarSerieWindow.jTextArea1.setText(datos);
            }
        } catch(DAOException e){
                    JOptionPane.showMessageDialog(null, "No se ha podido encontrar una serie con ese nombre en la base de datos.",  "Serie no encontrada", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void botonBorrar() throws DAOException {
        int idInt;
        if (!"".equals(id)) {
            try {
                idInt = Integer.parseInt(id);
                dao.delete(idInt);
                JOptionPane.showMessageDialog(null, "La serie se ha borrado correctamente.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El campo ID debe contener un número.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
    }
}
