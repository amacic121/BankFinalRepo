/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.malkier.bankarskisistem.domain;

/**
 *
 * @author PC
 */
public class PomocnaKlasa {
    private long jmbg;
    private String ime_prezime;
    private String adresa;
    private TipRacuna tipRacuna;

    public PomocnaKlasa() {
    }

    public PomocnaKlasa(long jmbg, String ime_prezime, String adresa, TipRacuna tipRacuna) {
        this.jmbg = jmbg;
        this.ime_prezime = ime_prezime;
        this.adresa = adresa;
        this.tipRacuna = tipRacuna;
    }

    public long getJmbg() {
        return jmbg;
    }

    public void setJmbg(long jmbg) {
        this.jmbg = jmbg;
    }

    public String getIme_prezime() {
        return ime_prezime;
    }

    public void setIme_prezime(String ime_prezime) {
        this.ime_prezime = ime_prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public TipRacuna getTipRacuna() {
        return tipRacuna;
    }

    public void setTipRacuna(TipRacuna tipRacuna) {
        this.tipRacuna = tipRacuna;
    }

    @Override
    public String toString() {
        return  tipRacuna.getIme();
    }
    
    
}
