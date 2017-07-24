package ideserve.trees.q3;

import ideserve.trees.meta.Node;
import ideserve.trees.utils.TreeUtils;

/**
 * http://www.ideserve.co.in/learn/lowest-common-ancestor-of-two-nodes-binary-search-tree
 */
public class FindLowestCommonAncestorBST {

    public static void main(String[] args) {
        Node<Integer> root = TreeUtils.createIntegerBST(new int[] {5, 2, 6, 0, 3, 1, 9, 7, 8});
        System.out.println(findLCA(root, 0, 3));
        System.out.println(findLCA(root, 1, 7));
        System.out.println(findLCA(root, 7, 8));
        System.out.println(findLCA(root, 9, 9));
        System.out.println(findLCA(root, 9, 10));
        System.out.println(findLCA(root, 9, -1));
    }

    /**
     * O(lg n) runtime
     * O(1) space
     *
     * @param root
     * @param v1
     * @param v2
     * @return
     */
    private static int findLCA(Node<Integer> root, int v1, int v2) {
        if (v1 == v2) {
            return v1;
        }
        if (v1 > v2) {
            int temp = v2;
            v2 = v1;
            v1 = temp;
        }

        int node = -1;

        Node n1 = findNode(root, v1);
        if (n1 == null) {
            return node;
        }
        Node n2 = findNode(root, v2);
        if (n2 == null) {
            return node;
        }

        Node<Integer> lca = findLCA(root, n1, n2);
        if (lca != null) {
            return lca.getValue();
        }

        return node;
    }

    private static Node<Integer> findLCA(Node<Integer> current, Node<Integer> n1, Node<Integer> n2) {
        if (current == null) {
            return null;
        }
        if (n1.getValue() < current.getValue() && current.getValue() < n2.getValue()) {
            return current;
        }
        if (current.getValue() == n1.getValue() || current.getValue() == n2.getValue()) {
            return current;
        }

        if (n1.getValue() < current.getValue()) {
            return findLCA(current.getLeft(), n1, n2);
        }
        else {
            return findLCA(current.getRight(), n1, n2);
        }
    }

    private static Node<Integer> findNode(Node<Integer> node, int v) {
        if (node == null) {
            return null;
        }
        if (v == node.getValue()) {
            return node;
        }
        if (v < node.getValue()) {
            return findNode(node.getLeft(), v);
        }
        else {
            return findNode(node.getRight(), v);
        }
    }
}
