package ideserve.trees.q1;

import ideserve.trees.generic.Node;
import ideserve.trees.utils.TreeUtils;

import java.util.Stack;

/**
 * http://www.ideserve.co.in/learn/iterative-preorder-traversal-of-binary-tree
 */
public class IterativePreOrderTraversal {

    public static void main(String[] args) {
        Node root = TreeUtils.createIntegerTree(new int[]{6,4,9,3,5,8});
        iterativePreOrderPrint(root);
    }

    /**
     * O(n) runtime
     * O(n) space
     *
     * @param root
     */
    private static void iterativePreOrderPrint(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            Node current = stack.pop();
            if (current.getRight() != null) {
                stack.push(current.getRight());
            }
            if (current.getLeft() != null) {
                stack.push(current.getLeft());
            }
            System.out.print(current.getValue() + ",");
        }
    }
}
