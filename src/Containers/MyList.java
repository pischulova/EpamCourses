package Containers;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by А on 20.10.14.
 */
public class MyList<E> implements Container<E> {
    List<E> list = new LinkedList<E>();

    @Override
    public void add(E element) {
        list.add(element);
    }

    @Override
    public void remove(int index) {
        list.remove(index);
    }

    @Override
    public E get(int index) {
        return list.get(index);
    }

    @Override
    public boolean contains(E element) {
        return list.contains(element);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Container<E> clone() {
        return this;
    }

    @Override
    public void printAll() {
        System.out.println("List elements:");
        for (E i: list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
