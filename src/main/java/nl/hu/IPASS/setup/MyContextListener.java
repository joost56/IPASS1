package nl.hu.IPASS.setup;

import nl.hu.IPASS.Persistance.PersistanceManager;

import javax.imageio.IIOException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;

@WebListener
public class MyContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try{
            PersistanceManager.loadUrenAzure();
            System.out.println("uren loaded");
        }catch (Exception e) {
            System.out.println("cannot load uren");
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try{
            PersistanceManager.saveUrenToAzure();
            System.out.println("uren saved");
        }catch (IOException ioe) {
            System.out.println("failed to save uren");
            ioe.printStackTrace();
        }
    }

}
