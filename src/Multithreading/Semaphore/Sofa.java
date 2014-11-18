package Multithreading.Semaphore;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by А on 18.11.14.
 */
public class Sofa {
    int count;
    Queue<Person> queue;

    public Sofa(int count) {
        this.count = count;
        queue = new LinkedList<>();
    }

    public void acquire() throws InterruptedException {
        queue.add((Person)Thread.currentThread());
        synchronized (this) {
            while (queue.peek() != Thread.currentThread())
                wait();
            while (count == 0) {
                wait();
            }
            queue.poll();
            count--;
        }
    }

    public synchronized void release() {
        count++;
        notifyAll();
    }
}
