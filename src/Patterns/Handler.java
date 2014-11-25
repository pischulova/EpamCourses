package Patterns;

/**
 * Created by А on 21.11.14.
 */
public class Handler {
    Handler handler;
    public void execute(String command) {
        System.out.println("default");
    }
}
class CommandA extends Handler {
    public CommandA(Handler h) {
        this.handler = h;
    }

    @Override
    public void execute(String command) {
        if (command == "aaa")
            System.out.println("aaa");
        else
            handler.execute(command);
    }
}
class CommandB extends Handler {
    public CommandB(Handler h) {
        this.handler = h;
    }

    @Override
    public void execute(String command) {
        if (command == "bbb")
            System.out.println("bbb");
        else
            handler.execute(command);
    }
}

class Starter {
    public static void main(String[] args) {
        Handler h = new Handler();
        CommandA a = new CommandA(h);
        CommandB b = new CommandB(a);
        b.execute("aaa");
    }
}

