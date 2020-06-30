package nl.hu.IPASS.Persistance;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import nl.hu.IPASS.model.Uren;

import java.io.*;

public class PersistanceManager {
    private final static String ENDPOINT = "https://factuuripass.blob.core.windows.net/";
    private final static String SASTOKEN = "?sv=2019-10-10&ss=bfqt&srt=sco&sp=rwdlacupx&se=2020-09-25T19:39:17Z&st=2020-06-29T11:39:17Z&spr=https&sig=HN%2FfOY9I7LKsbBeoFUNtwhzro%2B4G%2Bekwv0tPpGjK3tY%3D";
    private final static String CONTAINER = "factuurconstainer";

    private static BlobContainerClient blobContainer = new BlobContainerClientBuilder()
                                                            .endpoint(ENDPOINT)
                                                            .sasToken(SASTOKEN)
                                                            .containerName(CONTAINER)
                                                            .buildClient();
    public static void saveUrenToAzure() throws IOException {
        if (!blobContainer.exists()) {
            blobContainer.create();
        }
        BlobClient blob = blobContainer.getBlobClient("uren_blob");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(Uren.getAlleUren());

        byte[] bytes = baos.toByteArray();
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        blob.upload(bais, bytes.length, true);

        oos.close();
        bais.close();
    }

    public static void loadUrenAzure() throws ClassNotFoundException, IOException{
         if(blobContainer.exists()){
             BlobClient blob = blobContainer.getBlobClient("uren_blob");
             if (blob.exists()){
                 ByteArrayOutputStream baos = new ByteArrayOutputStream();
                 blob.download(baos);
                 byte[] bytes = baos.toByteArray();
                 ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
                 ObjectInputStream ois = new ObjectInputStream(bais);

                 Object obj = ois.readObject();
                 if (obj instanceof Uren){
                     Uren loadedUren = (Uren)obj;
                     Uren loadedOmschrijving = (Uren)obj;
                     Uren loadedDatum = (Uren)obj;
                     Uren loadedId = (Uren)obj;
                     Uren.setUren(loadedUren.getId(), loadedUren.getGewerkteUren(), loadedOmschrijving.getUrenOmschrijving(), loadedDatum.getDatum());
                 }
                 bais.close();
                 ois.close();
             }
         }
    }
}

