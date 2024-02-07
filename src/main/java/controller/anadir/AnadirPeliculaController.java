/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.anadir;

import dao.Conexion;
import dao.DAOException;
import dao.PeliculaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;
import javax.swing.JOptionPane;
import model.Pelicula;
import view.anadir.AnadirPeliculaWindow;

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
        String titulo = anadirPeliculaWindow.jTextField_Titulo.getText().trim();
        String sinopsis = anadirPeliculaWindow.jTextArea_Sinopsis.getText().trim();
        java.util.Date fechaEstreno = anadirPeliculaWindow.jDateChooser_fechaEstreno.getDate();

        // Obtener la fecha sin la hora
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaEstreno);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        Date fechaEst = new Date(calendar.getTimeInMillis());

        String duracion = anadirPeliculaWindow.jTextField_Duracion.getText();
        String genero = anadirPeliculaWindow.jTextField_Genero.getText();
        String presupuesto = anadirPeliculaWindow.jTextField_Presupuesto.getText();
        String ganancias = anadirPeliculaWindow.jTextField_Ganancias.getText();
        String imagen = anadirPeliculaWindow.jTextField_Imagen.getText();
        String director = anadirPeliculaWindow.jTextField_DirectorID.getText();
        String estudio = anadirPeliculaWindow.jTextField_EstudioID.getText();
        
        if(!"".equals(titulo) && !"".equals(sinopsis) && !"".equals(genero) && !"".equals(presupuesto) && !"".equals(ganancias) && !"".equals(imagen) && !"".equals(director) &&!"".equals(estudio)){
            try {
                Pelicula pelicula = new Pelicula(titulo, Integer.parseInt(duracion), sinopsis, genero, fechaEst, Long.parseLong(presupuesto), Long.parseLong(ganancias), imagen, Integer.parseInt(director), Integer.parseInt(estudio));
                dao.create(pelicula);
                JOptionPane.showMessageDialog(null, "Pelicula creada correctamente."); 
            } catch (DAOException ex) {
                JOptionPane.showMessageDialog(null, "No puedo crearse la pelicula correctamente");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Por favor complete todos los campos obligatorios.");
        }
    }
}

