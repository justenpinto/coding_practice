package ideserve.arrays.q1;

/**
 * Created by justenpinto on 2017-07-05.
 */
public class OddNumber {

    public static void main(String[] args) {
        findOddNumber(new int[]{2, 2, 4, 4, 5, 6, 6});
    }

    // O(n) runtime
    // O(1) space
    private static void findOddNumber(int[] n) {
        int num = 0;

        for (int i : n) {
            num = num ^ i;
        }

        System.out.println("Odd number: " + num);
    }
}
