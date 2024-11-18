package student.java.homework.weeks.week4_3;
import java.util.Arrays;
public class ArrayUtils {

    // Method to get elements after the last 1 in the array
    public static int[] getElementsAfterLastOne(int[] array) {
        int lastIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                lastIndex = i;
            }
        }

        if (lastIndex == -1) {
            throw new RuntimeException("The array does not contain any 1s.");
        }

        int[] result = new int[array.length - lastIndex - 1];
        System.arraycopy(array, lastIndex + 1, result, 0, array.length - lastIndex - 1);
        return result;
    }

    // Method to check if the array consists only of 1s and 2s
    public static boolean isArrayValid(int[] array) {
        boolean containsOne = false;
        boolean containsTwo = false;

        for (int i : array) {
            if (i != 1 && i != 2) {
                return false;
            }
            if (i == 1) {
                containsOne = true;
            }
            if (i == 2) {
                containsTwo = true;
            }
        }

        return containsOne || containsTwo;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Tests for getElementsAfterLastOne method
        try {
            int[] result1 = getElementsAfterLastOne(new int[]{1, 2, 1, 2, 2});
            System.out.println(Arrays.toString(result1)); // Output: [2, 2]
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        try {
            int[] result2 = getElementsAfterLastOne(new int[]{2, 2, 2, 2});
        } catch (RuntimeException e) {
            System.out.println(e.getMessage()); // Output: The array does not contain any 1s.
        }

        // Tests for isArrayValid method
        System.out.println(isArrayValid(new int[]{1, 2})); // Output: true
        System.out.println(isArrayValid(new int[]{1, 1})); // Output: false
        System.out.println(isArrayValid(new int[]{1, 3})); // Output: false
        System.out.println(isArrayValid(new int[]{1, 2, 2, 1})); // Output: true
    }
}
