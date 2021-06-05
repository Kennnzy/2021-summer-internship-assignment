import java.util.*;

public class Q2 {
    
    public static void main (String[] args) {
        int[] a = {2, 2, 3, 5, 6, 7, 10};
        int[] b = {2, 2, 4, 5, 8};

        reconcileHelper(a, b);
        
    }

    /**
        1. Initialize ArrayLists and convert array into ArrayList.
        2. Iterate through array a, checking at every iteration if array b contains the element in array a.
            a. If it does not contain the element, print the element out.
        3. Iterate through array b, checking at every iteration if array a contains the element in array b.
            a. If it does not contain the element, print the element out.
     */

    static void reconcileHelper(int[] a, int[] b) {
        
        if (a.length == 0 && b.length == 0) {
            System.out.println("Both arrays are empty.");
        } else if (a == null || b == null) {
            System.out.println("Either of the arrays are null.");
        } else {
            // Initialize ArrayLists
            ArrayList<Integer> aList = new ArrayList<Integer>();
            ArrayList<Integer> bList = new ArrayList<Integer>();

            // Copy arrays to ArrayList
            for (int element : a)
                aList.add(element);
            for (int element : b)
                bList.add(element);
        
            System.out.println("Numbers in array a that aren't in array b:");

            // Loop through array a and check if b array has the numbers.
            for (int i = 0; i < aList.size(); i++) {
                if (!bList.contains(a[i]))
                    System.out.print(a[i] + " ");
            }

            System.out.println("");
            System.out.println("Numbers in array b that aren't in array a:");

            // Loop through array b and check if a array has the numbers.
            for (int i = 0; i < bList.size(); i++) {
                if (!aList.contains(b[i]))
                    System.out.print(b[i] + " ");
            }
        }

    }
}