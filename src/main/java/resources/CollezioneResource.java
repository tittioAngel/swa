/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import java.net.URI;
import model.Autore;
import model.Collezione;
import model.Disco;
import model.Stato;

/**
 *
 * @author LENOVO
 */
@Path("collezione")

class CollezioneResource {

   private final Collezione c;
    
    public CollezioneResource(Collezione c){
        this.c = c;
    }
    
    
    /***
     * OP 4 - GET[BASE]/collezioni/id/dischi
     * @param c
     * @return 
     * estensione del path e fattorizzazione con classe DischiResource
     */
    @GET
    @Path("dischi")
    public DischiResource getDischi() {
        return new DischiResource(this.c);
    }
    
    /***
     * OP 6 - POST [BASE]/collezioni/id/dischi
     * @param uriinfo
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
    @POST
    @Path("dischi")
    @Consumes("application/json")
    public Response addDisco(
                              @Context UriInfo uriinfo,
                              @QueryParam("id") int id,
                              @QueryParam("titolo") String titolo,
                              @QueryParam("autore") Autore autore,
                              @QueryParam("genere") String genere,
                              @QueryParam("anno") int anno,
                              @QueryParam("etichetta") String etichetta,
                              @QueryParam("formato") String formato,
                              @QueryParam("barcode") String barcode,
                              @QueryParam("stato") Stato stato,
                              @Context HttpHeaders headers) {
        
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
        
        c.getDischi().add(res);
        
        URI uri = uriinfo.getBaseUriBuilder()                       // [BASE]/rest
                .path(CollezioniResources.class)                       // /progetti
                .path(CollezioniResources.class, "getDettCol")         // /idProg
                .path(CollezioneResource.class, "getDischi")        // /messaggi
                .path(Integer.toString(res.getId()))
                .build(c.getId());
        
        return Response.created(uri).build();
    }
}
