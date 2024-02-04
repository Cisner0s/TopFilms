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
    private String nickName;
    private String contrasena;
    private String nombre;
    private RolUsuarios rol;
    private EstatusUsuarios estatus;
    private List<Resena> resenas;

    public Usuario() {}

    public Usuario(String nick, String contrasena,String nombre, RolUsuarios rol, EstatusUsuarios estatus) {
       
        this.nickName = nick;
        this.nombre = nombre;
        this.rol = rol;
        this.contrasena = contrasena;
        this.estatus = estatus;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNombreCompleto() {
        return nombre;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombre = nombreCompleto;
    }

    public RolUsuarios getRol() {
        return rol;
    }

    public void setRol(RolUsuarios rol) {
          if (rol.equals("Administrador") || rol.equals("Critico") || rol.equals("Usuario")){
            this.rol = rol;
        } else {
            System.err.println("La cadena de texto introducida para modificar el rol no se corresponde con ´Administrador´, ´Critico´ o ´Usuario´");
        }
    }

    public String getContraseña() {
        return contrasena;
    }

    public void setContraseña(String contraseña) {
        this.contrasena = contraseña;
    }

    public List<Resena> getResenas() {
        return resenas;
    }

    public void setResenas(List<Resena> resenas) {
        this.resenas = resenas;
    }
    
    public EstatusUsuarios getEstatus(){
        return this.estatus;
    }
    
    public void setEstatus(EstatusUsuarios estatus){
        if (estatus.equals("Activo") || estatus.equals("Inactivo")){
            this.estatus = estatus;
        } else {
            System.err.println("La cadena de texto introducida para modificar el estatus no se corresponde con ´Activo´ ni con ´Inactivo´");
        }
    }
}
