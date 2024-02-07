/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.editar;

import controller.GestionUsuariosController;
import dao.Conexion;
import dao.DAOException;
import dao.DirectorDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.Actor;
import model.Director;
import view.editar.EditarDirectorWindow;

/**
 *
 * @author DCM
 */
public class EditarDirectorController implements ActionListener{
    private final EditarDirectorWindow editarDirectorWindow;
    private final DirectorDAO dao;
    private String id;
    
    public EditarDirectorController(EditarDirectorWindow editarDirectorWindow) {
        this.editarDirectorWindow = editarDirectorWindow;
        this.dao = new DirectorDAO(Conexion.conectar());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() instanceof JButton) {
            JButton botonClicado = (JButton) e.getSource();
            id = editarDirectorWindow.jTextField_BuscarID.getText().trim();
            if (botonClicado.equals(editarDirectorWindow.jButton_Buscar)){
                try {
                    botonID();
                } catch (DAOException ex) {
                    Logger.getLogger(GestionUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (botonClicado.equals(editarDirectorWindow.jButton_Editar)){
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
                Director director = dao.get(idInt);
                editarDirectorWindow.jTextField_Nombre.setText(director.getNombre());
                if(director.getSexo().equals("Masculino")){
                    editarDirectorWindow.jRadioButton_Masculino.setSelected(true);
                    editarDirectorWindow.jRadioButton_Femenino.setSelected(false);

                }else if (director.getSexo().equals("Femenino")){
                    editarDirectorWindow.jRadioButton_Femenino.setSelected(true);
                    editarDirectorWindow.jRadioButton_Masculino.setSelected(false);

                }
                editarDirectorWindow.jTextField_Nacionalidad.setText(director.getNacionalidad());
                editarDirectorWindow.jTextField_LugarNacimiento.setText(director.getLugar_nacimiento());
                editarDirectorWindow.jDateChooser_FechaNacimiento.setDate(director.getFecha_Nacimiento());
                editarDirectorWindow.jTextArea_Premios.setText(director.getPremios());

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
                String nombre = editarDirectorWindow.jTextField_Nombre.getText().trim();
                String sexo = null;
                if(editarDirectorWindow.jRadioButton_Masculino.isSelected()){
                    sexo = "Masculino";
                }else if (editarDirectorWindow.jRadioButton_Femenino.isSelected()){
                    sexo = "Femenino";
                }
                java.util.Date fechaNacimiento = editarDirectorWindow.jDateChooser_FechaNacimiento.getDate();

                // Obtener la fecha sin la hora
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(fechaNacimiento);
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);

                java.sql.Date fechaNac = new java.sql.Date(calendar.getTimeInMillis());
                
                String lugarNacimiento = editarDirectorWindow.jTextField_LugarNacimiento.getText().trim();
                String nacionalidad = editarDirectorWindow.jTextField_Nacionalidad.getText().trim();
                String premios = editarDirectorWindow.jTextArea_Premios.getText().trim();
                String nominaciones = editarDirectorWindow.jTextArea_Nominaciones.getText().trim();

                Director director = new Director(nombre, sexo, fechaNac, lugarNacimiento, nacionalidad, nominaciones, premios);
                director.setDirector_id(idInt);
                dao.update(director);
                JOptionPane.showMessageDialog(null, "El actor se ha editado correctamente.");
            } catch (DAOException e) {
                JOptionPane.showMessageDialog(null, "El campo ID debe contener un número.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
    }
}
