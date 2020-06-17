package nl.hu.IPASS.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Gebruiker {
    private String voornaam;
    private String achternaam;
//    private String email;
    private String gewerkteUren;
    private String urenOmschrijving;
//    private String datum;
    private static List<Gebruiker> alleGebruikers = new ArrayList<>();
    public static List<String> alleUren = new ArrayList<>();

    public Gebruiker(String voornaam, String achternaam, String gewerkteUren, String urenOmschrijving){
//            , String email, String gewerkteUren, String urenOmschrijving, String datum){
        this.voornaam = voornaam;
        this.achternaam = achternaam;
//        this.email = email;
//        this.gewerkteUren = gewerkteUren;
//        this.urenOmschrijving = urenOmschrijving;
//        this.datum = datum;
        alleGebruikers.add(this);
        alleUren.add(gewerkteUren);
        alleUren.add(urenOmschrijving);
    }

//    public Gebruiker(int gewerkteUren, String urenOmschrijving){
//        this.gewerkteUren = gewerkteUren;
//        this.urenOmschrijving = urenOmschrijving;
//        alleUren.add(this);
//    }

    public static Gebruiker createGebruiker(String voornaam, String achternaam, String gewerkteUren, String urenOmschrijving){
//            String email, String gewerkteUren, String urenOmschrijving, String datum) {
        if (alleGebruikers.stream().noneMatch(e -> e.getVoornaam().equals(voornaam))) {
            return new Gebruiker(voornaam, achternaam, gewerkteUren, urenOmschrijving);
//                    , achternaam, email, gewerkteUren, urenOmschrijving, datum);
        }
        return null;
    }

    public static List<String> getAlleUren() {
        return Collections.unmodifiableList(alleUren);
    }

    public static List<Gebruiker> getAlleGebruikers(){
        return alleGebruikers;
    }

//    public String getAchternaam() {
//        return achternaam;
//    }

    public String getVoornaam() {
        return voornaam;
    }

//    public String getEmail() {
//        return email;
//    }

//    public String getGewerkteUren() {
//        return gewerkteUren;
//    }

//    public String getUrenOmschrijving() {
//        return urenOmschrijving;
//    }

//    public void setAchternaam(String achternaam) {
//        this.achternaam = achternaam;
//    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

//    public void setEmail(String email) {
//        this.email = email;
//    }

//    public void setGewerkteUren(String gewerkteUren) {
//        this.gewerkteUren = gewerkteUren;
//    }

//    public void setUrenOmschrijving(String urenOmschrijving) {
//        this.urenOmschrijving = urenOmschrijving;
//    }

//    public String getDatum() {
//        return datum;
//    }

//    public void setDatum(String datum) {
//        this.datum = datum;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gebruiker gebruiker = (Gebruiker) o;
        return voornaam.equals(gebruiker.voornaam)&&
//        gewerkteUren == gebruiker.gewerkteUren &&
//                voornaam.equals(gebruiker.voornaam) &&
                achternaam.equals(gebruiker.achternaam);
//                email.equals(gebruiker.email) &&
//                urenOmschrijving.equals(gebruiker.urenOmschrijving) &&
//                datum.equals(gebruiker.datum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(voornaam, achternaam);
//                , achternaam, email, gewerkteUren, urenOmschrijving, datum);
    }
}

