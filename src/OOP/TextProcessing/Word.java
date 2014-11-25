package OOP.TextProcessing;

/**
 * Created by А on 20.11.14.
 */
public class Word implements Comparable{
    private String value;
    private int charQty;

    public Word(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public int getCharQty() {
        return charQty;
    }

    public int compareAlphabet(Word word) {
        String str = word.getValue();
        if (value.compareToIgnoreCase(str) > 0)
            return 1;
        else if (value.compareToIgnoreCase(str) < 0)
            return -1;
        else
            return 0;
    }

    public int countChar(Character ch) {
        int count = 0;
        char big = Character.toUpperCase(ch);
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == ch || value.charAt(i) == big)
                count++;
        }
        charQty = count;
        return count;
    }

    @Override
    public int compareTo(Object o) {
        Word other = (Word)o;
        if (this.charQty < other.charQty)
            return -1;
        else if (this.charQty > other.charQty)
            return 1;
        else
            return this.compareAlphabet(other);
    }

    @Override
    public String toString() {
        return "Word= {" + value + '}';
    }
}
