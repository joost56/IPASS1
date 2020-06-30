package nl.hu.IPASS.webservices;

import nl.hu.IPASS.model.Gebruiker;
import nl.hu.IPASS.model.Uren;

import javax.annotation.security.RolesAllowed;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.AbstractMap;
import java.util.HashMap;
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
    public String createUren(@FormParam("uren") String ur, @FormParam("omschrijving") String om, @FormParam("date") String da, @FormParam("id") int id){
        Uren nieuweUren = Uren.createUren(ur, om, da);
        JsonObjectBuilder job = Json.createObjectBuilder();
        if (om != null && ur != null) {
            job.add("datum", nieuweUren.getDatum());
            job.add("uren", nieuweUren.getGewerkteUren());
            job.add("omschrijving", nieuweUren.getUrenOmschrijving());
        }else if(ur == null) {
            job.add("error", "U heeft 0 uur gewerkt?");
        }else if (ur != null && om == null){
            job.add("error", "Wat heeft u gedaan in dit uur/deze uren?");
        }else{
            job.add("error", "Uren zijn niet toegevoegd");
        }
        return job.build().toString();
    }

    @POST
    @Path("jackson")
    @Produces(MediaType.APPLICATION_JSON)
    public Response CreateUren(@FormParam("uren") String ur, @FormParam("omschrijving") String om, @FormParam("date") String datum, @FormParam("id") int id){
        Uren nieuweUren = Uren.createUren(ur, om, datum);
        HashMap<String, String> hashalleuren = new HashMap<String, String>();
        if (nieuweUren == null) {
            return Response.status(Response.Status.CONFLICT).entity(new AbstractMap.SimpleEntry<>("result", "Uur bestond al")).build();
        }else {
            hashalleuren.put("uren", ur);
            hashalleuren.put("omschrijving", om);
            return Response.ok(nieuweUren).build();
        }

    }
}
