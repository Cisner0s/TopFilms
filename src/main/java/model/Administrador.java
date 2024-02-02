/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DCM
 */
public class Administrador extends Usuario{

    public Administrador(int usuario_id, String nombreUsuario, String nombreCompleto, String rol, String contraseña, String estatus) {
        super(nombreUsuario, nombreCompleto, rol, contraseña, estatus);
    }
}
