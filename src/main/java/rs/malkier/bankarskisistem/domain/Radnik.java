package rs.malkier.bankarskisistem.domain;

import java.util.Objects;

public class Radnik {
    private long id;
    private String imePrezime;
    private Banka banka;

    public Radnik(long id, String imePrezime, Banka banka) {
        this.id = id;
        this.imePrezime = imePrezime;
        this.banka = banka;
    }

    public Radnik() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public Banka getBanka() {
        return banka;
    }

    public void setBanka(Banka banka) {
        this.banka = banka;
    }

    @Override
    public String toString() {
        return "Radnik{" +
                "imePrezime='" + imePrezime + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Radnik radnik = (Radnik) o;
        return id == radnik.id;
    }


}
