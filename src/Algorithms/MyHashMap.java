package Algorithms;

/**
 * Created by А on 02.11.14.
 */
public class MyHashMap {

    private static class Entry {
        int key;
        String value;
        int hash;
        Entry next;

        private Entry(int key, String value, int hash, Entry next) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value='" + value + '\'' +
                    ", hash=" + hash + '}';
        }
    }

    private Entry[] array;
    private int size;

    public MyHashMap() {
        array = new Entry[16];
    }

    public void put(int key, String value) {
        if (size >= 0.75 * array.length)
            resize();
        int hash = getHash(key);
        int position = hash % array.length;
        boolean replace = false;
        for (Entry e = array[position]; e != null; e = e.next) {
            if (e.hash == hash && e.key == key) {
                e.value = value;
                replace = true;
            }
        }
        if (replace == false) {
            Entry entry = array[position];
            array[position] = new Entry(key, value, hash, entry);
            size++;
        }
    }

    private void resize() {
        Entry[] copy = new Entry[2 * array.length];
        for (int i = 0; i < array.length; i++) {
            for (Entry e = array[i]; e != null; e = e.next) {
                int newPosition = e.hash % copy.length;
                Entry entry = copy[newPosition];
                Entry temp = new Entry(e.key, e.value, e.hash, entry);
                copy[newPosition] = temp;
            }
        }
        array = copy;
    }

    private int getHash(Integer key) {
        int h = 0;
        h ^= key.hashCode();
        h ^= (h >>> 7) ^ (h >>> 4);
        return h;
    }

    public int getSize() {
        return size;
    }

    public boolean containsKey(int key) {
        int hash = getHash(key);
        int position = hash % array.length;
        for (Entry e = array[position]; e != null; e = e.next) {
            if (e.hash == hash && e.key == key)
                return true;
        }
        return false;
    }

    public boolean containsValue(String value) {
        for (int i = 0; i < array.length; i++) {
            for (Entry e = array[i]; e != null; e = e.next) {
                if (e.value == value)
                    return true;
            }
        }
        return false;
    }

    public void removeKey(int key) {
        int hash = getHash(key);
        int position = hash % array.length;
        Entry prev = array[position];
        Entry current = prev;
        while (current != null) {
            Entry next = current.next;
            if (current.key == key) {
                size--;
                if (prev == current) {
                    array[position] = next;
                } else {
                    prev.next = next;
                }
            }
            prev = current;
            current = next;
        }
    }

    public void printAll() {
        for (int i = 0; i < array.length; i++) {
            for (Entry e = array[i]; e != null; e = e.next) {
                if (e == null)
                    continue;
                System.out.println("Cell " + i);
                System.out.println(e.toString());
            }
        }
    }
}
