package nl.hu.IPASS.webservices;

import nl.hu.IPASS.model.Gebruiker;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/uren")
public class UrenResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getUren(){
        return Gebruiker.getAlleUren();
    }
}
