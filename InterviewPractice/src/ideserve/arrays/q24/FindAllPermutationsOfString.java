package ideserve.arrays.q24;

import java.util.HashSet;
import java.util.Set;

/**
 * http://www.ideserve.co.in/learn/all-permutations-of-a-string
 */
public class FindAllPermutationsOfString {

    public static void main(String[] args) {
        System.out.println(findAllPermutations("abc"));
    }

    /**
     * O(n*n!) runtime - For each character, we are getting all permutations of a string (there are n! permutations)
     * O(n!) space - Store each permutation
     *
     * @param s
     * @return
     */
    private static Set<String> findAllPermutations(String s) {
        Set<String> permutations = new HashSet<>();
        if (s == null || s.length() == 0) {
            permutations.add("");
            return permutations;
        }

        String charAtIndex = String.valueOf(s.charAt(0));
        Set<String> tempPerms = findAllPermutations(s.substring(1));
        for (String perm : tempPerms) {
            for (int j = 0; j <= perm.length(); j++) {
                permutations.add(perm.substring(0, j) + charAtIndex + perm.substring(j));
            }
        }

        return permutations;
    }

}
