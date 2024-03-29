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
public class Estudio {
    private int estudio_id;
    private String nombre;
    private Date fecha_Fundacion;
    private String propietario;
    private String sedes;
    private long patrimonio;

    public Estudio() {

    }

    public Estudio(String nombre, String propietario, Date fecha_Fundacion, long patrimonio, String sedes) {
        this.nombre = nombre;
        this.fecha_Fundacion = fecha_Fundacion;
        this.propietario = propietario;
        this.sedes = sedes;
        this.patrimonio = patrimonio;
    }

    public int getEstudio_id() {
        return estudio_id;
    }

    public void setEstudio_id(int estudio_id) {
        this.estudio_id = estudio_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_Fundacion() {
        return fecha_Fundacion;
    }

    public void setFecha_Fundacion(Date fecha_Fundacion) {
        this.fecha_Fundacion = fecha_Fundacion;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getSedes() {
        return sedes;
    }

    public void setSedes(String sedes) {
        this.sedes = sedes;
    }

    public long getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(int patrimonio) {
        this.patrimonio = patrimonio;
    }
    
    @Override
    public String toString() {
        return "Estudio ID: " + estudio_id + "\n" +
                "Nombre: " + nombre + "\n" +
                "Fecha de Fundación: " + fecha_Fundacion + "\n" +
                "Propietario: " + propietario + "\n" +
                "Sedes: " + sedes + "\n" +
                "Patrimonio: " + patrimonio;
    }
}
