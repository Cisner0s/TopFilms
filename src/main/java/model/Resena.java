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
    private Pelicula pelicula;
    private Serie serie;
    private Usuario usuario;

    public Resena(String tituloResena, String textoResena, Usuario usuario) {
        this.tituloResena = tituloResena;
        this.textoResena = textoResena;
        this.pelicula = pelicula;
        this.usuario = usuario;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public Resena() {
        // Constructor vacío
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

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}