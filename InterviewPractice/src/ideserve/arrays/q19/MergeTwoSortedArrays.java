package ideserve.arrays.q19;

/**
 * Created by justenpinto on 2017-07-10.
 */
public class MergeTwoSortedArrays {

    private static final int INVALID_NUM = Integer.MIN_VALUE;

    public static void main(String[] args) {
        printArray(mergeArrays(new int[]{-3,5,INVALID_NUM,7,INVALID_NUM,10,INVALID_NUM,11,INVALID_NUM}, new int[]{-1,2,6,12}));
    }

    private static int[] mergeArrays(int[] a, int[] b) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == INVALID_NUM) {
                a[i] = b[count++];
                sortMergedArray(a, i);
            }
        }
        return a;
    }

    private static void sortMergedArray(int[] a, int currentIndex) {
        if (currentIndex > 0) {
            while (a[currentIndex] < a[currentIndex - 1]) {
                int temp = a[currentIndex];
                a[currentIndex] = a[currentIndex - 1];
                a[currentIndex - 1] = temp;
            }
        }
    }

    private static void printArray(int[] a) {
        for (int v : a) {
            System.out.print(v + " ");
        }
        System.out.println();
    }
}
