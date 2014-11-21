package OOP.TextProcessing;

/**
 * Created by А on 20.11.14.
 */
public enum Symbol {
    EXCLAMATION('!'),
    DOT('.'),
    QUESTION('?'),
    NEWLINE('\n'),
    CARRET('\r'),
    THREE_DOT('…');

    private char sign;

    Symbol(char sign) {
        this.sign = sign;
    }


}
