/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.ArrayList;
import java.util.List;
import model.Utente;
import swarest.RESTWebApplicationException;

/**
 *
 * @author matte
 */
public class UtenteManager {
   
    public static List<Utente> utenti = new ArrayList<Utente>();

    
     public static void initilizeData(){
        if (utenti.isEmpty()) {
            
            
            
            utenti.add(Utente.dummyUtente(1, "thSantacruz","Giacomo", "Santacroce", "giacomo@gmail.com", "3455944879","12345"));
            utenti.add(Utente.dummyUtente(2, "tittioAngel","Matteo", "Angelucci", "metteo@gmail.com", "3455944879","12345"));
            utenti.add(Utente.dummyUtente(3, "claudo","Claudio", "Angelucci", "claudio@gmail.com", "3455944879","12345"));
        }
    }
    
    public static Utente getUtenteByID(int idUtente) {
        for (Utente u : utenti) {
            if (u.getId() == idUtente) {
                Utente res = new Utente();
                res.setId(u.getId());
                res.setNome(u.getNome());
                res.setCognome(u.getCognome());
                res.setEmail(u.getEmail());
                
                return res;
            }
        }
        
        throw new RESTWebApplicationException(404, "utente non trovato");
    }
    
    
}