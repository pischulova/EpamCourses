package Multithreading.Semaphore;

import Multithreading.Exceptions.IllegalActionException;

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
        if (queue.contains(Thread.currentThread()))
            try {
                throw new IllegalActionException();
            } catch (IllegalActionException e) {
                System.out.println("You can not acquire semaphore twice.");
            }
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
        if (!queue.contains(Thread.currentThread()))
            try {
                throw new IllegalActionException();
            } catch (IllegalActionException e) {
                System.out.println("You can not release before acquire.");
            }
        count++;
        notifyAll();
    }
}
