package nl.hu.IPASS.webservices;

import nl.hu.IPASS.model.Gebruiker;
import nl.hu.IPASS.model.Uren;

import javax.annotation.security.RolesAllowed;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Path("/uren")
public class UrenResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Uren> getUren(){
        return Uren.getAlleUren();
    }

    @POST
    @Path("nojackson")
    @Produces(MediaType.APPLICATION_JSON)
    public String createUren(@FormParam("uren") int ur, @FormParam("omschrijving") String om, @FormParam("date") String da ){
        Uren nieuweUren = Uren.createUren(ur, om, da);
        JsonObjectBuilder job = Json.createObjectBuilder();
        if (om != null && ur != 0) {
            job.add("uren", nieuweUren.getGewerkteUren());
            job.add("omschrijving", nieuweUren.getUrenOmschrijving());
            job.add("datum", nieuweUren.getDatum());
        }else if(ur == 0) {
            job.add("error", "U heeft 0 uur gewerkt?");
        }else if (ur != 0 && om == null){
            job.add("error", "Wat heeft u gedaan in dit uur/deze uren?");
        }else{
            job.add("error", "Uren zijn niet toegevoegd");
        }
        return job.build().toString();
    }

//    @POST
//    @Path("nojackson")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String createEigenaarOld(@FormParam("uren") int ur, @FormParam("omschrijving") String om){
//        List nieuweUren = Gebruiker.createUren(ur, om);
//        JsonObjectBuilder job = Json.createObjectBuilder();
//        if (nieuweUren != null) {
//            job.add("uren", (BigDecimal) Gebruiker.alleUren);
//        }else{
//            job.add("error", "uren niet aangemaakt");
//        }
//        return job.build().toString();
//    }
}
