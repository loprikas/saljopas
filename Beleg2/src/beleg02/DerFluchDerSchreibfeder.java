package beleg02;

import java.util.Random;

public class DerFluchDerSchreibfeder extends Schriftrollen {
    private int kosten;
    private final String classname = "Der Fluch der Schreibfeder";

    public static DerFluchDerSchreibfeder create() {
        DerFluchDerSchreibfeder fluch = new DerFluchDerSchreibfeder();
        Random ran = new Random();
        fluch.setKosten(200 + ran.nextInt(100));
        return fluch;
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
        player.getRucksack().remove(this);
        player.addAusruestung(this);
        return("Der Fluch der Schreibfeder wurde benutzt! Er zerstört alle Schwerter im Umkreis von " + getKosten()/4 + "m!");
    }
}
