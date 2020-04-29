package Services;

import Models.Player;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PlayerLibraryTests {

    @Test
    public void addingPlayerToMapWithDetails()
    {
        PlayerLibrary.getInstance().addPlayer(new Player("Dylan", new Integer[]{1, 2, 3, 4, 5, 6}));
        PlayerLibrary.getInstance().addPlayer(new Player("Ghost", new Integer[]{1, 2, 3, 4, 5, 6}));

        Map<String, Integer[]> players = PlayerLibrary.getInstance().getPlayers();

        assertNotNull(players);
        assertTrue(players.containsKey("Dylan"));
        assertTrue(players.containsKey("Ghost"));
    }

}