package nl.hu.IPASS.setup;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/rest")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages("nl.hu.IPASS.webservices, nl.hu.IPASS.security");
        register(RolesAllowedDynamicFeature.class);
        register(JacksonFeature.class);
    }
}
