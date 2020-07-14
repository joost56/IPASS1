package nl.hu.IPASS.model;

import java.io.Serializable;

public class Bedrijf implements Serializable {
    private String naam;
    private String adres;
    private String rekeningnummer;
    private int tariefPerUur;
    private int kvkNummer;
    private String BTWNummer;
    private int bedragExclusiefBTW;
    private int bedragInclusiefBTW;

    public Bedrijf(String naam, String adres, String rekeningnummer, int tariefPerUur, int kvkNummer, String BTWNummer, int bedragExclusiefBTW, int bedragInclusiefBTW){
        this.naam = naam;
        this.adres = adres;
        this.rekeningnummer = rekeningnummer;
        this.tariefPerUur = tariefPerUur;
        this.kvkNummer = kvkNummer;
        this.BTWNummer = BTWNummer;
        this.bedragExclusiefBTW = bedragExclusiefBTW;
        this.bedragInclusiefBTW = bedragInclusiefBTW;
    }

    public void setTariefPerUur(int tariefPerUur) {
        this.tariefPerUur = tariefPerUur;
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

    public int getTariefPerUur() {
        return tariefPerUur;
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

    public int getBedragExclusiefBTW() {
        return bedragExclusiefBTW;
    }

    public int getBedragInclusiefBTW() {
        return bedragInclusiefBTW;
    }

    public void setBedragExclusiefBTW(int bedragExclusiefBTW) {
        this.bedragExclusiefBTW = bedragExclusiefBTW;
    }

    public void setBedragInclusiefBTW(int bedragInclusiefBTW) {
        this.bedragInclusiefBTW = bedragInclusiefBTW;
    }

    @Override
    public String toString() {
        return "Bedrijf{" +
                "naam='" + naam + '\'' +
                ", adres='" + adres + '\'' +
                ", rekeningnummer='" + rekeningnummer + '\'' +
                ", tariefPerUur=" + tariefPerUur +
                ", kvkNummer=" + kvkNummer +
                ", BTWNummer='" + BTWNummer + '\'' +
                ", bedragExclusiefBTW=" + bedragExclusiefBTW +
                ", bedragInclusiefBTW=" + bedragInclusiefBTW +
                '}';
    }
}

