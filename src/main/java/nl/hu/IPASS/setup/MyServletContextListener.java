package nl.hu.IPASS.setup;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Applicatie is aan het opstarten!");
        System.out.println("Initialiseer hiet objecten of laad alvast data");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Applicatie gaat afsluiten");
        System.out.println("Ruim objecten op, of sla data op");
    }
}
