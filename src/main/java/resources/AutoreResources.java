/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resources;

import jakarta.ws.rs.Path;
import model.Autore;

/**
 *
 * @author LENOVO
 */
public class AutoreResources {
    
    private final Autore a;
    
    public AutoreResources(Autore a){
        this.a = a;
    }
    
    /***
     * OP 9 - elenco dischi di un autore
     * @return 
     */
    @Path("dischi")
    public DischiResource getDischi() {
        return new DischiResource(a);
    }
}
