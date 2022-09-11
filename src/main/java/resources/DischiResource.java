/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import java.util.List;
import model.Autore;
import model.Collezione;
import model.Disco;
import model.Stato;

/**
 *
 * @author LENOVO
 */
class DischiResource {

    private final Collezione c;
    
    public DischiResource(Collezione c){
        this.c = c;
    }
    
    /***
     * OP 4 - GET[BASE]/collezioni/id/dischi
     * @return 
     */
    @GET
    @Produces("application/json")
    public Response getDischi() throws WebApplicationException {
         
        List<Disco> res = c.getDischi();
        
        Autore a1 = Autore.dummyAutore("a1");
        Autore a2 = Autore.dummyAutore("a2");
        Autore a3 = Autore.dummyAutore("a3");
         
        res.add(Disco.dummyDisco("t1", a1, 2021, "Polydor", "LP", "abcdefg",Stato.ottimo,2,"Rap"));
        res.add(Disco.dummyDisco("t2", a2, 2018, "Pippo", "CD", "foo",Stato.pessimo,1,"Indie"));
        
         return Response.ok(res).build();
    }
    
    /***
     * OP 5 - GET[BASE]/collezioni/id/dischi/id
     * @param id
     * @param titolo
     * @param autore
     * @param genere
     * @param anno
     * @param etichetta
     * @param formato
     * @param barcode
     * @param stato
     * @return 
     */
    @GET
    @Produces("application/json")
    public Response getDischo(@QueryParam("id") int id,
                              @QueryParam("titolo") String titolo,
                              @QueryParam("autore") Autore autore,
                              @QueryParam("genere") String genere,
                              @QueryParam("anno") int anno,
                              @QueryParam("etichetta") String etichetta,
                              @QueryParam("formato") String formato,
                              @QueryParam("barcode") String barcode,
                              @QueryParam("stato") Stato stato,
                              @Context HttpHeaders headers) throws WebApplicationException {
         
        Disco res = new Disco();
        
        res.setId(id);
        res.setAnno(anno);
        res.setAutore(autore);
        res.setBarcode(barcode);
        res.setEtichetta(etichetta);
        res.setFormato(formato);
        res.setGenere(genere);
        res.setStato(stato);
        res.setTitolo(titolo);
        
        return Response.ok(res).build();
    }
}
