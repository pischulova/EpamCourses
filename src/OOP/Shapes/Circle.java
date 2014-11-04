package OOP.Shapes;

/**
 * Created by А on 18.10.14.
 */
public class Circle extends Shape {
    final static double PI = 3.1415;
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return radius*radius*PI;
    }
}
