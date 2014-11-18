package Multithreading.Cafe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by А on 18.11.14.
 */
public class Order {
    List<Dish> contents;
    private Client client;

    public Order(Client client, List<Dish> contents) {
        this.client = client;
        this.contents = contents;
    }

    public Client getClient() {
        return client;
    }

    public List<Dish> getContents() {
        return contents;
    }
}
