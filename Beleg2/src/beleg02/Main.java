package beleg02;


public class Main {


    public static void main(String[] args) {

        Schmiede smith = Schmiede.create();
        Juwelier juw = Juwelier.create();
        Buchhandlung book = Buchhandlung.create();


        Spieler player = Spieler.create("Henry");

        //Ausgaben Anfang:
        System.out.println("\n" + "Anfangsgeld von Spieler " + player.getName() + " : " + player.getGold());
        System.out.println("Kampstaerke von Spieler " + player.getName() + " : " + player.getStaerke() + "\n");

        System.out.println("Die Schmiede besitzt folgendes Angebot : " + smith.printAngebot());
        System.out.println("Der Juwelier besitzt folgendes Angebot : " + juw.printAngebot());
        System.out.println("Die Buchhandlung besitzt folgendes Angebot : " + book.printAngebot() + "\n");


        boolean pleite = false;
        while (!pleite) {

            pleite = true;


            for (int i = 0; i < smith.getAngebot().size(); i++) {
                if (smith.getAngebot().get(i).kaufbar(player)) { //wenn bezahlbar
                    System.out.println(player.getName() + " kauft etwas in der Schmiede für " + smith.getAngebot().get(i).getKosten() + " Gold.");
                    player.setGold(player.getGold() - smith.getAngebot().get(i).getKosten());
                    player.getRucksack().add(smith.getAngebot().get(i));
                    smith.deleteAngebot(smith.getAngebot().get(i));
                    pleite = false;
                    break;
                }
            }

            for (int i = 0; i < juw.getAngebot().size(); i++) {
                if (juw.getAngebot().get(i).kaufbar(player)) { //wenn bezahlbar
                    System.out.println(player.getName() + " kauft etwas beim Juwelier für " + juw.getAngebot().get(i).getKosten() + " Gold.");
                    player.setGold(player.getGold() - juw.getAngebot().get(i).getKosten());
                    player.getRucksack().add(juw.getAngebot().get(i));
                    juw.deleteAngebot(juw.getAngebot().get(i));
                    pleite = false;
                    break;
                }
            }

            for (int i = 0; i < book.getAngebot().size(); i++) {
                if (book.getAngebot().get(i).kaufbar(player)) { //wenn bezahlbar
                    System.out.println(player.getName() + " kauft etwas in der Buchhandlung für " + book.getAngebot().get(i).getKosten() + " Gold.");
                    player.setGold(player.getGold() - book.getAngebot().get(i).getKosten());
                    player.getRucksack().add(book.getAngebot().get(i));
                    book.deleteAngebot(book.getAngebot().get(i));
                    pleite = false;
                    break;
                }
            }
        }


        //Ausgaben Ende:
        System.out.println("\n" + "Der Rucksack enthält jetzt: " + player.printRucksack());
        System.out.println("\n" + "Der Spieler " + player.getName() + " hat jetzt noch " + player.getGold() + " Gold.\n");

        System.out.println("Die Schmiede besitzt noch folgendes Angebot : " + smith.printAngebot());
        System.out.println("Der Juwelier besitzt noch folgendes Angebot : " + juw.printAngebot());
        System.out.println("Die Buchhandlung besitzt noch folgendes Angebot : " + book.printAngebot() + "\n");

        System.out.println("Der Spieler rüstet nun die besten Gegenstaende aus!");


        for (int i = 0; i < player.getRucksack().size(); i++) {

            if (player.getRucksack().get(i).getClassname() == "Goldring") {
                if (player.isBest(player.getRucksack().get(i)) > 0) {
                    System.out.println("Der aktuelle Goldring wurde in den Rucksack gepackt, da ein besserer gefunden wurde!");
                    player.removeAusruestung(player.isBest(player.getRucksack().get(i)));
                    System.out.println(player.getRucksack().get(i).benutzen(player));
                } else if (player.isBest(player.getRucksack().get(i)) < 0 && player.isEqual(player.getRucksack().get(i))) {
                   System.out.println("Der Goldring wurde nicht ausgerüstet, da bereits ein besserer ausgerüstet ist!");
                } else System.out.println(player.getRucksack().get(i).benutzen(player));
            }

            if (player.getRucksack().get(i).getClassname() == "Schwert") {
                if (player.isBest(player.getRucksack().get(i)) > 0) {
                    System.out.println("Das aktuelle Schwert wurde in den Rucksack gepackt, da ein besseres gefunden wurde!");
                    player.removeAusruestung(player.isBest(player.getRucksack().get(i)));
                    System.out.println(player.getRucksack().get(i).benutzen(player));
                } else if (player.isBest(player.getRucksack().get(i)) < 0 && player.isEqual(player.getRucksack().get(i))) {
                    System.out.println("Das Schwert wurde nicht ausgerüstet, da bereits ein besseres ausgerüstet ist!");
                } else System.out.println(player.getRucksack().get(i).benutzen(player));
            }

            if (player.getRucksack().get(i).getClassname() == "Bogen") {
                if (player.isBest(player.getRucksack().get(i)) > 0) {
                    System.out.println("Der aktuelle Bogen wurde in den Rucksack gepackt, da ein besserer gefunden wurde!");
                    player.removeAusruestung(player.isBest(player.getRucksack().get(i)));
                    System.out.println(player.getRucksack().get(i).benutzen(player));
                } else if (player.isBest(player.getRucksack().get(i)) < 0 && player.isEqual(player.getRucksack().get(i))) {
                    System.out.println("Der Bogen wurde nicht ausgerüstet, da bereits ein besserer ausgerüstet ist!");
                } else System.out.println(player.getRucksack().get(i).benutzen(player));
            }
            else System.out.println(player.getRucksack().get(i).benutzen(player));
        }
        
        System.out.println("\n Die finale Angriffskraft des Spielers " + player.getName() + " ist " + player.getStaerke() + ".");

    }
}



//Ausgaben:

        /*
a. die initialen Eigenschaften des Spielers (Geldbörse, Kampfstärke)
b. die initiale Belegung der Läden
c. die Preise der Items
d. der Inhalt des Rucksackes nach dem Einkaufen
e. die Geldbörse des Spielers nach dem Einkaufen
f. die Restwarenbestände in den Läden nach dem Einkaufen
g. die aktuelle/erhöhte Kampfstärke nach Anwendung des Silberringes
         */





