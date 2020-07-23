package nl.hu.IPASS.webservices;

import nl.hu.IPASS.model.Klant;
import nl.hu.IPASS.model.Uren;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.AbstractMap;
import java.util.List;

@Path("klant")
public class KlantgegevensResource {

        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public List<Klant> getKlanten(){
            return Klant.getAlleKlanten();
        }

        @POST
        @Path("toevoegklantgegevens")
        @Produces(MediaType.APPLICATION_JSON)
        @RolesAllowed("gebruiker")
        public Response createKlant(@FormParam("bedrijfsnaam") String bn, @FormParam("bedrijfsadres") String ba, @FormParam("bedrijfspostcode") String bp, @FormParam("contactpersoon") String cp, @FormParam("tarief") int tarief) {

                if (bn.trim().equals("") || ba.trim().equals("") || bp.trim().equals("") || cp.trim().equals("") || tarief <= 0) {
                        return Response.status(Response.Status.CONFLICT).entity(new AbstractMap.SimpleEntry<>("error", "Alle velden moeten worden ingevuld!")).build();
                }
                if (!getKlanten().contains(bn) || !getKlanten().contains(ba)) {
                        Klant nieuweKlant = Klant.createKlant(bn, ba, bp, cp, tarief);
                        String klantNaam = Klant.getAlleKlantNamen().toString();
//                        Response.status(Response.Status.CONFLICT).entity(new AbstractMap.SimpleEntry<>("message", klantNaam)).build();
                        return Response.ok(nieuweKlant).build();

                }
                else {
                        return Response.status(Response.Status.CONFLICT).entity(new AbstractMap.SimpleEntry<>("error", "Klant met deze naam of bedrijfsadres bestaat al!")).build();
                }
        }

}
