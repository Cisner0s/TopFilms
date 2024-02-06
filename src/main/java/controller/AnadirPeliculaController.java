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
import java.sql.Date;
import javax.swing.JOptionPane;
import model.Pelicula;
import view.AnadirPeliculaWindow;

/**
 *
 * @author fran
 */
public class AnadirPeliculaController implements ActionListener {
    private final AnadirPeliculaWindow anadirPeliculaWindow;
    private final PeliculaDAO dao;
    
    public AnadirPeliculaController(AnadirPeliculaWindow anadirSerieWindow) {
        this.anadirPeliculaWindow = anadirSerieWindow;
        this.dao = new PeliculaDAO(Conexion.conectar());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String titulo = anadirPeliculaWindow.jTextField33.getText().trim();
        String sinopsis = anadirPeliculaWindow.jTextArea5.getText().trim();
        java.util.Date fechaEstreno = anadirPeliculaWindow.jDateChooser1.getDate();
        Date fechaEst = new Date(fechaEstreno.getTime());
        String duracion = anadirPeliculaWindow.jTextField27.getText();
        String genero = anadirPeliculaWindow.jTextField34.getText();
        String presupuesto = anadirPeliculaWindow.jTextField28.getText();
        String ganancias = anadirPeliculaWindow.jTextField29.getText();
        String imagen = anadirPeliculaWindow.jTextField30.getText();
        String director = anadirPeliculaWindow.jTextField31.getText();
        String estudio = anadirPeliculaWindow.jTextField32.getText();
        if(!"".equals(titulo) && !"".equals(sinopsis) && !"".equals(genero) && !"".equals(presupuesto) && !"".equals(ganancias) && !"".equals(imagen) && !"".equals(director) &&!"".equals(estudio)){
            try {
                Pelicula pelicula = new Pelicula(titulo, Integer.parseInt(duracion), sinopsis, genero, fechaEst, Long.parseLong(presupuesto), Long.parseLong(ganancias), imagen, Integer.parseInt(director), Integer.parseInt(estudio));
                dao.create(pelicula);
                JOptionPane.showMessageDialog(null, "Pelicula creada correctamente."); 
            } catch (DAOException ex) {
                JOptionPane.showMessageDialog(null, "No puedo crearse el actor correctamente");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Por favor complete todos los campos obligatorios. El campo de premios puede dejarse vacío si el actor no ha recibido ningún premio.");
        }
    }
}

