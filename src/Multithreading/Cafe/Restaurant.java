package Multithreading.Cafe;


/**
 * Created by А on 16.11.14.
 */
public class Restaurant {
    public static void main(String[] args) {
        Kitchen kitchen = new Kitchen();
        kitchen.start();
        Client c1 = new Client("Anna", kitchen);
        Client c2 = new Client("Paul", kitchen);

//        Client c3 = new Client("Chris", kitchen);
//        c3.makeOrder(Dish.SOUP, Dish.CAKE, Dish.COFFEE);
//        c3.start();

    }
}
