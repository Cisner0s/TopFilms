/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.Conexion;
import dao.DAOException;
import dao.SerieDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.JOptionPane;
import model.Serie;
import view.AnadirSerieWindow;

/**
 *
 * @author fran
 */
public class AnadirSerieController implements ActionListener {
    private final AnadirSerieWindow anadirSerieWindow;
    private final SerieDAO dao;
    
    public AnadirSerieController(AnadirSerieWindow anadirSerieWindow) {
        this.anadirSerieWindow = anadirSerieWindow;
        this.dao = new SerieDAO(Conexion.conectar());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String titulo = anadirSerieWindow.jTextField21.getText().trim();
        String numEp = anadirSerieWindow.jTextField34.getText().trim();
        java.util.Date fechaEstreno = anadirSerieWindow.jDateChooser1.getDate();
        Date fechaEst = new Date(fechaEstreno.getTime());
        String durMedEp = anadirSerieWindow.jTextField35.getText();
        String nTemps = anadirSerieWindow.jTextField36.getText();
        String presupuesto = anadirSerieWindow.jTextField38.getText();
        String ganancias = anadirSerieWindow.jTextField39.getText();
        String imagen = anadirSerieWindow.jTextField37.getText();
        String director = anadirSerieWindow.jTextField40.getText();
        String estudio = anadirSerieWindow.jTextField41.getText();
        if(!"".equals(titulo) && !"".equals(numEp) && !"".equals(durMedEp) && !"".equals(nTemps) && !"".equals(presupuesto) && !"".equals(ganancias) && !"".equals(imagen) && !"".equals(director) &&!"".equals(estudio)){
            try {
                Serie serie = new Serie(titulo, fechaEst, imagen, Integer.parseInt(numEp), Double.parseDouble(durMedEp), Integer.parseInt(nTemps), Long.parseLong(presupuesto), Long.parseLong(ganancias), Integer.parseInt(director), Integer.parseInt(estudio));
                dao.create(serie);
                JOptionPane.showMessageDialog(null, "Actor creado correctamente."); 
            } catch (DAOException ex) {
                JOptionPane.showMessageDialog(null, "No puedo crearse el actor correctamente");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Por favor complete todos los campos obligatorios. El campo de premios puede dejarse vacío si el actor no ha recibido ningún premio.");
        }
    }
}
