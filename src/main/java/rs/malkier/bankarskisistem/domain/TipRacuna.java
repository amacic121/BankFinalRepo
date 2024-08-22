package rs.malkier.bankarskisistem.domain;

import java.util.Objects;

public class TipRacuna {
    private long id;
    private String ime;


    public TipRacuna(long id, String ime) {
        this.id = id;
        this.ime = ime;
    }

    public TipRacuna() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    @Override
    public String toString() {
        return ime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipRacuna tipRacuna = (TipRacuna) o;
        return id == tipRacuna.id;
    }


}
