package nl.hu.IPASS.webservices;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/main")
public class InlogResource {
    @POST
    @Path("nojackson")
    @Produces(MediaType.APPLICATION_JSON)
    public void beveiliging(@FormParam("login") String email, String wachtwoord) {
        if (wachtwoord != null && email != null) {
            
        } else {

        }
    }


}
