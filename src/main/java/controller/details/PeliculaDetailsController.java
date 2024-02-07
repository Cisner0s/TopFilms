/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.details;

import controller.SessionDataSingleton;
import dao.Conexion;
import dao.DAOException;
import dao.DirectorDAO;
import dao.EstudioDAO;
import dao.PeliculaActorDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.Actor;
import model.Pelicula;
import model.RolUsuarios;
import model.Usuario;
import view.details.PeliculaDetailsWindow;

/**
 *
 * @author jorge
 */
public class PeliculaDetailsController {
    
    private PeliculaDetailsWindow view; 
    private Pelicula pelicula; 
    private final Usuario user; 
    private final PeliculaActorDAO pelActDao; 
    private final EstudioDAO estudioDao; 
    private final DirectorDAO directorDao;
    
    public PeliculaDetailsController(PeliculaDetailsWindow view, Pelicula pelicula){
        this.view = view; 
        this.pelicula = pelicula; 
        this.user = SessionDataSingleton.getInstance().getUsuario(); 
        this.pelActDao = new PeliculaActorDAO(Conexion.conectar());
        this.estudioDao = new EstudioDAO(Conexion.conectar());
        this.directorDao = new DirectorDAO(Conexion.conectar()); 
        
        iniciarTextoBoton();
        try {
            mostrarInformacion();
        } catch (DAOException ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido encontrar a los actres de la pelicula seleccionada");
        }
    }
    
    private void iniciarTextoBoton(){
        RolUsuarios rol = user.getRol();
        if(rol == RolUsuarios.USUARIO){
            view.jButton_anadirResena.setText("Añadir reseña");
        }
        if(rol == RolUsuarios.CRITICO){
            view.jButton_anadirResena.setText("Añadir crítica");
        }
    }
    
    private void mostrarInformacion() throws DAOException{
        view.jLabel_titulo.setText(pelicula.getTitulo());
        view.jLabel_genero.setText(pelicula.getGenero());
        view.jLabel_fechaEstreno.setText(pelicula.getFecha_Estreno().toString());
        view.jLabel_ganancias.setText(pelicula.getGanancias() + "$");
        view.jLabel_presupuesto.setText(pelicula.getPresupuesto() + "$");
        view.jLabel_duracion.setText(pelicula.getDuracion() + " min");
        
        String director;
        try {
            director = directorDao.get(pelicula.getDirector()).getNombre();
            view.jLabel_director.setText(director);
        } catch (DAOException ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido encontrar al director de la película seleccionada.");
        }
        String estudio; 
        try {
            estudio = estudioDao.get(pelicula.getEstudio()).getNombre();
            view.jLabel_estudio.setText(estudio);
        } catch (DAOException ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido encontar al estudio de la pelicula seleccionada.");
        }
        
        
        List<Actor> actores = pelActDao.obtenerActores(pelicula.getPelicula_id());
        DefaultListModel<String> listModel = new DefaultListModel<>();
        view.jList_actores.setModel(listModel);
        for(Actor actor : actores){
            listModel.addElement(actor.getNombre());
        }
        
                
    }
    
}
