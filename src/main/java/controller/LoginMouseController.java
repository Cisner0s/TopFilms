/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import view.LoginWindow;
import view.RegisterWindow;

/**
 *
 * @author jorge
 */
public class LoginMouseController implements MouseListener{

    private final LoginWindow loginWindow; 
    
    public LoginMouseController(LoginWindow loginWindow){
        this.loginWindow = loginWindow; 
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        loginWindow.dispose();
        new RegisterWindow().setVisible(true);
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
        loginWindow.jLabel_Footer.setForeground(Color.BLACK);
    }
    
}
