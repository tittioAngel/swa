/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package swarest;

import com.fasterxml.jackson.jakarta.rs.json.JacksonJsonProvider;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import security.AutenticazioneResource;

/**
 *
 * @author matte
 */

/**
 * @applicatonpath ci permette di dare un path di base al nostro servizio
 * @author matte
 */
@ApplicationPath("rest")
public class RESTApp extends Application{
      private final Set<Class<?>> classes;

    public RESTApp() {
        HashSet<Class<?>> c = new HashSet<Class<?>>();
        
//aggiungiamo tutte le *root resurces* (cioè quelle
        //con l'annotazione Path) che vogliamo pubblicare
       // c.add(UtentiResource.class);
        //c.add(UtenteResource.class);
       // c.add(ProgettiResource.class);
        //c.add(ProgettoResource.class);
        //c.add(MessaggiResource.class);
        //c.add(TasksResource.class);
        c.add(AutenticazioneResource.class);
        //c.add(LoggedFilter.class);

        //aggiungiamo il provider Jackson per poter
        //usare i suoi servizi di serializzazione e 
        //deserializzazione JSON; quindi ci dice di usare jackosn come provider
        c.add(JacksonJsonProvider.class);

        //necessario se vogliamo una (de)serializzazione custom di qualche classe    
       // c.add(ObjectMapperContextResolver.class);

        //esempio di autenticazione
        //c.add(AuthLevel1Filter.class);
        //aggiungiamo il filtro che gestisce gli header CORS
        //c.add(CORSFilter.class);

        //esempio di exception mapper, che mappa in Response eccezioni non già derivanti da WebApplicationException
        //c.add(AppExceptionMapper.class);

        classes = Collections.unmodifiableSet(c);
    }

    


//l'override di questo metodo deve restituire il set
    //di classi che Jersey utilizzerà per pubblicare il
    //servizio. Tutte le altre, anche se annotate, verranno
    //IGNORATE
    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }


}

