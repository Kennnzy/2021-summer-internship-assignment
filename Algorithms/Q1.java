import java.util.*;

public class Q1 {
    
    public static void main (String[] args) {
        int[] testArray = {2, 4, 5, 1, 3, 5, 4, 3};
        int targetSum = 6;
        // Expected pairs are (to be printed on the console):
        // (2, 4)
        // (1, 5)
        
        findPairs(testArray, targetSum);
        
    }

    /**
        1. Check edge case to see if array is empty or null.
        2. Sort array.
        3. Initialize two int variables to the beginnning and end of the array.
        4. While lo is lower than hi, check to see if both elements add to the target sum. If yes, then add it as a pair
            with the lowest element as the key so there are no duplicates.
        5. Now, since array is sorted, if both elementes added are higher than target sum, increasing low would be pointless since
            the target sum would never be reached. That is why I decreased hi instead of lo.
        6. Else, lo increases.
     */

    static void findPairs(int[] testArray, int targetSum) {
        if (testArray.length == 0 || testArray == null) {
            System.out.println("Array is empty or null.");
        } else {
            // Sort array
            Arrays.sort(testArray);

            // Initialize variables
            HashMap<Integer, Integer> pair = new HashMap<Integer, Integer>();
            int lo = 0;
            int hi = testArray.length - 1;

            while (lo < hi) {
                if (testArray[lo] + testArray[hi] == targetSum) {
                    pair.put(testArray[lo], testArray[hi]);
                }
                if (testArray[lo] + testArray[hi] > targetSum)
                {
                    hi--;
                }
                else
                {
                    lo++;
                }
            }

            // Print contents of HashMap
            for (Map.Entry<Integer, Integer> entry : pair.entrySet()) {
                System.out.println("(" + entry.getKey() + ", " + entry.getValue() + ")");
            }
        }
    }
}