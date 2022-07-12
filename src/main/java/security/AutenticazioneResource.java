/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package security;

import data.TokenManager;
import data.UtenteManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import model.Utente;

/**
 *
 * @author matte
 */
@Path("auth")
public class AutenticazioneResource {

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response doLogin(@Context UriInfo uriinfo,
            @FormParam("username") String username,
            @FormParam("password") String password) {
                
        try {
            // inizializzazione dei dati e delle credenziali degli utenti registrati nel sistema
            UtenteManager.initilizeData();
            
            Integer id = authenticate(username, password);
            if (id != null) {
                
                String authToken = issueToken(uriinfo, id);

                return Response.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + authToken).build();
                
            } else {
                return Response.status(Response.Status.UNAUTHORIZED).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    //@Logged
    @DELETE
    @Path("/logout")
    public Response doLogout(@Context HttpServletRequest request) {
        
        try {
            //estraiamo i dati inseriti dal nostro LoggedFilter...
            String token = (String) request.getAttribute("token");
            if (token != null) {
                revokeToken(token);
            }
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }

    private Integer authenticate(String username, String password) {
        for (Utente utente : UtenteManager.utenti) {
            if ( username.equals(utente.getUsername()) && password.equals(utente.getPassword())) {
                return utente.getId();
            }
        }
        
        return null;
    }

    private String issueToken(UriInfo context, Integer id) {
        String token = UUID.randomUUID().toString() + id;
        TokenManager.tokens.add(token);
        return token;
    }

    private void revokeToken(String token) {
        List<String> listaTokens = TokenManager.tokens; 
        Iterator<String> it = listaTokens.iterator();
        
        // rimuovo il token dalla lista di token presente in TokenManager
        while(it.hasNext()) {
            if(token.equals(it.next())) {
                it.remove();
            }
        }
    }
}
