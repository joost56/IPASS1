package nl.hu.IPASS.persistence;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import nl.hu.IPASS.model.Klant;
import nl.hu.IPASS.model.Uren;

import java.io.*;
import java.util.List;

public class PersistanceManager {
    private final static String ENDPOINT = "https://factuuripass.blob.core.windows.net/";
    private final static String SASTOKEN = "?sv=2019-10-10&ss=bfqt&srt=co&sp=rwdlacupx&se=2020-12-16T19:20:20Z&st=2020-07-16T10:20:20Z&spr=https&sig=fHwQL47ZVKwToDDBTeay8pKrAVoYkJ5yEDe9xRiW3m0%3D";
    private final static String CONTAINER = "factuurcontainer";

    private static BlobContainerClient blobContainer = new BlobContainerClientBuilder()
            .endpoint(ENDPOINT)
            .sasToken(SASTOKEN)
            .containerName(CONTAINER)
            .buildClient();

    public static void OpslaanUrenNaarAzure() throws IOException {
        BlobClient uren_blob = blobContainer.getBlobClient("uren_blob");
        List<Uren> opslaanUren = Uren.getAlleUren();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(opslaanUren);

        byte[] bytez = baos.toByteArray();
        ByteArrayInputStream bais = new ByteArrayInputStream(bytez);
        uren_blob.upload(bais, bytez.length, true);

        oos.close();
        bais.close();
        baos.close();
    }

    public static void LadenUrenVanAzure() throws IOException, ClassNotFoundException {
        if (blobContainer.exists()) {
            BlobClient uren_blob = blobContainer.getBlobClient("uren_blob");

            if (uren_blob.exists()) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                uren_blob.download(baos);

                ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
                ObjectInputStream ois = new ObjectInputStream(bais);

                List<Uren> uren = (List<Uren>) ois.readObject();
                Uren.setAlleUren(uren);
            }
        }
    }

    public static void OpslaanKlantNaarAzure() throws IOException {
        BlobClient klant_blob = blobContainer.getBlobClient("klant_blob");
        List<Klant> opslaanKlant = Klant.getAlleGegevens();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(opslaanKlant);

        byte[] bytez = baos.toByteArray();
        ByteArrayInputStream bais = new ByteArrayInputStream(bytez);
        klant_blob.upload(bais, bytez.length, true);

        oos.close();
        bais.close();
        baos.close();
    }

    public static void LadenKlantVanAzure() throws IOException, ClassNotFoundException {
        if (blobContainer.exists()) {
            BlobClient klant_blob = blobContainer.getBlobClient("klant_blob");

            if (klant_blob.exists()) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                klant_blob.download(baos);

                ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
                ObjectInputStream ois = new ObjectInputStream(bais);

                List<Klant> klant = (List<Klant>) ois.readObject();
                Klant.setAlleGegevens(klant);
            }
        }
    }
}
