package Algorithms.PolishNotation.Elements;

/**
 * Created by А on 11.12.14.
 */
public abstract class Node {
    Node left;
    Node right;

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return null;
    }

    public Node getRight() {
        return null;
    }

    public int calculate() {
        return 0;
    }
}
