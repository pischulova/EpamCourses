package Algorithms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Написать программу, осуществляющую сжатие английского текста.
 * Построить для каждого слова в тексте оптимальный префиксный код по
 * алгоритму Хаффмена. Использовать класс PriorityQueue.
 *
 * Created by А on 09.11.14.
 */
public class HuffmanAlgorithm {
    PriorityQueue<Node> queue;
    TreeMap<Character, String> mapOfCodes;
    char[] input;
    String output;
    int queueSize;

    private static class Node implements Comparable<Node> {
        private final char ch;
        private final int freq;
        private final Node left, right;

        Node(char ch, int freq, Node left, Node right) {
            this.ch    = ch;
            this.freq  = freq;
            this.left  = left;
            this.right = right;
        }

        public int compareTo(Node that) {
            return this.freq - that.freq;
        }

        public boolean isLeaf() {
            return ((left == null) && (right == null));
        }

        @Override
        public String toString() {
            return "Node{" +
                    "ch=" + ch +
                    ", freq=" + freq +
                    '}';
        }
    }

    public HuffmanAlgorithm() {
        queue = new PriorityQueue<>();
        queueSize = 0;
        mapOfCodes = new TreeMap<>();
        output = "";
    }

    private String readFile(String fileName) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            line = br.readLine();
            while (line != null) {
                sb.append(line);
                //sb.append(System.lineSeparator());
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = sb.toString();
        System.out.println(result);
        return result;
    }

    public void compress(String fileName) {
        String text = readFile(fileName);
        input = text.toCharArray();
        Node root = buildTree(input);
        buildTable(mapOfCodes, root, new String());

        Collection entrySet = mapOfCodes.entrySet();
        Iterator it = entrySet.iterator();
        while(it.hasNext())
            System.out.println(it.next());

        encodeInput();
        evaluateCompression();
    }

    private Node buildTree(char[] input) {
        int[] freq = new int[128];
        for (int i = 0; i < input.length; i++)
            freq[input[i]]++;
        for (char i = 0; i < 128; i++) {
            if (freq[i] != 0) {
                queue.offer(new Node(i, freq[i], null, null));
                queueSize++;
            }
        }
        if (queue.size() == 1) {
            if (freq['\0'] == 0)
                queue.offer(new Node('\0', 0, null, null));
            else
                queue.offer(new Node('\1', 0, null, null));
        }
        while (queue.size() > 1) {
            Node left  = removeMinimum();
            Node right = removeMinimum();
            Node parent = new Node('\0', left.freq + right.freq, left, right);
            queue.offer(parent);
        }
        return removeMinimum();
    }

    private void buildTable(TreeMap<Character, String> map, Node node, String s) {
        if (!node.isLeaf()) {
            buildTable(map, node.left, s + '0');
            buildTable(map, node.right, s + '1');
        } else {
            map.put(node.ch, s);
        }
    }

    private Node removeMinimum() {
        Node min = queue.peek();
        Iterator iter = queue.iterator();
        while (iter.hasNext()) {
            Node n = (Node)iter.next();
            if (n.freq < min.freq)
                min = n;
        }
        queue.remove(min);
        queueSize--;
        return min;
    }

    private void encodeInput() {
        for (char c : input) {
            output += mapOfCodes.get(c);
        }
        System.out.println(output);
    }

    private void evaluateCompression() {
        double inputSize = input.length * 8;
        double outputSize = output.length();
        double compression = (1 - outputSize/inputSize)*100;
        System.out.println("Input file size = " + inputSize);
        System.out.println("Output file size = " + outputSize);
        System.out.println("Performed " + String.format("%.2f", compression) + "% compression");
    }
}
