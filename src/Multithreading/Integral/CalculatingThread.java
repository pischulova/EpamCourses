package Multithreading.Integral;
import Multithreading.Integral.IntegralFunction.Function;

/**
 * Created by А on 13.11.14.
 */
public class CalculatingThread extends Thread {
    double firstArg, secondArg;
    Function function;
    double step;
    double result;

    public CalculatingThread(double firstArg, double secondArg, double step, Function fun) {
        this.firstArg = firstArg;
        this.secondArg = secondArg;
        this.function = fun;
        this.step = step;
        result = 0;
    }

    public void run() {
        result = step * ((function.f(firstArg) + function.f(secondArg)) / 2);
        //System.out.println(currentThread().getName()+" "+firstArg+ " "+secondArg+" result = "+result);
    }

    public double getResult() {
        return result;
    }
}
