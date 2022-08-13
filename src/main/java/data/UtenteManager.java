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
//            List<Collezione> collezione = new ArrayList<Skill>(); 
//            skills.add(Skill.dummySkills("Programmazione Java Sockets"));
//            skills.add(Skill.dummySkills(("programmazione in C")));
            
            utenti.add(Utente.dummyUtente("stef","Stefano", "Pisciella", "stefano@gmail.com", "3880581680","12345",);
            utenti.add(Utente.dummyUtente(2, "Beatrice", "Tomassi", "beatrice@gmail.com", "3880581680", "beatrice", "beatrice", skills));
            utenti.add(Utente.dummyUtente(3, "Nicola", "Rossi", "nicola@gmail.com", "3880581680", "nicola", "nicola", skills));
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
    
    
    public static List<Utente> getUtenti(Integer skill1, Integer skill2) {
        List<Utente> utentiIdonei= new ArrayList<Utente>();
       
        int skillRichieste = (skill1 != null)? 1 : 0;
        skillRichieste += (skill2 != null)? 1 : 0;
        
        if(skillRichieste == 0) {
            return utenti;
        }
        
        for(Utente u: utenti) {
            int skillPossedute = 0;
            
            for(Skill skill : u.getSkills()) {
                if(skill.getId() == skill1 || skill.getId() == skill2) {
                    skillPossedute++;
                }
                if (skillPossedute >= skillRichieste) {
                    utentiIdonei.add(u);
                }   
            }       
        }
        return utentiIdonei; 
    }
}