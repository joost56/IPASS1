package nl.hu.IPASS.webservices;

import com.azure.core.annotation.Put;
import nl.hu.IPASS.model.Uren;

import javax.annotation.security.RolesAllowed;
import javax.json.Json;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Path("uur")
public class UurResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getUren(){
        return Json.createObjectBuilder().add("error", "this request is not allowed").build().toString();
    }

    @GET
    @Path("{uurid}")
    @Produces("application/json")
    public Response getUren(@PathParam("uurid") int id){
        Uren uren = Uren.getUur(id);
        if (uren == null){
            Map<String, String> messages = new HashMap<>();
            messages.put("error", "Uur bestaat niet!");
            messages.put("requestId", Integer.toString(id));
            return Response.status(409).entity(messages).build();
        }
        return Response.ok(uren).build();
    }

    @PUT
    @Path("wijzigen")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("gebruiker")
    public Response updateUur(@FormParam("uren") int ur, @FormParam("omschrijving") String om, @FormParam("datum") String da, @FormParam("id") int id){
        if (id <=0) {
            return Response.status(Response.Status.CONFLICT).entity(new AbstractMap.SimpleEntry<>("error", "Id mag niet kleiner of gelijk aan 0 zijn!")).build();
        }
        if(ur <= 0) {
            return Response.status(Response.Status.CONFLICT).entity(new AbstractMap.SimpleEntry<>("error", "Uren mag niet kleiner of gelijk aan 0 zijn!")).build();
        }

        if(om.trim().equals("")) {
            return Response.status(Response.Status.CONFLICT).entity(new AbstractMap.SimpleEntry<>("error", "Omschrijving mag niet leeg zijn!")).build();
        }

        Uren update = Uren.updateUren(new Uren(id, ur, om, da));

        return Response.ok(update).build();
    }

    @DELETE
    @Path("{uurid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUur(@PathParam("uurid") int id){
        if (Uren.removeUur(id))return Response.ok().build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }

//    @DELETE
//    @Path("verwijderen")
//    @Produces(MediaType.APPLICATION_JSON)
//    @RolesAllowed("gebruiker")
//    public Response deleteUur(@PathParam("delete") int id){
//        if (id <=0) {
//            return Response.status(Response.Status.CONFLICT).entity(new AbstractMap.SimpleEntry<>("error", "Id mag niet kleiner of gelijk aan 0 zijn!")).build();
//        }
//        Uren delete = Uren.removeUur(id);
//        return Response.ok(delete).build();
//    }

}