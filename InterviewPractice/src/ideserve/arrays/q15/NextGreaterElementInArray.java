package ideserve.arrays.q15;

import java.util.Stack;

/**
 * http://www.ideserve.co.in/learn/next-great-element-in-an-array
 */
public class NextGreaterElementInArray {

    public static void main(String[] args) {
        printNextGreatestElements(new int[]{98,23,54,12,20,7,27});
        printNextGreatestElements(new int[]{1,54,75,55,42,9,103,100,102});
    }

    /**
     * O(n) runtime
     * O(n) space
     * @param a
     */
    private static void printNextGreatestElements(int[] a) {
        Stack<Integer> stack = new Stack<>();
        for (int current : a) {
            while (!stack.empty() && stack.peek() < current) {
                System.out.println("Next greatest number for " + stack.pop() + " is " + current);
            }
            stack.push(current);
        }
        while (!stack.empty()) {
            System.out.println("Next greatest number for " + stack.pop() + " is null");
        }
    }
}
