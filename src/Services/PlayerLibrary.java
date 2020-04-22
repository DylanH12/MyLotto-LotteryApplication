package Services;

import Models.Player;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class PlayerLibrary {

    // Singleton Object
    private static PlayerLibrary instance = null;
    // Data structure to hold the players in the application.
    private Map<String, Integer[]> playersMap;

    private PlayerLibrary()
    {
        playersMap = new HashMap();
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
        playersMap.put(player.getPlayerName(), player.getPlayerNumbers());
    }

    public Map<String, Integer[]> getPlayers()
    {
        return playersMap;
    }
}
