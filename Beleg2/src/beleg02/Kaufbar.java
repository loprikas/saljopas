package beleg02;

public interface Kaufbar {


    default boolean kaufbar(Spieler player){
        if (player.getGold() - getKosten() > 0){
            return true;
        }
        return false;
    }
    int getKosten();

}
