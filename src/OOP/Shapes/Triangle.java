package OOP.Shapes;

/**
 * Created by А on 18.10.14.
 */
public class Triangle extends Shape {
    double base;
    double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    double calculateArea(){
        return base*height/2;
    }
}
