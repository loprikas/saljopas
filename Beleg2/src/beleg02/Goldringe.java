package beleg02;

import java.util.Random;

public class Goldringe extends Ringe {
    private int kosten;
    private final String classname = "Goldring";

    public static Goldringe create() {
        Goldringe ring = new Goldringe();
        Random ran = new Random();
        ring.setKosten(50 + ran.nextInt(51));
        return ring;

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
    public String benutzen(Spieler player) {
        int wahrscheinlichkeit = kosten/2;
        player.getRucksack().remove(this);
        player.addAusruestung(this);
       return("Der Spieler rüstet einen Goldring aus. Er hat die Wahrscheinlichkeit von " + wahrscheinlichkeit + "%, ein Monster zu zähmen!");
    }
}
