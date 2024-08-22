package rs.malkier.bankarskisistem.domain;

import java.util.Objects;

public class Racun {
    private TipRacuna tipRacuna;
    private Klijent klijent;
    private Banka banka;
    private float iznos;
    private String brojRacuna;

    public Racun() {
    }

    public Racun(TipRacuna tipRacuna, Klijent klijent, Banka banka, float iznos, String brojRacuna) {
        this.tipRacuna = tipRacuna;
        this.klijent = klijent;
        this.banka = banka;
        this.iznos = iznos;
        this.brojRacuna = brojRacuna;
    }

    public TipRacuna getTipRacuna() {
        return tipRacuna;
    }

    public void setTipRacuna(TipRacuna tipRacuna) {
        this.tipRacuna = tipRacuna;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public Banka getBanka() {
        return banka;
    }

    public void setBanka(Banka banka) {
        this.banka = banka;
    }

    public float getIznos() {
        return iznos;
    }

    public void setIznos(float iznos) {
        this.iznos = iznos;
    }

    public String getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(String brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.klijent);
        hash = 71 * hash + Objects.hashCode(this.banka);
        hash = 71 * hash + Objects.hashCode(this.brojRacuna);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Racun other = (Racun) obj;
        if (!Objects.equals(this.brojRacuna, other.brojRacuna)) {
            return false;
        }
        if (!Objects.equals(this.klijent, other.klijent)) {
            return false;
        }
        return Objects.equals(this.banka, other.banka);
    }

    @Override
    public String toString() {
        return brojRacuna + "["+tipRacuna+"]";
    }


}