/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.editar;

import controller.GestionUsuariosController;
import dao.Conexion;
import dao.DAOException;
import dao.EstudioDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.Estudio;
import view.editar.EditarEstudioWindow;

/**
 *
 * @author DCM
 */
public class EditarEstudioController implements ActionListener{
    
    private final EditarEstudioWindow editarEstudioWindow;
    private final EstudioDAO dao;
    private String id;
    
    public EditarEstudioController(EditarEstudioWindow editarEstudioWindow) {
        this.editarEstudioWindow = editarEstudioWindow;
        this.dao = new EstudioDAO(Conexion.conectar());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() instanceof JButton) {
            JButton botonClicado = (JButton) e.getSource();
            id = editarEstudioWindow.jTextField_BuscarEstudioID.getText().trim();
            if (botonClicado.equals(editarEstudioWindow.jButton_Buscar)){
                try {
                    botonID();
                } catch (DAOException ex) {
                    Logger.getLogger(GestionUsuariosController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (botonClicado.equals(editarEstudioWindow.jButton_Editar)){
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
                Estudio estudio = dao.get(idInt);
                editarEstudioWindow.jTextField_Nombre.setText(estudio.getNombre());
                editarEstudioWindow.jTextField_Propietario.setText(estudio.getPropietario());
                editarEstudioWindow.jTextField_Patrimonio.setText(Long.toString(estudio.getPatrimonio()));
                editarEstudioWindow.jDateChooser_FechaFundacion.setDate(estudio.getFecha_Fundacion());
                editarEstudioWindow.jTextField_Sedes.setText(estudio.getSedes());

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
                String nombre = editarEstudioWindow.jTextField_Nombre.getText().trim();
                java.util.Date fechaFundacion = editarEstudioWindow.jDateChooser_FechaFundacion.getDate();

                // Obtener la fecha sin la hora
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(fechaFundacion);
                calendar.set(Calendar.HOUR_OF_DAY, 0);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.MILLISECOND, 0);

                java.sql.Date fechaFun = new java.sql.Date(calendar.getTimeInMillis());
                
                String propietario = editarEstudioWindow.jTextField_Propietario.getText().trim();
                long patrimonio = Long.parseLong(editarEstudioWindow.jTextField_Patrimonio.getText().trim());
                String sedes = editarEstudioWindow.jTextField_Sedes.getText().trim();

                Estudio estudio = new Estudio(nombre, propietario, fechaFun, patrimonio, sedes);
                estudio.setEstudio_id(idInt);
                dao.update(estudio);
                JOptionPane.showMessageDialog(null, "El estudio se ha editado correctamente.");
            } catch (DAOException e) {
                JOptionPane.showMessageDialog(null, "El campo ID debe contener un número.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
    }
}

