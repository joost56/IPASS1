package nl.hu.IPASS.setup;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/rest")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() { packages("nl.hu.IPASS.webservices");}
}
