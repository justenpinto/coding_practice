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
}
