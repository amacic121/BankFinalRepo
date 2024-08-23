/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.malkier.bankarskisistem.kontroler;



import java.util.ArrayList;
import java.util.List;

import rs.malkier.bankarskisistem.db.DataBaseBroker;
import rs.malkier.bankarskisistem.exception.BankaException;
import rs.malkier.bankarskisistem.exception.RacunException;
import rs.malkier.bankarskisistem.domain.*;
import rs.malkier.bankarskisistem.exception.KlijentException;
import rs.malkier.bankarskisistem.exception.KonverzijaException;
import rs.malkier.bankarskisistem.exception.PlacanjeException;

/**
 *
 * @author Pedja
 */
public class Kontroler {

    private static Kontroler kontroler;
    DataBaseBroker dbb = new DataBaseBroker();
    private Banka banka;

    private Kontroler() {
        dbb.openConection();

    }

    public static Kontroler getInstance(){
            if(kontroler == null){
                kontroler =
                        new Kontroler();
                return kontroler;
            }
            return kontroler;
    }

    public DataBaseBroker getDbb() {
        return dbb;
    }
    
    


    public List<Racun> vratiRacune(String jmbg) throws RacunException{
        return dbb.getStanjeZaSveRacune(Long.parseLong(jmbg), Kontroler.getInstance().getBanka().getPib());
    }

    public List<Racun> vratiJedanRacun(String racun) throws RacunException {
        List<Racun> lista = new ArrayList<>();
        lista.add(dbb.getStanje(racun));
        return lista;
    }

    public ArrayList<Banka> vratiBanke() {
        return dbb.getBanks();
    }

    public void sacuvajBanku(Banka banka) throws BankaException{
       dbb.createBank(banka);
    }

    public void setBanka(Banka banka) {
        this.banka = banka;
    }

    public Banka getBanka() {
        return banka;
    }

    public boolean uplati(float iznos, Racun racun) throws PlacanjeException{

        return dbb.uplataRacuna(racun.getBrojRacuna(), iznos);
    }

    public boolean isplati(float iznos, Racun racun) throws PlacanjeException{
        if(racun.getIznos()>=iznos){
            dbb.uplataRacuna(racun.getBrojRacuna(), -iznos);
            if(racun.getIznos()==iznos) {
                throw new PlacanjeException("Uspesno skinuta sva sredstva. Racun je likvidiran.");
            }
        }else if(racun.getIznos()<iznos){
            throw  new PlacanjeException("Nema dovoljno sredstava");
        }
        return true;

    }

    public boolean konvertuj(Racun racun1, Racun racun2, float iznos) throws KonverzijaException{
        return dbb.konvertujValute(racun2.getBrojRacuna(), racun1.getBrojRacuna(), iznos);
    }

    public ArrayList<Racun> getKlijent(long JMBG, long pib) throws RacunException {
        return dbb.getKlijentByJmbgAndBank(JMBG, pib);
    }

    public List<TipRacuna> vratiTipoveRacune() {
        return dbb.getTipovi();
    }

    public void sacuvajKlijenta(Klijent klijent) throws KlijentException {
        
        dbb.createClient(klijent);

    }

    public void sacuvajRacun(Racun racun) throws RacunException {
        
        dbb.createRacun(racun);

    }
    
}
