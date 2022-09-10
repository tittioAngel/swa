/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources;

import model.Collezione;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Autore;
import model.Disco;
import model.Stato;
import model.Utente;
import swarest.RESTWebApplicationException;
/**
 *
 * @author LENOVO
 */
public class CollezioniResources {
    
    private final Collezione c;
    
    CollezioniResources(Collezione c) {
        this.c = c;
    }
    
    
    //OP2
    @GET
    @Produces("application/json")
    @Path("{id: [1-9]+}")
    public Response getCollezioni(@PathParam("id") int id){
        
        List<Map<String, Object>> collezioni = new ArrayList();
        
        Utente u1 = Utente.dummyUtente(1, "thSantacruz","Giacomo", "Santacroce", "giacomo@gmail.com", "3455944879","12345");
        Utente u2 = Utente.dummyUtente(2, "tittioAngel","Matteo", "Angelucci", "metteo@gmail.com", "3455944879","12345");
        Utente u3 = Utente.dummyUtente(3, "claudo","Claudio", "Angelucci", "claudio@gmail.com", "3455944879","12345");
        
        Autore a1 = Autore.dummyAutore("a1");
        Autore a2 = Autore.dummyAutore("a2");
        Autore a3 = Autore.dummyAutore("a3");
        
        for (int i = 0; i <= 9; i++) {
            
            Collezione temp = new Collezione();
            
            if(i<3){
                temp = Collezione.dummyCollezione("c" + i, u1);
            }else if(i<6){
                temp = Collezione.dummyCollezione("c" + i, u2);
            }else{
                temp = Collezione.dummyCollezione("c" + i, u3);
            }
              
            List<Disco> dischi = temp.getDischi(); 
            for(int j=0; j<=3; j++){
                if(j==0){
                    dischi.add(Disco.dummyDisco("t" + j, a1, 2021, "Polydor", "LP", "abcdefg",Stato.ottimo,2,"Rap"));
                }else if(j==1){
                    dischi.add(Disco.dummyDisco("t" + j, a2, 2018, "Pippo", "CD", "foo",Stato.pessimo,1,"Indie"));
                }else{
                    dischi.add(Disco.dummyDisco("t" + j, a3, 1998, "Music", "CD", "barcode",Stato.buono,1,"Rap"));
                }
            }
     
            
            Map<String, Object> collezione = new HashMap<>();
            collezione.put("nome", temp.getNome());
            collezione.put("Creatore", temp.getCreatore());
            // creazione url per vedere il dettaglio
            URI uri = uriinfo.getBaseUriBuilder()
                    .path(getClass())
                    .path(getClass(), "getProject")
                    .build(i);
            collezione.put("url", uri.toString());
            collezioni.add(collezione);
                
        }
        
        ArrayList<Map<String, Object>> res = new ArrayList<>();
        
        if(id<3){
            res.add(collezioni.get(0));
            res.add(collezioni.get(1));
            res.add(collezioni.get(2));
        }else if(id<6){
            res.add(collezioni.get(3));
            res.add(collezioni.get(4));
            res.add(collezioni.get(5));
        }else{
            res.add(collezioni.get(6));
            res.add(collezioni.get(7));
            res.add(collezioni.get(8));
            res.add(collezioni.get(9));
        }
        
        if (res.isEmpty()) {
             throw new RESTWebApplicationException(404, "collezioni inesistenti");
        }     
        return Response.ok(res).build();
    }
    
}
