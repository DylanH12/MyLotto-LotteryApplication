package Services;

import Utlities.BinarySearch;
import Utlities.SelectionSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LotteryService {
    private static LotteryService instance = null;
    SelectionSort selectionSort;
    BinarySearch binarySearch;
    RandomNumberGenerator randomNumberGenerator;
    PlayerLibrary playerLibrary;
    List<String> winningNumbers;

    public static LotteryService getInstance()
    {
        if (instance == null)
            instance = new LotteryService();
        return instance;
    }

    private LotteryService(){
    }

    public int[] generateRandomNumbers()
    {
        return randomNumberGenerator.getInstance().generate();
    }

    public List<String> checkNumbersForMatches(int[] sortedRandomNumbers, int[] sortedPlayerNumbers)
    {
        winningNumbers = new ArrayList<String>();

        for (int num : sortedPlayerNumbers){
            int result = binarySearch.getInstance().search(sortedRandomNumbers, num);
            if (result != -1)
                winningNumbers.add("Winning Number: " + num);
        }

        if (winningNumbers.isEmpty()){
            winningNumbers.add("No matching numbers");
            return winningNumbers;
        }

        return winningNumbers;
    }

    public int[] sortNumbers(int[] arr)
    {
        return selectionSort.getInstance().sort(arr);
    }

    public Map<String, Integer[]> getPlayers()
    {
        return playerLibrary.getInstance().getPlayersFromMap();
    }
}
