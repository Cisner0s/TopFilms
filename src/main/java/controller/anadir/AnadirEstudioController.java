/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.anadir;

import dao.Conexion;
import dao.DAOException;
import dao.EstudioDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;
import javax.swing.JOptionPane;
import model.Director;
import model.Estudio;
import view.anadir.AnadirEstudioWindow;

/**
 *
 * @author DCM
 */
public class AnadirEstudioController implements ActionListener{

    private final AnadirEstudioWindow view;
    private final EstudioDAO dao;
    
    public AnadirEstudioController(AnadirEstudioWindow view){
        this.view = view;
        this.dao = new EstudioDAO(Conexion.conectar());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(view.camposCompletos()){
            String nombre = view.jTextField_Nombre.getText().trim();
            String patrimonio = view.jTextField_Patrimonio.getText().trim();
            String propietario = view.jTextField_Propietario.getText().trim();
            String sedes = view.jTextField_Sedes.getText().trim();
            
            java.util.Date fechaFunUtil = view.jDateChooser_FechaFundacion.getDate();
            // Obtener la fecha sin la hora
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fechaFunUtil);
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);

            Date fechaFun = new Date(calendar.getTimeInMillis());
            long patrimonioLong = 0;
            
            try{
                patrimonioLong = Long.parseLong(patrimonio);
            } catch (NumberFormatException numEx){
                JOptionPane.showMessageDialog(null, "Error al convertir una cadena patrimonio a un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            try {
                if(!dao.exist(nombre)){
                    if(patrimonioLong != 0){
                        Estudio estudio = new Estudio(nombre, propietario, fechaFun, patrimonioLong, sedes);
                        dao.create(estudio);
                        JOptionPane.showMessageDialog(null, "Estudio creado correctamente.");
                    } 
                } else {
                    JOptionPane.showMessageDialog(null, "El nombre de ese estudio ya esta registrado.");
                }
            } catch (DAOException ex) {
                JOptionPane.showMessageDialog(null, "No pudo crearse el estudio correctamente");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Por favor complete todos los campos obligatorios.");
        }
    }
}
