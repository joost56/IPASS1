package nl.hu.IPASS.security;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.Key;
import java.util.AbstractMap;
import java.util.Calendar;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import nl.hu.IPASS.model.Gebruiker;

import javax.ws.rs.Path;

    @Path("/authentication")
    public class AuthenticationResource {
        final static public Key key = MacProvider.generateKey();

        private String createToken(String username, String role) throws JwtException {
            Calendar expiration = Calendar.getInstance();
            expiration.add(Calendar.MINUTE, 30);

            return Jwts.builder()
                    .setSubject(username)
                    .setExpiration(expiration.getTime())
                    .claim("role", role)
                    .signWith(SignatureAlgorithm.HS512, key)
                    .compact();
        }

        @POST
        @Produces(MediaType.APPLICATION_JSON)
        public Response authenticateUserByPassword(@FormParam("email") String emailadres, @FormParam("password") String password) {
            try{
                if(emailadres.trim().equals("") || password.trim().equals("")) {
                    return Response.status(Response.Status.CONFLICT).entity(new AbstractMap.SimpleEntry<>("error", "De velden mogen niet leeg zijn!")).build();
                }

                if(!emailadres.contains("@")) {
                    return Response.status(Response.Status.CONFLICT).entity(new AbstractMap.SimpleEntry<>("error", "Het emailadres moet een @ bevatten!")).build();
                }

                Gebruiker gebruikerBijEmail = Gebruiker.getAlleGebruikers().stream().filter(gebruiker -> gebruiker.getEmail().equals(emailadres) && gebruiker.getWachtwoord().equals(password)).findFirst().orElse(null);

                if(gebruikerBijEmail == null) {
                    return Response.status(Response.Status.CONFLICT).entity(new AbstractMap.SimpleEntry<>("error", "Het emailadres of wachtwoord is onjuist!")).build();
                }

                String role = Gebruiker.validateLogin(emailadres, password);
                String token = createToken(emailadres, role);

                AbstractMap.SimpleEntry<String, String> JWT = new AbstractMap.SimpleEntry<>("JWT", token);
                return Response.ok(JWT).build();

            }
            catch (JwtException | IllegalArgumentException e){
                return Response.status(Response.Status.UNAUTHORIZED).build();
            }
        }
    }
