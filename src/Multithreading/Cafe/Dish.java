package Multithreading.Cafe;

/**
 * Created by А on 16.11.14.
 */
public enum Dish {
    SOUP(5000), CAKE(3000), COFFEE(3000);

    private int timeToEat;

    Dish(int timeToEat) {
        this.timeToEat = timeToEat;
    }

    public int getTimeToEat() {
        return timeToEat;
    }

}
