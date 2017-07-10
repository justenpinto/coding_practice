package ideserve.arrays.q2;

/**
 * http://www.ideserve.co.in/learn/find-the-missing-number-in-the-duplicate-array
 */
public class MissingNumberInDuplicateArray {

    public static void main(String[] args) {
        int[] a1 = new int[]{1,2,3,4,5};
        int[] a2 = new int[]{1,2,4,5};
        findMissingNumberXor(a1, a2);

    }

    // O(n) runtime
    // O(1) space
    private static void findMissingNumber(int[] a1, int[] a2) {
        int num = 0;
        for (int i = 0; i < a2.length; i++) {
            num += a1[i];
            num -= a2[i];
        }
        num += a1[a1.length - 1];
        System.out.println("Missing Number: " + num);
    }

    // O(n) runtime
    // O(1) space
    private static void findMissingNumberXor(int[] a1, int[] a2) {
        int num = 0;
        for (int i : a1) {
            num ^= i;
        }
        for (int i : a2) {
            num ^= i;
        }
        System.out.println("Missing Number: " + num);
    }
}
