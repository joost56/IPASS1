package nl.hu.IPASS.security;

import nl.hu.IPASS.model.Gebruiker;

import java.security.Principal;
import javax.ws.rs.core.SecurityContext;

public class MySecurityContext implements SecurityContext {
    private Gebruiker user;
    private String scheme;

    public MySecurityContext(Gebruiker user, String scheme){
        this.user = user;
        this.scheme = scheme;
    }

    @Override
    public Principal getUserPrincipal() {
        return this.user;
    }

    @Override
    public boolean isUserInRole(String rol) {
        if (user.getRole()!=null){
            return rol.equals(user.getRole());
        }
        return false;
    }

    @Override
    public boolean isSecure() {
        return "https".equals(this.scheme);
    }

    @Override
    public String getAuthenticationScheme() {
        return SecurityContext.BASIC_AUTH;
    }
}
