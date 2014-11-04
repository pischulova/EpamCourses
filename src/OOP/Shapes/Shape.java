package OOP.Shapes;

/**
 * Created by А on 18.10.14.
 */
public abstract class Shape {

    abstract double calculateArea();

    static double calculateSum(Shape shape1, Shape shape2) {
        return (shape1.calculateArea()+shape2.calculateArea());
    }

    public static void main(String[] args) {
        Trapezium trapezium = new Trapezium(3, 5, 1);
        Triangle triangle = new Triangle(8, 9);
        Circle circle = new Circle(4);
        Parallelogram parallelogram = new Parallelogram(7, 2);
        System.out.println(calculateSum(trapezium, triangle));
        System.out.println(calculateSum(circle, parallelogram));
    }
}
