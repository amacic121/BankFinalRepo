package rs.malkier.bankarskisistem.domain;

public class Klijent {

    long jmbg;
    String imePrezime;
    String adresa;


    public Klijent(long jmbg, String imePrezime, String adresa) {
        this.jmbg = jmbg;
        this.imePrezime = imePrezime;
        this.adresa = adresa;
    }

    public Klijent(){

    }


    public long getJmbg() {
        return jmbg;
    }

    public void setJmbg(long jmbg) {
        this.jmbg = jmbg;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return "domain.Klijent{" +
                "imePrezime='" + imePrezime + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Klijent klijent = (Klijent) o;
        return jmbg == klijent.jmbg;
    }

}
