package Multithreading.Matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Многопоточное приложение для перемножения двух матриц размерности nxn. Количество потоков k.
 *
 * Created by А on 11.11.14.
 */
public class MatrixMultiplier {
    int[][] matrix1;
    int[][] matrix2;
    int[][] result;
    int threadsNumber;
    int matrixSize;
    List<MultiplyThread> threadList;

    public MatrixMultiplier(int size, int threadsNumber) {
        if (threadsNumber > size)
            throw new IllegalArgumentException();
        matrix1 = fillMatrix(size);
        matrix2 = fillMatrix(size);
        result = new int[size][size];
        this.threadsNumber = threadsNumber;
        this.matrixSize = size;
        threadList = new ArrayList<>();
    }

    public void multiply() {
        createThreads();
        int order = 0;
        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                threadList.get(order).createTask(i, j);
                if (++order == threadsNumber)
                    order = 0;
            }
        }

        for (Thread thread : threadList) {
            thread.start();
        }

        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < matrixSize; i++) {
            for (int j = 0; j < matrixSize; j++) {
                System.out.println("element [" + i +"]["+ j + "] = "+ result[i][j]);
            }
        }
    }

    private int[][] fillMatrix(int size) {
        int[][] full = new int[size][size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int randomInt = random.nextInt(50);
                full[i][j] = randomInt;
            }
        }
        return full;
    }

    private void createThreads() {
        for (int i = 0; i < threadsNumber; i++) {
            threadList.add(new MultiplyThread(matrix1, matrix2, result));
        }
    }

    public static void main(String[] args) {
        MatrixMultiplier mm = new MatrixMultiplier(5, 4);
        mm.multiply();

    }
}
