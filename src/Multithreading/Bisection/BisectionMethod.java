package Multithreading.Bisection;

import Multithreading.Integral.IntegralFunction;

/**
 * Создать адаптивный алгоритм решения уравнения f(x)=0 на отрезке [a,b] методом деления отрезка пополам.
 * Количество потоков зависит от глубины рекурсии.
 *
 * Created by А on 13.11.14.
 */
public class BisectionMethod {
    private Function function;
    private double firstArg, secondArg;
    private double root;

    public static class Function{
        public double f(double arg) {
            double res = 2* arg - 3;
            return res;
        }
    }

    public BisectionMethod(double firstArg, double secondArg) {
        this.firstArg = firstArg;
        this.secondArg = secondArg;
        function = new Function();
    }

    public double findRoot() {
        if (function.f(firstArg)*function.f(secondArg) > 0) {
            System.out.println("The function doesn't have any root on the interval.");
            return 0;
        } else {
            BisectionThread thread = new BisectionThread(function, firstArg, secondArg);
            thread.start();

            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            root = thread.getRoot();
            return root;
        }
    }

    public static void main(String[] args) {
        BisectionMethod method = new BisectionMethod(1, 20);

        System.out.printf("Root = %.3f", method.findRoot());
    }
}
