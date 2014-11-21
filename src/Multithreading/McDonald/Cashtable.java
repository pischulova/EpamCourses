package Multithreading.McDonald;

import java.util.LinkedList;

/**
 * Created by А on 16.11.14.
 */
public class Cashtable extends Thread{
    private LinkedList<Customer> queue;
    private int number;
    boolean isBusy;

    public Cashtable(int number) {
        this.number = number;
        isBusy = false;
        queue = new LinkedList<>();
    }

    public LinkedList<Customer> getQueue() {
        return queue;
    }

    public int getNumber() {
        return number;
    }

    public void addCustomer(Customer customer) {
        queue.add(customer);
    }

    @Override
    public void run() {
        while (true)
            serve();
    }

    public synchronized void serve() {
        if (queue.size() == 0)
            return;
        Customer customer = queue.peek();
        try {
            while(isBusy){
                wait();
            }
            isBusy = true;
            customer.isServed = true;
            System.out.println("Cashtable " + this.number + " is serving " + customer.name + "...");
            Thread.sleep(8000);
            queue.remove(customer);
            System.out.println("Cashtable " + this.number + " finished serving " + customer.name);
            System.out.println(customer.name + " is gone");
            isBusy = false;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
