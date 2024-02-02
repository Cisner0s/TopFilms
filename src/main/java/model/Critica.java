/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DCM
 */
public class Critica {
    private int critica_id;
    private String titulo;
    private String texto;
    private Pelicula pelicula;
    private Serie serie;
    private Critico critico;
    
    public Critica() {
        // Constructor vacío
    }
    
    public Critica(String titulo,String texto) {
        this.titulo = titulo;
        this.texto=texto;
    }

    public int getCritica_id() {
        return critica_id;
    }

    public void setCritica_id(int critica_id) {
        this.critica_id = critica_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Critico getCritico() {
        return critico;
    }

    public void setCritico(Critico critico) {
        this.critico = critico;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }
    
    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
}
