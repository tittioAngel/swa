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
    private Genere genere;
    private int anno;
    private String etichetta;
    private String formato;
    private String barcode;
    private Stato stato;
    private List<Traccia> tracce;
    private int ncopie;
    private String img;
    
    
    private static int cont=1;

    public Disco() {
        id=cont;
        cont++;
        
        titolo="";
        autore=new Autore();
        genere=new Genere();
        anno=0;
        etichetta="";
        formato="";
        barcode="";
        stato=null;
        tracce=new ArrayList<>();
        ncopie=0;
        img=""; 
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

    public Genere getGenere() {
        return genere;
    }

    @JsonProperty
    public void setGenere(Genere genere) {
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
        this.tracce = tracce;
    }

    public int getNcopie() {
        return ncopie;
    }

    @JsonProperty
    public void setNcopie(int ncopie) {
        this.ncopie = ncopie;
    }

    public String getImg() {
        return img;
    }

    
    @JsonProperty
    public void setImg(String img) {
        this.img = img;
    }

  
    
   public static Disco dummyDisco ( String titolo, Autore autore, int anno, String etichetta, String formato, String barcode, List<Traccia> tracce, Stato stato, String img,int ncopie, Genere genere) {
        Disco disco = new Disco();
        
        
        disco.setTitolo(titolo);
        disco.setAutore(autore);
        disco.setGenere(genere);
        disco.setAnno(anno);
        disco.setEtichetta(etichetta);
        disco.setFormato(formato);
        disco.setBarcode(barcode);
        disco.setTracce(tracce);
        disco.setStato(stato);
        disco.setImg(img);
        disco.setNcopie(ncopie);
        
        
        return disco;
    }
    
}
