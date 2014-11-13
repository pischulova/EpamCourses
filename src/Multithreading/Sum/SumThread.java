package Multithreading.Sum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by А on 13.11.14.
 */
public class SumThread extends Thread {
    List<Integer> dataList;
    int sum;

    public SumThread() {
        dataList = new ArrayList<>();
        sum = 0;
    }

    public void addData(int data) {
        dataList.add(data);
    }

    public void run() {
        for (Integer i : dataList) {
            sum += i;
        }
    }

    public int getSum() {
        return sum;
    }
}
