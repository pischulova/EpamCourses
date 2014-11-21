package Multithreading.Sum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by А on 20.11.14.
 */
public class SumCalc2 {
    int limit;
    int threadsNumber;
    List<SumThread> threadList;

    public SumCalc2(int limit, int threadsNumber) {
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
        for (int i = 0; i < limit; i++) {
            for (int j = threadsNumber; j>1; j--) {
                if (i % j == 0)
                    threadList.get(j-1).addData(i);
                else
                    threadList.get(0).addData(i);
            }
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
}
