package ideserve.trees.q4;

import ideserve.trees.meta.Node;
import ideserve.trees.utils.TreeUtils;

/**
 * http://www.ideserve.co.in/learn/populate-right-neighbors-in-a-binary-tree
 */
public class PopulateNeighbourNodes {

    public static void main(String[] args) {
        Node<Integer> n0 = new Node<>(0);
        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(3);
        Node<Integer> n5 = new Node<>(5);
        Node<Integer> n6 = new Node<>(6);
        Node<Integer> n7 = new Node<>(7);
        Node<Integer> n8 = new Node<>(8);

        n0.setLeft(n1); n0.setRight(n2);
        n1.setLeft(n3);
        n2.setLeft(n5); n2.setRight(n6);
        n6.setLeft(n7); n6.setRight(n8);

        populateNeighbourNodes(n0);
        traverseUsingNeighbours(n0);
    }

    /**
     * O(n) runtime
     * O(1) space
     *
     * @param currentNode
     */
    private static void populateNeighbourNodes(Node<Integer> currentNode) {
        if (currentNode == null) {
            return;
        }
        if (currentNode.hasLeft()) {
            if (currentNode.hasRight()) {
                currentNode.getLeft().setParent(currentNode.getRight());
            } else {
                findFirstNonNullNeighbour(currentNode);
            }
        } else if (currentNode.hasRight()) {
            findFirstNonNullNeighbour(currentNode);
        }

        populateNeighbourNodes(currentNode.getLeft());
        populateNeighbourNodes(currentNode.getRight());
    }

    private static void findFirstNonNullNeighbour(Node<Integer> currentNode) {
        Node ancestorNode = currentNode.getParent();
        Node neighbourNode;
        while (ancestorNode != null) {
            neighbourNode = ancestorNode.hasLeft() ? ancestorNode.getLeft() : ancestorNode.getRight();
            if (neighbourNode != null) {
                currentNode.getLeft().setParent(neighbourNode);
                break;
            }
            ancestorNode = ancestorNode.getParent();
        }
    }

    private static void traverseUsingNeighbours(Node root) {
        Node current = root;
        while (current != null) {
            Node temp = current;
            current = null;
            while (temp != null) {
                if (current == null) {
                    current = temp.hasLeft() ? temp.getLeft() : temp.getRight();
                }
                System.out.print(temp.getValue() + " ");
                temp = temp.getParent();
            }
            System.out.print("\n\n");
        }
    }
}
