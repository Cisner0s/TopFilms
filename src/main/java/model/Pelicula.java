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
public class Pelicula {
    private int pelicula_id;
    private String titulo;
    private Date fecha_Estreno;
    private String genero;
    private long presupuesto;
    private long ganancias;
    private String sinopsis;
    private String imagen;
    private int director_id;
    private int estudio_id;
    private List<Actor> actores;
    private List<Resena> resenas;
    private List<Critica> criticas;

    public Pelicula() {}
    
    public Pelicula(String titulo, String sinopsis, String genero, Date fecha_Estreno, long presupuesto, long ganancias, String imagen, int director_id, int estudio_id) {
        this.titulo = titulo;
        this.fecha_Estreno = fecha_Estreno;
        this.genero = genero;
        this.presupuesto = presupuesto;
        this.ganancias = ganancias;
        this.sinopsis = sinopsis;
        this.imagen = imagen;
        this.director_id = director_id;
        this.estudio_id = estudio_id;
    }
    
    public int getPelicula_id() {
        return pelicula_id;
    }

    public void setPelicula_id(int pelicula_id) {
        this.pelicula_id = pelicula_id;
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

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    public long getGanancias() {
        return ganancias;
    }

    public void setGanancias(int ganancias) {
        this.ganancias = ganancias;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getDirector() {
        return director_id;
    }

    public void setDirector(int director_id) {
        this.director_id = director_id;
    }

    public int getEstudio() {
        return estudio_id;
    }

    public void setEstudio(Estudio estudio) {
        this.estudio_id = estudio_id;
    }

    public List<Actor> getActores() {
        return actores;
    }

    public void setActores(List<Actor> actores) {
        this.actores = actores;
    }

    public List<Resena> getResenas() {
        return resenas;
    }

    public void setResenas(List<Resena> resenas) {
        this.resenas = resenas;
    }
    
    @Override
    public String toString() {
        return "Pelicula{" +
            "pelicula_id=" + pelicula_id +
            ", titulo='" + titulo + '\'' +
            ", fecha_Estreno='" + fecha_Estreno + '\'' +
            ", genero='" + genero + '\'' +
            ", presupuesto=" + presupuesto +
            ", ganancias=" + ganancias +
            ", sinopsis='" + sinopsis + '\'' +
            ", imagen='" + imagen + '\'' +
            ", director=" + director_id +
            ", estudio=" + estudio_id +
            ", actores=" + actores +
            ", resenas=" + resenas +
            ", criticas=" + criticas +
            '}';
}

}
