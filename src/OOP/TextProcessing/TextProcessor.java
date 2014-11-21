package OOP.TextProcessing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Created by А on 20.11.14.
 */
public class TextProcessor {
    String fileName;
    String input;
    final String REGEX_PARAGRAPH = "(\t|\n|\r|\\s+)";
    final String REGEX_SENTENCE = "(\\.|\\?|!|\\...)\\s*";

    public TextProcessor(String fileName) {
        this.fileName = fileName;
    }

    public void process() {
        input = readFile(fileName);
        input = replaceParagraphs(input);
        System.out.println(input);
        getSentences(input);
    }

    private String readFile(String fileName) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        try {
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = sb.toString();
        System.out.println(result);
        return result;
    }

    private String replaceParagraphs(String text) {
        return text.replaceAll(REGEX_PARAGRAPH, " ");
    }

    private String[] getSentences(String text) {
        Pattern pattern = Pattern.compile(REGEX_SENTENCE);
        String[] sentences = pattern.split(text);
        for (String s : sentences) {
            System.out.println(s);
        }
        return sentences;
    }

    public static void main(String[] args) {
        TextProcessor tp = new TextProcessor("file.txt");
        tp.process();

    }
}
