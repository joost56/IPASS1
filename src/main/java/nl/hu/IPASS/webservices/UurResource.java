package nl.hu.IPASS.webservices;

import com.azure.core.annotation.Put;
import nl.hu.IPASS.model.Uren;

import javax.json.Json;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

@Path("/uur")
public class UurResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getUren(){
        return Json.createObjectBuilder().add("error", "this request is not allowed").build().toString();
    }


    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response getUren(@PathParam("id") int id){
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
    @Path("{id}")
    @Produces("application/json")
    public Response updateUur(@PathParam("id") int id, @FormParam("uren") String gewerkteUren, @FormParam("omschrijving") String urenOmschrijving, @FormParam("datum") String datum){
        Uren replaced = Uren.updateUren(new Uren(id, gewerkteUren, datum, urenOmschrijving));
        if (replaced==null) return Response.status(Response.Status.EXPECTATION_FAILED).entity(new AbstractMap.SimpleEntry<>("error", "kon uur met id " + id + " niet updaten")).build();
        return Response.ok(Uren.getUur(id)).build();
        }
    }

