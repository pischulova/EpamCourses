package Multithreading.CyclicBarrier;

/**
 * Created by А on 20.11.14.
 */
public class Guest extends Thread {
    int timeToSleep;
    Supervisor supervisor;

    public Guest(int time, Supervisor supervisor) {
        this.timeToSleep = time;
        this.supervisor = supervisor;
        start();
    }

    @Override
    public void run() {
        try {
            this.sleep(timeToSleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName() + " came.");
        supervisor.await();
    }
}
