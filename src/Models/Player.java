package Models;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Player {

    // Allows to increment the Id
    private static final AtomicInteger count = new AtomicInteger(0);

    private int id;
    private String playerName;
    private int[] playerNumbers;

    public Player(String playerName, int[] playerNumbers)
    {
        this.id = count.incrementAndGet();
        this.playerName = playerName;
        this.playerNumbers = playerNumbers;
    }

    public int getPlayerId()
    {
        return this.id;
    }

    public String getPlayerName()
    {
        return this.playerName;
    }

    public String getPlayerNumbers()
    {
        return Arrays.toString(this.playerNumbers).replaceAll("\\[|\\]|,|\\s", " ");
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", playerName='" + playerName + '\'' +
                ", playerNumbers=" + Arrays.toString(playerNumbers) +
                '}';
    }
}
