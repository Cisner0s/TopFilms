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
    private Integer pelicula_id;
    private Integer serie_id;
    private Integer usuario_id;
    
    public Critica() {
        // Constructor vacío
    }
    
    public Critica(String titulo,String texto, Integer pelicula_id, Integer serie_id, Integer usuario_id) {
        this.titulo = titulo;
        this.texto=texto;
        this.pelicula_id = pelicula_id; 
        this.serie_id = serie_id; 
        this.usuario_id = usuario_id; 
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

    public Integer getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Integer usuario_id) {
        this.usuario_id = usuario_id;
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

    public Integer getSerie_id() {
        return serie_id;
    }

    public void setSerie_id(Integer serie_id) {
        this.serie_id = serie_id;
    }
    
    public Integer getPelicula_id() {
        return pelicula_id;
    }

    public void setPelicula_id(Integer pelicula_id) {
        this.pelicula_id = pelicula_id;
    }
}
