package Algorithms.PolishNotation.Elements;

/**
 * Created by А on 11.12.14.
 */
public class ArgumentComposite extends Node {
    Operator operator;
    Node left;
    Node right;

    public ArgumentComposite(Operator operator) {
        this.operator = operator;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    @Override
    public int calculate() {
        return operator.calculate(left.calculate(), right.calculate());
    }
}
