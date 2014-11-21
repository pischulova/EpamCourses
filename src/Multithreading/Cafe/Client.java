package Multithreading.Cafe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by А on 16.11.14.
 */
public class Client extends Thread {
    private Kitchen kitchen;
    List<Dish> clientOrder;
    private List<Dish> readyDishes;

    public Client(String name, Kitchen kitchen) {
        this.kitchen = kitchen;
        this.setName(name);
        clientOrder = new ArrayList<>();
        readyDishes = new ArrayList<>();
        System.out.println("New client "+ name + " came.");
        this.start();
    }

    public List<Dish> getReadyDishes() {
        return readyDishes;
    }

    public void makeOrder() {
        clientOrder.add(Dish.SOUP);
        clientOrder.add(Dish.CAKE);
        clientOrder.add(Dish.COFFEE);
        kitchen.recieveOrder(clientOrder, this);
    }

    @Override
    public void run() {
        makeOrder();
        try {
            synchronized (this) {
                for (Dish dish : clientOrder) {
                    while (!readyDishes.contains(dish)) {
                        this.wait();
                    }
                    System.out.println(this.getName() + " is eating " + dish.toString()+"...");
                    this.sleep(dish.getTimeToEat());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName() + " leaves the restaurant.");
    }
}
