/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import view.menu.ActorMenuWindow;
import view.BusquedaWindow;
import view.menu.DirectorMenuWindow;
import view.menu.EstudioMenuWindow;

/**
 *
 * @author jorge
 */
public class BusquedaController implements MouseListener{
    
    private final BusquedaWindow view; 
    
    public BusquedaController(BusquedaWindow view){
        this.view = view; 
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String choose = (String)view.jComboBox_tipo.getSelectedItem(); 
        if(!"...".equals(choose)){
            switch(choose){
                case "Actor": 
                    view.dispose();
                    new ActorMenuWindow().setVisible(true);
                    break;
                case "Director": 
                    view.dispose();
                    new DirectorMenuWindow().setVisible(true);
                    break;
                case "Estudio": 
                    view.dispose();
                    new EstudioMenuWindow().setVisible(true);
                    break;
            }
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione el tipo de contenido porfavor.");
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
