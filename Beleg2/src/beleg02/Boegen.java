package beleg02;

import java.util.Random;

public class Boegen extends Waffen{

    private int kosten;
    private int schaden;


    private final String classname = "Bogen";

    public static Boegen create() {
        Boegen bow = new Boegen();
        Random ran = new Random();
        bow.setKosten(90 + ran.nextInt(60));
        bow.setSchaden(bow.getKosten()/10);
        return bow;

    }

    @Override
    public String benutzen(Spieler player) {
        player.getRucksack().remove(this);
        player.addAusruestung(this);
       return("Der Spieler " + player.getName() + " schießt den Bogen " + player.getStaerke() + " mal und macht dabei " + (player.getStaerke()*getSchaden() + " Schaden."));
    }

    @Override
    public String getClassname() {
        return classname;
    }
    @Override
    public int getSchaden() {
        return schaden;
    }

    public void setSchaden(int schaden) {
        this.schaden = schaden;
    }

    public void setKosten(int kosten){
        this.kosten = kosten;
    }

    public int getKosten(){
        return kosten;
    }

    }

