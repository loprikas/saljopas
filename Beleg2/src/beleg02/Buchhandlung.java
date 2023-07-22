package beleg02;

import java.util.Vector;
import java.util.Random;

public class Buchhandlung extends Laeden {
    private Vector<Schriftrollen> angebot;

    public static Buchhandlung create() {
        Buchhandlung book = new Buchhandlung();
        Random ran = new Random();
        Vector<Schriftrollen> vec = new Vector<Schriftrollen>();
        book.setAngebot(vec);
        int iterate = 2 + ran.nextInt(5);
        for (int i = 0; i < iterate; i++) {
            int ring = ran.nextInt(2);
            if (ring == 0) {
                book.addAngebot(DerFluchDerSchreibfeder.create());
            } else book.addAngebot(DieAugenVonHypnos.create());
        }
        return book;
    }
    public String printAngebot(){
        String print = "";

        for (int i = 0; i < angebot.size(); i++) {
            print += ("Die Schriftrolle " + angebot.get(i).getClassname() + " kostet " + angebot.get(i).getKosten() + ". ");
        }

        return print;
    }
    public void addAngebot(Schriftrollen rolle) {
        angebot.add(rolle);
    }

    public void setAngebot(Vector<Schriftrollen> angebot) {
        this.angebot = angebot;
    }

    public Vector<Schriftrollen> getAngebot() {
        return angebot;
    }

    public void deleteAngebot(Schriftrollen rolle){
        angebot.remove(rolle);
    }


}
