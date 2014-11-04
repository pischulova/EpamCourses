package Containers;

/**
 * Created by А on 20.10.14.
 */
public interface Container<E> extends Cloneable{
    void add(E element);
    void remove(int index);
    E get(int index);
    boolean contains(E element);
    int size();
    Container<E> clone();
    void printAll();
}


