package Patterns.Command;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by А on 21.11.14.
 */
public interface Command {
    void execute();
}

class CommandA implements Command {
    @Override
    public void execute() {
        System.out.println("A");
    }
}

class CommandB implements Command {
    @Override
    public void execute() {
        System.out.println("B");
    }
}

class CommandFactory {
    Map<String, Command> m = new HashMap<String, Command>() {{
        put("aaa", new CommandA());
        put("bbb", new CommandB());
    }};
    public Command createCommand(String s) {
       return m.get(s);
    }
}

class Starter {
    public static void main(String[] args) {
        CommandFactory factory = new CommandFactory();
        Command c = factory.createCommand("aaa");
        c.execute();
    }
}
