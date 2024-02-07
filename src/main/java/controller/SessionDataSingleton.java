package controller;


import model.RolUsuarios;
import model.Usuario;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jorge
 */
public class SessionDataSingleton {
    private static SessionDataSingleton instance;
    private Usuario usuario; 

    private SessionDataSingleton() {}

    public static SessionDataSingleton getInstance() {
        if (instance == null) {
            instance = new SessionDataSingleton();
        }
        return instance;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setRolUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
