/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.editar;

import controller.GestionUsuariosController;
import dao.Conexion;
import dao.DAOException;
import dao.PeliculaDAO;
import dao.SerieDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.Pelicula;
import model.Serie;
import view.editar.EditarPeliculaWindow;
import view.editar.EditarSerieWindow;

/**
 *
 * @author DCM
 */
public class EditarSerieController implements ActionListener{
    private final EditarSerieWindow editarSerieWindow;
    private final SerieDAO dao;
    private String id;
    
    public EditarSerieController(EditarSerieWindow editarSerieWindow) {
        this.editarSerieWindow = editarSerieWindow;
        this.dao = new SerieDAO(Conexion.conectar());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) { 
        if (e.getSource() instanceof JButton) {
            JButton botonClicado = (JButton) e.getSource();
            id = editarSerieWindow.jTextField_BuscarID.getText().trim();
            if (botonClicado.equals(editarSerieWindow.jButton_Buscar)){
                try {
                    botonID();
                } catch (DAOException ex) {
                    Logger.getLogger(GestionUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (botonClicado.equals(editarSerieWindow.jButton_Editar)){
                try {
                    botonEditar();
                } catch (DAOException ex) {
                    Logger.getLogger(GestionUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
    public void botonID() throws DAOException {
         if (!"".equals(id)){
            try {
                int idInt = Integer.parseInt(id);
                Serie serie = dao.get(idInt);
                editarSerieWindow.jTextField_Titulo.setText(serie.getTitulo());
                editarSerieWindow.jDateChooser_FechaEstreno.setDate(serie.getFecha_Estreno());
                editarSerieWindow.jTextField_NumEpisodios.setText(Integer.toString(serie.getN_Episodios()));
                editarSerieWindow.jTextField_DuracionMedia.setText(Double.toString(serie.getDuracion_Med_Episodio()));
                editarSerieWindow.jTextField_NumTemp.setText(Integer.toString(serie.getN_Temporadas()));
                editarSerieWindow.jTextField_Presupuesto.setText(Long.toString(serie.getPresupuesto()));
                editarSerieWindow.jTextField_Ganancias.setText(Long.toString(serie.getGanacias()));
                editarSerieWindow.jTextField_DirectorID.setText(Integer.toString(serie.getDirector()));
                editarSerieWindow.jTextField_EstudioID.setText(Integer.toString(serie.getEstudio()));
                editarSerieWindow.jTextField_Genero.setText(serie.getGenero());


            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El campo ID debe contener un número.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Rellena el campo Actor_ID.");
        }
    }
    
    public void botonEditar() throws DAOException {
        int idInt;
        if (!"".equals(id)) {
            try {
                idInt = Integer.parseInt(id);
                String titulo = editarSerieWindow.jTextField_Titulo.getText().trim();
                java.util.Date fechaEstreno = editarSerieWindow.jDateChooser_FechaEstreno.getDate();

                // Obtener la fecha sin la hora
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(fechaEstreno);
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);

                java.sql.Date fechaEs = new java.sql.Date(calendar.getTimeInMillis());
                
                int numEpisodios = Integer.parseInt(editarSerieWindow.jTextField_NumEpisodios.getText().trim());
                double duracionMedia = Double.parseDouble(editarSerieWindow.jTextField_DuracionMedia.getText().trim());
                int numTemporadas = Integer.parseInt(editarSerieWindow.jTextField_NumTemp.getText().trim());
                long presupuesto = Long.parseLong(editarSerieWindow.jTextField_Presupuesto.getText().trim());
                long ganancias = Long.parseLong(editarSerieWindow.jTextField_Ganancias.getText().trim());
                int directorID = Integer.parseInt(editarSerieWindow.jTextField_DirectorID.getText().trim());
                int estudioID = Integer.parseInt(editarSerieWindow.jTextField_EstudioID.getText().trim());
                String genero = editarSerieWindow.jTextField_Genero.getText().trim();
                
                Serie serie = new Serie(titulo, fechaEs, genero, numEpisodios, duracionMedia, numTemporadas, presupuesto, ganancias, directorID, estudioID);
                serie.setSerie_id(idInt);
                dao.update(serie);
                JOptionPane.showMessageDialog(null, "El estudio se ha editado correctamente.");
            } catch (DAOException e) {
                JOptionPane.showMessageDialog(null, "El campo ID debe contener un número.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
    }
}
