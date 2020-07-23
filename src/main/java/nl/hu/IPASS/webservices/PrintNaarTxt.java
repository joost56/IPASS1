package nl.hu.IPASS.webservices;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import nl.hu.IPASS.model.Bedrijf;
import nl.hu.IPASS.model.Factuur;
import nl.hu.IPASS.model.Klant;
import nl.hu.IPASS.model.Uren;
import nl.hu.IPASS.persistence.PersistanceManager;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
import java.util.List;

@Path("printen")
public class PrintNaarTxt {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Uren> alleUren(){
        return Uren.getAlleUren();
    }

    @PUT
    @Path("print")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("gebruiker")
    public Response printUren(){
        String uren = Uren.getAlleUren().toString();
        String gegevens = Klant.getAlleKlanten().toString();
        String bedrijf = Bedrijf.getBedrijfs().toString();

        try {
            File myObj = new File("factuur.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter("factuur.txt");
            myWriter.write(uren);
            myWriter.write(gegevens);
            myWriter.write(bedrijf);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return Response.ok().build();
    }
}
