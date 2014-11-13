package Multithreading.Sum;

import java.util.ArrayList;
import java.util.List;

/**
 * Найти сумму n чисел с использованием k потоков. При этом потоки должны быть загружены равноценно.
 *
 * Created by А on 13.11.14.
 */
public class SumCalculator {
    int limit;
    int threadsNumber;
    List<SumThread> threadList;

    public SumCalculator(int limit, int threadsNumber) {
        this.limit = limit;
        this.threadsNumber = threadsNumber;
        threadList = new ArrayList<>();
    }

    public int calculate() {
        System.out.println(threadsNumber + " threads");
        runThreads();
        int result = 0;
        for (SumThread thread : threadList)
            result += thread.getSum();
        return result;
    }

    private void runThreads() {
        for (int i = 0; i < threadsNumber; i++)
            threadList.add(new SumThread());
        int order = 0;
        for (int i = 0; i < limit; i++) {
            threadList.get(order).addData(i);
            if (++order == threadsNumber)
                order = 0;

        }
        long startTime = System.currentTimeMillis();
        for (SumThread thread : threadList)
            thread.start();
        for (SumThread thread : threadList) {
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

    public static void main(String[] args) {
        SumCalculator calculator = new SumCalculator(1000, 1);
        calculator.calculate();
        calculator = new SumCalculator(100000, 2);
        calculator.calculate();
        calculator = new SumCalculator(100000, 3);
        calculator.calculate();
        calculator = new SumCalculator(100000, 5);
        calculator.calculate();
        calculator = new SumCalculator(100000, 10);
        calculator.calculate();
        calculator = new SumCalculator(100000, 20);
        calculator.calculate();
        calculator = new SumCalculator(100000, 50);
        calculator.calculate();
        calculator = new SumCalculator(100000, 100);
        calculator.calculate();
        calculator = new SumCalculator(100000, 200);
        calculator.calculate();
    }
}
