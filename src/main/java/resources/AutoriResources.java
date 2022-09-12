/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import model.Autore;

/**
 *
 * @author LENOVO
 */
@Path("autori")
public class AutoriResources {
    
    /**
     * OP 8 lista autori 
     * @param uriinfo
     * @param id
     * @return
     * @throws RESTWebApplicationException 
     */
    @GET
    @Produces("application/json")
    public Response getAutori(){
        
        List<Autore> res = new ArrayList<>();
        
        Autore a1 = Autore.dummyAutore("a1");
        Autore a2 = Autore.dummyAutore("a2");
        Autore a3 = Autore.dummyAutore("a3");
        
        res.add(a1);
        res.add(a2);
        res.add(a3);
        
        return Response.ok(res).build();
    }
}
