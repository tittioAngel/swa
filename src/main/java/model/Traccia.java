/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author matte
 */
public class Traccia {
    private int id;
    private String nome;
    private String durata;
    private String cantante;
    private String compositore;
    
    private static int cont=1;
    
    
    public Traccia(){
        id=cont;
        cont++;
        
        nome="";
        durata="";
        cantante="";
        compositore="";
        
    }

    public Traccia(String nome, String durata) {
        id=cont;
        cont++;
        this.nome = nome;
        this.durata = durata;
    }

    
    
    
    
    public int getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }


    @JsonProperty
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDurata() {
        return durata;
    }

    
    @JsonProperty
    public void setDurata(String durata) {
        this.durata = durata;
    }

    public String getCantante() {
        return cantante;
    }

    
    @JsonProperty
    public void setCantante(String cantante) {
        this.cantante = cantante;
    }

    public String getCompositore() {
        return compositore;
    }

    
    @JsonProperty
    public void setCompositore(String compositore) {
        this.compositore = compositore;
    }
    
    
    
    
     public static Traccia dummyUtente (String nome, String durata, String compositore, String cantante) {
        Traccia traccia = new Traccia();
        
        traccia.setNome(nome);
        traccia.setDurata(durata);
        traccia.setCompositore(compositore);
        traccia.setCantante(cantante);
        
        
        return traccia;
     }

}