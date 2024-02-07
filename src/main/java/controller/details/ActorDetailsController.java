/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.details;

import dao.Conexion;
import dao.DAOException;
import dao.PeliculaActorDAO;
import dao.PeliculaDAO;
import dao.SerieActorDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.Actor;
import model.Pelicula;
import model.Serie;
import view.details.ActorDetailsWindow;

/**
 *
 * @author jorge
 */
public class ActorDetailsController {
    
    private final ActorDetailsWindow view; 
    private final PeliculaActorDAO pelActDao; 
    private final SerieActorDAO serActDao;
    private Actor actor;  
    
    public ActorDetailsController(ActorDetailsWindow view, Actor actor){
        this.view = view; 
        this.actor = actor;
        this.serActDao = new SerieActorDAO(Conexion.conectar());
        this.pelActDao = new PeliculaActorDAO(Conexion.conectar());
        
        try {
            mostrarInformacion();
        } catch (DAOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudieron mostrar las peliculas y series en las que actua.");
        }
    }
    
    private void mostrarInformacion() throws DAOException{
        view.jLabel_nombre.setText(actor.getNombre());
        view.jLabel_sexo.setText(actor.getSexo());
        view.jLabel_nacionalidad.setText(actor.getNacionalidad());
        view.jLabel_lugarNac.setText(actor.getLugarNacimiento());
        view.jLabel_fechaNac.setText(actor.getFechaNacimiento().toString());
        view.jLabel_premios.setText(actor.getPremios());
        
        List<Pelicula> peliculas = pelActDao.obtenerPeliculas(actor.getId());
        DefaultListModel<String> listModel = new DefaultListModel<>();
        view.jList_peliculas.setModel(listModel);
      
        for(Pelicula pel : peliculas){
            listModel.addElement(pel.getTitulo());
        }   
        
        List<Serie> series = serActDao.obtenerSeries(actor.getId());
        listModel = new DefaultListModel<>();
        view.jList_series.setModel(listModel);
      
        for(Serie ser : series){
            listModel.addElement(ser.getTitulo());
        }  
    }
    
    
    
}
