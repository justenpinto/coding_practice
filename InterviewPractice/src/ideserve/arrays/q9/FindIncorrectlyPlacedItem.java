package ideserve.arrays.q9;

/**
 * http://www.ideserve.co.in/learn/find-the-missing-number-in-the-increasing-sequence
 */
public class FindIncorrectlyPlacedItem {

    public static void main(String[] args) {
        System.out.println("Missing number: " + findIncorrectItem(new int[]{1,2,4,5,6,7}, 0, 6));
    }

    // O(lg n) runtime
    // O(1) space
    private static int findIncorrectItem(int[] a, int low, int high) {

        int mid = (high + low) / 2;

        if (isCorrectlyPlaced(a[mid], mid)) {
            low = mid + 1;
        }
        else {
            high = mid;
        }

        if (high == low) {
            return a[high] - 1;
        }

        return findIncorrectItem(a, low, high);
    }

    private static boolean isCorrectlyPlaced(int number, int i) {
        return number == i + 1;
    }
}
