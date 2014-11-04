package Algorithms;

/**
 * Created by А on 30.10.14.
 */
public class RBTree {

    static class Node {
        private Node rightChild;
        private Node leftChild;
        private Node parent;
        private int value;
        private Color color;

        Node(int value) {
            this.value = value;
        }

        enum Color {
            BLACK, RED;
        }
    }

    private Node root;
    private Node tempParent = root;

    public RBTree() {
        root = null;
    }

    private void insert(int value) {
        Node current = null;
        if (root == null) {
            root = new Node(value);
            root.color = Node.Color.BLACK;
        } else {
            current = this.insertInto(root, value);
            if (current != null)
                current.color = Node.Color.RED;
        }
        //diff cases
    }

    private Node insertInto(Node head, int value) {
        if (head == null) {
            head = new Node(value);
            head.parent = tempParent;
            return head;
        } else if (value == head.value)
            return null;
        else if (value < head.value) {
            tempParent = head;
            return this.insertInto(head.leftChild, value);
        } else {
            tempParent = head;
            return this.insertInto(head.rightChild, value);
        }
    }
}
