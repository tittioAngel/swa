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
public class Disco {
    
    private int id;
    private String titolo;
    private Autore autore;
    private String genere;
    private int anno;
    private String etichetta;
    private String formato;
    private String barcode;
    private Stato stato;
    private List<Traccia> tracce;
    private int ncopie;

    
    private static int cont=1;

    public Disco() {
        id=cont;
        cont++;
        
        titolo="";
        autore=new Autore();
        genere="";
        anno=0;
        etichetta="";
        formato="";
        barcode="";
        stato=null;
        tracce=new ArrayList<Traccia>();
        ncopie=0;
    }
    
    
    
    

    public int getId() {
        return id;
    }

    @JsonProperty
    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    @JsonProperty
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Autore getAutore() {
        return autore;
    }

    
    @JsonProperty
    public void setAutore(Autore autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    @JsonProperty
    public void setGenere(String genere) {
        this.genere = genere;
    }

    public int getAnno() {
        return anno;
    }

    @JsonProperty
    public void setAnno(int anno) {
        this.anno = anno;
    }

    public String getEtichetta() {
        return etichetta;
    }

    @JsonProperty
    public void setEtichetta(String etichetta) {
        this.etichetta = etichetta;
    }

    public String getFormato() {
        return formato;
    }

    @JsonProperty
    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getBarcode() {
        return barcode;
    }

    @JsonProperty
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Stato getStato() {
        return stato;
    }

    @JsonProperty
    public void setStato(Stato stato) {
        this.stato = stato;
    }

    public List<Traccia> getTracce() {
        return tracce;
    }

    @JsonProperty
    public void setTracce(List<Traccia> tracce) {
        this.tracce=tracce;
    }

    public int getNcopie() {
        return ncopie;
    }

    @JsonProperty
    public void setNcopie(int ncopie) {
        this.ncopie = ncopie;
    }

  
    
   public static Disco dummyDisco ( String titolo, Autore autore, int anno, String etichetta, String formato, String barcode, Stato stato,int ncopie, String genere) {
        Disco disco = new Disco();
        
        
        disco.setTitolo(titolo);
        disco.setAutore(autore);
        disco.setGenere(genere);
        disco.setAnno(anno);
        disco.setEtichetta(etichetta);
        disco.setFormato(formato);
        disco.setBarcode(barcode);
        disco.setStato(stato);
        disco.setNcopie(ncopie);
        
        
        return disco;
    }
    
}
