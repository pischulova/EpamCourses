package Multithreading.Matrix;

import java.util.*;

/**
 * Created by А on 11.11.14.
 */
class MultiplyThread extends Thread {
    int[][] matrix1;
    int[][] matrix2;
    int[][] result;
    List<Integer> rowNumbers;
    List<Integer> columnNumbers;

    MultiplyThread(int[][] matrix1, int[][] matrix2, int[][]result) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.result = result;
        rowNumbers = new ArrayList<>();
        columnNumbers = new ArrayList<>();
    }

    public void createTask(int row, int column) {
        rowNumbers.add(row);
        columnNumbers.add(column);
    }

    public void run() {
        for (int i = 0; i < rowNumbers.size(); i++) {
            int row = rowNumbers.get(i);
            int column = columnNumbers.get(i);
            int sum = 0;
            System.out.println(currentThread().getName()+ " " +row+ " "+column);
            for (int k = 0; k < matrix1.length; k++) {
                sum += matrix1[row][k] * matrix2[column][k];
            }
            result[row][column] = sum;
        }
    }
}
