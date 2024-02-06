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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.Pelicula;
import view.AnadirActorWindow;

/**
 *
 * @author jorge
 */
public class AnadirActorController implements ActionListener{
    
    private final AnadirActorWindow view; 
    private final PeliculaDAO filmDao; 
    
    public AnadirActorController(AnadirActorWindow view) {
        this.view = view; 
        this.filmDao = new PeliculaDAO(Conexion.conectar());
        try {
            initPeliculas();
        } catch (DAOException ex) {
            System.out.println("Error PeliculaDAO");
        }
                
    }
    
    public void initPeliculas() throws DAOException{
        List<Pelicula> peliculas = filmDao.read();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        view.jList_peliculas.setModel(listModel);
      
        for(Pelicula pel : peliculas){
            listModel.addElement(pel.getTitulo());
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(view.camposCompletos()){
            
        }else{
            JOptionPane.showMessageDialog(null, "Por favor complete todos los campos obligatorios. El campo de premios puede dejarse vacío si el actor no ha recibido ningún premio.");
        }
    }
    
    
            
    
            
    
}
