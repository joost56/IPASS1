package nl.hu.IPASS.model;

import nl.hu.IPASS.persistence.PersistanceManager;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Factuur implements Serializable {
    private int factuurNummer;
    private String factuurDatum;
    private static List<Factuur> urenVanBlob = new ArrayList<>();


    public Factuur(int factuurNummer){
        this.factuurNummer = factuurNummer;
    }

    public int getFactuurNummer() {
        return factuurNummer;
    }

    public String getFactuurDatum() {
        return factuurDatum;
    }

    public void setFactuurDatum(String factuurDatum) {
        this.factuurDatum = factuurDatum;
    }

    public void setFactuurNummer(int factuurNummer) {
        this.factuurNummer = factuurNummer;
    }

    public static Factuur createNummer(int factuurNummer){
        Factuur newFactuur = new Factuur(factuurNummer);
        return newFactuur;
    }

    @Override
    public String toString() {
        return "Factuur{" +
                "factuurNummer=" + factuurNummer +
                ", factuurDatum='" + factuurDatum + '\'' +
                '}';
    }
}
