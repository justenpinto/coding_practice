package ideserve.arrays.q3;

/**
 * http://www.ideserve.co.in/learn/find-the-element-that-appears-once-in-an-array
 */
public class FindElementOnceInArray {

    public static void main(String[] args) {
        findElement(new int[]{ 5, 5, 4, 8, 4, 5, 8, 9, 4, 8 }, 3);
    }

    // O(n*k) runtime
    // O(k) space
    // k is always 32, therefore:
    // O(32*n) = O(n) runtime
    // O(32) = O(1) space
    private static void findElement(int[] a, int duplicity) {

        int[] countSetBits = new int[32];

        for (int i = 0; i < a.length; i++) {

            for (int k = 0; k < countSetBits.length; k++) {
                int setBit = 1 << k;

                if ((a[i] & setBit) == setBit) {
                    countSetBits[k]++;
                }
            }
        }

        int num = 0;

        for (int i = 0; i < countSetBits.length; i++) {
            countSetBits[i] = countSetBits[i] % duplicity;

            if (countSetBits[i] == 1) {
                num |= 1 << i;
            }
        }
        System.out.println("Single occurrence: " + num);
    }
}
