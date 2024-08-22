package rs.malkier.bankarskisistem.domain;

public class Banka {

    private long pib;
    private String naziv;
    private String adresa;
    private float kursEvro;
    private float kursDolar;
    private float kursEvroDolar;

    public Banka() {
    }

    public Banka(long pib, String naziv, String adresa, float kursEvro, float kursDolar, float kursEvroDolar) {
        this.pib = pib;
        this.naziv = naziv;
        this.adresa = adresa;
        this.kursEvro = kursEvro;
        this.kursDolar = kursDolar;
        this.kursEvroDolar = kursEvroDolar;

    }

    public long getPib() {
        return pib;
    }

    public void setPib(long pib) {
        this.pib = pib;
    }

    public float getKursEvroDolar() {
        return kursEvroDolar;
    }

    public void setKursEvroDolar(float kursEvroDolar) {
        this.kursEvroDolar = kursEvroDolar;
    }

    public float getKursDolar() {
        return kursDolar;
    }

    public void setKursDolar(float kursDolar) {
        this.kursDolar = kursDolar;
    }

    public float getKursEvro() {
        return kursEvro;
    }

    public void setKursEvro(float kursEvro) {
        this.kursEvro = kursEvro;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Banka banka = (Banka) o;
        return pib == banka.pib;
    }


}
