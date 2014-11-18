package Multithreading.Cafe;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by А on 16.11.14.
 */
public class Cook extends Thread {

    private Dish specialization;
    private String name;
    private Kitchen kitchen;
    private Queue<Order> dishesToCook;

    public Cook(Kitchen kitchen, Dish specialization, String name) {
        this.specialization = specialization;
        this.name = name;
        this.kitchen = kitchen;
        dishesToCook = new LinkedList<>();
    }

    @Override
    public void run() {
        while (true)
            cook();
    }

    public  void addTask(Order order) {
        synchronized (dishesToCook){
            dishesToCook.add(order);
            dishesToCook.notifyAll();
        }
    }

    private void cook() {
        Order current;
        synchronized (dishesToCook){
            while (dishesToCook.size() == 0) {
                try {
                    dishesToCook.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            current = dishesToCook.poll();
        }
        try {
            switch (specialization) {
                case SOUP: this.sleep(5000); break;
                case CAKE: this.sleep(6000); break;
                case COFFEE: this.sleep(3000); break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        kitchen.deliverDish(current, specialization);
    }
}
