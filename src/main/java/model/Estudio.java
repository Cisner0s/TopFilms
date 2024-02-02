/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DCM
 */
public class Estudio {
    private int estudio_id;
    private String nombre;
    private String fecha_Fundacion;
    private String propietario;
    private String sedes;
    private int patrimonio;

    public Estudio() {

    }

    public Estudio(String nombre, String fecha_Fundacion, String propietario, String sedes, int patrimonio) {
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

    public String getFecha_Fundacion() {
        return fecha_Fundacion;
    }

    public void setFecha_Fundacion(String fecha_Fundacion) {
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

    public int getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(int patrimonio) {
        this.patrimonio = patrimonio;
    }
}
