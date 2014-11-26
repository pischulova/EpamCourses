package Multithreading.CyclicBarrier;

/**
 * Created by А on 20.11.14.
 */
public class Supervisor  {
    private int maxGuests;
    private int count;
    private Runnable carousel;

    public Supervisor(int maxGuests, Runnable carousel) {
        this.maxGuests = maxGuests;
        this.count = maxGuests;
        this.carousel = carousel;
    }

    public synchronized void await() {
        if (count <= 0)
            count = maxGuests;
        while (--count > 0){
            try {
                System.out.println("Waiting for " + count + " more people..");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
        new Thread(carousel).start();
    }
}
