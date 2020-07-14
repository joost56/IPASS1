package nl.hu.IPASS.model;

import java.io.Serializable;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

public class Gebruiker implements Principal, Serializable {
    private String email;
    private String wachtwoord;
    private String role;
    private static List<Gebruiker> alleGebruikers = new ArrayList<>();
    private static List<String> alleUren = new ArrayList<>();

    public Gebruiker(String email, String password) {
        this.email = email;
        this.wachtwoord = password;
        role = "gebruiker";

        if (!alleGebruikers.contains(this)) alleGebruikers.add(this);
    }

    @Override public String getName() {
        return email;
    }

    public String getEmail() {
        return email;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public String getRole() {
        return this.role;
    }

    public static List<Gebruiker> getAlleGebruikers() {
        return alleGebruikers;
    }

    public static List<String> getAlleUren() {
        return alleUren;
    }

    public void setEmail(String email) {
        if (getAccountByEmail(email) != null || email.isEmpty() || !email.contains("@")) {
            return;
        }
        this.email = email;
    }

    public Gebruiker setWachtwoord(String wachtwoord) {
        if (wachtwoord.isEmpty() || wachtwoord.length() < 8 || wachtwoord.length() > 50) {
            return null;
        }
        this.wachtwoord = wachtwoord;
        return this;
    }

    public static Gebruiker getAccountByEmail(String email) {
        return Gebruiker.getAlleGebruikers().stream()
                .filter(e -> e.email.equals(email))
                .findFirst()
                .orElse(null);
    }

    public static Gebruiker addGebruiker(String email, String wachtwoord) {
        if (getAccountByEmail(email) != null || email.isEmpty() || !email.contains("@") || wachtwoord.isEmpty() || wachtwoord.length() < 8 || wachtwoord.length() > 50 ) {
            return null;
        }

        return new Gebruiker(email, wachtwoord);
    }

    public static Gebruiker removeGebruiker(String email) {
        Gebruiker.getAlleGebruikers().removeIf(e -> e.getEmail().equals(email));
        return null;

    }

    public static String validateLogin(String email, String password) {
        Gebruiker found = getAccountByEmail(email);
        if (found != null) {
            return password.equals(found.wachtwoord) ? found.getRole() : null;
        }
        return null;
    }
}
