package Algorithms.PolishNotation.Elements;

/**
 * Created by А on 11.12.14.
 */
public class Argument extends Node {
    private int value;

    public Argument(int value) {
        this.value = value;
    }

    @Override
    public int calculate() {
        return value;
    }
}
