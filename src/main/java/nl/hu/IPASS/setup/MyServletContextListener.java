package nl.hu.IPASS.setup;

import nl.hu.IPASS.model.Uren;
import nl.hu.IPASS.model.Gebruiker;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Applicatie is aan het opstarten!");
        System.out.println("Initialiseer hiet objecten of laad alvast data");
        Uren.createUren(12, "dit en dat gedaan", "26-6-2020");
        Uren.createUren(34, "dit gedaan", "27-6-2020");
        Gebruiker.addGebruiker("joost@hotmail.com", "hallo1234");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Applicatie gaat afsluiten");
        System.out.println("Ruim objecten op, of sla data op");
    }
}
