package Multithreading.Integral;

import java.util.ArrayList;
import java.util.List;

/**
 * Найти значение определенного интеграла от гладкой функции f(x).
 * Использовать метод трапеций. Определить оптимальное количество потоков
 * (при котором производительность будет максимальной).
 *
 * Created by А on 13.11.14.
 */
public class IntegralFunction {
    double firstArg;
    double lastArg;
    int threadsNumber;
    double step;
    List<CalculatingThread> threadList;
    Function function;

    public static class Function{
        public double f(double arg) {
            double res = Math.pow(arg, 2) - Math.sqrt(arg) - arg;
            return res;
        }
    }

    public IntegralFunction(double firstArg, double lastArg, int threadsNumber) {
        System.out.println("Number of threads = " + threadsNumber);
        this.firstArg = firstArg;
        this.lastArg = lastArg;
        this.threadsNumber = threadsNumber;
        step = (lastArg - firstArg)/threadsNumber;
        threadList = new ArrayList<>();
        function = new Function();
    }

    public double calculateIntegral() {
        runThreads();
        double result = 0;
        for (CalculatingThread thread : threadList) {
            result += thread.getResult();
        }
        return result;
    }

    private void runThreads() {
        double first, second;
        for (int i = 0; i < threadsNumber; i++) {
            first = firstArg + i * step;
            second = first + step;
            threadList.add(new CalculatingThread(first, second, step, function));
        }
        long startTime = System.currentTimeMillis();
        for (CalculatingThread thread : threadList) {
            thread.start();
        }
        for (CalculatingThread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Execution time: "+ totalTime+" ms");
    }

}
