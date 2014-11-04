package Algorithms;

import java.util.Arrays;

/**
 * Created by А on 29.10.14.
 */
public class MyPriorityQueue {
    private int[] array;
    private int size = 0;

    public MyPriorityQueue() {
        this.array = new int[11];
    }

    private void resize() {
        int newCapacity = 2 * array.length + 1;
        array = Arrays.copyOf(array, newCapacity);
    }

    public void offer(int element) {
        if (size == array.length)
            resize();
        array[size] = element;
        int i = size;
        while (i >= 0 && array[(i-1)/2] < array[i]) {
            int current = array[i];
            array[i] = array[(i-1)/2];
            array[(i-1)/2] = current;
            i = (i-1)/2;
        }
        size++;
    }

    public int peek() {
        return array[0];
    }

    public int poll() {
        if (size == 0)
            return 0;
        int max = array[0];
        array[0] = array[size-1];
        array[size-1] = 0;
        size--;
        heapify(0);
        return max;
    }

    private void heapify(int current) {
        int left = 2*current + 1;
        int right = 2*current + 2;
        int largest;
        if (left <= size && array[left] > array[current])
            largest = left;
        else
            largest = current;
        if (right <= size && array[right] > array[largest])
            largest = right;
        if (largest != current) {
            int temp = array[current];
            array[current] = array[largest];
            array[largest] = temp;
            heapify(largest);
        }
    }

    public void merge(MyPriorityQueue queue) {
        while (this.size + queue.size >= array.length)
            resize();
        for (int i = 0; i < queue.size; i++) {
            this.offer(queue.poll());
        }
    }

    public int size() {
        return size;
    }

    public void printAll() {
        for (int i = 0; i < this.size; i++) {
            System.out.println("cell "+i+ " = "+array[i]);
        }
    }

}
