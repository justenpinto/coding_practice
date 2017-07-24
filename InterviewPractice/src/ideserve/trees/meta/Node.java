package ideserve.trees.meta;

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

    public Node(Node left, Node right) {
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

    public boolean hasParent() {
        return parent != null;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public boolean hasRight() {
        return right != null;
    }

}
