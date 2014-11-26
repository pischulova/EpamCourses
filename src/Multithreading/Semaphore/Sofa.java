package Multithreading.Semaphore;

import Multithreading.Exceptions.IllegalActionException;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by А on 18.11.14.
 */
public class Sofa {
    int count;
    Queue<Person> waitingQueue;
    Queue<Thread> acquiredThreads;

    public Sofa(int count) {
        this.count = count;
        waitingQueue = new LinkedList<>();
        acquiredThreads = new LinkedList<>();
    }

    public void acquire() throws InterruptedException {
        if (waitingQueue.contains(Thread.currentThread()))
            try {
                throw new IllegalActionException();
            } catch (IllegalActionException e) {
                System.err.println("You can not acquire semaphore twice.");
            }
        else {
            waitingQueue.add((Person)Thread.currentThread());
            synchronized (this) {
                while (waitingQueue.peek() != Thread.currentThread())
                    wait();
                while (count == 0) {
                    wait();
                }
                acquiredThreads.add(Thread.currentThread());
                waitingQueue.poll();
                count--;
            }
        }
    }

    public synchronized void release() {
        if (!acquiredThreads.contains(Thread.currentThread())) {
            try {
                throw new IllegalActionException();
            } catch (IllegalActionException e) {
                System.err.println("You can not release before acquire.");
            }
        } else {
            count++;
            acquiredThreads.remove(Thread.currentThread());
            notifyAll();
        }
    }
}
