package ideserve.arrays.q22;

/**
 * http://www.ideserve.co.in/learn/longest-increasing-subsequence
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int length = findLargestIncreasingSubsequence(new int[]{12,18,7,34,30,28,90,88});
        System.out.println(length);
    }

    /**
     * O(n^2) runtime
     * O(n) space
     *
     * @param sequence
     * @return
     */
    private static int findLargestIncreasingSubsequence(int[] sequence) {
        int longestLength = 0;

        int[] lengths = new int[sequence.length];
        lengths[0] = 1;

        for (int i = 1; i < sequence.length; i++) {
            lengths[i] = 1;
            for (int j = 0; j < i; j++) {
                if (sequence[i] > sequence[j]) {
                    lengths[i] = Math.max(lengths[i], lengths[j] + 1);
                }
            }
            if (lengths[i] > longestLength) {
                longestLength = lengths[i];
            }
        }
        return longestLength;
    }
}
