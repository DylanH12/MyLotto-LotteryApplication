package Services;

import Models.Player;
import java.util.Arrays;
import java.util.LinkedList;

public class PlayerLibrary {

    // Singleton Object
    // Check if this is doing a singleton
    private static PlayerLibrary instance = null;
    private LinkedList<Player> players;

    private PlayerLibrary()
    {
        players = new LinkedList<>();
    }

    // Instance property returns the singleton instance
    public static PlayerLibrary getInstance(){
        if (instance == null) {
            instance = new PlayerLibrary();
        }
        return instance;
    }

    public void addPlayer(Player player)
    {
        players.add(player);
    }

    public Player[] getPlayers()
    {
        Object[] objarr = players.toArray();
        Player[] playersArr = Arrays.copyOf(objarr, objarr.length, Player[].class);
        return playersArr;
    }
}
