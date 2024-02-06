/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DCM
 */
public class Resena {
  
    private int resena_id;
    private String tituloResena;
    private String textoResena;
    private Integer pelicula_id;
    private Integer serie_id;
    private Integer usuario_id;

    public Resena(String tituloResena, String textoResena, Integer pelicula_id, Integer serie_id, Integer usuario_id) {
        this.tituloResena = tituloResena;
        this.textoResena = textoResena;
        this.pelicula_id = pelicula_id; 
        this.serie_id = serie_id; 
        this.usuario_id = usuario_id; 
    }

    public Integer getSerie() {
        return serie_id;
    }

    public void setSerie(Integer serie_id) {
        this.serie_id = serie_id;
    }
    
    public int getResena_id() {
        return resena_id;
    }

    public void setResena_id(int resena_id) {
        this.resena_id = resena_id;
    }

    public String getTituloResena() {
        return tituloResena;
    }

    public void setTituloResena(String tituloResena) {
        this.tituloResena = tituloResena;
    }

    public String getTextoResena() {
        return textoResena;
    }

    public void setTextoResena(String textoResena) {
        this.textoResena = textoResena;
    }

    public Integer getPelicula() {
        return pelicula_id;
    }

    public void setPelicula(Integer pelicula_id) {
        this.pelicula_id = pelicula_id;
    }

    public Integer getUsuario() {
        return usuario_id;
    }

    public void setUsuario(Integer usuario_id) {
        this.usuario_id = usuario_id;
    }
    
    @Override
    public String toString() {
        return "Resena{" +
            "ID=" + resena_id +
            ", titulo='" + tituloResena + '\'' +
            ", texto='" + textoResena + '\'' +
            '}';
    }
}