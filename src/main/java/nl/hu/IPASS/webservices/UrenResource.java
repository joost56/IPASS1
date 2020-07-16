package nl.hu.IPASS.webservices;

import nl.hu.IPASS.model.Uren;

import javax.annotation.security.RolesAllowed;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.FileWriter;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.List;

@Path("uren")
public class UrenResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Uren> getUren(){
        return Uren.getAlleUren();
    }

    @POST
    @Path("toevoegen")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("gebruiker")
    public Response createUren(@FormParam("uren") int ur, @FormParam("omschrijving") String om, @FormParam("datum") String datum, @FormParam("id") int id){
        if(ur <= 0) {return Response.status(Response.Status.CONFLICT).entity(new AbstractMap.SimpleEntry<>("error", "Uren mag niet kleiner of gelijk aan 0 zijn!")).build();}
        if(om.trim().equals("")) {return Response.status(Response.Status.CONFLICT).entity(new AbstractMap.SimpleEntry<>("error", "Omschrijving mag niet leeg zijn!")).build();}
        while (Uren.getAlleUren().contains(id)){id = ++id;}
        Uren nieuweUren = Uren.createUren(ur, om, datum);



//        try {
//            FileWriter myWriter = new FileWriter("Factuur.txt");
//            myWriter.write(ur);
//            myWriter.close();
//            System.out.println("Successfully wrote to the file.");
//        } catch (IOException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }

        return Response.ok(nieuweUren).build();
    }
}
