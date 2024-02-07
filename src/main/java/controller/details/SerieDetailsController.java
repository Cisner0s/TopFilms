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
import dao.ResenaDAO;
import dao.SerieActorDAO;
import dao.UsuarioDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.Actor;
import model.Critica;
import model.Resena;
import model.RolUsuarios;
import model.Serie;
import model.Usuario;
import view.anadir.AnadirCriticaWindow;
import view.anadir.AnadirResenaWindow;
import view.details.PeliculaDetailsWindow;
import view.details.SerieDetailsWindow;

/**
 *
 * @author jorge
 */
public class SerieDetailsController implements ActionListener{
    
    private SerieDetailsWindow view; 
    private Serie serie; 
    private final Usuario user; 
    private final SerieActorDAO serActDao; 
    private final EstudioDAO estudioDao; 
    private final DirectorDAO directorDao;
    private final ResenaDAO resenaDao;
    private final CriticaDAO criticaDao; 
    private final UsuarioDAO userDao; 
    
    public SerieDetailsController(SerieDetailsWindow view, Serie serie){
        this.view = view; 
        this.serie = serie; 
        this.user = SessionDataSingleton.getInstance().getUsuario(); 
        this.serActDao = new SerieActorDAO(Conexion.conectar());
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
        view.jLabel_titulo.setText(serie.getTitulo());
        view.jLabel_genero.setText(serie.getGenero());
        view.jLabel_fechaEst.setText(serie.getFecha_Estreno().toString());
        view.jLabel_ganancias.setText(serie.getGanacias()+ "$");
        view.jLabel_presupuesto.setText(serie.getPresupuesto() + "$");
        view.jLabel_n_ep.setText(serie.getN_Episodios() + "");
        view.jLabel_n_temp.setText(serie.getN_Temporadas() + "");
        view.jLabel_durmed.setText(serie.getDuracion_Med_Episodio() + " min");
        
        String director;
        try {
            director = directorDao.get(serie.getDirector()).getNombre();
            view.jLabel_director.setText(director);
        } catch (DAOException ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido encontrar al director de la serie seleccionada.");
        }
        String estudio; 
        try {
            estudio = estudioDao.get(serie.getEstudio()).getNombre();
            view.jLabel_estudio.setText(estudio);
        } catch (DAOException ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido encontar al estudio de la serie seleccionada.");
        }
        
        //Mostrar lista de actores
        List<Actor> actores;
        try {
            actores = serActDao.obtenerActores(serie.getSerie_id());
            DefaultListModel<String> listModel = new DefaultListModel<>();
            view.jList_actores.setModel(listModel);
            for(Actor actor : actores){
                listModel.addElement(actor.getNombre());
            }
        } catch (DAOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo listar a los actores");
        }
        
        
        
        //Mostrar lista de resenas
        List<Resena> resenas;
        try {
            resenas = resenaDao.getResenasSeries(serie.getSerie_id());
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
        
        List<Critica> criticas; 
        try {
            criticas = criticaDao.getCriticasSeries(serie.getSerie_id());
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
    
    private String getNick(Resena resena) throws DAOException{
        String nick = userDao.get(resena.getUsuario()).getNickName();
        return nick; 
    }
    
    private String getNick(Critica critica) throws DAOException{
        String nick = userDao.get(critica.getUsuario_id()).getNickName();
        return nick; 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(user.getRol() == RolUsuarios.USUARIO){
            AnadirResenaWindow resenaView = new AnadirResenaWindow();
            AnadirResenaController ctr = new AnadirResenaController(resenaView, null, serie);
            resenaView.jButton_anadir.addActionListener(ctr);
            resenaView.setVisible(true);
        }
        if(user.getRol() == RolUsuarios.CRITICO){
            AnadirCriticaWindow criticaView = new AnadirCriticaWindow();
            AnadirCriticaController ctr = new AnadirCriticaController(criticaView, null, serie);
            criticaView.jButton_anadir.addActionListener(ctr);
            criticaView.setVisible(true);
        }
    }
}
