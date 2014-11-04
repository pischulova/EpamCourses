package Algorithms;

/**
 * Created by А on 23.10.14.
 */
public class SinglyLinkedList {
    private int size;
    private Node first;
    private Node last;

    static class Node {
        private int value;
        private Node next;
    }

    public SinglyLinkedList() {
        size = 0;
        first = null;
        last = null;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void add(int element) {
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
        if (isEmpty())
            System.out.println("The list is empty");
        else {
            for (Node node = first; node != null; node = node.next) {
                if (element == node.value) {
                    node.value = node.next.value;
                    node.next = node.next.next;
                    size--;
                    break;
                }
            }
        }
    }

    public boolean contains(int element) {
        if (isEmpty())
            System.out.println("The list is empty");
        else {
            for (Node node = first; node != null; node = node.next) {
                if (element == node.value) {
                    return true;
                }

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
