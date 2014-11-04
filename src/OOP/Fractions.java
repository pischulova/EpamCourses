package OOP;

/**
 * Created by А on 21.10.14.
 */
public class Fractions {
    float function(int value, int number) {
        float res = 0;
        for (int i = 0; i < number; i++) {
            res += value * Math.pow(10, i);
        }
        return res;
    }

    float method(int value, int number) {
        float sum = 0;
        for (int i = 1; i <= number; i++) {
            float temp = function(value, i);
            sum += 1 / temp;
            System.out.println(i + " " + 1/temp);
        }
        return sum;
    }

    float method2(int value, int number) {
        float sum = 0;
        for (int i = number; i > 0; i--) {
            float temp = function(value, i);
            sum += 1 / temp;
            System.out.println(i + " " + 1/temp);
        }
        return sum;
    }

    public static void main(String[] args) {
        Fractions fr = new Fractions();
        System.out.println(fr.method(9, 8));
        System.out.println("---------------");
        System.out.println(fr.method2(9, 8));
    }
}
