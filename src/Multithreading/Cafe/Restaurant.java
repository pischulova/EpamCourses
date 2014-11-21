package Multithreading.Cafe;


/**
 * Система ресторан. В ресторане n столиков за каждым столиком сидит клиент.
 * Клиент делает заказ из трех блюд Борщ, Торт, Кофе.
 * Клиент обедает в последовательности Борщ->Торт->Кофе.
 * Также в ресторане есть три повара. Один готовит борщи. Второй- торты. Третий-кофе.
 * Д/з №10
 *
 * Created by А on 16.11.14.
 */
public class Restaurant {
    public static void main(String[] args) {
        Kitchen kitchen = new Kitchen();
        kitchen.start();
        Client c1 = new Client("Anna", kitchen);
        Client c2 = new Client("Paul", kitchen);
        Client c3 = new Client("Chris", kitchen);

    }
}
