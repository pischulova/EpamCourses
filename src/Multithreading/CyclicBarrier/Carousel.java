package Multithreading.CyclicBarrier;

/**
 * Реализовать CyclicBarrier. Он приостанавливает все потоки, которые вызывают его метод await до тех пор,
 * пока их не наберётся нужное количество, указанное в конструкторе.
 * Также в конструкторе можно передать объект, реализующий знакомый нам интерфейс Runnable,
 * который будет выполнен по достижению размера очереди потоков определённого количества.
 * Д/з №11
 *
 * Created by А on 20.11.14.
 */
public class Carousel implements Runnable{

    @Override
    public void run() {
        System.out.println("The carousel starts running!");
    }

    public static void main(String[] args) {
        Supervisor supervisor = new Supervisor(3, new Carousel());
        Guest g1 = new Guest(0, supervisor);
        Guest g2 = new Guest(1000, supervisor);
        Guest g3 = new Guest(2000, supervisor);
        Guest g4 = new Guest(3000, supervisor);
        Guest g5 = new Guest(4000, supervisor);
        Guest g6 = new Guest(5000, supervisor);

    }
}
