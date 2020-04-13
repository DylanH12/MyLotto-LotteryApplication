package Services;

import Models.Player;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class PlayerLibrary {

    // Singleton Object
    // Check if this is doing a singleton
    private static PlayerLibrary instance = null;
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
        Integer[] numbers = player.getPlayerNumbers();
        playersMap.put(player.getPlayerName(), numbers);
    }

    public Map<String, Integer[]> getPlayers()
    {
        return playersMap;
    }
}
