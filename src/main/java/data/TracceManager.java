/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.ArrayList;
import java.util.List;
import model.Autore;
import model.Traccia;

/**
 *
 * @author matte
 */
public class TracceManager {
     public static List<Traccia> tracce = new ArrayList<Traccia>();
     
      public static List<Traccia> initilizeData(){
        if (tracce.isEmpty()) {
            Autore autore1 = new Autore("Matthew Marcantonio");
            Autore autore2 = new Autore("Gemelli");
            
            tracce.add(Traccia.dummyTraccia("Canthology", "3:49", autore1, "Caparezza"));
            tracce.add(Traccia.dummyTraccia("Fugadà", "3:43", null, "Caparezza"));
            tracce.add(Traccia.dummyTraccia("Mica Van Gogh", "3:55", null, "Caparezza"));
            tracce.add(Traccia.dummyTraccia("Cover", "5:10", null, "Caparezza"));
            tracce.add(Traccia.dummyTraccia("Taciturnal", "2:54", autore2, "Coez"));
            tracce.add(Traccia.dummyTraccia("Ciao", "3:39", null, "Coez"));
        }
        
        return tracce;
    }
}
