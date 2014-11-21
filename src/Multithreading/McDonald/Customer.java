package Multithreading.McDonald;

import com.sun.java.swing.plaf.windows.resources.windows;
import sun.net.www.content.audio.basic;

import java.util.List;

/**
 * Created by А on 16.11.14.
 */
public class Customer extends Thread {
    final List<Cashtable> cashtableList;
    Cashtable cashtable;
    String name;
    boolean isServed = false;

    public Customer(List<Cashtable> cashtableList, String name) {
        this.cashtableList = cashtableList;
        this.name = name;
    }

    @Override
    public void run() {
        chooseCashtable();
        if (cashtable.getState() == State.TIMED_WAITING) {
            try {
                this.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!isServed) {
                System.out.println(name + " is waiting to long.");
                changeQueue();
            }

        }
    }

    public void chooseCashtable() {
        synchronized (cashtableList) {
            Cashtable best = cashtableList.get(0);
            for (Cashtable c: cashtableList) {
                if (c.getQueue().size() == 0) {
                    best = c;
                    break;
                }
                if (c.getQueue().size() < best.getQueue().size())
                    best = c;
            }
            cashtable = best;
        }
        synchronized (cashtable.getQueue()) {
            cashtable.addCustomer(this);
            System.out.println(name + " : " + cashtable.getNumber() + " cashtable.");
        }
    }

    public void changeQueue() {
        synchronized (cashtableList) {
            Cashtable best = cashtable;
            for (Cashtable c : cashtableList) {
                if (!c.isBusy || c.getQueue().size() < cashtable.getQueue().size())
                    best = c;
            }
            cashtable.getQueue().remove(this);
            if (best == cashtable)
                System.out.println(name + " decided to stay in this queue.");
            else {
                cashtable = best;
                System.out.println(name + " changed queue to "+ cashtable.getNumber());
                cashtable.addCustomer(this);
            }
        }
    }
}
