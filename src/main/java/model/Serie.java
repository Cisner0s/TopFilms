/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author DCM
 */
public class Serie {
    
    private int serie_id;
    private String titulo;
    private String fecha_Estreno;
    private String genero;
    private int presupuesto;
    private int ganacias;
    private int n_Episodios;
    private double Duracion_Med_Episodio;
    private String imagen;
    private int n_Temporadas;
    private Director director;
    private Estudio estudio;
    private List<Actor> actores;
    private List<Resena> resenas;
    private List<Critica> criticas;

    public Serie() {

    }

    public Serie( String titulo, String fecha_Estreno, String genero, int presupuesto, int ganacias,
            int n_Episodios, double Duracion_Med_Episodio, String imagen, int n_Temporadas, Estudio estudio,
            Director director) {
     
        this.titulo = titulo;
        this.fecha_Estreno = fecha_Estreno;
        this.genero = genero;
        this.presupuesto = presupuesto;
        this.ganacias = ganacias;
        this.n_Episodios = n_Episodios;
        this.Duracion_Med_Episodio = Duracion_Med_Episodio;
        this.imagen = imagen;
        this.n_Temporadas = n_Temporadas;
        this.estudio = estudio;
        this.director = director;
    }

    public int getSerie_id() {
        return serie_id;
    }

    public void setSerie_id(int serie_id) {
        this.serie_id = serie_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha_Estreno() {
        return fecha_Estreno;
    }

    public void setFecha_Estreno(String fecha_Estreno) {
        this.fecha_Estreno = fecha_Estreno;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    public int getGanacias() {
        return ganacias;
    }

    public void setGanacias(int ganacias) {
        this.ganacias = ganacias;
    }

    public int getN_Episodios() {
        return n_Episodios;
    }

    public void setN_Episodios(int n_Episodios) {
        this.n_Episodios = n_Episodios;
    }

    public double getDuracion_Med_Episodio() {
        return Duracion_Med_Episodio;
    }

    public void setDuracion_Med_Episodio(double Duracion_Med_Episodio) {
        this.Duracion_Med_Episodio = Duracion_Med_Episodio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getN_Temporadas() {
        return n_Temporadas;
    }

    public void setN_Temporadas(int n_Temporadas) {
        this.n_Temporadas = n_Temporadas;
    }

    public Estudio getEstudio() {
        return estudio;
    }

    public void setEstudio(Estudio estudio) {
        this.estudio = estudio;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Actor> getActores() {
        return actores;
    }

    public void setActores(List<Actor> actores) {
        this.actores = actores;
    }

    public List<Resena> getResena() {
        return resenas;
    }

    public void setResena(List<Resena> resena) {
        this.resenas = resena;
    }
}
