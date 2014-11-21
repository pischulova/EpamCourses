package Multithreading.Violinists;

/**
 * Решить задачу о скрипачах. Есть n скрипок, k-смычков и l скрипачей. Также выполняется условие l>k+n.
 * Д/з №10
 * Created by А on 20.11.14.
 */
public class Show {
    public static void main(String[] args) {
        Helper helper = new Helper(2, 3);
        Violinist v1 = new Violinist(helper);
        Violinist v2 = new Violinist(helper);
        Violinist v3 = new Violinist(helper);
        Violinist v4 = new Violinist(helper);
        Violinist v5 = new Violinist(helper);
        Violinist v6 = new Violinist(helper);
        v1.start();
        v2.start();
        v3.start();
        v4.start();
        v5.start();
        v6.start();
    }
}
