package beleg02;


import java.util.Random;
import java.util.Vector;

public class Schmiede extends Laeden{
    private Vector<Waffen> angebot;

    public static Schmiede create() {
        Schmiede smith = new Schmiede();
        Random ran = new Random();
        Vector<Waffen> vec = new Vector<Waffen>();
        smith.setAngebot(vec);
        int iterate = 5 + ran.nextInt(5);
        for (int i = 0; i < iterate; i++) {
            int ring = ran.nextInt(2);
            if (ring == 0){
                smith.addAngebot(Schwerter.create());
            }
            else smith.addAngebot(Boegen.create());
        }
        return smith;
    }

    public Vector<Waffen> getAngebot() {
        return angebot;
    }

    public String printAngebot(){
        String print = "";

            for (int i = 0; i < angebot.size(); i++) {
                print += ("Die Waffe " + angebot.get(i).getClassname() + " kostet " + angebot.get(i).getKosten() + ". ");
            }

        return print;
    }

    public void addAngebot(Waffen waffe) {
        angebot.add(waffe);
    }

    public void setAngebot(Vector<Waffen> angebot) {
        this.angebot = angebot;
    }

    public void deleteAngebot(Waffen waffe){
        angebot.remove(waffe);
    }




}
