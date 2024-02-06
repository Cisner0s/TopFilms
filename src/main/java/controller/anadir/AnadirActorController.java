/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.anadir;

import dao.ActorDAO;
import dao.Conexion;
import dao.DAOException;
import dao.PeliculaActorDAO;
import dao.PeliculaDAO;
import dao.SerieActorDAO;
import dao.SerieDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.Actor;
import model.Pelicula;
import model.PeliculaActor;
import model.Serie;
import model.SerieActor;
import view.anadir.AnadirActorWindow;

/**
 *
 * @author jorge
 */
public class AnadirActorController implements ActionListener{
    
    private final AnadirActorWindow view; 
    private final PeliculaDAO filmDao; 
    private final SerieDAO serieDao;
    private final ActorDAO actorDao; 
    private final PeliculaActorDAO pelActDao; 
    private final SerieActorDAO serActDao;
    
    public AnadirActorController(AnadirActorWindow view) {
        this.view = view; 
        this.filmDao = new PeliculaDAO(Conexion.conectar());
        this.serieDao = new SerieDAO(Conexion.conectar());
        this.actorDao = new ActorDAO(Conexion.conectar());
        this.pelActDao = new PeliculaActorDAO(Conexion.conectar());
        this.serActDao = new SerieActorDAO(Conexion.conectar());
        try {
            initPeliculas();
            initSeries();
        } catch (DAOException ex) {
            System.out.println("Error PeliculaDAO");
        }
                
    }
 
    private void initPeliculas() throws DAOException{
        List<Pelicula> peliculas = filmDao.read();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        view.jList_peliculas.setModel(listModel);
      
        for(Pelicula pel : peliculas){
            listModel.addElement(pel.getTitulo());
        }   
    }

    private void initSeries() throws DAOException{
        List<Serie> series = serieDao.read();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        view.jList_series.setModel(listModel);
      
        for(Serie serie : series){
            listModel.addElement(serie.getTitulo());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(view.camposCompletos()){
            String nombre = view.jTextField_nombre.getText().trim();
            String sexo = view.jTextField_sexo.getText().trim();
            java.util.Date fechaNacUtil = view.jDateChooser_fechaNac.getDate();
            // Obtener la fecha sin la hora
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fechaNacUtil);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);

            Date fechaNac = new Date(calendar.getTimeInMillis());

            String lugarNac = view.jTextField_lugarNac.getText();
            String nacionalidad = view.jTextField_nacionalidad.getText();
            String premios = view.jTextArea_premios.getText();
            
            try {
                if(!actorDao.existe(nombre)){
                    Actor actor = new Actor(nombre, sexo, fechaNac, lugarNac, nacionalidad, premios);
                    actorDao.create(actor);
                    
                    List<Pelicula> peliculas = new ArrayList<>();
                    List<String> nombresPeliculas = view.jList_peliculas.getSelectedValuesList(); 
                    for(String nombrePelicula : nombresPeliculas){
                        peliculas.add(filmDao.get(nombrePelicula));
                    }
                    for(Pelicula pelicula : peliculas){
                        PeliculaActor relPelAct = new PeliculaActor(pelicula.getPelicula_id(), actor.getId());
                        pelActDao.create(relPelAct);
                    }
                    
                    List<Serie> series = new ArrayList<>();
                    List<String> nombresSeries = view.jList_series.getSelectedValuesList();
                    for(String nombreSerie : nombresSeries){
                        series.add(serieDao.get(nombreSerie));
                    }
                    for(Serie serie : series){
                        SerieActor relSerAct = new SerieActor(serie.getSerie_id(), actor.getId());
                        serActDao.create(relSerAct);
                    }
                    
                    
                    JOptionPane.showMessageDialog(null, "Actor creado correctamente.");
                }else{
                    JOptionPane.showMessageDialog(null, "El nombre de ese actor ya esta registrado.");
                }
            } catch (DAOException ex) {
                JOptionPane.showMessageDialog(null, "No pudo crearse el actor correctamente");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Por favor complete todos los campos obligatorios. El campo de premios puede dejarse vacío si el actor no ha recibido ningún premio.");
        }
    }
}
