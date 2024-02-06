/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.anadir;

import dao.Conexion;
import dao.DAOException;
import dao.DirectorDAO;
import dao.EstudioDAO;
import dao.SerieDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;
import javax.swing.JOptionPane;
import model.Serie;
import view.anadir.AnadirSerieWindow;

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
        String titulo = anadirSerieWindow.jTextField_Titulo.getText().trim();
        String numEp = anadirSerieWindow.jTextField_NumEpisodios.getText().trim();
        java.util.Date fechaEstreno = anadirSerieWindow.jDateChooser_FechaEstreno.getDate();

        // Obtener la fecha sin la hora
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaEstreno);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        Date fechaEst = new Date(calendar.getTimeInMillis());

        String durMedEp = anadirSerieWindow.jTextField_DuracionMedia.getText();
        String nTemps = anadirSerieWindow.jTextField_NumTemporadas.getText();
        String presupuesto = anadirSerieWindow.jTextField_Presupuesto.getText();
        String ganancias = anadirSerieWindow.jTextField_Ganancias.getText();
        String genero = anadirSerieWindow.jTextField_Genero.getText();
        String director = anadirSerieWindow.jTextField_NombreDirector.getText();
        String estudio = anadirSerieWindow.jTextField_NombreEstudio.getText();
        
        if(!"".equals(titulo) && !"".equals(numEp) && !"".equals(durMedEp) && !"".equals(nTemps) && !"".equals(presupuesto) && !"".equals(ganancias) && !"".equals(genero) && !"".equals(director) &&!"".equals(estudio)){
            try {
                Serie serie = new Serie(titulo, fechaEst, genero, Integer.parseInt(numEp), Double.parseDouble(durMedEp), Integer.parseInt(nTemps), Integer.parseInt(presupuesto), Integer.parseInt(ganancias), Integer.parseInt(director), Integer.parseInt(estudio));
                dao.create(serie);
                JOptionPane.showMessageDialog(null, "Serie creada correctamente."); 
            } catch (DAOException ex) {
                JOptionPane.showMessageDialog(null, "No pudo crearse la serie correctamente");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Por favor complete todos los campos obligatorios.");
        }
    }
}
