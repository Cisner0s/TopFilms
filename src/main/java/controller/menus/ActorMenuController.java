/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.menus;

import dao.ActorDAO;
import dao.Conexion;
import dao.DAOException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Actor;
import view.menu.ActorMenuWindow;

/**
 *
 * @author jorge
 */
public class ActorMenuController implements MouseListener{

    private final ActorMenuWindow view; 
    private final ActorDAO dao; 
    
    public ActorMenuController(ActorMenuWindow view){
        this.view = view; 
        this.dao = new ActorDAO(Conexion.conectar());
        
        try {
            listarActores();
        } catch (DAOException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar las peliculas");
        }
    }
    
    private void listarActores() throws DAOException{
        List<Actor> actores; 
        List<Object> row = new ArrayList<>();
        actores = dao.read();
        ActorMenuTableModel model = new ActorMenuTableModel();
        view.jTable.setModel(model);
        
        for(Actor a : actores){
            row.add(a.getNombre());
            row.add(a.getFechaNacimiento());
            row.add(a.getLugarNacimiento());
            row.add(a.getNacionalidad());
            model.addRow(row.toArray());
            row.removeAll(row);
        }
    }
    
    private class ActorMenuTableModel extends DefaultTableModel{

        public ActorMenuTableModel(){
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
