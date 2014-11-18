package Multithreading.Semaphore;

/**
 * Created by А on 18.11.14.
 */
public class Person extends Thread {
    Sofa sofa;

    public Person(Sofa sofa) {
        this.sofa = sofa;
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " came");
        try {
            sofa.acquire();
            System.out.println(this.getName() + " is sitting on the sofa...");
            this.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sofa.release();
    }
}
