/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.editar;

import controller.GestionUsuariosController;
import dao.Conexion;
import dao.DAOException;
import dao.PeliculaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.Estudio;
import model.Pelicula;
import view.editar.EditarPeliculaWindow;

/**
 *
 * @author DCM
 */
public class EditarPeliculaController  implements ActionListener{    
    private final EditarPeliculaWindow editarPeliculaWindow;
    private final PeliculaDAO dao;
    private String id;
    
    public EditarPeliculaController(EditarPeliculaWindow editarPeliculaWindow) {
        this.editarPeliculaWindow = editarPeliculaWindow;
        this.dao = new PeliculaDAO(Conexion.conectar());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) { 
        if (e.getSource() instanceof JButton) {
            JButton botonClicado = (JButton) e.getSource();
            id = editarPeliculaWindow.jTextField_BuscarID.getText().trim();
            if (botonClicado.equals(editarPeliculaWindow.jButton_Buscar)){
                try {
                    botonID();
                } catch (DAOException ex) {
                    Logger.getLogger(GestionUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (botonClicado.equals(editarPeliculaWindow.jButton_Editar)){
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
                Pelicula pelicula = dao.get(idInt);
                editarPeliculaWindow.jTextField_Titulo.setText(pelicula.getTitulo());
                editarPeliculaWindow.jTextField_Genero.setText(pelicula.getGenero());
                editarPeliculaWindow.jTextField_Ganancias.setText(Long.toString(pelicula.getGanancias()));
                editarPeliculaWindow.jDateChooser_FechaEstreno.setDate(pelicula.getFecha_Estreno());
                editarPeliculaWindow.jTextField_DirectorID.setText(Integer.toString(pelicula.getDirector()));
                editarPeliculaWindow.jTextField_Imagen.setText(pelicula.getImagen());
                editarPeliculaWindow.jTextField_EstudioID.setText(Integer.toString(pelicula.getEstudio()));
                editarPeliculaWindow.jTextArea_Sinopsis.setText(pelicula.getSinopsis());
                editarPeliculaWindow.jTextField_Presupuesto.setText(Long.toString(pelicula.getPresupuesto()));
                editarPeliculaWindow.jTextField_Duracion.setText(Integer.toString(pelicula.getDuracion()));

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
                String titulo = editarPeliculaWindow.jTextField_Titulo.getText().trim();
                java.util.Date fechaEstreno = editarPeliculaWindow.jDateChooser_FechaEstreno.getDate();

                // Obtener la fecha sin la hora
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(fechaEstreno);
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);

                java.sql.Date fechaEs = new java.sql.Date(calendar.getTimeInMillis());
                
                String genero = editarPeliculaWindow.jTextField_Genero.getText().trim();
                long ganancias = Long.parseLong(editarPeliculaWindow.jTextField_Ganancias.getText().trim());
                int directorID = Integer.parseInt(editarPeliculaWindow.jTextField_DirectorID.getText().trim());
                int estudioID = Integer.parseInt(editarPeliculaWindow.jTextField_EstudioID.getText().trim());
                String imagen = editarPeliculaWindow.jTextField_Imagen.getText().trim();
                String sinopsis = editarPeliculaWindow.jTextArea_Sinopsis.getText().trim();
                long presupuesto = Long.parseLong(editarPeliculaWindow.jTextField_Presupuesto.getText().trim());
                int duracion = Integer.parseInt(editarPeliculaWindow.jTextField_Duracion.getText().trim());

                Pelicula pelicula = new Pelicula(titulo, duracion, sinopsis, genero, fechaEs, presupuesto, ganancias, imagen, directorID, estudioID);
                pelicula.setPelicula_id(idInt);
                dao.update(pelicula);
                JOptionPane.showMessageDialog(null, "El estudio se ha editado correctamente.");
            } catch (DAOException e) {
                JOptionPane.showMessageDialog(null, "El campo ID debe contener un número.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
    }
}

