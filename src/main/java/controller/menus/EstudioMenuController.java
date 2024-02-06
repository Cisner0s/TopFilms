/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.menus;

import dao.Conexion;
import dao.DAOException;
import dao.EstudioDAO;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Estudio;
import view.menu.EstudioMenuWindow;

/**
 *
 * @author jorge
 */
public class EstudioMenuController implements MouseListener{

    private final EstudioMenuWindow view; 
    private final EstudioDAO dao; 
    
    public EstudioMenuController(EstudioMenuWindow view){
        this.view = view; 
        this.dao = new EstudioDAO(Conexion.conectar());
        
        try {
            listarEstudios();
        } catch (DAOException ex) {
            JOptionPane.showMessageDialog(null, "No se pudieros listar los estudios.");
            view.dispose();
        }
    }
    
    private void listarEstudios() throws DAOException{
        List<Estudio> estudios; 
        List<Object> row = new ArrayList<>();
        estudios = dao.read();
        EstudioMenuTableModel model = new EstudioMenuTableModel();
        view.jTable.setModel(model);
        
        for(Estudio a : estudios){
            row.add(a.getNombre());
            row.add(a.getPropietario());
            row.add(a.getFecha_Fundacion());
            model.addRow(row.toArray());
            row.removeAll(row);
        }
    }
    
    private class EstudioMenuTableModel extends DefaultTableModel{

        public EstudioMenuTableModel(){
            super(new Object[][]{}, new String[]{"Nombre", "Propietario", "Fecha de fundación"});
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
