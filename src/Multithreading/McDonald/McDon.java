package Multithreading.McDonald;

import java.util.ArrayList;
import java.util.List;

/**
 * Свободная касса. В ресторане быстрого обслуживания есть несколько касс. Посетители стоят в очереди
 * в конкретную кассу, но могут перейти в другую очередь при уменьшении или исчезновении там очереди.
 * д/з №9
 * Created by А on 16.11.14.
 */
public class McDon {
    private volatile List<Cashtable> cashtableList;

    public McDon() {
        cashtableList = new ArrayList<>();
        Cashtable c1 = new Cashtable(1);
        Cashtable c2 = new Cashtable(2);
        Cashtable c3 = new Cashtable(3);
        cashtableList.add(c1);
        cashtableList.add(c2);
        cashtableList.add(c3);
        c1.start();
        c2.start();
        c3.start();
    }

    public List<Cashtable> getCashtableList() {
        return cashtableList;
    }

    public static void main(String[] args) throws InterruptedException {
        McDon mcDon = new McDon();
        List<Cashtable> cashtableList = mcDon.getCashtableList();
        Customer c1 = new Customer(cashtableList, "Anna");
        Customer c2 = new Customer(cashtableList, "Sam");
        Customer c3 = new Customer(cashtableList, "Chandler");
        Customer c4 = new Customer(cashtableList, "Alex");
        Customer c5 = new Customer(cashtableList, "Monica");
        Customer c6 = new Customer(cashtableList, "John");
        Customer c7 = new Customer(cashtableList, "Kathy");
        c1.start();
        c2.start();
        c2.sleep(2000);
        c3.start();
        c4.start();
        c4.sleep(4000);
        c5.start();
        c6.start();
        c7.start();
    }

}
