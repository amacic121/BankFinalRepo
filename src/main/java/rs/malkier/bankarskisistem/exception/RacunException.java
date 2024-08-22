package rs.malkier.bankarskisistem.exception;

/**
 *
 
@author Marija*/
public class RacunException extends Exception{
    String greska;

    public RacunException() {
    }

    public RacunException(String greska) {
        this.greska = greska;
    }

    public String getGreska() {
        return greska;
    }

    public void setGreska(String greska) {
        this.greska = greska;
    }





}