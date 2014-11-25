package OOP.TextProcessing;

/**
 * Создать программу обработки текста учебника по программированию с использованием классов:
 * Символ, Слово, Предложение, Знак препинания и др. Во всех задачах с формированием текста заменять табуляции
 * и последовательности пробелов одним пробелом.
 * 2.	Вывести все предложения заданного текста в порядке возрастания количества слов в каждом из них.
 * 9.	Все слова текста рассортировать по возрастанию количества заданной буквы в слове.
 *      Слова с одинаковым количеством расположить в алфавитном порядке.
 *
 * Created by А on 20.11.14.
 */
public class TextProcessor {
    Text text;

    public TextProcessor(String fileName) {
        this.text = new Text(fileName);
    }

    public void process() {
        text.getWholeText();
        text.getSentences();
        text.sortSentences();
        text.getAllWords();
        text.sortWordsByCharQty('e');

    }

    public static void main(String[] args) {
        TextProcessor tp = new TextProcessor("Introduction_short.txt");
        tp.process();
    }
}
