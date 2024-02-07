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
import model.Estudio;
import model.Pelicula;
import view.details.EstudioDetailsWindow;

/**
 *
 * @author jorge
 */
public class EstudioDetailsController {
    
    private final EstudioDetailsWindow view;
    private final PeliculaDAO filmDao; 
    private Estudio estudio;
    
    public EstudioDetailsController(EstudioDetailsWindow view, Estudio estudio){
        this.view = view; 
        this.estudio = estudio; 
        this.filmDao = new PeliculaDAO(Conexion.conectar());
        
        try {
            mostrarDetalles();
        } catch (DAOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudieron cargar las películas producidas por el estudio " + estudio.getNombre());
        }
    }
    
    private void mostrarDetalles() throws DAOException{
        view.jLabel_nombre.setText(estudio.getNombre());
        view.jLabel_propietario.setText(estudio.getPropietario());
        view.jLabel_fechaFund.setText(estudio.getFecha_Fundacion().toString());
        view.jLabel_patrimonio.setText(estudio.getPatrimonio() + "$");
        view.jLabel_sedes.setText(estudio.getSedes());
        
        List<Pelicula> peliculas = filmDao.getPeliculasEstudio(estudio.getEstudio_id());
        DefaultListModel<String> listModel = new DefaultListModel<>();
        view.jList_peliculas.setModel(listModel);
        
        for(Pelicula pelicula : peliculas){
            listModel.addElement(pelicula.getTitulo());
        }
    }
    
}
