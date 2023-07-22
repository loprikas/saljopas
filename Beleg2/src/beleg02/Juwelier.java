package beleg02;

import java.util.*;

public class Juwelier extends Laeden {
    private Vector<Ringe> angebot;

    public static Juwelier create() {
        Juwelier juw = new Juwelier();
        Random ran = new Random();
        Vector<Ringe> vec = new Vector<Ringe>();
        juw.setAngebot(vec);
        int iterate = 5 + ran.nextInt(5);
        for (int i = 0; i < iterate; i++) {
            int ring = ran.nextInt(2);
            if (ring == 0){
                juw.addAngebot(Goldringe.create());
            }
            else juw.addAngebot(Silberringe.create());
        }
        return juw;
    }

    public String printAngebot(){
        String print = "";

        for (int i = 0; i < angebot.size(); i++) {
            print += ("Der " + angebot.get(i).getClassname() + " kostet " + angebot.get(i).getKosten() + ". ");
        }

        return print;
    }
    public Vector<Ringe> getAngebot() {
        return angebot;
    }

    public void addAngebot(Ringe ring) {
        angebot.add(ring);
    }

    public void setAngebot(Vector<Ringe> angebot) {
        this.angebot = angebot;
    }

    public void deleteAngebot(Ringe ring){
        angebot.remove(ring);
    }





}
