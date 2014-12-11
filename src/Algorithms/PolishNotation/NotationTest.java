package Algorithms.PolishNotation;


/**
 * Created by А on 11.12.14.
 */
public class NotationTest {
    public static void main(String[] args) {
        PolishNotation pn = new PolishNotation("(12*3+10)*5+12*7");
        System.out.println(pn.calculate());
    }
}
