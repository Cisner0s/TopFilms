/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author DCM
 */
public class Director {
    private int id;
    private String nombre;
    private String sexo;
    private Date fecha_Nacimiento;
    private String lugar_nacimiento;
    private String nacionalidad;
    private String nominaciones;
    private String premios;
    private List<Pelicula> peliculas;
    private List<Serie> series;

   
    public Director() {}

    public Director(String nombre, String sexo, Date fecha_Nacimiento, String lugar_nacimiento, String nacionalidad, String nominaciones, String premios) {
        this.nombre = nombre;
        this.fecha_Nacimiento = fecha_Nacimiento;
        this.sexo = sexo;
        this.lugar_nacimiento = lugar_nacimiento;
        this.nacionalidad = nacionalidad;
        this.premios = premios;
        this.nominaciones = nominaciones;
    }

    public List<Serie> getSeries() {
        return series;
    }

    public void setSeries(List<Serie> series) {
        this.series = series;
    }

    public int getDirector_id() {
        return id;
    }

    public void setDirector_id(int director_id) {
        this.id = director_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_Nacimiento() {
        return fecha_Nacimiento;
    }

    public void setFecha_Nacimiento(Date fecha_Nacimiento) {
        this.fecha_Nacimiento = fecha_Nacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getLugar_nacimiento() {
        return lugar_nacimiento;
    }

    public void setLugar_nacimiento(String lugar_nacimiento) {
        this.lugar_nacimiento = lugar_nacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getPremios() {
        return premios;
    }

    public void setPremios(String premios) {
        this.premios = premios;
    }

    public String getNominaciones() {
        return nominaciones;
    }

    public void setNominaciones(String nominaciones) {
        this.nominaciones = nominaciones;
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }
    
    @Override
    public String toString() {
        return "Director{" +
                "director_id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fecha_Nacimiento='" + fecha_Nacimiento + '\'' +
                ", sexo='" + sexo + '\'' +
                ", lugar_nacimiento='" + lugar_nacimiento + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", premios='" + premios + '\'' +
                ", nominaciones='" + nominaciones + '\'' +
                '}';
    }
}