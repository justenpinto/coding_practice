package ideserve.trees.generic;

/**
 * Generic Node class for tree questions
 */
public class Node<T> {

    private T value;
    private Node parent, left, right;

    public Node() {

    }

    public Node(T value) {
        this.value = value;
    }

    public Node(T value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Node(T value, Node parent) {
        this.value = value;
        this.parent = parent;
    }

    public Node(Node parent) {
        this.parent = parent;
    }

    public Node(T value, Node parent, Node left, Node right) {
        this.value = value;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
