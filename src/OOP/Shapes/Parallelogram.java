package OOP.Shapes;

/**
 * Created by А on 18.10.14.
 */
public class Parallelogram extends Shape {
    double longerSide;
    double height;

    public Parallelogram(double longerSide, double height) {
        this.longerSide = longerSide;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return longerSide*height;
    }
}
