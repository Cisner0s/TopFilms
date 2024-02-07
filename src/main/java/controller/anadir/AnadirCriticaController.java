/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.anadir;

import controller.SessionDataSingleton;
import dao.Conexion;
import dao.CriticaDAO;
import dao.DAOException;
import dao.ResenaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Critica;
import model.Pelicula;
import model.Resena;
import model.Serie;
import model.Usuario;
import view.anadir.AnadirCriticaWindow;

/**
 *
 * @author jorge
 */
public class AnadirCriticaController implements ActionListener{
    
    private final AnadirCriticaWindow view;
    private final Pelicula pelicula; 
    private final Serie serie; 
    private final CriticaDAO criticaDao;
    private final Usuario user; 
    
    public AnadirCriticaController(AnadirCriticaWindow view, Pelicula pelicula, Serie serie){
        this.view = view; 
        this.pelicula = pelicula; 
        this.serie = serie; 
        this.user = SessionDataSingleton.getInstance().getUsuario();
        this.criticaDao = new CriticaDAO(Conexion.conectar());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String titulo = view.jTextField1.getText();
        String texto = view.jTextArea1.getText();
        Critica critica; 
        
        if(pelicula != null){
            critica = new Critica(titulo, texto, pelicula.getPelicula_id(), null, user.getUsuario_id());
            try {
                criticaDao.create(critica);
            } catch (DAOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "No se pudo crear la resena.");
            }
        }else{
            critica = new Critica(titulo, texto, null, serie.getSerie_id(), user.getUsuario_id());
            try {
                criticaDao.create(critica);
            } catch (DAOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "No se pudo crear la resena.");
            }
        }
        JOptionPane.showMessageDialog(null, "La reseña se ha creado correctamente.");
        view.dispose();
    }
}
