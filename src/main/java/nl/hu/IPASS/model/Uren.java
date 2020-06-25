package nl.hu.IPASS.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Uren{
    private int gewerkteUren;
    private String urenOmschrijving;
    private static List<Uren> alleUren = new ArrayList<>();

    private Uren(int gewerkteUren, String urenOmschrijving) {
        this.gewerkteUren = gewerkteUren;
        this.urenOmschrijving = urenOmschrijving;
        alleUren.add(this);
    }

    public static Uren createUren(int gewerkteUren, String urenOmschrijving){
        return new Uren(gewerkteUren, urenOmschrijving);
    }

    public static List<Uren> getAlleUren() {
        return Collections.unmodifiableList(alleUren);
    }

    public int getGewerkteUren() {
        return gewerkteUren;
    }

    public String getUrenOmschrijving() {
        return urenOmschrijving;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Uren uren = (Uren) o;
        return gewerkteUren == uren.gewerkteUren &&
                urenOmschrijving.equals(uren.urenOmschrijving);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gewerkteUren, urenOmschrijving);
    }
}
