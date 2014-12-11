package Algorithms.PolishNotation.Elements;

/**
 * Created by А on 11.12.14.
 */
public enum Operator {
    PLUS(1) {
        int calculate(int arg, int arg2) {
            return arg + arg2;
        }
    },
    MINUS(1) {
        int calculate(int arg, int arg2) {
            return arg - arg2;
        }
    },
    MULTIPLY(2) {
        int calculate(int arg, int arg2) {
            return arg * arg2;
        }
    },
    DIVIDE(2) {
        int calculate(int arg, int arg2) {
            return arg / arg2;
        }
    },
    OP_BRACES(3) {
        int calculate(int arg, int arg2) {
            return 0;
        }
    },
    CL_BRACES(3) {
        int calculate(int arg, int arg2) {
            return 0;
        }
    };

    int priority;

    Operator(int priority) {
        this.priority = priority;
    }

    abstract int calculate(int arg, int arg2);

    public int getPriority() {
        return priority;
    }
}
