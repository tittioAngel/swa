/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.ArrayList;
import java.util.List;
import model.Disco;
import model.Stato;
import model.Traccia;

/**
 *
 * @author matte
 */
public class DischiManager {
    
    public static List<Disco> dischi=new ArrayList<Disco>();
    
     public static void initilizeData(){
         if (dischi.isEmpty()) {
             List<Traccia> tracce= TracceManager.initilizeData();
             
             List <Traccia> tracce1 =new ArrayList<Traccia>();
             tracce1.add(tracce.get(0));
             tracce1.add(tracce.get(1));
             
             List <Traccia> tracce2=new ArrayList<Traccia>();
             tracce2.add(tracce.get(2));
             tracce2.add(tracce.get(3));
            
             List <Traccia> tracce3 =new ArrayList<Traccia>();
             tracce3.add(tracce.get(4));
             tracce3.add(tracce.get(5));
             
             dischi.add(Disco.dummyDisco("Exuvia", "Caparezza", 2021, "Polydor", "LP", "abcdefg",Stato.ottimo,2,"Rap"));
             
             
         }
     }
}
