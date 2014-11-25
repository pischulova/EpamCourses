package Patterns.Decorator;

/**
 * Created by А on 21.11.14.
 */
abstract public class Product {
    abstract public void show();
}

class Pizza extends Product {
    public void show() {
        System.out.println("pizza");
    }
}

abstract class Decorator extends Product {
    Product p;
}

class Tomato extends Decorator {
    public Tomato(Product p) {
        this.p = p;
    }

    public void show() {
        p.show();
        System.out.println("tomato");
    }
}

class Cheese extends Decorator {
    public Cheese(Product p) {
        this.p = p;
    }

    public void show() {
        p.show();
        System.out.println("cheese");
    }
}

class Starter{
    public static void main(String[] args) {
        Product pizza = new Pizza();
        Product cheesePizza = new Cheese(pizza);
        cheesePizza.show();
        Product tomatoCheesePizza = new Tomato(cheesePizza);
        tomatoCheesePizza.show();
    }
}
