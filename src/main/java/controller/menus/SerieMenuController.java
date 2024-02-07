/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.menus;

import controller.details.SerieDetailsController;
import dao.Conexion;
import dao.DAOException;
import dao.PeliculaDAO;
import dao.SerieDAO;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Serie;
import view.details.PeliculaDetailsWindow;
import view.details.SerieDetailsWindow;
import view.menu.SerieMenuWindow;

/**
 *
 * @author jorge
 */
public class SerieMenuController implements MouseListener{
    
    private final SerieMenuWindow view; 
    private final SerieDAO dao; 
    
    public SerieMenuController(SerieMenuWindow view){
        this.view = view; 
        this.dao = new SerieDAO(Conexion.conectar());
        
        try {
            listarSeries();
        } catch (DAOException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar las peliculas");
        }
    }
    
    private void listarSeries() throws DAOException{
        List<Serie> series; 
        List<String> row = new ArrayList<>();
        series = dao.read();
        SerieMenuTableModel model = new SerieMenuTableModel();
        view.jTable.setModel(model);
        
        for(Serie serie : series){
            row.add(serie.getTitulo());
            row.add(serie.getGenero());
            row.add(String.valueOf(serie.getN_Episodios()));
            row.add(String.valueOf(serie.getDuracion_Med_Episodio()));
            model.addRow(row.toArray());
            row.removeAll(row);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount() == 2){
            int filaSerSelect = view.jTable.getSelectedRow();
            if(filaSerSelect != 1){
                String titulo = (String) view.jTable.getModel().getValueAt(filaSerSelect, 0); 
                try {
                    Serie pelSelect = dao.get(titulo);
                    SerieDetailsWindow detailsView = new SerieDetailsWindow(); 
                    SerieDetailsController ctr = new SerieDetailsController(detailsView, pelSelect);
                    detailsView.jButton_anadirResena.addActionListener(ctr);
                    detailsView.jButton_refrescar.addActionListener(ctr);
                    detailsView.setVisible(true);
                } catch (DAOException ex) {
                    JOptionPane.showMessageDialog(null, "No se ha podido encontrar la serie seleccionada.");
                }
                
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    private class SerieMenuTableModel extends DefaultTableModel{

        public SerieMenuTableModel(){
            super(new Object[][]{}, new String[]{"Título", "Género", "Número de episodios", "Duración media de episodio"});
        }
        
        @Override
        public boolean isCellEditable(int row, int column){
            return false; 
        }
        
    }
}
