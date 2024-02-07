/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.details;

import controller.SessionDataSingleton;
import controller.anadir.AnadirCriticaController;
import controller.anadir.AnadirResenaController;
import dao.Conexion;
import dao.CriticaDAO;
import dao.DAOException;
import dao.DirectorDAO;
import dao.EstudioDAO;
import dao.PeliculaActorDAO;
import dao.ResenaDAO;
import dao.UsuarioDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.Actor;
import model.Critica;
import model.Pelicula;
import model.Resena;
import model.RolUsuarios;
import model.Usuario;
import view.anadir.AnadirCriticaWindow;
import view.details.PeliculaDetailsWindow;
import view.anadir.AnadirResenaWindow;

/**
 *
 * @author jorge
 */
public class PeliculaDetailsController implements ActionListener{
    
    private PeliculaDetailsWindow view; 
    private Pelicula pelicula; 
    private final Usuario user; 
    private final PeliculaActorDAO pelActDao; 
    private final EstudioDAO estudioDao; 
    private final DirectorDAO directorDao;
    private final ResenaDAO resenaDao;
    private final CriticaDAO criticaDao; 
    private final UsuarioDAO userDao; 
    
    public PeliculaDetailsController(PeliculaDetailsWindow view, Pelicula pelicula){
        this.view = view; 
        this.pelicula = pelicula; 
        this.user = SessionDataSingleton.getInstance().getUsuario(); 
        this.pelActDao = new PeliculaActorDAO(Conexion.conectar());
        this.estudioDao = new EstudioDAO(Conexion.conectar());
        this.directorDao = new DirectorDAO(Conexion.conectar()); 
        this.resenaDao = new ResenaDAO(Conexion.conectar());
        this.criticaDao = new CriticaDAO(Conexion.conectar());
        this.userDao = new UsuarioDAO(Conexion.conectar());
        
        iniciarTextoBoton();
        mostrarInformacion();
        
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
    
    private void mostrarInformacion() {
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
        
        //Mostrar lista de actores
        List<Actor> actores;
        try {
            actores = pelActDao.obtenerActores(pelicula.getPelicula_id());
            DefaultListModel<String> listModel = new DefaultListModel<>();
            view.jList_actores.setModel(listModel);
            for(Actor actor : actores){
                listModel.addElement(actor.getNombre());
            }
        } catch (DAOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo listar a los actores");
        }
        
        listarResenas(); 
        listarCriticas();
        
                
    }
    
    private String getNick(Resena resena) throws DAOException{
        String nick = userDao.get(resena.getUsuario()).getNickName();
        return nick; 
    }
    
    private String getNick(Critica critica) throws DAOException{
        String nick = userDao.get(critica.getUsuario_id()).getNickName();
        return nick; 
    }
    
    public void listarResenas(){
        List<Resena> resenas; 
        try {
            resenas = resenaDao.getResenasPeliculas(pelicula.getPelicula_id());
            DefaultListModel listModel = new DefaultListModel<>();
            view.jList_resenas.setModel(listModel);
            for(Resena resena : resenas){
                String nick = getNick(resena);
                listModel.addElement("<html>" + resena.getTituloResena() + " - " + nick + "<br>" + 
                                     resena.getTextoResena());
            }
        } catch (DAOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se puedieron listar las reseñas");
        }
    }
    
    public void listarCriticas(){
        List<Critica> criticas; 
        try {
            criticas = criticaDao.getCriticasPeliculas(pelicula.getPelicula_id());
            DefaultListModel listModel = new DefaultListModel<>();
            view.jList_criticas.setModel(listModel);
            for(Critica critica : criticas){
                String nick = getNick(critica);
                listModel.addElement("<html>" + critica.getTitulo()+ " - " + nick + "<br>" + 
                                     critica.getTexto());
            }
        } catch (DAOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudieron listar las críticas.");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.jButton_anadirResena){
            if(user.getRol() == RolUsuarios.USUARIO){
                AnadirResenaWindow resenaView = new AnadirResenaWindow();
                AnadirResenaController ctr = new AnadirResenaController(resenaView, pelicula, null);
                resenaView.jButton_anadir.addActionListener(ctr);
                resenaView.setVisible(true);
            }
            if(user.getRol() == RolUsuarios.CRITICO){
                AnadirCriticaWindow criticaView = new AnadirCriticaWindow();
                AnadirCriticaController ctr = new AnadirCriticaController(criticaView, pelicula, null);
                criticaView.jButton_anadir.addActionListener(ctr);
                criticaView.setVisible(true);
            }
        }
        if(e.getSource() == view.jButton_refrescar){
            listarCriticas();
            listarResenas();
        }
        
    }
    
}
