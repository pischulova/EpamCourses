package Multithreading.Bisection;

import Multithreading.Bisection.BisectionMethod.*;

/**
 * Created by А on 13.11.14.
 */
public class BisectionThread extends Thread {
    Function function;
    double firstArg, secondArg;
    double root;
    BisectionThread childThread;
    final static double minInterval = 1;

    public BisectionThread(Function function, double firstArg, double secondArg) {
        this.function = function;
        this.firstArg = firstArg;
        this.secondArg = secondArg;
        childThread = null;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started");

        double middle = (firstArg + secondArg) / 2;
        System.out.println(secondArg - firstArg);
        if (Math.abs(secondArg - firstArg) <= minInterval)
            root = middle;
        else {
            if (function.f(firstArg)*function.f(middle) > 0) {
                childThread = new BisectionThread(function, middle, secondArg);
            } else {
                childThread = new BisectionThread(function, firstArg, middle);
            }
            childThread.start();
            try {
                childThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public double getRoot() {
        return root;
    }
}
