package nl.hu.IPASS.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Bedrijf implements Serializable {
    private String naam;
    private String adres;
    private String rekeningnummer;
    private int kvkNummer;
    private String BTWNummer;
    private static List<Bedrijf> bedrijfs = new ArrayList<>();

    public Bedrijf(String naam, String adres, String rekeningnummer, int kvkNummer, String BTWNummer){
        this.naam = naam;
        this.adres = adres;
        this.rekeningnummer = rekeningnummer;
        this.kvkNummer = kvkNummer;
        this.BTWNummer = BTWNummer;
    }

    public static Bedrijf createBedrijf(String naam, String adres, String rekeningnummer, int kvkNummer, String BTWNummer){
        Bedrijf newBedrijf = new Bedrijf(naam, adres, rekeningnummer, kvkNummer, BTWNummer);
        bedrijfs.add(newBedrijf);
        return newBedrijf;
    }

    public static List<Bedrijf> getBedrijfs() {
        return bedrijfs;
    }

    public static void setBedrijfs(List<Bedrijf> bedrijfs) {
        Bedrijf.bedrijfs = bedrijfs;
    }

    public static boolean checkBedrijf(){
        return !bedrijfs.isEmpty();
    }

    public void setRekeningnummer(String rekeningnummer) {
        this.rekeningnummer = rekeningnummer;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public String getAdres() {
        return adres;
    }

    public String getRekeningnummer() {
        return rekeningnummer;
    }

    public int getKvkNummer() {
        return kvkNummer;
    }

    public void setKvkNummer(int kvkNummer) {
        this.kvkNummer = kvkNummer;
    }

    public String getBTWNummer() {
        return BTWNummer;
    }

    public void setBTWNummer(String BTWNummer) {
        this.BTWNummer = BTWNummer;
    }

    @Override
    public String toString() {
        return "Bedrijf{" +
                "naam='" + naam + '\'' +
                ", adres='" + adres + '\'' +
                ", rekeningnummer='" + rekeningnummer + '\'' +
                ", kvkNummer=" + kvkNummer +
                ", BTWNummer='" + BTWNummer + '\'' +

                '}';
    }
}

