package Containers;

/**
 * Created by А on 20.10.14.
 */
public class App {
    public static void main(String[] args) {
        Set s1 = new Set(new MyList()) {{
            add(1);
            add(2);
            add("g");
        }};

        Set s2 = new Set(new MyArray()) {{
            add(3);
            add(5);
            add("hi");
        }};
        Set s3 = s1.union(s2);
        s3.printAll();
    }
}
