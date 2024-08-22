package rs.malkier.bankarskisistem.db;

//import domain.Banka;
//import domain.Klijent;
//import domain.Racun;
//import domain.TipRacuna;

import rs.malkier.bankarskisistem.domain.Klijent;
import rs.malkier.bankarskisistem.domain.*;
import rs.malkier.bankarskisistem.exception.BankaException;
import rs.malkier.bankarskisistem.exception.RacunException;

import java.sql.*;
import java.util.ArrayList;

public class DataBaseBroker {

    private static DataBaseBroker instance;
    private Connection connection;

    public static DataBaseBroker getInstance() {
        if (instance == null) {
            instance = new DataBaseBroker();
        }
        return instance;
    }

    public Connection openConection() {
        try {
            System.out.println("Uspesno otvorena konekcija");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank", "postgres", "password");

        } catch (SQLException e) {
            System.out.println("Greska prilikom otvaranja baze :(\n " + e.getMessage());
        }
        return connection;
    }

    public void closeConection() {
        try {
            connection.close();
            System.out.println("Uspesno zatvorena konekcija");
        } catch (SQLException e) {
            System.out.println("Greska prilikom zatvaranja baze :(\n " + e.getMessage());
        }
    }

    public void createBank(Banka banka) throws BankaException {
        String querry;
        try {
            querry = "INSERT INTO bank.schema_bank.banka VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(querry);
            ps.setLong(1, banka.getPib());
            ps.setString(2, banka.getNaziv());
            ps.setString(3, banka.getAdresa());
            ps.setFloat(4, banka.getKursEvro());
            ps.setFloat(5, banka.getKursDolar());
            ps.setFloat(6, banka.getKursEvroDolar());
            ps.executeUpdate();
            System.out.println("Uspesno sacuvana banka");
        } catch (SQLException e) {
            throw new BankaException("Duplirana banka");
        }

    }


    public ArrayList<Banka> getBanks() {
        ArrayList<Banka> banks = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM bank.schema_bank.banka";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {

                Banka banka = new Banka(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getFloat(5), rs.getFloat(6));
                banks.add(banka);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return banks;
    }

    public void createClient(Klijent klijent) {
        String querry;
        try {
            querry = "INSERT INTO bank.schema_bank.klijent VALUES (?,?,?)";
            PreparedStatement ps = connection.prepareStatement(querry);
            ps.setLong(3, klijent.getJmbg());
            ps.setString(1, klijent.getImePrezime());
            ps.setString(2, klijent.getAdresa());
            ps.executeUpdate();
            System.out.println("Uspesno sacuvana klijent");
        } catch (SQLException e) {
            System.out.println("Greska prilikom cuvanja klijenta\n " + e.getMessage());
        }

    }

    public ArrayList<Klijent> getClients() {
        ArrayList<Klijent> clients = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM bank.schema_bank.klijent";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {

                Klijent klijent = new Klijent();
                klijent.setJmbg(rs.getLong(3));
                klijent.setImePrezime(rs.getString(1));
                klijent.setAdresa(rs.getString(2));
                clients.add(klijent);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clients;

    }

    public void createRacun(Racun racun) {
        String querry;
        try {
            querry = "INSERT INTO bank.schema_bank.racun VALUES (?,?,?,?, ?)";
            PreparedStatement ps = connection.prepareStatement(querry);
            ps.setLong(1, racun.getTipRacuna().getId());
            ps.setLong(2, racun.getKlijent().getJmbg());
            ps.setLong(3, racun.getBanka().getPib());
            ps.setFloat(4, racun.getIznos());
            ps.setString(5, racun.getBrojRacuna());

            ps.executeUpdate();
            System.out.println("Uspesno sacuvan racun");
        } catch (SQLException e) {
            System.out.println("Greska prilikom cuvanja racuna\n " + e.getMessage());
        }

    }

    private TipRacuna getTipRacuna(long id) {
        String querry;
        try {
            querry = "SELECT * FROM bank.schema_bank.tip_racuna WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(querry);
            ps.setLong(1, id);


            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                TipRacuna tipRacuna = new TipRacuna();
                tipRacuna.setId(rs.getLong(1));
                tipRacuna.setIme(rs.getString(2));
                return tipRacuna;
            }
            System.out.println("Uspesno sacuvan racun");
        } catch (SQLException e) {
            System.out.println("Greska prilikom cuvanja racuna\n " + e.getMessage());
        }
        return null;
    }

    private Klijent getKlijent(long jmbg) {
        String querry;
        try {
            querry = "SELECT * FROM bank.schema_bank.klijent WHERE jmbg=?";
            PreparedStatement ps = connection.prepareStatement(querry);

            ps.setLong(1, jmbg);


            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Klijent klijent = new Klijent();
                klijent.setJmbg(rs.getLong(3));
                klijent.setImePrezime(rs.getString(1));
                klijent.setAdresa(rs.getString(2));
                return klijent;
            }
            System.out.println("Uspesno sacuvan racun");
        } catch (SQLException e) {
            System.out.println("Greska prilikom cuvanja racuna\n " + e.getMessage());
        }
        return null;
    }
    private List<> getKlijentByJmbgAndBank(long jmbg, Banka bank) {
        String query;
        try {
            query = "SELECT bank.schema_bank.KLIJENT.jmbg, bank.schema_bank.KLIJENT.ime_prezime,bank.schema_bank.KLIJENT.adresa FROM bank.schema_bank.KLIJENT JOIN bank.schema_bank.RACUN USING(JMBG) JOIN bank.schema_bank.BANKA USING(PIB) WHERE JMBG=? AND PIB=?;";
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setLong(1, jmbg);
            ps.setLong(2, bank.getPib());


            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Klijent klijent = new Klijent();
                klijent.setJmbg(rs.getLong(3));
                klijent.setImePrezime(rs.getString(1));
                klijent.setAdresa(rs.getString(2));
                return klijent;
            }
            System.out.println("Uspesno sacuvan racun");
        } catch (SQLException e) {
            System.out.println("Greska prilikom cuvanja racuna\n " + e.getMessage());
        }
        return null;
    }
    private Banka getBank(long pib) {
        String querry;
        try {
            querry = "SELECT * FROM bank.schema_bank.banka WHERE pib=?";
            PreparedStatement ps = connection.prepareStatement(querry);

            ps.setLong(1, pib);


            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Banka banka = new Banka();
                banka.setPib(rs.getLong(1));
                banka.setNaziv(rs.getString(2));
                banka.setAdresa(rs.getString(2));
                banka.setKursEvro(rs.getFloat(4));
                banka.setKursDolar(rs.getFloat(5));
                banka.setKursEvroDolar(rs.getFloat(6));
                return banka;
            }
            System.out.println("Uspesno sacuvan racun");
        } catch (SQLException e) {
            System.out.println("Greska prilikom cuvanja racuna\n " + e.getMessage());
        }
        return null;
    }

    public ArrayList<Racun> getRacuni() {
        ArrayList<Racun> racuni = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM bank.schema_bank.racun";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                Racun racun = new Racun();
                TipRacuna tip = getTipRacuna(rs.getLong(1));
                racun.setTipRacuna(tip);
                Klijent klijent = getKlijent(rs.getLong(2));
                racun.setKlijent(klijent);
                Banka banka = getBank(rs.getLong(3));
                racun.setBanka(banka);
                racun.setIznos(rs.getFloat(4));
                racun.setBrojRacuna(rs.getString(5));
                racuni.add(racun);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return racuni;

    }

    public boolean uplataRacuna(String brojRacuna, float iznos) {
        String querry;
        querry = "Select * from bank.schema_bank.racun where broj_racuna=?";
        try {
            PreparedStatement ps1 = connection.prepareStatement(querry);
            ps1.setString(1, brojRacuna);
            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {
                float postojeci_iznos = rs.getFloat(4);

                String querryUpdate = "Update  bank.schema_bank.racun set iznos=? where broj_racuna=?";
                PreparedStatement ps = connection.prepareStatement(querryUpdate);
                ps.setFloat(1, postojeci_iznos + iznos);
                ps.setString(2, brojRacuna);
                ps.executeUpdate();
                if (postojeci_iznos + iznos == 0) {
                    String queryDelete = "Delete from bank.schema_bank.racun where broj_racuna=?";
                    PreparedStatement ps2 = connection.prepareStatement(queryDelete);
                    ps2.setString(1, brojRacuna);
                    ps2.executeUpdate();
                    System.out.println("Racun likvidiran");
                }

            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;

    }

    public Racun getStanje(String brojRacuna) throws RacunException {
        String querry;
        querry = "Select * from bank.schema_bank.racun where broj_racuna=?";
        Racun racun = new Racun();
        try {
            PreparedStatement ps = connection.prepareStatement(querry);
            ps.setString(1, brojRacuna);
            ps.executeQuery();
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                TipRacuna tip = getTipRacuna(rs.getLong(1));
                racun.setTipRacuna(tip);
                Klijent klijent = getKlijent(rs.getLong(2));
                racun.setKlijent(klijent);
                Banka banka = getBank(rs.getLong(3));
                racun.setBanka(banka);
                racun.setIznos(rs.getFloat(4));
                racun.setBrojRacuna(rs.getString(5));
            }else{
                throw new RacunException("Ne postoji racun sa tim brojem!");
            }


        } catch (SQLException e) {
            System.out.println("Greska prilikom provere stanja \n" + e.getMessage());
        }

        return racun;

    }

    public ArrayList<Racun> getStanjeZaSveRacune(long jmbg, long pib) {
        String querry;
        querry = "Select * from bank.schema_bank.racun where jmbg=? and pib=?";
        ArrayList<Racun> racuni = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(querry);
            ps.setLong(1, jmbg);
            ps.setLong(2, pib);
            ps.executeQuery();
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Racun racun = new Racun();
                TipRacuna tip = getTipRacuna(rs.getLong(1));
                racun.setTipRacuna(tip);
                Klijent klijent = getKlijent(rs.getLong(2));
                racun.setKlijent(klijent);
                Banka banka = getBank(rs.getLong(3));
                racun.setBanka(banka);
                racun.setIznos(rs.getFloat(4));
                racun.setBrojRacuna(rs.getString(5));
                racuni.add(racun);
            }

        } catch (SQLException e) {
            System.out.println("Greska prilikom provere stanja \n" + e.getMessage());
        }

        return racuni;

    }

    public boolean konvertujValute(String racun1, String racun2, Float iznos) {
        String getRacun = "Select * from bank.schema_bank.racun where broj_racuna=?";
        try {
            PreparedStatement ps = connection.prepareStatement(getRacun);
            PreparedStatement ps2 = connection.prepareStatement(getRacun);
            ps.setString(1, racun1);
            ps2.setString(1, racun2);
            ResultSet rs1 = ps.executeQuery();
            ResultSet rs2 = ps2.executeQuery();
            if (rs1.next() && rs2.next()) {
                Racun racunSa = new Racun();
                TipRacuna tip = getTipRacuna(rs1.getLong(1));
                racunSa.setTipRacuna(tip);
                Klijent klijent = getKlijent(rs1.getLong(2));
                racunSa.setKlijent(klijent);
                Banka banka = getBank(rs1.getLong(3));
                racunSa.setBanka(banka);
                racunSa.setIznos(rs1.getFloat(4));
                racunSa.setBrojRacuna(rs1.getString(5));
                if (iznos > racunSa.getIznos()) {
                    return false;
                }
                Racun racunNa = new Racun();
                TipRacuna tipNa = getTipRacuna(rs2.getLong(1));
                racunNa.setTipRacuna(tipNa);
                Klijent klijent2 = getKlijent(rs2.getLong(2));
                racunNa.setKlijent(klijent2);
                Banka banka2 = getBank(rs2.getLong(3));
                racunNa.setBanka(banka2);
                racunNa.setIznos(rs2.getFloat(4));
                racunNa.setBrojRacuna(rs2.getString(5));
                if (banka.getPib() != banka2.getPib()) {
                    return false;
                }
                float noviIznos = racunNa.getIznos();
                switch ((int) tip.getId()) {
                    case 1:
                        if (tipNa.getId() == 2) {
                            noviIznos = iznos / banka.getKursEvro();
                        } else {
                            noviIznos = iznos / banka.getKursDolar();
                        }
                        break;
                    case 2:
                        if (tipNa.getId() == 1) {
                            noviIznos = iznos * banka.getKursEvro();
                        } else {
                            noviIznos = iznos * banka.getKursEvroDolar();

                        }
                        break;
                    case 3:
                        if (tipNa.getId() == 1) {
                            noviIznos = iznos * banka.getKursDolar();
                        } else {
                            noviIznos = iznos / banka.getKursEvroDolar();
                        }
                        break;

                }
                noviIznos = noviIznos + racunNa.getIznos();
                connection.setAutoCommit(false);
                String setIznos = "Update bank.schema_bank.racun set iznos=? where broj_racuna=?";
                PreparedStatement ps3 = connection.prepareStatement(setIznos);
                PreparedStatement ps4 = connection.prepareStatement(setIznos);
                ps3.setFloat(1, racunSa.getIznos() - iznos);
                ps3.setString(2, racunSa.getBrojRacuna());
                ps4.setFloat(1, noviIznos);
                ps4.setString(2, racunNa.getBrojRacuna());
                ps3.executeUpdate();
                ps4.executeUpdate();
                connection.commit();
                connection.setAutoCommit(true);
                if (racunSa.getIznos() + iznos == 0) {
                    String queryDelete = "Delete from bank.schema_bank.racun where broj_racuna=?";
                    PreparedStatement psDelete = connection.prepareStatement(queryDelete);
                    psDelete.setString(1, racunSa.getBrojRacuna());
                    psDelete.executeUpdate();
                    System.out.println("Racun likvidiran");
                }


            }
        } catch (SQLException e) {
            return false;

        }
        return true;
    }


}
