/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.menus;

import controller.details.PeliculaDetailsController;
import dao.Conexion;
import dao.DAOException;
import dao.PeliculaDAO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Pelicula;
import view.details.PeliculaDetailsWindow;
import view.menu.FilmMenuWindow;

/**
 *
 * @author jorge
 */
public class FilmMenuController implements MouseListener{
    
    private final FilmMenuWindow view; 
    private final PeliculaDAO dao; 
    
    public FilmMenuController(FilmMenuWindow view){
        this.view = view; 
        this.dao = new PeliculaDAO(Conexion.conectar());
        
        try {
            listarPeliculas();
        } catch (DAOException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar las peliculas");
        }
    }
    
    private void listarPeliculas() throws DAOException{
        List<Pelicula> peliculas; 
        List<String> row = new ArrayList<>();
        peliculas = dao.read();
        FilmMenuTableModel model = new FilmMenuTableModel();
        view.jTable.setModel(model);
        
        for(Pelicula pel : peliculas){
            row.add(pel.getTitulo());
            row.add(pel.getSinopsis());
            row.add(String.valueOf(pel.getDuracion()));
            model.addRow(row.toArray());
            row.removeAll(row);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount() == 2){
            int filaPelSelect = view.jTable.getSelectedRow();
            if(filaPelSelect != 1){
                String titulo = (String) view.jTable.getModel().getValueAt(filaPelSelect, 0); 
                try {
                    Pelicula pelSelect = dao.peliculaPorTitulo(titulo);
                    PeliculaDetailsWindow detailsView = new PeliculaDetailsWindow();
                    PeliculaDetailsController ctr = new PeliculaDetailsController(detailsView, pelSelect);
                    detailsView.jButton_anadirResena.addActionListener(ctr);
                    detailsView.setVisible(true);
                } catch (DAOException ex) {
                    JOptionPane.showMessageDialog(null, "No se ha podido encontrar la pelicula seleccionada.");
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
    
    private class FilmMenuTableModel extends DefaultTableModel{

        public FilmMenuTableModel(){
            super(new Object[][]{}, new String[]{"Título", "Sinopsis", "Duración"});
        }
        
        @Override
        public boolean isCellEditable(int row, int column){
            return false; 
        }
        
    }
    
    
}
