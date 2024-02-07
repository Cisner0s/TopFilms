/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.editar;

import controller.GestionUsuariosController;
import dao.ActorDAO;
import dao.Conexion;
import dao.DAOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.Actor;
import view.editar.EditarActorWindow;

/**
 *
 * @author fran
 */
public class EditarActorController implements ActionListener{
    private final EditarActorWindow editarActorWindow;
    private final ActorDAO dao;
    private String id;
    
    public EditarActorController(EditarActorWindow editarActorWindow) {
        this.editarActorWindow = editarActorWindow;
        this.dao = new ActorDAO(Conexion.conectar());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() instanceof JButton) {
            JButton botonClicado = (JButton) e.getSource();
            id = editarActorWindow.jTextField_BuscarActor.getText().trim();
            if (botonClicado.equals(editarActorWindow.jButton_Buscar)){
                try {
                    botonID();
                } catch (DAOException ex) {
                    Logger.getLogger(GestionUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (botonClicado.equals(editarActorWindow.jButton_Editar)){
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
                Actor actor = dao.get(idInt);
                editarActorWindow.jTextField_Nombre.setText(actor.getNombre());
                editarActorWindow.jTextField_Sexo.setText(actor.getSexo());
                editarActorWindow.jTextField_Nacionalidad.setText(actor.getNacionalidad());
                editarActorWindow.jTextField_LugarNacimiento.setText(actor.getLugarNacimiento());
                editarActorWindow.jDateChooser_FechaNacimiento.setDate(actor.getFechaNacimiento());
                editarActorWindow.jTextArea_premios.setText(actor.getPremios());

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
                String nombre = editarActorWindow.jTextField_Nombre.getText().trim();
                String sexo = editarActorWindow.jTextField_Sexo.getText().trim();
                
                java.util.Date fechaNacimiento = editarActorWindow.jDateChooser_FechaNacimiento.getDate();

                // Obtener la fecha sin la hora
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(fechaNacimiento);
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);

                java.sql.Date fechaNac = new java.sql.Date(calendar.getTimeInMillis());
                
                String lugarNacimiento = editarActorWindow.jTextField_LugarNacimiento.getText().trim();
                String nacionalidad = editarActorWindow.jTextField_Nacionalidad.getText().trim();
                String premios = editarActorWindow.jTextArea_premios.getText().trim();

                Actor actor = new Actor(nombre, sexo, fechaNac, lugarNacimiento, nacionalidad, premios);
                actor.setId(idInt);
                dao.update(actor);
                JOptionPane.showMessageDialog(null, "El actor se ha editado correctamente.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El campo ID debe contener un número.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
    }
}
