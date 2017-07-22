package ideserve.trees.q2;

import ideserve.trees.generic.Node;
import ideserve.trees.utils.TreeUtils;

import java.util.Stack;

/**
 * http://www.ideserve.co.in/learn/spiral-level-order-traversal-of-a-binary-tree-set-1
 */
public class SpiralOrderTraversalExtraSpaceAllowed {

    public static void main(String[] args) {
        spiralTraversal(TreeUtils.createIntegerTree(new int[]{0,1,2,4,5,3,6,7,8,9}));
    }

    /**
     * O(n) runtime
     * O(n) space
     *
     * @param root
     */
    private static void spiralTraversal(Node root) {
        if (root == null) {
            return;
        }

        boolean evenLevel = true;
        Stack<Node> evenLevelStack = new Stack<>();
        evenLevelStack.push(root);
        Stack<Node> oddLevelStack = new Stack<>();

        while(!evenLevelStack.empty() || !oddLevelStack.empty()) {
            if (evenLevel) {
                Node current = evenLevelStack.pop();
                System.out.print(current.getValue() + ",");
                if (current.getRight() != null) {
                    oddLevelStack.push(current.getRight());
                }
                if (current.getLeft() != null) {
                    oddLevelStack.push(current.getLeft());
                }
                evenLevel = !evenLevelStack.empty();
            }
            else {
                Node current = oddLevelStack.pop();
                System.out.print(current.getValue() + ",");
                if (current.getLeft() != null) {
                    evenLevelStack.push(current.getLeft());
                }
                if (current.getRight() != null) {
                    evenLevelStack.push(current.getRight());
                }
                evenLevel = oddLevelStack.empty();
            }
        }
    }
}
