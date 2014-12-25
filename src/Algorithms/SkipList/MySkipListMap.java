package Algorithms.SkipList;

import java.util.ArrayList;
import java.util.List;

/**
 * Предложить собственную реализацию ConcurrentSkipListMap. д/з  12
 *
 * Created by А on 04.12.14.
 */
public class MySkipListMap {

    static class Node {
        private int key;
        private String value;
        Level level;
        Node next;
        Node below;

        Node(int key, String value, Level level) {
            this.key = key;
            this.value = value;
            this.level = level;
        }

        Node(int key, String value, Level level, Node next, Node below) {
            this.key = key;
            this.value = value;
            this.level = level;
            this.next = next;
            this.below = below;
        }

        @Override
        public String toString() {
            return "Node {" + "key=" + key + ", value=" + value + '}';
        }
    }

    class Level {
        Node first;
        int height;
        int realSize;

        /**
         * Level represents a singly-linked-list of Nodes.
         * First Node is a dummy node, with minimum Integer value as key,
         * null as value, null next node and below node pointing to a dummy node of level below (if present)
         */
        Level() {
            height = levels.size();
            first = new Node(Integer.MIN_VALUE, null, this, null, null);
            if (height != 0) {
                first.below = levels.get(height - 1).first;
            }
        }

        boolean isEmpty() {
            return realSize == 0;
        }
    }

    List<Level> levels;
    Node recentlyAdded = null;

    private Level getUpperLevel() {
        return levels.get(levels.size() - 1);
    }

    public MySkipListMap() {
        levels = new ArrayList<>();
    }

    public synchronized void put(int key, String value) {
        int insertionHeight = 0;
        if (!levels.isEmpty()) {
            insertionHeight = (int)(Math.random()*levels.size());
        } else {
            levels.add(new Level());
            levels.add(new Level());
        }

        if (insertionHeight == levels.size()-1) {
            levels.add(new Level());
        }
        Level currentLevel = levels.get(levels.size() - 1);
        insertToLevel(currentLevel.first, insertionHeight, key, value);
    }

    private void insertToLevel(Node currentNode, int insertionHeight, int key, String value) {
        Level currentLevel = currentNode.level;
        if (currentNode.next == null || currentNode.next.key > key) {
            if (currentLevel.height <= insertionHeight) {
                insertHere(currentNode, key, value);
            } else {
                currentNode = currentNode.below;
                insertToLevel(currentNode, insertionHeight, key, value);
            }
        } else {
            Node placeToInsert = null;
            for (Node node = currentNode; node != null; node = node.next) {
                if (node.next == null || node.next.key > key) {
                    placeToInsert = node;
                    break;
                }
            }
            if (currentLevel.height <= insertionHeight) {
                insertHere(placeToInsert, key, value);
            } else {
                currentNode = placeToInsert.below;
                insertToLevel(currentNode, insertionHeight, key, value);
            }
        }
    }

    private void insertHere(Node currentNode, int key, String value) {
        Level currentLevel = currentNode.level;

        Node newNode = new Node (key, value, currentLevel);
        newNode.next = currentNode.next;
        currentNode.next = newNode;
        if (recentlyAdded != null && recentlyAdded.key == key)
            recentlyAdded.below = newNode;
        recentlyAdded = newNode;
        currentLevel.realSize++;

        if (currentLevel.height != 0) {
            currentNode = currentNode.below;
            insertToLevel(currentNode, currentLevel.height, key, value);
        }
    }

    public String getValue(int key) {
        if (levels.isEmpty())
            throw new IllegalStateException();
        Node currentNode = levels.get(levels.size() - 1).first;
        return search(currentNode, key);
    }

    Node previous = null;
    private String search(Node currentNode, int key) throws NullPointerException{
        String result;
        if (currentNode.key < key) {
            if (currentNode.next == null)
                result = search(currentNode.below, key);
            else {
                previous = currentNode;
                currentNode = currentNode.next;
                result = search(currentNode, key);
            }
        } else if (currentNode.key > key) {
            currentNode = previous.below;
            result = search(currentNode, key);
        } else if (currentNode.key == key) {
            result = currentNode.value;
        } else
            return null;
        return result;
    }

    private void searchAndRemove(Node currentNode, int key) {
        if (currentNode.key < key) {
            if (currentNode.next == null)
                searchAndRemove(currentNode.below, key);
            else {
                previous = currentNode;
                currentNode = currentNode.next;
                searchAndRemove(currentNode, key);
            }
        } else if (currentNode.key > key) {
            currentNode = previous.below;
            searchAndRemove(currentNode, key);
        } else {
            while (previous.next.key != key) {
                previous = previous.next;
            }
            previous.next = currentNode.next;
            previous = previous.below;
            currentNode.level.realSize--;
            if (previous != null)
                searchAndRemove(currentNode.below, key);
        }
    }

    public synchronized void remove(int key) {
        if (levels.isEmpty())
            throw new IllegalArgumentException();
        try {
            getValue(key);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
        Node currentNode = levels.get(levels.size() - 1).first;
        searchAndRemove(currentNode, key);
        if (levels.size() > 2 && getUpperLevel().isEmpty() && levels.get(levels.size()-2).isEmpty())
            levels.remove(getUpperLevel());
    }

    public void printAll() {
        for (Level level : levels) {
            System.out.println("Level " + level.height + ", size = " + level.realSize);
            for (Node node = level.first.next; node != null; node = node.next) {
                System.out.println(node.toString());
            }
        }
    }
}
