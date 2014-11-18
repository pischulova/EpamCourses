package Multithreading.Semaphore;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by А on 18.11.14.
 */
public class Room {
    public static void main(String[] args) {
        Sofa sofa = new Sofa(3);
        List<Person> persons = new LinkedList<>();
        for (int i = 0; i < 6; i++)
            persons.add(new Person(sofa));
        for (Person p : persons) {
            p.start();
            try {
                p.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
