package OOP;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by А on 23.10.14.
 */
public class Account {
    private int accountId;
    private double balance = 0;
    private List<Entry> entryList = new ArrayList<>();

    private class Entry {
        private double sum;
        private boolean direction; //true +, false -
        private String description;

        Entry(double sum, boolean direction) {
            this.sum = sum;
            this.direction = direction;
        }
    }

    void withdraw(double sum) {
        Entry entry = new Entry(sum, false);
        entryList.add(entry);
        balance -= sum;
    }

    void transferIn(double sum) {
        Entry entry = new Entry(sum, true);
        entryList.add(entry);
        balance += sum;
    }

    double getBalance() {
        return balance;
    }

}

