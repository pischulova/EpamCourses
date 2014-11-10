package Algorithms;

import Algorithms.Exceptions.ListIsEmptyException;
import Algorithms.Exceptions.ListOverflowException;

/**
 * Created by А on 05.11.14.
 */
public class SafeSinglyLinkedList {
    private int size;
    private int maxSize;
    private Node first;
    private Node last;

    static class Node {
        private int value;
        private Node next;
    }

    public SafeSinglyLinkedList(int maxSize) {
        size = 0;
        first = null;
        last = null;
        this.maxSize = maxSize;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public boolean isFull() {
        return size == maxSize;
    }

    public void add(int element) {
        try {
            if (isFull())
                throw new ListOverflowException();
        } catch (ListOverflowException e) {
            e.printStackTrace();
        }
        Node oldLast = last;
        last = new Node();
        last.value = element;
        last.next = null;
        if (isEmpty())
            first = last;
        else
            oldLast.next = last;
        size++;
    }

    public void remove(int element) {
        try {
            if (isEmpty())
                throw new ListIsEmptyException();
        } catch (ListIsEmptyException e) {
            e.printStackTrace();
        }

        for (Node node = first; node != null; node = node.next) {
            if (element == node.value) {
                node.value = node.next.value;
                node.next = node.next.next;
                size--;
                break;
            }
        }
    }

    public boolean contains(int element) {
        try {
            if (isEmpty())
                throw new ListIsEmptyException();
        } catch (ListIsEmptyException e) {
            e.printStackTrace();
        }
        for (Node node = first; node != null; node = node.next) {
            if (element == node.value) {
                return true;
            }
        }
        return false;
    }

    public void printAll() {
        for (Node node = first; node != null; node = node.next) {
            System.out.println(node.value);
        }
    }
}
