/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.anadir;

import controller.SessionDataSingleton;
import dao.Conexion;
import dao.DAOException;
import dao.ResenaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Pelicula;
import model.Resena;
import model.Serie;
import model.Usuario;
import view.anadir.AnadirResenaWindow;

/**
 *
 * @author jorge
 */
public class AnadirResenaController implements ActionListener{

    private final AnadirResenaWindow view;
    private final Pelicula pelicula; 
    private final Serie serie; 
    private final ResenaDAO resenaDao;
    private final Usuario user; 
    
    public AnadirResenaController(AnadirResenaWindow view, Pelicula pelicula, Serie serie){
        this.view = view; 
        this.pelicula = pelicula; 
        this.serie = serie; 
        this.user = SessionDataSingleton.getInstance().getUsuario();
        this.resenaDao = new ResenaDAO(Conexion.conectar());
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String titulo = view.jTextField1.getText();
        String texto = view.jTextArea1.getText();
        Resena resena; 
        
        if(pelicula != null){
            resena = new Resena(titulo, texto, pelicula.getPelicula_id(), null, user.getUsuario_id());
            try {
                resenaDao.create(resena);
            } catch (DAOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "No se pudo crear la resena.");
            }
        }else{
            resena = new Resena(titulo, texto, null, serie.getSerie_id(), user.getUsuario_id());
            try {
                resenaDao.create(resena);
            } catch (DAOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "No se pudo crear la resena.");
            }
        }
        JOptionPane.showMessageDialog(null, "La reseña se ha creado correctamente.");
        view.dispose();
    }
    
}
