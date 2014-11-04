package Containers;

/**
 * Created by А on 21.10.14.
 */
public class MyArray<E> implements Container<E> {
    E[] array;
    int count = 0;

    public MyArray() {
        array  = (E[]) new Object[2];
    }

    void resize(int capacity) {
        E[] copy = (E[])new Object[capacity];
        for (int i = 0; i < count; i++) {
            copy[i] = (E)array[i];
        }
        array = copy;
    }

    @Override
    public void add(E element) {
        if (count == array.length) {
            resize(2*array.length);
        }
        array[count++] = element;
    }

    @Override
    public void remove(int index) {
        for (int k = index+1; k < count; k++) {
            array[k-1] = array[k];
        }
        count--;
        if (count>0 && count == array.length/4)
            resize(array.length/2);
    }

    @Override
    public E get(int index) {
        return array[index];
    }

    @Override
    public boolean contains(E element) {
        for (int i = 0; i < count; i++) {
            if (array[i] == element)
                return true;
        }
        return false;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Container<E> clone() {
        return this;
    }

    @Override
    public void printAll() {
        System.out.println("Array elements:");
        for (int i = 0; i < count; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
