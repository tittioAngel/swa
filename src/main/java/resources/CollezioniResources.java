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
import jakarta.ws.rs.core.UriInfo;
import java.net.URI;
/**
 *
 * @author LENOVO
 */
public class CollezioniResources {
    
    
    /**
     * OP 2 
     * @param uriinfo
     * @param id
     * @return
     * @throws RESTWebApplicationException 
     */
    @GET
    @Produces("application/json")
    @Path("{id: [1-9]+}")
    public Response getCollezioni(
                    @Context UriInfo uriinfo,    
                    @PathParam("id") int id)throws RESTWebApplicationException{
        
        List<Map<String, Object>> collezioni = new ArrayList();
        
        Utente u1 = Utente.dummyUtente(1, "thSantacruz","Giacomo", "Santacroce", "giacomo@gmail.com", "3455944879","12345");
        Utente u2 = Utente.dummyUtente(2, "tittioAngel","Matteo", "Angelucci", "metteo@gmail.com", "3455944879","12345");
        Utente u3 = Utente.dummyUtente(3, "claudo","Claudio", "Angelucci", "claudio@gmail.com", "3455944879","12345");
        
        Autore a1 = Autore.dummyAutore("a1");
        Autore a2 = Autore.dummyAutore("a2");
        Autore a3 = Autore.dummyAutore("a3");
        
        for (int i = 0; i <= 9; i++) {
            
            Collezione c = new Collezione();
            List<Disco> dischi = c.getDischi(); 
            
            if(i<3){
                c = Collezione.dummyCollezione("c" + i, u1);
                dischi.add(Disco.dummyDisco("t1", a1, 2021, "Polydor", "LP", "abcdefg",Stato.ottimo,2,"Rap"));
                dischi.add(Disco.dummyDisco("t2", a2, 2018, "Pippo", "CD", "foo",Stato.pessimo,1,"Indie"));
            }else if(i<6){
                c = Collezione.dummyCollezione("c" + i, u2);
                dischi.add(Disco.dummyDisco("t3", a3, 1998, "Music", "CD", "barcode",Stato.buono,1,"Rap"));
            }else{
                c = Collezione.dummyCollezione("c" + i, u3);
                dischi.add(Disco.dummyDisco("t4", a2, 1894, "Music", "LP", "fffffffff",Stato.buono,1,"Classica"));
                dischi.add(Disco.dummyDisco("t5", a3, 2022, "Polydor", "CD", "24385",Stato.ottimo,1,"Rap"));
                dischi.add(Disco.dummyDisco("t6", a1, 2019, "Pippo", "CD", "11111111",Stato.buono,1,"Rap"));
            }
              
            c.setDischi(dischi);
            
            Map<String, Object> collezione = new HashMap<>();
            collezione.put("nome", c.getNome());
            collezione.put("Creatore", c.getCreatore());
            // creazione url per vedere il dettaglio
            URI uri = uriinfo.getBaseUriBuilder()
                    .path(getClass())
                    .path(getClass(), "getDettCol")
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
    
    /**
     * Estensione del path per gestire le operazioni su singolo progetto
     * @param id
     * @return 
     */
    @Path("{id: [1-9]+}")
    public CollezioneResource getDettCol(@PathParam("id") int id) {
        
        Collezione c = null;
        Utente u1 = Utente.dummyUtente(1, "thSantacruz","Giacomo", "Santacroce", "giacomo@gmail.com", "3455944879","12345");
        Utente u2 = Utente.dummyUtente(2, "tittioAngel","Matteo", "Angelucci", "metteo@gmail.com", "3455944879","12345");
        Utente u3 = Utente.dummyUtente(3, "claudo","Claudio", "Angelucci", "claudio@gmail.com", "3455944879","12345");
        
        if(id<3){
            c = Collezione.dummyCollezione("c" + id, u1);
        }else if(id<6){
            c = Collezione.dummyCollezione("c" + id, u2);
        }else{
            c = Collezione.dummyCollezione("c" + id, u3);
        }
        
        return new CollezioneResource(c);
    }
    
}
