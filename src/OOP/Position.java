package OOP;

/**
 * Created by А on 21.10.14.
 */
public class Position {
    void method(int a, int pos, boolean flag) {
        if (flag == true) {
            int b = 0b00000001;
            b = b << pos;
            a = a | b;
        } else {
            int b = 0b00000001;
            b = b << pos;
            b = ~b;
            a = a & b;
        }
    }

    public static void main(String[] args) {
        Position p = new Position();
        p.method(16, 0, true);
    }
}
