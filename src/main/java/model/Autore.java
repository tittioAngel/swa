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
public class Autore { 
    private int id;
    private String nome;
    
    private static int cont=1;
    
    
    public Autore(){
        id=cont;
        cont++;
        
        nome="";
}

    public Autore(String nome) {
        this.setNome(nome);
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
    
    public static Autore dummyAutore(String nome){
        Autore autore= new Autore();
        
        autore.setNome(nome);
        return autore;
    }
    
    
}
