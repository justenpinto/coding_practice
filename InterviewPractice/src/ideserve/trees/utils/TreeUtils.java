package ideserve.trees.utils;

import ideserve.trees.generic.Node;

/**
 * Tree Util class for Trees package
 */
public class TreeUtils {
    public static Node createTree(int[] array) {
        Node[] nodes = new Node[array.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node<>(array[i]);
        }

        for (int i = 0; i < nodes.length; i++) {
            if (2 * i + 1 < nodes.length) {
                nodes[i].setLeft(nodes[2*i + 1]);
            }
            if (2 * i + 2 < nodes.length) {
                nodes[i].setRight(nodes[2*i + 2]);
            }
        }
        return nodes[0];
    }

    public static int getHeight(Node node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(getHeight(node.getRight()), getHeight(node.getLeft()));
    }

    public static void printPreOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.getValue() + " ");
        printPreOrderTraversal(node.getLeft());
        printPreOrderTraversal(node.getRight());
    }

    public static void printInOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        printInOrderTraversal(node.getLeft());
        System.out.print(node.getValue() + " ");
        printInOrderTraversal(node.getRight());
    }

    public static void printPostOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        printInOrderTraversal(node.getLeft());
        printInOrderTraversal(node.getRight());
        System.out.print(node.getValue() + " ");
    }

    public static boolean isLeaf(Node node) {
        return node.getLeft() == null && node.getRight() == null;
    }

    public static boolean isRoot(Node node) {
        return node.getParent() == null;
    }
}
