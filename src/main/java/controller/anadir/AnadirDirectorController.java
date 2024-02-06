/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.anadir;

import dao.Conexion;
import dao.DAOException;
import dao.DirectorDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;
import javax.swing.JOptionPane;
import model.Director;
import view.anadir.AnadirDirectorWindow;

/**
 *
 * @author DCM
 */
public class AnadirDirectorController implements ActionListener{
    private final AnadirDirectorWindow view;
    private final DirectorDAO dao;
    
    public AnadirDirectorController(AnadirDirectorWindow view){
        this.view = view;
        this.dao = new DirectorDAO(Conexion.conectar());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(view.camposCompletos()){
            String nombre = view.jTextField_Nombre.getText().trim();
            String lugarDeNacimiento = view.jTextField_LugarNacimiento.getText().trim();
            String nacionalidad = view.jTextField_Nacionalidad.getText().trim();
            
            java.util.Date fechaNacUtil = view.jDateChooser_FechaNacimiento.getDate();
            // Obtener la fecha sin la hora
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fechaNacUtil);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);

            Date fechaNac = new Date(calendar.getTimeInMillis());

            String nominaciones = view.jTextArea_Nominaciones.getText();
            String premios = view.jTextArea_Premios.getText();
            boolean masculino = view.jRadioButton_Masculino.isSelected();
            boolean femenino = view.jRadioButton_Femenino.isSelected();
            String sexo = null;
            
            if(masculino){
                sexo = "masculino";
            } else if(femenino){
                sexo = "femenino";
            }
            
            try {
                if(!dao.exist(nombre)){
                    Director director = new Director(nombre, sexo, fechaNac, lugarDeNacimiento, nacionalidad, nominaciones, premios);
                    dao.create(director);
                    JOptionPane.showMessageDialog(null, "Director creado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "El nombre de ese director ya esta registrado.");
                }
            } catch (DAOException ex) {
                JOptionPane.showMessageDialog(null, "No pudo crearse el director correctamente");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Por favor complete todos los campos obligatorios.");
        }
    }
}
