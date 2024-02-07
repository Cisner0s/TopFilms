/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.details;

import dao.Conexion;
import dao.DAOException;
import dao.PeliculaDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.Director;
import model.Pelicula;
import view.details.DirectorDetailsWindow;

/**
 *
 * @author jorge
 */
public class DirectorDetailsController {
    
    private final DirectorDetailsWindow view; 
    private final PeliculaDAO filmDao; 
    private Director director; 
    
    public DirectorDetailsController(DirectorDetailsWindow view, Director director){
        this.view = view; 
        this.filmDao = new PeliculaDAO(Conexion.conectar());
        this.director = director; 
        
        try {
            mostrarDetalles();
        } catch (DAOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudieron cargar las peliculas dirigidas por el director " + director.getNombre());
        }
    }
    
    private void mostrarDetalles() throws DAOException{
        view.jLabel_nombre.setText(director.getNombre());
        view.jLabel_sexo.setText(director.getSexo());
        view.jLabel_fechaNac.setText(director.getFecha_Nacimiento().toString());
        view.jLabel_lugarNac.setText(director.getLugar_nacimiento());
        view.jLabel_nacionalidad.setText(director.getNacionalidad());
        view.jTextArea_premios.setText(director.getPremios());
        view.jTextArea_nominaciones.setText(director.getNominaciones());
        
        List<Pelicula> peliculas = filmDao.getPeliculasDirector(director.getDirector_id());
        DefaultListModel<String> listModel = new DefaultListModel<>(); 
        view.jList_peliculas.setModel(listModel);
        
        for(Pelicula pel : peliculas){
            listModel.addElement(pel.getTitulo());
        }
        
    }
    
}
