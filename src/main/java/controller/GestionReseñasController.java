/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import controller.details.ActorDetailsController;
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
import model.Critica;
import model.Resena;
import view.GestionReseñasWindow;
import view.details.ActorDetailsWindow;
import view.menu.ActorMenuWindow;

/**
 *
 * @author DCM
 */
public class GestionReseñasController implements MouseListener{
    private final GestionReseñasWindow view; 
    private final ResenasDAO dao; 
    
    public GestionReseñasController(GestionReseñasWindow view){
        this.view = view; 
        this.dao = new ResenasDAO(Conexion.conectar());
        
        try {
            listarResenas();
        } catch (DAOException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar los actores");
        }
    }
    
    private void listarResenas() throws DAOException{
        List<Critica> criticas; 
        List<Object> row = new ArrayList<>();
        criticas = dao.read();
        ActorMenuTableModel model = new ActorMenuTableModel();
        view.jTable.setModel(model);
        
        for(Critica a : criticas){
            row.add(a.getTitulo());
            row.add(a.getTexto());
            model.addRow(row.toArray());
            row.removeAll(row);
        }
    }
    
    private class ActorMenuTableModel extends DefaultTableModel{

        public ActorMenuTableModel(){
            super(new Object[][]{}, new String[]{"Titulo", "Reseña"});
        }
        
        @Override
        public boolean isCellEditable(int row, int column){
            return false; 
        }
        
    }
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount() == 2){
            int filaActSelect = view.jTable.getSelectedRow();
            if(filaActSelect != 1){
                String titulo = (String) view.jTable.getModel().getValueAt(filaActSelect, 0); 
                System.out.println(titulo);
                try {
                    Critica critSelect = dao.get(titulo);
                    Object[] opciones = {"Borrar", "Cancelar"};
                    int seleccion = JOptionPane.showOptionDialog(null, "¿Qué deseas hacer?", "Opciones", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
                    
                    if (seleccion == 0) {
          
                    } else if (seleccion == 1) {
                 
                    } else {
                      
                    }
                } catch (DAOException ex) {
                    JOptionPane.showMessageDialog(null, "No se ha podido encontrar al actor seleccionado.");
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
}
