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
public class Genere {
    private int id;
    private String nome;
    
    private static int cont=1;
    
    public Genere(){
        id=cont;
        cont++;
        
        nome="";
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

    public static int getCont() {
        return cont;
    }

     public static Genere dummyGenere (String nome) {
        Genere genere = new Genere();
        
        genere.setNome(nome);

        return genere;
     }

    
    
    
}
