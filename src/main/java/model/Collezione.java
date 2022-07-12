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
    
    private static int cont=1;
    
    public Collezione(){
        id=cont;
        cont++;
        
        nome="";
        dischi= new ArrayList<>();
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
    
    
    public Collezione dummyColezione(String nome, List<Disco> dischi){
        Collezione collezione=new Collezione();
        
        collezione.setNome(nome);
        collezione.setDischi(dischi);
        
        return collezione;
    }
    
    
    
}
