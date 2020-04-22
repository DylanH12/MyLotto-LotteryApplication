package Services;

public class RandomNumberGenerator {

    private static RandomNumberGenerator instance = null;
    private static int[] randomNumbers = new int[6];

    /*
    Private constructor to stop instantiation of the class
     */
    private RandomNumberGenerator() {
    }

    /*
    Will check if an instance is created
    Gets the instance of the class
     */
    public static RandomNumberGenerator getInstance() {
        if (instance == null) {
            instance = new RandomNumberGenerator();
        }
        return instance;
    }

    public int[] generate() {
        // Explain this is to avoid duplicate numbers
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = (int) (Math.random() * ((59 - 1) + 1)) + 1;
            for (int j = 0; j < i; j++) {
                if (randomNumbers[i] == randomNumbers[j]) {
                    i--; // if randomNumbers[i] is a duplicate of randomNumbers[j], then run the outer loop on i again
                    break;
                }
            }
        }
        return randomNumbers;
    }
}
