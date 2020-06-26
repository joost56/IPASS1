package nl.hu.IPASS.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Uren{
    private int gewerkteUren;
    private String urenOmschrijving;
    private String datum;
    private static List<Uren> alleUren = new ArrayList<>();

    private Uren(int gewerkteUren, String urenOmschrijving, String datum) {
        this.gewerkteUren = gewerkteUren;
        this.urenOmschrijving = urenOmschrijving;
        this.datum = datum;
        alleUren.add(this);
    }

    public static Uren createUren(int gewerkteUren, String urenOmschrijving, String datum){
        return new Uren(gewerkteUren, urenOmschrijving, datum);
    }

    public static List<Uren> getAlleUren() {
        return Collections.unmodifiableList(alleUren);
    }

    public String getDatum(){
//        LocalDate datum = LocalDate.now();
//        String datumString = datum.toString();
//        return  datumString;
        Date datum = new Date(); // your date
// Choose time zone in which you want to interpret your Date
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Amsterdam"));
        cal.setTime(datum);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) +1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return day+ "-" + month + "-" + year;
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
