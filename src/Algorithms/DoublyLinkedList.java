package Algorithms;

/**
 * Created by А on 23.10.14.
 */
public class DoublyLinkedList {
    private int size;
    private Node header = new Node();

    static class Node {
         private int value;
         private Node next;
         private Node previous;
    }

    public DoublyLinkedList() {
        size = 0;
        header.next = null;
        header.previous = null;
        header.value = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return header.next == null;
    }

    public void add(int element) {
        Node oldLast = header.previous;
        header.previous = new Node();
        header.previous.value = element;
        header.previous.next = null;
        header.previous.previous = oldLast;
        if (isEmpty()) {
            header.next = header.previous;
            header.next.previous = null;
        } else {
            oldLast.next = header.previous;
        }
        size++;
    }

    public void remove(int element) {
        if (isEmpty())
            System.out.println("The list is empty");
        else {
            for (Node node = header.next; node != null; node = node.next) {
                if (element == node.value) {
                    if(size == 1) {
                        header.previous = null;
                        header.next = null;
                    }
                    if (node.previous == null) {
                        header.next = node.next;
                        node.value = node.next.value;
                        node.next = node.next.next;
                    } else  if (node.next == null) {
                        header.previous = node.previous;
                        node.previous.next = null;
                    } else {
                        node.previous.next = node.next;
                        node.next.previous = node.previous;
                    }
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
            for (Node node = header.next; node != null; node = node.next) {
                if (element == node.value) {
                    return true;
                }

            }
        }
        return false;
    }

    public void printAll() {
        for (Node node = header.next; node != null; node = node.next) {
            System.out.println(node.value);
        }
    }
}
