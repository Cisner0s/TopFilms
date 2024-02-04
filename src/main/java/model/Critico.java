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
public class Critico extends Usuario{
    private List<Critica> criticas;
    
//    public Critico(int usuario_id, String nombreUsuario, String nombreCompleto, String rol, String contraseña, String estatus) {
//        super(nombreUsuario, nombreCompleto, rol, contraseña, estatus);
//    }

    private Critico(String nombreUsuario, String nombreCompleto, String rol, String contraseña, String estatus) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Critica> getCriticas() {
        return criticas;
    }

    public void setCriticas(List<Critica> criticas) {
        this.criticas = criticas;
    }
}
