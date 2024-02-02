/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author DCM
 */
public class Usuario {
    
    private int usuario_id;
    private String nombreUsuario;
    private String contraseña;
    private String nombreCompleto;
    private String rol;
    private String estatus;
    private List<Resena> resenas;

    public Usuario() {}

    public Usuario(String nombreUsuario, String nombreCompleto, String rol, String contraseña, String estatus) {
       
        this.nombreUsuario = nombreUsuario;
        this.nombreCompleto = nombreCompleto;
        this.rol = rol;
        this.contraseña = contraseña;
        this.estatus = estatus;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
          if (rol.equals("Administrador") || rol.equals("Critico") || rol.equals("Usuario")){
            this.rol = rol;
        } else {
            System.err.println("La cadena de texto introducida para modificar el rol no se corresponde con ´Administrador´, ´Critico´ o ´Usuario´");
        }
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public List<Resena> getResenas() {
        return resenas;
    }

    public void setResenas(List<Resena> resenas) {
        this.resenas = resenas;
    }
    
    public String getEstatus(){
        return this.estatus;
    }
    
    public void setEstatus(String estatus){
        if (estatus.equals("Activo") || estatus.equals("Inactivo")){
            this.estatus = estatus;
        } else {
            System.err.println("La cadena de texto introducida para modificar el estatus no se corresponde con ´Activo´ ni con ´Inactivo´");
        }
    }
}
