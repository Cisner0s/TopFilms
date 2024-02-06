/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.menus;

import dao.Conexion;
import dao.DAOException;
import dao.DirectorDAO;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Director;
import view.menu.DirectorMenuWindow;

/**
 *
 * @author jorge
 */
public class DirectorMenuController implements MouseListener{

    private DirectorMenuWindow view; 
    private DirectorDAO dao; 
    
    public DirectorMenuController(DirectorMenuWindow view){
        this.view  = view; 
        this.dao = new DirectorDAO(Conexion.conectar());
        
        try {
            listarDirectores();
        } catch (DAOException ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido listar a los directores.");
        }
    }
    
    private void listarDirectores() throws DAOException{
        List<Director> directores; 
        List<Object> row = new ArrayList<>();
        directores = dao.read();
        DirectorMenuTableModel model = new DirectorMenuTableModel();
        view.jTable.setModel(model);
        
        for(Director a : directores){
            row.add(a.getNombre());
            row.add(a.getFecha_Nacimiento());
            row.add(a.getLugar_nacimiento());
            row.add(a.getNacionalidad());
            model.addRow(row.toArray());
            row.removeAll(row);
        }
    }
    
    private class DirectorMenuTableModel extends DefaultTableModel{

        public DirectorMenuTableModel(){
            super(new Object[][]{}, new String[]{"Nombre", "Fecha de nacimiento", "Lugar de nacimiento", "Nacionalidad"});
        }
        
        @Override
        public boolean isCellEditable(int row, int column){
            return false; 
        }
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
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
    
}
