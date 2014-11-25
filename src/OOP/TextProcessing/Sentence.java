package OOP.TextProcessing;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by А on 20.11.14.
 */
public class Sentence {
    private List<Word> words;
    private List<Punctuation> punctuationList;
    String value;
    final String REGEX_WORD = "([^(\\s)]*)(\\s)*";

    public Sentence(String value) {
        this.value = value;
        words = new LinkedList<>();
        punctuationList = new LinkedList<>();
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
        for (Word w : words) {
            System.out.println(w);
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

    @Override
    public String toString() {
        return "Sentence{" +
                "value='" + value + '\'' +
                '}';
    }
}
