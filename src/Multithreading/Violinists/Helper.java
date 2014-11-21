package Multithreading.Violinists;

/**
 * Created by А on 20.11.14.
 */
public class Helper {
    private int bowNumber;
    private int violinNUmber;

    public Helper(int bowNumber, int violinNUmber) {
        this.bowNumber = bowNumber;
        this.violinNUmber = violinNUmber;
    }

    public synchronized void askViolin() {
        while (violinNUmber == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        violinNUmber--;
    }

    public synchronized void releaseViolin() {
        violinNUmber++;
        notifyAll();
    }

    public synchronized void askBow() {
        while (bowNumber == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        bowNumber--;
    }

    public synchronized void releaseBow() {
        bowNumber++;
        notifyAll();
    }
}
