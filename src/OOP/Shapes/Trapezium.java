package OOP.Shapes;

/**
 * Created by А on 18.10.14.
 */
public class Trapezium extends Shape {
    double base1;
    double base2;
    double height;

    public Trapezium(double base1, double base2, double height) {
        this.base1 = base1;
        this.base2 = base2;
        this.height = height;
        System.out.println("I'm a trapezium");
    }

    @Override
    double calculateArea(){
        return ((base1+base2)/2)*height;
    }
}
