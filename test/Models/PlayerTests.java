package Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTests {

    @Test
    public void getPlayersDetails()
    {
        String actualPlayerName = "Dylan";
        Integer[] actualNumbers = new Integer[]{1, 2, 3, 4, 5, 6};

        Player player = new Player(actualPlayerName, actualNumbers);

        String nameResult = player.getPlayerName();
        Integer[] numbersResult = player.getPlayerNumbers();

        assertEquals(actualPlayerName, nameResult);
        assertArrayEquals(actualNumbers, numbersResult);
    }

}