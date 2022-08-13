/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author matte
 */
public class Utente {
    private int id;
    private String username;
    private String nome;
    private String cognome;
    private String email;
    private String telefono;
    private String password;
   
    private List<Collezione> collezione;
    
    private static int cont=1; // contatore per l'autoincremento dell'id 

    
    

    
    
    public Utente(){
        id=cont;
        cont++;
        
        username="";
        nome="";
        cognome= "";
        email="";
        telefono="";
        password="";  
        collezione= new ArrayList<Collezione>();
    }
    
    @JsonIgnore
    public int getId() {
        return id;
    }

    
    
    public String getUsername() {
        return username;
    }

    
    @JsonProperty
    public void setUsername(String username) {
        this.username = username;
    }

   
    public String getNome() {
        return nome;
    }

    @JsonProperty
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    
    @JsonProperty
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }
    
    
    @JsonProperty
    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    
    @JsonProperty
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }
    
    
    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    
    public List<Collezione> getCollezione() {
        return collezione;
    }

    @JsonProperty
    public void setCollezione(List<Collezione> collezione) {
        this.collezione = collezione;
    }
    
    
    
    
    
    
    
    
    
    public static Utente dummyUtente (String username, String nome, String cognome, String email, String telefono,String password,List<Collezione> collezione) {
        Utente utente = new Utente();
        
        utente.setUsername(username);
        utente.setNome(nome);
        utente.setCognome(cognome);
        utente.setEmail(email);
        utente.setTelefono(telefono);
        utente.setPassword(password);
        
        utente.setCollezione(collezione);
        
        return utente;
    }
}
