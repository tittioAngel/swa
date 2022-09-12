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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import model.Autore;
import model.Collezione;
import model.Disco;
import model.Stato;
import swarest.RESTWebApplicationException;

/**
 *
 * @author LENOVO
 */
@Path("dischi")
class DischiResource {

    private Collezione c;
    private Autore a;
    
    public DischiResource(Collezione c){
        this.c = c;
    }
    
    public DischiResource(Autore a){
        this.a = a;
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
    @Path("{utente: [1-9]+}/{disco: [1-9]}")
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
    
    /***
     * OP 7a - ricerca tra i dischi personali
     * @param titolo
     * @param etichetta
     * @param formato
     * @return 
     */
    @GET
    @Produces("application/json")
    @Path("{id: [1-9]}")
    public Response getDischiPers(@QueryParam("titolo") String titolo,
                                  @QueryParam("etichetta") String etichetta,
                                  @QueryParam("formato") String formato) throws WebApplicationException {
         
        List<Disco> dischi = new ArrayList<>();
        
        for(int i=0;i<10;i++){
            Disco d = new Disco();
            d.setTitolo("t"+i);
            d.setEtichetta("e"+i);
            d.setFormato("CD");
            dischi.add(d);
        }
        
        List<Disco> res = new ArrayList<>();
        
        if(formato.equals("CD")){
            res =  new ArrayList<>(dischi);
        }else{
            Iterator<Disco> itr = res.iterator();
            while (itr.hasNext()) {
                Disco temp = itr.next();
                if(temp.getTitolo().equals("titolo")||temp.getEtichetta().equals("etichetta")){
                    res.add(temp);
                }
            }   
        }
         
        if (res.isEmpty()) {
             throw new RESTWebApplicationException(404, "disco inesistente");
        }     
        return Response.ok(res).build();
    } //farne altri?
    
    /***
     * OP 9 - dischi di un autore
     * @param idAutore
     * @return 
     */
    @GET
    @Produces("application/json")
    
    public Response getDischiAut(@QueryParam("id") int idAutore) throws WebApplicationException {
         
        List<Disco> res = new ArrayList<>();
        a.setId(idAutore);
        
        for(int i=0;i<10;i++){
            Disco d = new Disco();
            d.setTitolo("t"+i);
            d.setAutore(a);
            res.add(d);
        }
        
        return Response.ok(res).build();
    }
}
