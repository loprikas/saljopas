package beleg02;

import java.util.Random;

public class DieAugenVonHypnos extends Schriftrollen{
    private int kosten;
    private final String classname = "Die Augen von Hypnos";

    public static DieAugenVonHypnos create() {
        DieAugenVonHypnos hypno = new DieAugenVonHypnos();
        Random ran = new Random();
        hypno.setKosten(200 + ran.nextInt(100));
        return hypno;

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
        return("Die Augen von Hypnos wurden benutzt! Sie lähmt alle Monster im Umkreis von " + getKosten()/2 + "m!");
    }
}
