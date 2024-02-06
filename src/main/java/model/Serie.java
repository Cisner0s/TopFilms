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
public class Serie {
    
    private int serie_id;
    private String titulo;
    private Date fecha_Estreno;
    private String genero;
    private long presupuesto;
    private long ganacias;
    private int n_Episodios;
    private double Duracion_Med_Episodio;
    private int n_Temporadas;
    private int director_id;
    private int estudio_id;
    private List<Actor> actores;
    private List<Resena> resenas;
    private List<Critica> criticas;

    public Serie() {

    }

    public Serie( String titulo, Date fecha_Estreno, String genero, int n_Episodios,
            double Duracion_Med_Episodio, int n_Temporadas, long presupuesto, long ganacias,
            int director_id, int estudio_id) {
     
        this.titulo = titulo;
        this.fecha_Estreno = fecha_Estreno;
        this.genero = genero;
        this.presupuesto = presupuesto;
        this.ganacias = ganacias;
        this.n_Episodios = n_Episodios;
        this.Duracion_Med_Episodio = Duracion_Med_Episodio;
        this.n_Temporadas = n_Temporadas;
        this.estudio_id = estudio_id;
        this.director_id = director_id;
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

    public Date getFecha_Estreno() {
        return fecha_Estreno;
    }

    public void setFecha_Estreno(Date fecha_Estreno) {
        this.fecha_Estreno = fecha_Estreno;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public long getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(long presupuesto) {
        this.presupuesto = presupuesto;
    }

    public long getGanacias() {
        return ganacias;
    }

    public void setGanacias(long ganacias) {
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

    public int getN_Temporadas() {
        return n_Temporadas;
    }

    public void setN_Temporadas(int n_Temporadas) {
        this.n_Temporadas = n_Temporadas;
    }

    public int getEstudio() {
        return estudio_id;
    }

    public void setEstudio(int estudio_id) {
        this.estudio_id = estudio_id;
    }

    public int getDirector() {
        return director_id;
    }

    public void setDirector(Director director) {
        this.director_id = director_id;
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
