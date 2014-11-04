package OOP;

/**
 * Created by А on 21.10.14.
 */
public class Size {
    int getSize(int i) {
        int count = 0;
        while (i != 0) {
            i = i>>1;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Size s = new Size();
        System.out.println(s.getSize(30));
    }
}
