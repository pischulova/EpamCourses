package OOP.TextProcessing;

/**
 * Created by А on 20.11.14.
 */
public class Word {
    String value;

    public Word(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Word= {" + value + '}';
    }
}
