/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import view.anadir.AnadirActorWindow;
import view.anadir.AnadirDirectorWindow;
import view.anadir.AnadirEstudioWindow;
import view.anadir.AnadirPeliculaWindow;
import view.anadir.AnadirSerieWindow;
import view.borrar.BorrarActorWindow;
import view.borrar.BorrarDirectorWindow;
import view.borrar.BorrarEstudioWindow;
import view.borrar.BorrarPeliculaWindow;
import view.borrar.BorrarSerieWindow;
import view.editar.EditarActorWindow;
import view.editar.EditarDirectorWindow;
import view.editar.EditarEstudioWindow;
import view.editar.EditarPeliculaWindow;
import view.editar.EditarSerieWindow;
import view.GestionContenidoWindow;


/**
 *
 * @author fran
 */
public class GestionContenidoController implements ActionListener, MouseListener{
    private final GestionContenidoWindow gestionContenidoWindow;
    
    public GestionContenidoController(GestionContenidoWindow gestionContenidoWindow) {
        this.gestionContenidoWindow = gestionContenidoWindow;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JComboBox) {
            JComboBox botonClicado = (JComboBox) e.getSource();
            if (botonClicado.equals(gestionContenidoWindow.jComboBox1)){
                String selectedAction = (String) gestionContenidoWindow.jComboBox1.getSelectedItem();
                if(null != selectedAction)switch (selectedAction) {
                    case "..." -> {
                        gestionContenidoWindow.jCheckBox_Anadir.setEnabled(false);
                        gestionContenidoWindow.jCheckBox_Editar.setEnabled(false);
                        gestionContenidoWindow.jCheckBox_Borrar.setEnabled(false);
                    }
                    case "Pelicula" -> {
                        gestionContenidoWindow.jCheckBox_Anadir.setEnabled(true);
                        gestionContenidoWindow.jCheckBox_Editar.setEnabled(true);
                        gestionContenidoWindow.jCheckBox_Borrar.setEnabled(true);
                    }
                    case "Serie" -> {
                        gestionContenidoWindow.jCheckBox_Anadir.setEnabled(true);
                        gestionContenidoWindow.jCheckBox_Editar.setEnabled(true);
                        gestionContenidoWindow.jCheckBox_Borrar.setEnabled(true);
                    }
                    case "Actor" -> {
                        gestionContenidoWindow.jCheckBox_Anadir.setEnabled(true);
                        gestionContenidoWindow.jCheckBox_Editar.setEnabled(true);
                        gestionContenidoWindow.jCheckBox_Borrar.setEnabled(true);
                    }
                    case "Director" -> {
                        gestionContenidoWindow.jCheckBox_Anadir.setEnabled(true);
                        gestionContenidoWindow.jCheckBox_Editar.setEnabled(true);
                        gestionContenidoWindow.jCheckBox_Borrar.setEnabled(true);
                    }
                    case "Estudio" -> {
                        gestionContenidoWindow.jCheckBox_Anadir.setEnabled(true);
                        gestionContenidoWindow.jCheckBox_Editar.setEnabled(true);
                        gestionContenidoWindow.jCheckBox_Borrar.setEnabled(true);
                    }
                    default -> {
                    }
                }
            }
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() instanceof JCheckBox) {
            JCheckBox botonClicado = (JCheckBox) e.getSource();
            if (botonClicado.equals(gestionContenidoWindow.jCheckBox_Editar)){
                if(!gestionContenidoWindow.jCheckBox_Editar.isEnabled()){
            
                } else if(gestionContenidoWindow.jCheckBox_Editar.isSelected() && gestionContenidoWindow.jCheckBox_Editar.isEnabled()){
                    gestionContenidoWindow.jCheckBox_Anadir.setEnabled(false);
                    gestionContenidoWindow.jCheckBox_Borrar.setEnabled(false);
                } else if(!gestionContenidoWindow.jCheckBox_Editar.isSelected()){
                    gestionContenidoWindow.jCheckBox_Anadir.setEnabled(true);
                    gestionContenidoWindow.jCheckBox_Borrar.setEnabled(true);
                }
            } else if (botonClicado.equals(gestionContenidoWindow.jCheckBox_Anadir)){
                if(!gestionContenidoWindow.jCheckBox_Anadir.isEnabled()){
            
                } else if(gestionContenidoWindow.jCheckBox_Anadir.isSelected() && gestionContenidoWindow.jCheckBox_Anadir.isEnabled()){
                    gestionContenidoWindow.jCheckBox_Editar.setEnabled(false);
                    gestionContenidoWindow.jCheckBox_Borrar.setEnabled(false);
                } else if(!gestionContenidoWindow.jCheckBox_Anadir.isSelected()){
                    gestionContenidoWindow.jCheckBox_Editar.setEnabled(true);
                    gestionContenidoWindow.jCheckBox_Borrar.setEnabled(true);
                }
            } else if (botonClicado.equals(gestionContenidoWindow.jCheckBox_Borrar)){
                if(!gestionContenidoWindow.jCheckBox_Borrar.isEnabled()){
            
                } else if(gestionContenidoWindow.jCheckBox_Borrar.isSelected() && gestionContenidoWindow.jCheckBox_Borrar.isEnabled()){
                    gestionContenidoWindow.jCheckBox_Editar.setEnabled(false);
                    gestionContenidoWindow.jCheckBox_Anadir.setEnabled(false);
                } else if(!gestionContenidoWindow.jCheckBox_Borrar.isSelected()){
                    gestionContenidoWindow.jCheckBox_Editar.setEnabled(true);
                    gestionContenidoWindow.jCheckBox_Anadir.setEnabled(true);
                }
            }
        }
        if (e.getSource() instanceof JButton) {
            JButton botonClicado = (JButton) e.getSource();
            if (botonClicado.equals(gestionContenidoWindow.jButton1)){
                String selectedAction = (String) gestionContenidoWindow.jComboBox1.getSelectedItem();
                int accion; // 0 = Añadir | 1 = Editar | 2 = Borrar | 3 = No seleccionado
        
                if(gestionContenidoWindow.jCheckBox_Anadir.isEnabled()){
                    accion = 0;
                } else if(gestionContenidoWindow.jCheckBox_Editar.isEnabled()){
                    accion = 1;
                } else if(gestionContenidoWindow.jCheckBox_Borrar.isEnabled()){
                    accion = 2;
                } else {
                    accion = 3;
                }
        
                if(null != selectedAction)switch (selectedAction) {
                    case "..." -> {
                
                    }
                    case "Pelicula" -> {
                        if(accion == 0){
                            gestionContenidoWindow.dispose();
                            new AnadirPeliculaWindow().setVisible(true);
                        } else if (accion == 1){
                            gestionContenidoWindow.dispose();
                            new EditarPeliculaWindow().setVisible(true);
                        } else if (accion == 2){
                            gestionContenidoWindow.dispose();
                            new BorrarPeliculaWindow().setVisible(true);
                        }
                    }
                    case "Serie" -> {
                        if(accion == 0){
                            gestionContenidoWindow.dispose();
                            new AnadirSerieWindow().setVisible(true);
                        } else if (accion == 1){
                            gestionContenidoWindow.dispose();
                            new EditarSerieWindow().setVisible(true);
                        } else if (accion == 2){
                            gestionContenidoWindow.dispose();
                            new BorrarSerieWindow().setVisible(true);
                        }
                    }
                    case "Actor" -> {
                        if(accion == 0){
                            gestionContenidoWindow.dispose();
                            new AnadirActorWindow().setVisible(true);
                        } else if (accion == 1){
                            gestionContenidoWindow.dispose();
                            new EditarActorWindow().setVisible(true);
                        } else if (accion == 2){
                            gestionContenidoWindow.dispose();
                            new BorrarActorWindow().setVisible(true);
                        }
                    }
                    case "Director" -> {
                        if(accion == 0){
                            gestionContenidoWindow.dispose();
                            new AnadirDirectorWindow().setVisible(true);
                        } else if (accion == 1){
                            gestionContenidoWindow.dispose();
                            new EditarDirectorWindow().setVisible(true);
                        } else if (accion == 2){
                            gestionContenidoWindow.dispose();
                            new BorrarDirectorWindow().setVisible(true);
                        }
                    }
                    case "Estudio" -> {
                        if(accion == 0){
                            gestionContenidoWindow.dispose();
                            new AnadirEstudioWindow().setVisible(true);
                        } else if (accion == 1){
                            gestionContenidoWindow.dispose();
                            new EditarEstudioWindow().setVisible(true);
                        } else if (accion == 2){
                            gestionContenidoWindow.dispose();
                            new BorrarEstudioWindow().setVisible(true);
                        }
                    }
                    default -> {
                    }
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
