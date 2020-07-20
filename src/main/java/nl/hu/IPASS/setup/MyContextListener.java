package nl.hu.IPASS.setup;

import nl.hu.IPASS.model.Gebruiker;
import nl.hu.IPASS.model.Klant;
import nl.hu.IPASS.model.Uren;
import nl.hu.IPASS.persistence.PersistanceManager;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;

@WebListener
public class MyContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try{
            PersistanceManager.LadenUrenVanAzure();
            PersistanceManager.LadenKlantVanAzure();
            System.out.println("beide loaded");
            System.out.println(Uren.getAlleUren());
            System.out.println(Klant.getAlleGegevens());
        }catch (Exception e) {
            System.out.println("cannot load");
            e.printStackTrace();
        }
        System.out.println("Applicatie is aan het opstarten!");
        System.out.println("Initialiseer hiet objecten of laad alvast data");
        Gebruiker.addGebruiker("joost@hotmail.com", "hallo1234");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try{
            PersistanceManager.OpslaanUrenNaarAzure();
            PersistanceManager.OpslaanKlantNaarAzure();
            System.out.println(Uren.getAlleUren());
            System.out.println(Klant.getAlleGegevens());
            System.out.println("beide saved");
        }catch (IOException ioe) {
            System.out.println("failed to save");
            ioe.printStackTrace();
        }

        System.out.println("Applicatie gaat afsluiten");
        System.out.println("Ruim objecten op, of sla data op");
    }

}
