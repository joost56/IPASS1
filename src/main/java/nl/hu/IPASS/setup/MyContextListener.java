package nl.hu.IPASS.setup;

import nl.hu.IPASS.model.Gebruiker;
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
            System.out.println("uren loaded");
            System.out.println(Uren.getAlleUren());
        }catch (Exception e) {
            System.out.println("cannot load uren");
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
            System.out.println(Uren.getAlleUren());
            System.out.println("uren saved");
        }catch (IOException ioe) {
            System.out.println("failed to save uren");
            ioe.printStackTrace();
        }

        System.out.println("Applicatie gaat afsluiten");
        System.out.println("Ruim objecten op, of sla data op");
    }

}
