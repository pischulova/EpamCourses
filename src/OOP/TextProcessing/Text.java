package OOP.TextProcessing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by А on 23.11.14.
 */
public class Text {
    List<Sentence> sentences;
    List<Word> words;
    String value;
    final String REGEX_PARAGRAPH = "(\\t|\\n|\\r|\\f|\\s+)";
    final String REGEX_SENTENCE = "(\\.|\\?|!|\\...|\\*/)\\s+";


    public Text(String fileName) {
        this.value = readFile(fileName);
        sentences = new LinkedList<>();
        words = new LinkedList<>();
    }

    public String getWholeText() {
        return value;
    }

    public List<Word> getWords() {

        return words;
    }

    private String readFile(String fileName) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        try {
            while (reader.ready()) {
                String line = reader.readLine();
                line = line.replaceAll(REGEX_PARAGRAPH, " ");
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = sb.toString();
        return result;
    }

    public List<Sentence> getSentences() {
        Pattern pattern = Pattern.compile(REGEX_SENTENCE);
        String[] sentenceArray = pattern.split(value);
        for (String s : sentenceArray) {
            sentences.add(new Sentence(s));
        }
//        for (Sentence s : sentences) {
//            System.out.println(s);
//        }
        return sentences;

    }
}
