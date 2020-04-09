package Utlities;

public class BinarySearch {

    private static BinarySearch instance = null;

    public static BinarySearch getInstance()
    {
        if (instance == null)
            instance = new BinarySearch();
        return instance;
    }

    public static int search(int arr[], int x)
    {
        int l = 0, r = arr.length - 1;
        while (l <= r)
        {
            int m = l + (r - l) / 2;

            if (arr[m] == x)
                return m;

            if (arr[m] < x)
                l = m + 1;

            else
                r = m - 1;
        }

        return -1;
    }
}
