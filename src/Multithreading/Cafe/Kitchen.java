package Multithreading.Cafe;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * Created by А on 16.11.14.
 */
public class Kitchen extends Thread{
    Cook c1, c2, c3;

    public Kitchen() {
        c1 = new Cook(this, Dish.SOUP, "Mike");
        c2 = new Cook(this, Dish.CAKE, "John");
        c3 = new Cook(this, Dish.COFFEE, "Erlend");
    }

    public synchronized void recieveOrder(List<Dish> list, Client client) {
        Order order = new Order(client, list);

        for (Dish current : list) {
            switch (current) {
                case SOUP:
                    c1.addTask(order);
                    break;
                case CAKE:
                    c2.addTask(order);
                    break;
                case COFFEE:
                    c3.addTask(order);
                    break;
            }
        }
    }

    @Override
    public void run() {
        c1.start();
        c2.start();
        c3.start();
    }

    public void deliverDish(Order order, Dish dish) {
        Client client = order.getClient();
        System.out.println(dish.toString() + " is delivered to " + client.getName());
        client.getReadyDishes().add(dish);
        synchronized (client) {
            client.notify();
        }
    }
}
