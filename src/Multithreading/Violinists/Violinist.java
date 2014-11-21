package Multithreading.Violinists;

/**
 * Created by А on 20.11.14.
 */
public class Violinist extends Thread {
    Helper helper;

    public Violinist(Helper helper) {
        this.helper = helper;
    }

    @Override
    public void run() {
        helper.askViolin();
        helper.askBow();
        System.out.println(this.getName() + " is playing...");
        try {
            this.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        helper.releaseBow();
        helper.releaseViolin();
    }
}
