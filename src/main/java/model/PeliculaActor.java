/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author jorge
 */
public class PeliculaActor {
    
    private int pelicula_id; 
    private int actor_id; 
    
    public PeliculaActor(int pelicula_id, int actor_id){
        this.pelicula_id = pelicula_id; 
        this.actor_id = actor_id;
    }
    
    public int getPelicula_id(){
        return pelicula_id; 
    }

    public void setPelicula_id(int pelicula_id){
        this.pelicula_id = pelicula_id;
    }
    
    public int getActor_id(){
        return actor_id; 
    }
    
    public void setActor_id(int actor_id){
        this.actor_id = actor_id;
    }
    
}
