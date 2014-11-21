package Multithreading.CyclicBarrier;

/**
 * Created by А on 20.11.14.
 */
public class Supervisor  {
    private int maxGuests;
    private int count;
    private Runnable carousel;

    public Supervisor(int value, Runnable carousel) {
        this.maxGuests = value;
        this.count = value;
        this.carousel = carousel;
    }

    public synchronized void await() {
        if (maxGuests < 0)
            maxGuests = count;
        while (--maxGuests > 0){
            try {
                System.out.println("Waiting for " + maxGuests + " more people..");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
        new Thread(carousel).start();
    }
}
