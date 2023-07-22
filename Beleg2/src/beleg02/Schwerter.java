package beleg02;

import java.util.Random;

public class Schwerter extends Waffen{

    public int kosten;
    private final static String classname = "Schwert";
    private int schaden;

    public static Schwerter create() {
        Schwerter sword = new Schwerter();
        Random ran = new Random();
        sword.setKosten(90 + ran.nextInt(60));
        sword.setSchaden(sword.getKosten()/10);
        return sword;

    }

    @Override
    public String benutzen(Spieler player) {
        player.getRucksack().remove(this);
        player.addAusruestung(this);
        return("Der Spieler " + player.getName() + " schlägt mit dem dem Schwert " + player.getStaerke() + " mal und macht dabei " + (player.getStaerke()*getSchaden() + " Schaden."));
    }

    public int getKosten() {
        return kosten;
    }

    public void setKosten(int kosten) {
        this.kosten = kosten;
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
}
