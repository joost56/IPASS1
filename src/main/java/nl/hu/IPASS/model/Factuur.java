package nl.hu.IPASS.model;

public class Factuur {
    public static Factuur deFactuur = new Factuur(123456789, "12 november 2020 ofzo");
    private int factuurNummer;
    private String factuurDatum;

    public Factuur(int factuurNummer, String factuurDatum){
        this.factuurNummer = factuurNummer;
        this.factuurDatum = factuurDatum;
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

    @Override
    public String toString() {
        return "Factuur{" +
                "factuurNummer=" + factuurNummer +
                ", factuurDatum='" + factuurDatum + '\'' +
                '}';
    }
}
