package OOP.TextProcessing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by А on 20.11.14.
 */
public class Sentence implements Comparable{
    private List<Word> words;
    private List<Punctuation> punctuationList;
    String value;
    final String REGEX_WORD = "([^(\\s)]*)(\\s)*";

    public Sentence(String value) {
        this.value = value;
        words = new ArrayList<>();
        punctuationList = new LinkedList<>();
        getWords();
    }

    public List<Word> getWords() {
        Pattern pattern = Pattern.compile(REGEX_WORD);
        Matcher matcher = pattern.matcher(value);
        while (matcher.find()) {
            String string = matcher.group();
            for (Punctuation p : Punctuation.values()) {
                String ch = p.getSign()+"";
                if (string.contains(ch))
                    string = string.replace(ch, "");
            }
            if (string.contains(" "))
                string = string.replace(" ", "");
            if (!string.equals("") && !string.matches(".*\\d.*"))
                words.add(new Word(string));
        }
        return words;
    }

    public List<Punctuation> getPunctuationList() {
        for (int index = 0; index < value.length(); index++) {
            for (Punctuation p : Punctuation.values()) {
                if (value.charAt(index) == p.getSign()) {
                    punctuationList.add(p);
                }
            }
        }
        System.out.println(punctuationList);
        return punctuationList;
    }

    public String getValue() {
        return value;
    }

    public int getWordsNumber() {
        return words.size();
    }

    public String toString() {
        return "Sentence{" +
                "value='" + value + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Sentence s = (Sentence)o;
        int our = this.getWordsNumber();
        int other = s.getWordsNumber();
        if (our < other)
            return -1;
        else if (our > other)
            return 1;
        else {
            String s1 = value;
            String s2 = s.getValue();
            if (s1.compareToIgnoreCase(s2) > 0)
                return 1;
            else if (s1.compareToIgnoreCase(s2) < 0)
                return -1;
        }
        return 0;
    }
}
