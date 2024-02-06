/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author jorge
 */
public class SerieActor {
    
    private int serie_id; 
    private int actor_id; 
    
    public SerieActor(int serie_id, int actor_id){
        this.serie_id = serie_id; 
        this.actor_id = actor_id; 
    }
    
    public int getSerie_id(){
        return serie_id; 
    }
    
    public void setSerie_Id(int id){
        serie_id = id; 
    }
    
    public int getActor_id(){
        return actor_id; 
    }
    
    public void setActor_id(int id){
        actor_id = id; 
    }
    
}
