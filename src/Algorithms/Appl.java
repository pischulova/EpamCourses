package Algorithms;

/**
 * Created by А on 23.10.14.
 */
public class Appl {
    public static void main(String[] args) {
//        MyHashMap map = new MyHashMap();
//        map.put(156, "aa");
//        map.put(22, "tt");
//        map.put(309, "zz");
//        map.put(664, "hh");
//        map.put(35, "ii");
//        map.put(22, "ee");
//        map.printAll();
//        System.out.println(map.containsKey(309));
//        System.out.println(map.containsKey(39));
//        System.out.println(map.containsValue("ww"));
//        System.out.println(map.containsValue("ee"));
//        map.removeKey(309);
//        System.out.println("****");
//        map.printAll();

        MyPriorityQueue queue = new MyPriorityQueue();
        queue.offer(10);
        queue.offer(9);
        queue.offer(12);
        queue.offer(7);
        queue.offer(17);
        System.out.println("max = " + queue.peek());
        System.out.println("size = " + queue.size());
        queue.printAll();
        System.out.println("**Second queue**");
//        queue.poll();
//        System.out.println("max = " + queue.peek());
//        System.out.println("size = " + queue.size());
//        queue.printAll();
        MyPriorityQueue queue2 = new MyPriorityQueue();
        queue2.offer(4);
        queue2.offer(11);
        queue2.offer(27);
        queue2.printAll();
        queue.merge(queue2);
        System.out.println("**After merging**");
        queue.printAll();

    }
}
