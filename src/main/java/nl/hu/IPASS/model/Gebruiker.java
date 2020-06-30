package nl.hu.IPASS.model;

import java.util.*;

public class Gebruiker {
    private String voornaam;
    private String achternaam;
    private String email;
    private String datum;
    private static List<Gebruiker> alleGebruikers = new ArrayList<>();
    private static List<String> alleUren = new ArrayList<>();

    private Gebruiker(String voornaam, String achternaam
//            , int gewerkteUren, String urenOmschrijving
    ){
        this.voornaam = voornaam;
        this.achternaam = achternaam;
//        this.gewerkteUren = gewerkteUren;
//        this.urenOmschrijving = urenOmschrijving;
//        alleUren.add(gewerkteUren, urenOmschrijving);
    }

    public static Gebruiker createGebruiker(String voornaam, String achternaam
//            , int gewerkteUren, String urenOmschrijving

    ) {
        if (alleGebruikers.stream().noneMatch(e -> e.getVoornaam().equals(voornaam))) {
            return new Gebruiker(voornaam, achternaam
//                    , gewerkteUren, urenOmschrijving
            );
        }
        return null;
    }

//    private void String(int gewerkteUren, String urenOmschrijving){
//        this.gewerkteUren = gewerkteUren;
//        this.urenOmschrijving = urenOmschrijving;
//        alleUren.add(this);
//    }
//    public static Gebruiker createUren(int gewerkteUren, String urenOmschrijving){
//        alleUren.add(gewerkteUren, urenOmschrijving);
//        return null;
//    }

//    public static List<String> getAlleUren() {
//        return Collections.unmodifiableList(alleUren);
//    }

    public static List<Gebruiker> getAlleGebruikers(){
        return Collections.unmodifiableList(alleGebruikers);
    }

    public String getVoornaam() {
        return voornaam;
    }

//    public int getGewerkteUren() {
//        return gewerkteUren;
//    }
//
//    public String getUrenOmschrijving() {
//        return urenOmschrijving;
//    }

}

