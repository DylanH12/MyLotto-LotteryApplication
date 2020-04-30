package Models;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Player {

    private String playerName;
    private Integer[] playerNumbers;

    public Player(String playerName, Integer[] playerNumbers)
    {
        this.playerName = playerName;
        this.playerNumbers = playerNumbers;
    }


    public String getPlayerName()
    {
        return this.playerName;
    }

    public Integer[] getPlayerNumbers()
    {
        return this.playerNumbers;
    }
}
