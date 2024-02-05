/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import view.LoginWindow;

/**
 *
 * @author jorge
 */
public class LoginFocusController implements FocusListener{

    private final LoginWindow loginWindow; 
    
    public LoginFocusController(LoginWindow loginWindow){
        this.loginWindow = loginWindow; 
    }
    
    @Override
    public void focusGained(FocusEvent e) {
        if(e.getSource() == loginWindow.txt_user){
            if (loginWindow.txt_user.getText().equals("Nombre de usuario") && loginWindow.txt_user.getForeground().equals(Color.gray)) {
            loginWindow.txt_user.setText("");
            loginWindow.txt_user.setForeground(Color.black);
            }
        }else if(e.getSource() == loginWindow.txt_password){
            String pw = new String(loginWindow.txt_password.getPassword());
            if (pw.equals("Contraseña") && loginWindow.txt_password.getForeground().equals(Color.gray)) {
                loginWindow.txt_password.setText("");
                loginWindow.txt_password.setForeground(Color.black);
                loginWindow.txt_password.setEchoChar('*');
            }
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if(e.getSource() == loginWindow.txt_user){
            if (loginWindow.txt_user.getText().equals("")) {
                loginWindow.txt_user.setText("Nombre de usuario");
                loginWindow.txt_user.setForeground(Color.gray);
            }
        }else if(e.getSource() == loginWindow.txt_password){
            String pw = new String(loginWindow.txt_password.getPassword());
            if (pw.equals("")) {
                loginWindow.txt_password.setEchoChar((char) 0);
                loginWindow.txt_password.setText("Contraseña");
                loginWindow.txt_password.setForeground(Color.gray);
            }
        }
    }
    
}
