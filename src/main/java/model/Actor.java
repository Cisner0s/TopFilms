/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author DCM
 */
public class Actor {
    
    private int id; 
    private String nombre; 
    private String sexo; 
    private Date fechaNacimiento;
    private String lugarNacimiento; 
    private String nacionalidad; 
    private String premios; 
    
    public Actor(String nombre, String sexo, Date fechaNacimiento, String lugarNacimiento, String nacionalidad, String premios){
        this.nombre = nombre; 
        this.sexo = sexo; 
        this.fechaNacimiento = fechaNacimiento; 
        this.lugarNacimiento = lugarNacimiento; 
        this.nacionalidad = nacionalidad; 
        this.premios = premios; 
    }
    
    public int getId(){
        return this.id; 
    }
    
    public String getNombre(){
        return this.nombre; 
    }
    
    public String getSexo(){
        return this.sexo;
    }
    
    public Date getFechaNacimiento(){
        return this.fechaNacimiento; 
    }
    
    public String getLugarNacimiento(){
        return this.lugarNacimiento; 
    }
    
    public String getNacionalidad(){
        return this.nacionalidad; 
    }
    
    public String getPremios(){
        return this.premios;
    }
    
    public void setId(int id) {
    this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setPremios(String premios) {
        this.premios = premios;
    }

    @Override
    public String toString() {
        return "Actor ID: " + id + "\n" +
               "Nombre: " + nombre + "\n" +
               "Sexo: " + sexo + "\n" +
               "Fecha de Nacimiento: " + fechaNacimiento + "\n" +
               "Lugar de Nacimiento: " + lugarNacimiento + "\n" +
               "Nacionalidad: " + nacionalidad + "\n" +
               "Premios: " + premios + "\n";
    }

}
