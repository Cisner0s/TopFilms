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
    private String imagen; 
    
    public Actor(int id, String nombre, String sexo, Date fechaNacimiento, String lugarNacimiento, String nacionalidad, String premios, String imagen){
        this.id = id; 
        this.nombre = nombre; 
        this.sexo = sexo; 
        this.fechaNacimiento = fechaNacimiento; 
        this.lugarNacimiento = lugarNacimiento; 
        this.nacionalidad = nacionalidad; 
        this.premios = premios; 
        this.imagen = imagen;  
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
    
    public String getImagen(){
        return this.imagen; 
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

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Actor{" +
            "id=" + id +
            ", nombre='" + nombre + '\'' +
            ", sexo='" + sexo + '\'' +
            ", fechaNacimiento=" + fechaNacimiento +
            ", lugarNacimiento='" + lugarNacimiento + '\'' +
            ", nacionalidad='" + nacionalidad + '\'' +
            ", premios='" + premios + '\'' +
            ", imagen='" + imagen + '\'' +
            '}';
    }
}
