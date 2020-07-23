package nl.hu.IPASS.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Klant implements Serializable {
    private String bedrijfsnaam;
    private String bedrijfsadres;
    private String bedrijfspostcode;
    private String contactpersoon;
    private int tarief;
    private static List<Klant> alleKlanten = new ArrayList<>();
    private static List<String> alleKlantNamen = new ArrayList<>();

    public Klant(String bedrijfsnaam, String bedrijfsadres, String bedrijfspostcode, String contactpersoon, int tarief) {
        this.bedrijfsnaam = bedrijfsnaam;
        this.bedrijfsadres = bedrijfsadres;
        this.bedrijfspostcode = bedrijfspostcode;
        this.contactpersoon = contactpersoon;
        this.tarief = tarief;

    }

    public static Klant createKlant(String bedrijfsnaam, String bedrijfsadres, String bedrijfspostcode, String contactpersoon, int tarief){
        Klant newKlant = new Klant(bedrijfsnaam, bedrijfsadres, bedrijfspostcode, contactpersoon, tarief);
        alleKlanten.add(newKlant);
        alleKlantNamen.add(bedrijfsnaam);
        return newKlant;
    }

    public static List<Klant> getAlleKlanten() {
        return alleKlanten;
    }

    public static List<String> getAlleKlantNamen(){
        return alleKlantNamen;
    }

    public static void setAlleGegevens(List<Klant> alleKlanten) {
        Klant.alleKlanten = alleKlanten;
    }

    public String getBedrijfsnaam() {
        return bedrijfsnaam;
    }

    public void setBedrijfsnaam(String bedrijfsnaam) {
        this.bedrijfsnaam= bedrijfsnaam;
    }

    public String getBedrijfsadres() {
        return bedrijfsadres;
    }

    public void setBedrijfsadres(String bedrijfsadres) {
        this.bedrijfsadres = bedrijfsadres;
    }

    public String getBedrijfspostcode() {
        return bedrijfspostcode;
    }

    public void setBedrijfspostcode(String bedrijfspostcode) {
        this.bedrijfspostcode = bedrijfspostcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Klant klant = (Klant) o;
        return tarief == klant.tarief &&
                bedrijfsnaam.equals(klant.bedrijfsnaam) &&
                bedrijfsadres.equals(klant.bedrijfsadres) &&
                bedrijfspostcode.equals(klant.bedrijfspostcode) &&
                contactpersoon.equals(klant.contactpersoon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bedrijfsnaam, bedrijfsadres, bedrijfspostcode, contactpersoon, tarief);
    }
}

