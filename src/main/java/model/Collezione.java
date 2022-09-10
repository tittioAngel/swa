/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author matte
 */
public class Collezione {
    private int id;
    private String nome;
    private List <Disco> dischi;
    private Utente creatore;
    private List <Utente> condivisi;
    
    private static int cont=1;
    
    public Collezione(){
        id=cont;
        cont++;
        
        nome="";
        dischi= new ArrayList<>();
        creatore= new Utente();
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

    public List<Disco> getDischi() {
        return dischi;
    }

    @JsonProperty
    public void setDischi(List<Disco> dischi) {
        this.dischi = dischi;
    }
    
    public Utente getCreatore() {
        return creatore;
    }
    
    @JsonProperty
    public void setCreatore(Utente creatore){
        this.creatore = creatore;
    }
    
     public List<Utente> getCondivisi() {
        return condivisi;
    }

    @JsonProperty
    public void addCondivisi(Utente condiviso) {
        this.condivisi.add(condiviso);
    }
    
    /**
     *
     * @param nome
     * @param creatore
     * @return
     */
    public static Collezione dummyCollezione(String nome, Utente creatore){
        Collezione collezione=new Collezione();
        
        collezione.setNome(nome);
        collezione.setCreatore(creatore);
        
        return collezione;
    }
    
    
    
}
