package OOP.TextProcessing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

/**
 * Created by А on 23.11.14.
 */
public class Text {
    List<Sentence> sentences;
    List<Word> allWords;
    String value;
    final String REGEX_PARAGRAPH = "(\\t|\\n|\\r|\\f|\\s+)";
    final String REGEX_SENTENCE = "(\\.|\\?|!|\\...|\\*/)\\s+";


    public Text(String fileName) {
        this.value = readFile(fileName);
        sentences = new ArrayList<>();
        allWords = new ArrayList<>();
    }

    public String getWholeText() {
        return value;
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
        return sentences;
    }

    public TreeSet<Sentence> sortSentences() {
        TreeSet<Sentence> sorted = new TreeSet<>();
        for (Sentence s : sentences)
            sorted.add(s);
        for (Sentence s : sorted)
            System.out.println(s.getWordsNumber()+ " "+ s);
        return sorted;
    }

    public List<Word> getAllWords() {
        for (Sentence s : sentences) {
            for (Word w : s.getWords())
                allWords.add(w);
        }
        return allWords;
    }

    public void sortWordsByCharQty(Character ch) {
        for (Word w : allWords) {
            w.countChar(ch);
        }
        TreeSet<Word> sorted = new TreeSet<>();
        for (Word w : allWords) {
            sorted.add(w);
        }
        for (Word w : sorted)
            System.out.println(w.getCharQty()+ " "+ w);
    }

}
