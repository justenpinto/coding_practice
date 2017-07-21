package ideserve.trees.q1;

import ideserve.trees.generic.Node;
import ideserve.trees.utils.TreeUtils;

/**
 * Created by justenpinto on 2017-07-21.
 */
public class RecursivePreOrderTraversal {

    public static void main(String[] args) {
        preOrderTraversal(TreeUtils.createTree(new int[]{6,4,9,3,5,8}));
    }

    /**
     * O(n) runtime
     * O(1) space
     * 
     * @param node
     */
    private static void preOrderTraversal(Node node) {
        System.out.print(node.getValue() + ",");
        if (node.getLeft() != null) {
            preOrderTraversal(node.getLeft());
        }
        if (node.getRight() != null) {
            preOrderTraversal(node.getRight());
        }
    }
}
