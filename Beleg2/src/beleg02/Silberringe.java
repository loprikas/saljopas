package beleg02;

import java.util.Random;

public class Silberringe extends Ringe{

    private int kosten;
    private final String classname = "Silberring";

    public static Silberringe create() {
        Silberringe ring = new Silberringe();
        Random ran = new Random();
        ring.setKosten(10 + ran.nextInt(30));
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
        int bonus = kosten/4;
        player.setStaerke(player.getStaerke() + bonus);
        player.getRucksack().remove(this);
        player.addAusruestung(this);
        return("Der Spieler rüstet einen Silberring aus. Er erhoeht die Kampfstaerke von " + player.getName() + " um " + bonus + " auf " + player.getStaerke() + "!");
    }
}
