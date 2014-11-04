package Containers;

import com.sun.org.apache.regexp.internal.recompile;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by А on 20.10.14.
 */
class Set<E>{
    Container c;

    public Set(Container c) {
        this.c = c;
    }

    public Set union (Set secondSet) {
        Container container = c.clone();
        Set result = new Set(container);
        for(int i = 0; i < secondSet.size(); i++) {
            result.add(secondSet.c.get(i));
        }
        return result;
    }

    public void printAll() {
        System.out.println("Set elements: ");
        for (int i = 0; i < c.size(); i++)
            System.out.print(c.get(i) + " ");
        System.out.println();
    }

    void add(E element) {
        c.add(element);
    }
    void remove(int index) {
        c.remove(index);
    }
    E get(int index) {
        return (E)c.get(index);
    }
    boolean contains(E element) {
        return c.contains(element);
    }
    int size() {
        return c.size();
    }

}