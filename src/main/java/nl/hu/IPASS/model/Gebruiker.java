package nl.hu.IPASS.model;

public class Gebruiker {
    private String voornaam;
    private String achternaam;
    private String email;
    private int gewerkteUren;
    private String urenOmschrijving;
    private String datum;

    public Gebruiker(String voornaam, String achternaam, String email, int gewerkteUren, String urenOmschrijving, String datum){
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.email = email;
        this.gewerkteUren = gewerkteUren;
        this.urenOmschrijving = urenOmschrijving;
        this.datum = datum;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getEmail() {
        return email;
    }

    public int getGewerkteUren() {
        return gewerkteUren;
    }

    public String getUrenOmschrijving() {
        return urenOmschrijving;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGewerkteUren(int gewerkteUren) {
        this.gewerkteUren = gewerkteUren;
    }

    public void setUrenOmschrijving(String urenOmschrijving) {
        this.urenOmschrijving = urenOmschrijving;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    @Override
    public String toString() {
        return "Gebruiker{" +
                "voornaam='" + voornaam + '\'' +
                ", achternaam='" + achternaam + '\'' +
                ", email='" + email + '\'' +
                ", gewerkteUren=" + gewerkteUren +
                ", urenOmschrijving='" + urenOmschrijving + '\'' +
                '}';
    }
}

