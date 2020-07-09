package nl.hu.IPASS.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Uren implements Serializable {
    private String gewerkteUren;
    private String urenOmschrijving;
    private String datum;
    private int id;
    private static int numUren = 0;
    private static List<Uren> alleUren = new ArrayList<>();
    private static HashMap<String, String> Hashalleuren = new HashMap<String, String>();

    private Uren(String gewerkteUren, String urenOmschrijving, String datum){
        this.gewerkteUren = gewerkteUren;
        this.urenOmschrijving = urenOmschrijving;
        this.datum = datum;
        id = ++numUren;
    }


    public Uren(int id, String gewerkteUren, String urenOmschrijving, String datum) {
        this.id = id;
        this.gewerkteUren = gewerkteUren;
        this.urenOmschrijving = urenOmschrijving;
        this.datum = datum;
    }

    public static Uren getUur(int id){
        return alleUren.stream().filter(e->e.id==id).findFirst().orElse(null);
    }

    public static Uren createUren(String gewerkteUren, String urenOmschrijving, String datum){
        Uren newUur = new Uren(gewerkteUren, urenOmschrijving, datum);
        alleUren.add(newUur);
        return newUur;
    }

    public static Uren updateUrenGewerkteUren(int id, String gewerkteUren, String urenOmschrijving, String datum){
        Uren found = Uren.getUur(id);
        if (found!=null){
            found.setGewerkteUren(gewerkteUren);
            found.setUrenOmschrijving(urenOmschrijving != null ? urenOmschrijving : "");
        }
        return found;
    }
    public static Uren updateUren(Uren newUren){
        return alleUren.set(alleUren.indexOf(Uren.getUur(newUren.getId())), newUren);
    }

    public static boolean removeUur(int id){
        if (id>0) return alleUren.remove(alleUren.indexOf(Uren.getUur(id)))!=null;
        return false;
    }

    public static HashMap<String, String> getHashalleuren() {
        return Hashalleuren;
    }

    public static List<Uren> getAlleUren() {
        return alleUren;
    }

    public int getId() {
        return id;
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

    public String getGewerkteUren() {
        return gewerkteUren;
    }

    public String getUrenOmschrijving() {
        return urenOmschrijving;
    }

    public void setGewerkteUren(String gewerkteUren) {
        this.gewerkteUren = gewerkteUren;
    }

    public static void setUren(int id, String gewerkteUren, String urenOmschrijving, String datum){
        new Uren(id ,gewerkteUren, urenOmschrijving, datum);
    }

    public void setUrenOmschrijving(String urenOmschrijving) {
        this.urenOmschrijving = urenOmschrijving;
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
