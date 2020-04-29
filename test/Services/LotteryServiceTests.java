package Services;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LotteryServiceTests {

    @Test
    public void generateRandomNumbersBetween1And59()
    {
        int[] randomNumbers = LotteryService.getInstance().generateRandomNumbers();

        assertNotNull(randomNumbers);

        for (int number : randomNumbers)
        {
            assertTrue(number > 1 && number < 59);
        }
    }

    @Test
    public void sortNumbers()
    {
        int[] unsortedRandomNumbers = new int[] {32, 11, 43, 55, 12, 51};

        int[] sortedRandomNumbers = LotteryService.getInstance().sortNumbers(unsortedRandomNumbers);

        assertNotNull(sortedRandomNumbers);
        assertEquals(sortedRandomNumbers[0], 11);
        assertEquals(sortedRandomNumbers[1], 12);
        assertEquals(sortedRandomNumbers[2], 32);
        assertEquals(sortedRandomNumbers[3], 43);
        assertEquals(sortedRandomNumbers[4], 51);
        assertEquals(sortedRandomNumbers[5], 55);

    }

    @Test
    public void checkArraysForMatchesWhenWinningNumbers()
    {
        int[] array1 = new int[] {1, 2, 3, 4, 5, 6};
        int[] array2 = new int[] {1, 6, 12, 14, 33 ,55};

        List<String> response =  LotteryService.getInstance().checkNumbersForMatches(array1, array2);

        assertNotNull(response);
        assertEquals(response.get(0), "Winning Number: 1");
        assertEquals(response.get(1), "Winning Number: 6");
    }

    @Test
    public void checkArraysForMatchesWhenNoWinningNumbers()
    {
        int[] array1 = new int[] {1, 2, 3, 4, 5, 6};
        int[] array2 = new int[] {9, 11, 12, 14, 33 ,55};

        List<String> response =  LotteryService.getInstance().checkNumbersForMatches(array1, array2);

        assertNotNull(response);
        assertEquals(response.get(0), "No matching numbers");
    }

}