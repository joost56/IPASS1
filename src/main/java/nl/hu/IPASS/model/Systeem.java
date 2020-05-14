package nl.hu.IPASS.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Systeem {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String datum = (formatter.format(date));
        Gebruiker gebruiker = new Gebruiker("John", "Buiting", "joost.buiting@gmail.com", 10, "blah", "blah");
        Bedrijf bedrijf = new Bedrijf("consultancybureau", "vestiging", "12345EL1243", 30, 123456789, "NL123456789B54", 10, 20);
        Factuur factuur = new Factuur(12, datum);

        System.out.println(gebruiker);
        System.out.println(bedrijf);
        System.out.println(factuur);
    }
}

