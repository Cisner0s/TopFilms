/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.Conexion;
import dao.DAOException;
import dao.PeliculaDAO;
import dao.SerieDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Serie;
import view.SerieMenuWindow;

/**
 *
 * @author jorge
 */
public class SerieMenuController {
    
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
