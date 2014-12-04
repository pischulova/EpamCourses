package Multithreading.ThreadPoolExecutor;

/**
 * Created by А on 27.11.14.
 */
public class Starter {
    public static void main(String[] args) throws InterruptedException {
        MyThreadPool executor = new MyThreadPool(3, 4);

        executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("1 task started");
                try {
                    Thread.sleep(4000);
                    System.out.println("1 task finished");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("2 task started");
                try {
                    Thread.sleep(4000);
                    System.out.println("2 task finished");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("3 task started");
                try {
                    Thread.sleep(4000);
                    System.out.println("3 task finished");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("4 task started");
                try {
                    Thread.sleep(4000);
                    System.out.println("4 task finished");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("5 task started");
                try {
                    Thread.sleep(4000);
                    System.out.println("5 task finished");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        executor.awaitTermination(15000);
    }
}
