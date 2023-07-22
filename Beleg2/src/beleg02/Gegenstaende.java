package beleg02;

public abstract class Gegenstaende implements Kaufbar{
    public abstract String getClassname();
    public abstract String benutzen(Spieler player);
}
