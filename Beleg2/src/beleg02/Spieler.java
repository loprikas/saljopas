package beleg02;
import java.util.Random;

import java.util.Vector;


public class Spieler {
    private int staerke;
    private String name;
    private int gold = 1000;
    Vector<Gegenstaende> ausruestung;

    private Vector<Gegenstaende> rucksack;

    public static Spieler create(String name){
        Random ran = new Random();
        Spieler player = new Spieler();
        Vector<Gegenstaende> backpack = new Vector<Gegenstaende>();
        Vector<Gegenstaende> ausruestung = new Vector<Gegenstaende>();
        player.setAusruestung(ausruestung);
        player.setRucksack(backpack);
        player.setName(name);
        player.setStaerke(1 + ran.nextInt(2));
        return player;
    }

    public void setRucksack(Vector<Gegenstaende> rucksack) {
        this.rucksack = rucksack;
    }
        public Vector<Gegenstaende> getRucksack() {
        return rucksack;
    }

    public int isBest(Gegenstaende item){
        if (isEqual(item)){
            for (int i = 0; i < ausruestung.size(); i++) {
                if (item.getClassname() == ausruestung.get(i).getClassname() && ausruestung.get(i).getKosten() < item.getKosten()) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean isEqual(Gegenstaende item){
        boolean ankor = false;

        for (int i = 0; i < ausruestung.size(); i++) {
            if (item.getClassname() == ausruestung.get(i).getClassname()){
                return true;
            }
        }
        return ankor;
    }

    public String printRucksack(){
        String inhalt = " ";

        for (int i = 0; i < rucksack.size(); i++) {
            inhalt += (" " + rucksack.get(i).getClassname()) + ".";
        }
        return inhalt;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getStaerke() {
        return staerke;
    }

    public void setStaerke(int staerke) {
        this.staerke = staerke;
    }

    public Vector<Gegenstaende> getAusruestung() {
        return ausruestung;
    }

    public void setAusruestung(Vector<Gegenstaende> ausruestung) {
        this.ausruestung = ausruestung;
    }

    public void addAusruestung(Gegenstaende item){
        ausruestung.add(item);
    }

    public void removeAusruestung(int index){
        rucksack.add(ausruestung.get(index));
        ausruestung.remove(ausruestung.get(index));
    }

}
