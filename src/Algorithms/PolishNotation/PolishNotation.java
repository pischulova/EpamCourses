package Algorithms.PolishNotation;

import Algorithms.PolishNotation.Elements.*;
import Algorithms.PolishNotation.Elements.Node;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Дано арифметическое выражение типа (12*3+10)*5+12*7. Вычислить данное выражение используя паттерн Composite
 *
 * Created by А on 11.12.14.
 */
public class PolishNotation {
    private String expression;

    private Stack<Node> nodeStack;
    private Stack<Operator> operatorStack;

    private Node root;

    public PolishNotation(String expression) {
        this.expression = expression;
        nodeStack = new Stack<>();
        operatorStack = new Stack<>();
    }

    public int calculate() {
        System.out.println(expression);
        buildTree();
        return root.calculate();
    }

    private void buildTree() {
        LinkedList<Character> temp = new LinkedList<>();
        char [] array = expression.toCharArray();
        for(int i = 0; i < array.length; i++) {
            char ch = array[i];
            Operator oper = isOperator(ch);

            if(Character.isDigit(ch)) {
                temp.add(ch);

            } else {
                if(!temp.isEmpty()) {
                    String str = "";
                    while (!temp.isEmpty())
                        str+= temp.poll();
                    nodeStack.push(new Argument(Integer.valueOf(str)));
                }
                if(oper != null) {
                    if(operatorStack.isEmpty()) {
                        operatorStack.push(oper);

                    } else {
                        Operator last = operatorStack.pop();
                        if(last != Operator.OP_BRACES && oper.getPriority() <= last.getPriority()) {
                            createNewArgumentComposite(last);
                            operatorStack.push(oper);
                        } else {
                            operatorStack.push(last);
                            operatorStack.push(oper);
                        }
                    }
                } else {
                    if(ch == '(') {
                        Operator brace = Operator.OP_BRACES;
                        operatorStack.push(brace);
                    } else {
                        Operator lastOper = operatorStack.pop();
                        while (lastOper != Operator.OP_BRACES) {
                            createNewArgumentComposite(lastOper);
                            lastOper = operatorStack.pop();
                        }
                    }
                }
            }
        }
        if(!temp.isEmpty()) {
            String str = "";
            while (!temp.isEmpty())
                str+= temp.poll();
            nodeStack.push(new Argument(Integer.valueOf(str)));
        }
        while(!operatorStack.isEmpty()) {
            createNewArgumentComposite(operatorStack.pop());
        }
    }

    private void createNewArgumentComposite(Operator operator) {
        Node secondArg = nodeStack.pop();
        Node firstArg = nodeStack.pop();
        Node currentNode = new ArgumentComposite(operator);
        currentNode.setLeft(firstArg);
        currentNode.setRight(secondArg);
        nodeStack.push(currentNode);
        root = currentNode;
    }

    private Operator isOperator(Character ch) {
        switch (ch) {
            case '+': return Operator.PLUS;
            case '-': return Operator.MINUS;
            case '*': return Operator.MULTIPLY;
            case '/': return Operator.DIVIDE;
        }
        return null;
    }
}
