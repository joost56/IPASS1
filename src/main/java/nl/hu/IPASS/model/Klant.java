package nl.hu.IPASS.model;

import java.io.Serializable;

public class Klant implements Serializable {
    private String naam;
    private int teBetalenBedrag;

    public Klant(String naam, int teBetalenBedrag){
        this.naam = naam;
        this.teBetalenBedrag = teBetalenBedrag;

    }

    public String getNaam() {
        return naam;
    }

    public int getTeBetalenBedrag() {
        return teBetalenBedrag;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setTeBetalenBedrag(int teBetalenBedrag) {
        this.teBetalenBedrag = teBetalenBedrag;
    }

}

