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
        @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
        public Response authenticateUserByPassword(@FormParam("username") String username, @FormParam("password") String password){
            try{
                String role = MyUser.validateLogin(username, password);
                String token = createToken(username, role);

                AbstractMap.SimpleEntry<String, String> JWT = new AbstractMap.SimpleEntry<>("JWT", token);
                return Response.ok(JWT).build();
            }
            catch (JwtException | IllegalArgumentException e){
                return Response.status(Response.Status.UNAUTHORIZED).build();
            }
        }
    }
